package com.example.demo;

import java.util.List;

import javax.sql.DataSource;

import com.example.demo.model.Order;

public interface OrderDao {
    public void setDataSource(DataSource ds);

       public List<Order> list();
}