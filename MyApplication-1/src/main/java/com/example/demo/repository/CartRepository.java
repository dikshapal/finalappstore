package com.example.demo.repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Cart;

@Repository
public class CartRepository extends JdbcDaoSupport{

	 @Autowired 
		DataSource dataSource;
	 
	 float subTotal;
		
		@PostConstruct
		private void initialize(){
			setDataSource(dataSource);
		}
		
		public void addtocart(Cart cart,int uid) {
			
			subTotal =(cart.getFprice() * 1);
			
			System.out.println(cart.getFname());
			 getJdbcTemplate().update("insert into cart (uid,fid,quantity,fname,fprice,fweight,SubTotal) values(?,?,?,?,?,?,?)",
					 uid,cart.getFid(),1,cart.getFname(),cart.getFprice(),cart.getFweight(),subTotal);
		}

		public int updatecart(int uid,Cart cart) {
			
			System.out.println("Quantityyyy = "+ cart.getQuantity());
			
			

			System.out.println("uidddd = "+ uid);
			
			

			System.out.println("Fiddddd = "+ cart.getFid());
			

			
			getJdbcTemplate().update("update cart set quantity = ?,subtotal=? where uid = ? and fid=? ",cart.getQuantity(),cart.getFprice()*cart.getQuantity(),uid,cart.getFid());
			
			
			
			int total= getJdbcTemplate().queryForObject("select Sum(SubTotal) from cart where uid = ?",Integer.class,uid);
			
			return total;

			
			
		}
		
		
}
