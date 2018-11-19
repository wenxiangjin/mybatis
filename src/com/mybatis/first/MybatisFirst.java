package com.mybatis.first;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.mybatis.po.User;

public class MybatisFirst {
	@Test
	public void findUserById() throws IOException
	{//配置文件
		String resource ="SqlMapConfig.xml";
		//得到配置流文件
		InputStream inputStream=Resources.getResourceAsStream(resource);
		//创建对话工厂
		SqlSessionFactory sqlSessionFactory = new
				SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession=sqlSessionFactory.openSession();
		User user =sqlSession.selectOne("test.findUserById", 1);
		System.out.println("user="+user);
	}  

	

}
