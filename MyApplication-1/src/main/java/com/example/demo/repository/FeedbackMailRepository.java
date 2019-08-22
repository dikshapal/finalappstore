package com.example.demo.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class FeedbackMailRepository {
    
    @Autowired
    JdbcTemplate jdbcTemplate;
     public boolean getfeedback_status(int uid) {
        
        String FB = "";
        System.out.println("00");
        
        String  email ="Ravi@Kumar";
        System.out.println("001");
        try {
            
            System.out.println("2");
            
        FB = (jdbcTemplate.queryForObject(
                "select feedback_status from Registration where userid =  ?",
                String.class, uid));
        
        }catch(EmptyResultDataAccessException e) {
            
        }
        
        System.out.println("FeedBack Is" + FB);
        if(FB.equals("1")) {
            return true;
        }
        if(FB.equals("0")) {
            return false;
        }
        return true;
    }
    public void incr_negative_point(int uid) {
    
            //  String SQL = "update Registration set negative_points = negative_points + 1 where userid  = ?";
          
              jdbcTemplate.update("update Registration set negativePoints = negativePoints + 1 where userid = ?",uid);
              return;
           
     }
    
}
