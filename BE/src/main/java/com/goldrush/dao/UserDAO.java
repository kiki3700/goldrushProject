package com.goldrush.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.goldrush.dto.UserDTO;

public class UserDAO {
	
	
	
	private final DB db;
	
	static void main(String[] args) throws SQLException {
		DB dh = new DBHandler();
		
		UserDAO a = new UserDAO(dh);
		
		a.select();
		
	}
	
	
	public UserDAO(DB db) {
		this.db = db;
	}
	
	public int newUser(UserDTO vo) throws SQLException{
        Connection c = db.connect();

        
        PreparedStatement preparedStatement = c.prepareStatement(
                "insert into users(id, name, tokeon, balance) values(?,?,?,?)");

        preparedStatement.setString(1, vo.getId());
        preparedStatement.setString(2, vo.getName());
        preparedStatement.setString(3, vo.getTokeon());
        preparedStatement.setString(4, vo.getBalance());
        preparedStatement.executeUpdate();
        preparedStatement.close();

        db.disconnect();
        return 0;
    }
	public void select() throws SQLException {

        try {
            ResultSet rs=null;
            Connection c = db.connect();
			Statement stmt = c.createStatement();
			rs=stmt.executeQuery("select * from users");
			
			while(rs.next()) {
				String id = rs.getString("id");
				System.out.println(id);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        db.disconnect();
	}
}
