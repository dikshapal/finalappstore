package com.example.demo;


import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.demo.model.Cart;

public class GetCartJDBCTemplate {
    private DataSource dataSource;
       private JdbcTemplate jdbcTemplateObject;
       
       
       @Bean
       public JdbcTemplate jdbcTemplate(DataSource dataSource) {
           return new JdbcTemplate(dataSource);
       }
    

       public List<Cart> list(int uid) {
    	   
  
           String SQL = "select fid,fname,fprice,fweight,quantity from cart where uid=?";
          
              List<Cart> cs = jdbcTemplateObject.query(SQL, new GetCartMapper(),uid);
              return cs ;
    }


    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
          this.jdbcTemplateObject = new JdbcTemplate(dataSource);
        
    }

}