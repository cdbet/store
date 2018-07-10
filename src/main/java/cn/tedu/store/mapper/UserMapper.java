package cn.tedu.store.mapper;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.User;

public interface UserMapper {
	void insertUser(User user);
	/**
	 * ͨ��username��ѯ
	 * @param user
	 * @return �����ѯ���˷���user�������û�з���null
	 */
	User selectByUsername(String username);
	
	Integer selectEmail(String email);
	
	Integer selectPhone(String phone);
	
	Integer updateUser(User user);
	/**
	 * ����id��ѯ�û���Ϣ
	 * @param id
	 * @return ������ڷ��ض��󣬷񷵻�null
	 */
	User selectById(Integer id);
	
	/**
	 * �޸ĸ���ͷ��
	 * @param image
	 * @param id
	 */
	void updateImageById(@Param("image")String image,@Param("id")Integer id);
}
