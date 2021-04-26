package com.goldrush.app;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.goldrush.dao.Userdao;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:dao-context.xml")
public class aaa {

	@Test
	public void test() {
		Userdao a = new Userdao();
		a.read("1");
	}

}
