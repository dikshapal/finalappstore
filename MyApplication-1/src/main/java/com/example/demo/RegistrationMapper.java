package com.example.demo;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.model.Registration;
import com.example.demo.model.UserDetails;

public class RegistrationMapper implements RowMapper<Registration> {
    @Override
    public Registration mapRow(ResultSet rs, int rowNum) throws SQLException {
    	Registration cs = new Registration();
        cs.setFirstname(rs.getString("firstname"));
        cs.setLastname(rs.getString("lastname"));
        cs.setPassword(rs.getString("password"));
        cs.setEmail(rs.getString("email"));
        cs.setAddress(rs.getString("address"));
        cs.setContact(rs.getInt("Contact"));
    
        return cs;
    }
}