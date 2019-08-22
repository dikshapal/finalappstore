package com.example.demo;


import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.demo.model.Grocery;


public class GroceryJDBCTemplate {
    private DataSource dataSource;
       private JdbcTemplate jdbcTemplateObject;
       
       
       @Bean
       public JdbcTemplate jdbcTemplate(DataSource dataSource) {
           return new JdbcTemplate(dataSource);
       }
    

       public List<Grocery> list(String category) {
    	   
  
           String SQL = "select * from grocery where category=?";
          
              List<Grocery> cs = jdbcTemplateObject.query(SQL, new GroceryMapper(),category);
              return cs ;
    }


    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
          this.jdbcTemplateObject = new JdbcTemplate(dataSource);
        
    }

}