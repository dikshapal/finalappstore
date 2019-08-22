package com.example.demo;


import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.demo.model.Registration;
import com.example.demo.model.UserDetails;

public class UserDetailsJDBCTemplate {
    private DataSource dataSource;
       private JdbcTemplate jdbcTemplateObject;
       
       
       @Bean
       public JdbcTemplate jdbcTemplate(DataSource dataSource) {
           return new JdbcTemplate(dataSource);
       }
    

       public List<UserDetails> list() {
           String SQL = "select * from Registration where email=?";
           String email="diksha@pal";
              List<UserDetails> cs = jdbcTemplateObject.query(SQL, new UserDetailsMapper(),email);
              return cs ;
    }


    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
          this.jdbcTemplateObject = new JdbcTemplate(dataSource);
        
    }

}