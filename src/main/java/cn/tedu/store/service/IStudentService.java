package cn.tedu.store.service;

import org.springframework.transaction.annotation.Transactional;

/**
 * ҵ������ɾ�Ĳ鷽������
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
