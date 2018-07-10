package cn.tedu.store.mapper;

import org.apache.ibatis.annotations.Param;

public interface AccountMapper {
	
	Integer select1();//id–¥À¿
	Integer select2();//id–¥À¿
	Integer update1(@Param("id1")String id1,@Param("money")Integer money);
	Integer update2(@Param("id2")String id2,@Param("money")Integer money);
	
}
