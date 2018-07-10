package cn.tedu.store.controller;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.bean.User;
import cn.tedu.store.ex.PasswordNotMatchException;
import cn.tedu.store.ex.UserNotFoundException;
import cn.tedu.store.ex.UsernameAreadyExistException;
import cn.tedu.store.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
	@Resource
	private IUserService iUserService;

	@RequestMapping("/showRegister.do")
	public String showRegister() {
		return "register";

	}
	@RequestMapping("/showLogin.do")
	public String showLogin() {
		return "login";
	}
	@RequestMapping("/showIndex.do")
	public String showIndex() {
		return "index";
	}
	
	@RequestMapping("/showPersonInfo.do")
	public String showPersonInfo() {
		return "personInfo";
		
	}
	//实现头像上传
	@RequestMapping("/doUpload.do")
	@ResponseBody
	public ResponseResult<Void>doUpload(@RequestParam("file")MultipartFile file , HttpSession session ) throws Exception{
		//1.创建rr对象
		ResponseResult<Void> rr=new ResponseResult<Void>();
		//2.上传图片
		//获取服务器的真实路径
		String path=session.getServletContext().getRealPath("/");
		System.out.println(path);
		file.transferTo(new File(path,"/upload/"+file.getOriginalFilename()));
		
		iUserService.upDateImage("/upload/"+file.getOriginalFilename(), this.getId(session));
		//更新session的user对象
		session.setAttribute("user",iUserService.getUserById(this.getId(session)));
		//3.修改image字段的值
		rr.setState(1);
		rr.setMessage("上传成功");
		
		return rr;
	}
	
	
	
	@RequestMapping("/login.do")
	@ResponseBody
	public ResponseResult<Void> login(String username,String password,HttpSession session){
		ResponseResult<Void> rr;
		try {
			User user=iUserService.login(username,password);
			session.setAttribute("user",user);
			rr=new ResponseResult<Void>(1,"登录成功");
		} catch (RuntimeException e) {
			rr=new ResponseResult<Void>(0,e.getMessage());
		}
		return rr;
	}

	// 验证用户名是否存在
	@RequestMapping("/checkUsername.do")
	@ResponseBody
	public ResponseResult<Void> checkUsername(String username) {
		ResponseResult<Void> rr = new ResponseResult<Void>();
		boolean us = iUserService.checkUsername(username);
		if (us) {
			rr.setState(0);
			rr.setMessage("用户不可以使用");
		} else {
			rr.setState(1);
			rr.setMessage("用户可以使用");
		}
		return rr;

	}

	@RequestMapping("/checkEmail.do")
	@ResponseBody
	public ResponseResult<Void> checkEmail(String email) {
		ResponseResult<Void> rr = new ResponseResult<Void>();
		boolean us = iUserService.checkEmail(email);
		if (us) {
			rr.setState(0);
			rr.setMessage("邮箱不可用");
		} else {
			rr.setState(1);
			rr.setMessage("邮箱可用");
		}
		return rr;
	}

	@RequestMapping("/checkPhone.do")
	@ResponseBody
	public ResponseResult<Void> checkPhone(String phone) {
		ResponseResult<Void> rr = new ResponseResult<Void>();
		boolean us = iUserService.checkphone(phone);
		if (us) {
			rr.setState(0);
			rr.setMessage("电话不可用");
		} else {
			rr.setState(1);
			rr.setMessage("电话可用");
		}
		return rr;
	}
	//实现注册	
	@RequestMapping("/register.do")
	@ResponseBody
	public ResponseResult<Void> register(@RequestParam("uname") String username,
			@RequestParam("upwd") String password,
			String email, String phone) {
		ResponseResult<Void> rr;
		try {
			User user=new User();
			user.setUsername(username);
			user.setPassword(password);
			user.setEmail(email);
			user.setPhone(phone);
			iUserService.register(user);
			rr=new ResponseResult<Void>(1,"注册成功");
		} catch (RuntimeException e) {
			rr=new ResponseResult<Void>(0,e.getMessage());
		}
		return rr;
	}
	
	@RequestMapping("/exit.do")
	public String exit(HttpSession session) {
		session.invalidate();
		return "redirect:/main/showIndex.do";
	}
	
	@RequestMapping("/showPassword.do")
	public String showPassword() {
		return "personal_password";
	}
	
	@RequestMapping("/updatePassword.do")
	@ResponseBody
	public ResponseResult<Void> updatePaaword(HttpSession session,String oldPwd,String newPwd){
		ResponseResult<Void> rr;
		try {
			//this和super
			
			//this表示当前类的对象，super表示父类或超类
			//this.test(); this.x;				super.test();super.y;
			//this("abc");							super("sdf");
		
			iUserService.changePassword(this.getId(session), oldPwd, newPwd);
			rr=new ResponseResult<Void>(1,"修改成功");
		
		} catch (RuntimeException e) {
			rr=new ResponseResult<Void>(0,e.getMessage());
		}
		return rr;
	}

	@RequestMapping("/updateUser.do")
	@ResponseBody
	public ResponseResult<Void> updateUser(HttpSession session,String username,Integer gender,String phone,String email){
		ResponseResult<Void> rr;
		try {
			iUserService.updateUser(this.getId(session), username, gender, phone, email);
			//刷新页面
			session.setAttribute("user",iUserService.getUserById(this.getId(session)));
			rr=new ResponseResult<Void> (1,"修改成功");
		} catch (UsernameAreadyExistException e) {
			rr=new ResponseResult<Void>(0,e.getMessage());
			
		}
		return rr;
		
	}
}
