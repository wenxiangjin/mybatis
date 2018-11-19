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
	{//�����ļ�
		String resource ="SqlMapConfig.xml";
		//�õ��������ļ�
		InputStream inputStream=Resources.getResourceAsStream(resource);
		//�����Ի�����
		SqlSessionFactory sqlSessionFactory = new
				SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession=sqlSessionFactory.openSession();
		User user =sqlSession.selectOne("test.findUserById", 1);
		System.out.println("user="+user);
	}  

	

}
