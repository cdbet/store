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
	//ʵ��ͷ���ϴ�
	@RequestMapping("/doUpload.do")
	@ResponseBody
	public ResponseResult<Void>doUpload(@RequestParam("file")MultipartFile file , HttpSession session ) throws Exception{
		//1.����rr����
		ResponseResult<Void> rr=new ResponseResult<Void>();
		//2.�ϴ�ͼƬ
		//��ȡ����������ʵ·��
		String path=session.getServletContext().getRealPath("/");
		System.out.println(path);
		file.transferTo(new File(path,"/upload/"+file.getOriginalFilename()));
		
		iUserService.upDateImage("/upload/"+file.getOriginalFilename(), this.getId(session));
		//����session��user����
		session.setAttribute("user",iUserService.getUserById(this.getId(session)));
		//3.�޸�image�ֶε�ֵ
		rr.setState(1);
		rr.setMessage("�ϴ��ɹ�");
		
		return rr;
	}
	
	
	
	@RequestMapping("/login.do")
	@ResponseBody
	public ResponseResult<Void> login(String username,String password,HttpSession session){
		ResponseResult<Void> rr;
		try {
			User user=iUserService.login(username,password);
			session.setAttribute("user",user);
			rr=new ResponseResult<Void>(1,"��¼�ɹ�");
		} catch (RuntimeException e) {
			rr=new ResponseResult<Void>(0,e.getMessage());
		}
		return rr;
	}

	// ��֤�û����Ƿ����
	@RequestMapping("/checkUsername.do")
	@ResponseBody
	public ResponseResult<Void> checkUsername(String username) {
		ResponseResult<Void> rr = new ResponseResult<Void>();
		boolean us = iUserService.checkUsername(username);
		if (us) {
			rr.setState(0);
			rr.setMessage("�û�������ʹ��");
		} else {
			rr.setState(1);
			rr.setMessage("�û�����ʹ��");
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
			rr.setMessage("���䲻����");
		} else {
			rr.setState(1);
			rr.setMessage("�������");
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
			rr.setMessage("�绰������");
		} else {
			rr.setState(1);
			rr.setMessage("�绰����");
		}
		return rr;
	}
	//ʵ��ע��	
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
			rr=new ResponseResult<Void>(1,"ע��ɹ�");
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
			//this��super
			
			//this��ʾ��ǰ��Ķ���super��ʾ�������
			//this.test(); this.x;				super.test();super.y;
			//this("abc");							super("sdf");
		
			iUserService.changePassword(this.getId(session), oldPwd, newPwd);
			rr=new ResponseResult<Void>(1,"�޸ĳɹ�");
		
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
			//ˢ��ҳ��
			session.setAttribute("user",iUserService.getUserById(this.getId(session)));
			rr=new ResponseResult<Void> (1,"�޸ĳɹ�");
		} catch (UsernameAreadyExistException e) {
			rr=new ResponseResult<Void>(0,e.getMessage());
			
		}
		return rr;
		
	}
}
