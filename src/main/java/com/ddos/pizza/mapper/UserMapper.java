package com.ddos.pizza.mapper;

import com.ddos.pizza.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Mapper
@Service
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
	User isExistByUserName(String userName);
	/**
	 * 检查电话是否可用
	 * @param phone
	 * @return
	 */
	User isExistByUserPhone(String phone);

	/**
	 * 登录
	 * @param user
	 * @return
	 */
	User login(User user);

	/**
	 * 更新信息
	 * @param user
	 */
	void update(User user);
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
