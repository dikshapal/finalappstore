package com.example.demo;


import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.demo.model.Order;


public class OrderJDBCTemplate {
    private DataSource dataSource;
       private JdbcTemplate jdbcTemplateObject;
       
       
       @Bean
       public JdbcTemplate jdbcTemplate(DataSource dataSource) {
           return new JdbcTemplate(dataSource);
       }
    

//       public List<Order> list(int uid) {
//    	   
//  
//           String SQL = "select fname,fprice,fweight from cart where uid=?";
//          
//              List<Order> cs = jdbcTemplateObject.query(SQL, new OrderMapper(),uid);
//              return cs ;
//    }


    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
          this.jdbcTemplateObject = new JdbcTemplate(dataSource);
        
    }

}