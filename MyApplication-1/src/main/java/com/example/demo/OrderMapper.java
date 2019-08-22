package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.model.Cart;


public class OrderMapper implements RowMapper<Cart> {
    @Override
    public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
    	
    	Cart cs = new Cart();

        cs.setFname(rs.getString("fname"));
        cs.setFprice(rs.getFloat("fprice"));
        cs.setFweight(rs.getFloat("fweight"));
  
        return cs;
    }
}