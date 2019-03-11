package com.ddos.pizza.service;

import com.ddos.pizza.domain.User;

/**
 * @author renyuanliang
 * @date 2019/3/5 19:28
 */
public interface IUserService {
    public void register(User user);
    public User isExist(String userName);
    public User login(User user);
    public void update(User user);
}
