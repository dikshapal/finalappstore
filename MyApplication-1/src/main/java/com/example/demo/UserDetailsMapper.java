package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.model.Registration;
import com.example.demo.model.UserDetails;

public class UserDetailsMapper implements RowMapper<UserDetails> {
    @Override
    public UserDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
    	UserDetails cs = new UserDetails();
        cs.setFirstname(rs.getString("firstname"));
        cs.setLastname(rs.getString("lastname"));
        cs.setPassword(rs.getString("password"));
        cs.setEmail(rs.getString("email"));
        cs.setAddress(rs.getString("address"));
        cs.setContact(rs.getInt("Contact"));
    
        return cs;
    }
}