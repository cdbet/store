package cn.tedu.store.service;

import org.springframework.transaction.annotation.Transactional;

//��ʶ�ӿڵ�����ʵ����ķ���ʵ��������
@Transactional
public interface IAccountService {
	public void account(String id1,String id2,Integer money);
}
