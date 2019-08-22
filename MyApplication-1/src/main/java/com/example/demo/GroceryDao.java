package com.example.demo;

import java.util.List;

import javax.sql.DataSource;

import com.example.demo.model.Grocery;

public interface GroceryDao {
    public void setDataSource(DataSource ds);

       public List<Grocery> list();
}