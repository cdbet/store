package test;

import java.io.FileInputStream;


import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

public class TestMD5 {

	@Test
	public void test1() throws Exception {
		String str1 = "abc123";
		String str2 = "ƒ„’®¡À!";

		String rsStr1 = DigestUtils.md5Hex(str1);
		String rsStr2 = DigestUtils.md5Hex(str2);
		System.out.println(rsStr1);
		System.out.println(rsStr2);
		
		String rs1=DigestUtils.md5Hex(new FileInputStream("pom.xml"));
		String rs2=DigestUtils.md5Hex(new FileInputStream("pom2.xml"));
		System.out.println(rs1);
		System.out.println(rs2);

	}
	@Test
	public void test2() {
		String pwd="123456";
		String salt="ƒ„’®¡À!";
		String rs=DigestUtils.md5Hex(pwd+salt);
		System.out.println(rs);
	}
}
