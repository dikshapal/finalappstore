package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RegistrationRepository {
	
	  @Autowired
	    JdbcTemplate jdbcTemplate;
	    
	    public String registeremail(int uid) {
	        
	    	String email= "";
	    
	        try {
	            
	            
	        email = (jdbcTemplate.queryForObject(
	                "select email from Registration where userid =  ?",
	                String.class, uid));
	        
	        }catch(EmptyResultDataAccessException e) {
	            
	        }
	        
	        return email;
	        
	    }
	    
		    
		    public int feedbackstatus(int uid) {
		        
		    	int status = 0;
		    
		        try {
		            
		            
		        	status = (jdbcTemplate.queryForObject(
		                "select feedbackstatus from Registration where userid =  ?",
		                Integer.class, uid));
		        
		        }catch(EmptyResultDataAccessException e) {
		            
		        }
		        
		        return status;
		        
		    }
	

}
