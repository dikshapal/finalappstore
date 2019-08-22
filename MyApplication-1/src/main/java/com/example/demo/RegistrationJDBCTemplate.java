package com.example.demo;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.demo.model.Registration;
import com.example.demo.model.UserDetails;

public class RegistrationJDBCTemplate {
    private DataSource dataSource;
       private static JdbcTemplate jdbcTemplateObject;
       
       
       @Bean
       public JdbcTemplate jdbcTemplate(DataSource dataSource) {
           return new JdbcTemplate(dataSource);
       }
    

       public static List<Registration> list() {
           String SQL = "select * from Registration where email=?";
           String email="diksha@pal";
              List<Registration> cs = jdbcTemplateObject.query(SQL, new RegistrationMapper(),email);
              return cs ;
    }


    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
          this.jdbcTemplateObject = new JdbcTemplate(dataSource);
        
    }

}