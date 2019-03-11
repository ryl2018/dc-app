package com.ddos.pizza.service;

import com.ddos.pizza.domain.User;

/**
 * @author renyuanliang
 * @date 2019/3/5 19:28
 */
public interface IUserService {
    void register(User user);
    User isExist(String userName);
    User login(User user);
    void update(User user);
}
