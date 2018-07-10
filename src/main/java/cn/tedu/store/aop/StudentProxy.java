package cn.tedu.store.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.tedu.store.service.IStudentService;
import cn.tedu.store.service.StudentService;
//��̬������:�ص㣺����ҵ������󣬻������������
@Component
public class StudentProxy implements IStudentService{
	@Autowired
	private StudentService studentService;
	@Autowired
	private StudentAop studentAop;
	
	public void add() {
		studentService.add();
		studentAop.log();
		
	}

	public void update() {
		// TODO Auto-generated method stub
		
	}

	public void delete() {
		// TODO Auto-generated method stub
		
	}

	public void getById() {
		// TODO Auto-generated method stub
		
	}

	public void getAll() {
		// TODO Auto-generated method stub
		
	}

}
