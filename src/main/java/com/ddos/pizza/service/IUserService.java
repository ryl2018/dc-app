package com.ddos.pizza.service;

import com.ddos.pizza.domain.User;

/**
 * @author renyuanliang
 * @date 2019/3/5 19:28
 */
public interface IUserService {
    /**
     * 用户注册
     * @param user
     */
    void register(User user);
    /**
    *判断name是否可用
    */
    public User isExist(String userName);
    User login(User user);
    void update(User user);
}
