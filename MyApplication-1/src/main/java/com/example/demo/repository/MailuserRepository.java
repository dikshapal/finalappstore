package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MailuserRepository {
    
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    public String getemail(int uid) {
        
    	String email= "";
    
        try {
            
            System.out.println("2");
            
        email = (jdbcTemplate.queryForObject(
                "select email from Registration where userid =  ?",
                String.class, uid));
        
        }catch(EmptyResultDataAccessException e) {
            
        }
        
        System.out.println(email);
        
        return email;
        
    }
    
} 