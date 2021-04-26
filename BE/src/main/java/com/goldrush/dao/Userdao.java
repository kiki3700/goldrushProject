package com.goldrush.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.goldrush.dto.UserDTO;

@Repository
public class Userdao {
	
    @Inject
    SqlSession sqlSession;
    private static final String NAMESPACE = "mappers.userMapper";
    
    
    public UserDTO read(String id) {
        UserDTO user = sqlSession.selectOne(NAMESPACE + ".selectUserById", id);
        return user;
    }
}
