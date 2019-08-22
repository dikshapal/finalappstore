package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.model.Cart;


public class GetCartMapper implements RowMapper<Cart> {
    @Override
    public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
    	
    	Cart cs = new Cart();
    	cs.setFid(rs.getInt("fid"));
        cs.setFname(rs.getString("fname"));
        cs.setFprice(rs.getFloat("fprice"));
        cs.setFweight(rs.getFloat("fweight"));
        cs.setQuantity(rs.getInt("quantity"));
  
        return cs;
    }
}