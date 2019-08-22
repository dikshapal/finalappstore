package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.model.Grocery;


public class GroceryMapper implements RowMapper<Grocery> {
    @Override
    public Grocery mapRow(ResultSet rs, int rowNum) throws SQLException {
    	
    	Grocery cs = new Grocery();
        cs.setFid(rs.getInt("fid"));
        cs.setFname(rs.getString("fname"));
        cs.setFprice(rs.getFloat("fprice"));
        cs.setFweight(rs.getFloat("fweight"));
        cs.setCategory(rs.getString("category"));
  
        return cs;
    }
}