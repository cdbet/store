package cn.tedu.store.service;

import org.springframework.transaction.annotation.Transactional;

/**
 * 业务层的增删改查方法调用
 * @author tedu
 *
 */

public interface IStudentService {

	void add();
	void update();
	void delete();
	void getById();
	void getAll();
}
