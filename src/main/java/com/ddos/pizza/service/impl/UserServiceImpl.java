package com.ddos.pizza.service.impl;

import com.ddos.pizza.common.security.Md5;
import com.ddos.pizza.domain.User;
import com.ddos.pizza.common.exception.PizzaException;
import com.ddos.pizza.common.exception.userenum.UserErrorEnum;
import com.ddos.pizza.mapper.UserMapper;
import com.ddos.pizza.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private HttpSession session;
    @Resource
    private ValueOperations<String, String> valueOperations;
    @Override
    public User register(User user) {
        Assert.notNull(user, "user must not null");
        Assert.notNull(user.getPassword(), "user.password must not null");
        Assert.notNull(user.getPhone(), "user.phone must not null");
        user.setId(UUID.randomUUID());
        user.setPassword(Md5.string2md5s(user.getPassword()));
        userMapper.register(user);
        String token = UUID.randomUUID().toString();
        user.setToken(token);
        valueOperations.set(token,user.getId().toString());
        return user;
    }

    @Override
    public boolean isExistByUserName(String userName) {
        Assert.notNull(userName, "userName must not null");
        return userMapper.isExistByUserName(userName) != null;
    }

    @Override
    public boolean isExistByUserPhone(String phone) {
        Assert.notNull(phone, "phone must not null");
        return userMapper.isExistByUserPhone(phone) == null;
    }

    @Override
    public User login(User user) throws PizzaException {
        Assert.notNull(user, "user must not null");
        Assert.notNull(user.getPassword(), "user.password must not null");
        Assert.notNull(user.getPhone(), "user.phone must not null");
        user.setPassword(Md5.string2md5s(user.getPassword()));
        User u = userMapper.login(user);
        if (u != null) {
            String token = UUID.randomUUID().toString();
            u.setToken(token);
            valueOperations.set(token,u.getId().toString());

        } else {
            throw new PizzaException(UserErrorEnum.USER_1003);
        }
        return u;
    }

    @Override
    public void update(User user) throws PizzaException {
        String uid = (String) session.getAttribute("CONTEXT_USER_ID");
        if (uid == null) {
            throw new PizzaException(UserErrorEnum.USER_1001);
        }
        if (user.getId().equals(uid)){
            userMapper.update(user);
        } else {
            throw new PizzaException(UserErrorEnum.USER_1002);
        }
    }

    @Override
    public User getUserById(UUID userId) {
        Assert.notNull(userId, "userId must not null");
        userMapper.getUserById(userId);
        return null;
    }

    @Override
    public void restPassword(User user) {
        Assert.notNull(user, "user must not null");
        Assert.notNull(user.getPhone(), "user.phone must not null");
        Assert.notNull(user.getPassword(), "user.password must not null");
        user.setPassword(Md5.string2md5s(user.getPassword()));
        userMapper.restPassword(user);
    }

    @Override
    public void logout(String token) {
        Assert.notNull(token, "token must not null");
        valueOperations.getOperations().delete(token);
        session.removeAttribute("CONTEXT_USER_ID");
    }
}
