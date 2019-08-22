package com.example.demo;

import java.util.List;

import javax.sql.DataSource;

import com.example.demo.model.Cart;
import com.example.demo.model.Grocery;

public interface GetCartDao {
    public void setDataSource(DataSource ds);

       public List<Cart> list();
}