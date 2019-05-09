package com.ddos.pizza.service.impl;

import com.ddos.pizza.domain.User;
import com.ddos.pizza.mapper.UserMapper;
import com.ddos.pizza.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public void register(User user) {
        userMapper.register(user);
    }

    @Override
    public User isExist(String userName) {
        return null;
    }

    @Override
    public User login(User user) {
        return null;
    }

    @Override
    public void update(User user) {

    }
}
