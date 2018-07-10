package cn.tedu.store.service;

import org.springframework.transaction.annotation.Transactional;

//标识接口的所有实现类的方法实现事务处理
@Transactional
public interface IAccountService {
	public void account(String id1,String id2,Integer money);
}
