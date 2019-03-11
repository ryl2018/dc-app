package com.ddos.pizza.mapper;

import com.ddos.pizza.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    /**
     * 用户注册
     * @param user
     */
	public void register(User user);
	public User isExist(String userName);
	public User login(User user);
	public void update(User user);
}
