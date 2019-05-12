package com.ddos.pizza.service;

import com.ddos.pizza.domain.User;
import com.ddos.pizza.common.exception.PizzaException;

import java.util.UUID;

/**
 * @author renyuanliang
 * @date 2019/3/5 19:28
 */
public interface IUserService {
    /**
     * 用户注册
     * @param user
     */
    User register(User user);
    /**
     * 判断name是否可用
     */
    boolean isExistByUserName(String userName);

    boolean isExistByUserPhone(String phone);
    /**
     *
     * @param user
     * @return
     * @throws PizzaException
     */
    User login(User user) throws PizzaException;

    /**
     *
     * @param user
     * @throws PizzaException
     */
    void update(User user) throws PizzaException;

    /**
     * 根据用户ID查询用户信息
     * @param userId
     * @return
     */
    User getUserById(UUID userId);

    /**
     *
     * @param user
     * @return
     */
    void restPassword(User user);
}
