package com.example.demo.repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Feedback;


@Repository
public class FeedbackRepository extends JdbcDaoSupport{

	
	 @Autowired 
		DataSource dataSource;
	 
		
		@PostConstruct
		private void initialize(){
			setDataSource(dataSource);
		}
		
	
	public void insertFeedback(int uid, Feedback feedback) { 
		
		
		System.out.println("hi");

		getJdbcTemplate().update("insert into Feedbacktable (uid,email ,comments)values(?,? ,?)",uid, feedback.getEmail() , feedback.getComments());
		
		
		getJdbcTemplate().update("update Registration set feedbackstatus = 1 where userid = ?" , uid);
    
	}

}
