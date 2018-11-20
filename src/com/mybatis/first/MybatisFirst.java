package com.mybatis.first;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

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
	@Test
	public void findUserByName() throws IOException
	{
		String resource ="SqlMapConfig.xml";
		InputStream inputStream=Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlsessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		 SqlSession sqlSession =sqlsessionFactory.openSession();
			List<Object> list=sqlSession.selectList("test.findUserByName","测试用户");
			for(
					//多态
					Object user:list	)	{
				System.out.println(user);
			}
			sqlSession.close();
	}
	@Test
		public void insertUser() throws IOException
		{
			String resource ="SqlMapConfig.xml";
			InputStream inputStream=Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlsessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession sqlSession=sqlsessionFactory.openSession();
			User user=new User();
			user.setBirthday(new Date());
			user.setSex("M");
			user.setUsername("芦苇");
			user.setAddress("哈尔滨");
			sqlSession.insert("test.insertUser",user);
			sqlSession.commit();
			sqlSession.close();
			}
		
		}
