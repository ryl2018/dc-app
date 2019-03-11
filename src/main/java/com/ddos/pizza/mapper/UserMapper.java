package com.ddos.pizza.mapper;

import com.ddos.pizza.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    /**
     * 用户注册
     * @param user
     */
	void register(User user);

	/**
	 * 检查名称是否可用
	 * @param userName
	 * @return
	 */
	User isExist(String userName);

	/**
	 * 登录
	 * @param user
	 * @return
	 */
	User login(User user);
	void update(User user);
}
