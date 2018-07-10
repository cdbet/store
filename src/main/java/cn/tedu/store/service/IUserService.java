package cn.tedu.store.service;

import org.springframework.transaction.annotation.Transactional;

import cn.tedu.store.bean.User;
@Transactional
public interface IUserService {
	void register(User user);
	//���email���ڣ�����true�����򣬷���false
	boolean checkEmail(String email);
	//���phone���ڣ�����true�����򣬷���false
	boolean checkphone(String phone);
	//���username���ڣ�����true�����򣬷���false
	boolean checkUsername(String username);
	/**
	 * ͨ���û���������ʵ�ֵ�¼
	 * @param username
	 * @param password
	 * @return ����û���������ȷ����true
	 * 	���󷵻��쳣
	 */
	User login(String username,String password);
	
	void changePassword(Integer id,String oldPassword,String newPassword);
	
	void updateUser(Integer id,String username,Integer gender,String phone,String email);
	
	/**
	 * ͨ����ѯid����user����
	 * @param id
	 * @return
	 */
	User getUserById(Integer id);
	
	void upDateImage(String image,Integer id);
}
