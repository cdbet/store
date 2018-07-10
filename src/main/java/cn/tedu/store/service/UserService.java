package cn.tedu.store.service;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import cn.tedu.store.bean.User;
import cn.tedu.store.ex.PasswordNotMatchException;
import cn.tedu.store.ex.UserNotFoundException;

import cn.tedu.store.ex.UsernameAreadyExistException;
import cn.tedu.store.mapper.UserMapper;

@Service
public class UserService implements IUserService {
	@Resource
	private UserMapper userMapper;
	@Value("#{dbConfig.salt}")
	String salt;

	public void register(User user) {
		System.out.println("userService.register");
		User user1 = userMapper.selectByUsername(user.getUsername());
		if (user1 == null) {
			String pwd=user.getPassword();
			
			user.setPassword(DigestUtils.md5Hex(pwd+salt));
			userMapper.insertUser(user);
		} else {
			throw new UsernameAreadyExistException("用户名不可以用");
		}

	}

	public boolean checkEmail(String email) {
		return userMapper.selectEmail(email)>0;
		
		
		
	}

	public boolean checkphone(String phone) {
		return userMapper.selectPhone(phone)>0;
	}

	public boolean checkUsername(String username) {
		return userMapper.selectByUsername(username)!=null;
	}

	
	public User login(String username, String password) {
		System.out.println("userService:login");
		User user=userMapper.selectByUsername(username);
	
		if(user.getUsername()==null) {
			throw new UserNotFoundException("没有用户");
		}else {
			if(user.getPassword().equals(DigestUtils.md5Hex(password+salt))) {
				return user;
			}else if(user.getPassword().equals(password)){
				return user;
			}else{
				throw new PasswordNotMatchException("密码错误");
			}
		}
	}

	public void changePassword(Integer id, String oldPassword, String newPassword) {
		User user=userMapper.selectById(id);
		if(user==null) {
			throw new UserNotFoundException("用户不存在");
		}else {
			if(DigestUtils.md5Hex(oldPassword+salt).equals(user.getPassword())) {
				User user1=new User();
				user1.setId(id);
				user1.setPassword(DigestUtils.md5Hex(newPassword+salt));
				userMapper.updateUser(user1);
			}else if(oldPassword.equals(user.getPassword())){
				User user1=new User();
				user1.setId(id);
				user1.setPassword(DigestUtils.md5Hex(newPassword+salt));
				userMapper.updateUser(user1);
			}else{
				throw new PasswordNotMatchException("密码错误");
			}
		}
		
	}

	public void updateUser(Integer id, String username, Integer gender, String phone, String email) {
		User user=new User();
		User u1=userMapper.selectByUsername(username);
		if(u1==null) {
		
			user.setUsername(username);
			
			
		}else {
			User u2=userMapper.selectById(id);
			if(u2.getUsername().equals(username)) {
				
			}else {
				throw new UsernameAreadyExistException("用户名已存在!");
			}
			
		}
		user.setId(id);
		user.setGender(gender);
		user.setPhone(phone);
		user.setEmail(email);
		userMapper.updateUser(user);
		
	}

	
	
	public User getUserById(Integer id) {
		//返回持久层的selectById(id)方法的user对象
		return  userMapper.selectById(id);
		
		
	}

	public void upDateImage(String image, Integer id) {
		userMapper.updateImageById(image, id);
		
	}

}
