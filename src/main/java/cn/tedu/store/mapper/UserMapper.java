package cn.tedu.store.mapper;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.User;

public interface UserMapper {
	void insertUser(User user);
	/**
	 * 通过username查询
	 * @param user
	 * @return 如果查询到了返回user对象如果没有返回null
	 */
	User selectByUsername(String username);
	
	Integer selectEmail(String email);
	
	Integer selectPhone(String phone);
	
	Integer updateUser(User user);
	/**
	 * 根据id查询用户信息
	 * @param id
	 * @return 如果存在返回对象，否返回null
	 */
	User selectById(Integer id);
	
	/**
	 * 修改个人头像
	 * @param image
	 * @param id
	 */
	void updateImageById(@Param("image")String image,@Param("id")Integer id);
}
