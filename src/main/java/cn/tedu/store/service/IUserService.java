package cn.tedu.store.service;

import org.springframework.transaction.annotation.Transactional;

import cn.tedu.store.bean.User;
@Transactional
public interface IUserService {
	void register(User user);
	//如果email存在，返回true；否则，返回false
	boolean checkEmail(String email);
	//如果phone存在，返回true；否则，返回false
	boolean checkphone(String phone);
	//如果username存在，返回true；否则，返回false
	boolean checkUsername(String username);
	/**
	 * 通过用户名和密码实现登录
	 * @param username
	 * @param password
	 * @return 如果用户名密码正确返回true
	 * 	错误返回异常
	 */
	User login(String username,String password);
	
	void changePassword(Integer id,String oldPassword,String newPassword);
	
	void updateUser(Integer id,String username,Integer gender,String phone,String email);
	
	/**
	 * 通过查询id返回user对象
	 * @param id
	 * @return
	 */
	User getUserById(Integer id);
	
	void upDateImage(String image,Integer id);
}
