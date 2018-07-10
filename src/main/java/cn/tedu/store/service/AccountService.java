package cn.tedu.store.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.store.mapper.AccountMapper;

@Service
public class AccountService implements IAccountService {
	@Resource
	private AccountMapper accountMapper;

	public void account(String id1, String id2, Integer money) {
		Integer n1 = accountMapper.update1(id1, accountMapper.select1() - money);

		if (n1 == 0) throw new RuntimeException("ÐÞ¸ÄÊ§°Ü");
		

		Integer n2 = accountMapper.update2(id2, accountMapper.select2() + money);
		if (n2 == 0) throw new RuntimeException("ÐÞ¸ÄÊ§°Ü!");
		

	}

}
