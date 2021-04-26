package com.goldrush.service;

import java.sql.SQLException;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.goldrush.dao.UserDAO;
import com.goldrush.dto.UserDTO;

public class service {
	 GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:dao-context.xml");
	 public int insert() throws SQLException {
		 UserDTO vo = new UserDTO();
		 vo.setId("4");
		 vo.setName("yuti");
		 vo.setName("kkk");
		 vo.setBalance("10000");
		 UserDAO dao =(UserDAO) ctx.getBean("UserDAO");
		 
		 return dao.newUser(vo);
	 }

public void select() {
	 UserDAO dao =(UserDAO) ctx.getBean("UserDAO");
}
}
