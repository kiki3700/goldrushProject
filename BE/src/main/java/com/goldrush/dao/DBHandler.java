package com.goldrush.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

public class DBHandler implements DB {
	Connection conn =null;
	
	public DBHandler() {
		
	}
	@Override
	public Connection connect() {
		// TODO Auto-generated method stub

		 try {
			GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:dao-context.xml");
			SimpleDriverDataSource ds = (SimpleDriverDataSource) ctx.getBean("dataSource");
			conn = ds.getConnection();
			System.out.println("정상적으로 연결되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return conn;
	}

	@Override
	public int disconnect() {
		// TODO Auto-generated method stub
        try {
            if(conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            return -1;
        }

		return 0;
	}

}
