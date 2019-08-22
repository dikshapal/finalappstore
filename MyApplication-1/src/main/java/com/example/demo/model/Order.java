package com.example.demo.model;
public class Order {
    
    private int OrderId;
    private int Quantity;
    private String OrderDate;
    private String ShippingDate;
    private float OrderTotal;
    
    
	public int getOrderId() {
		return OrderId;
	}
	public void setOrderId(int orderId) {
		OrderId = orderId;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public String getOrderDate() {
		return OrderDate;
	}
	public void setOrderDate(String orderDate) {
		OrderDate = orderDate;
	}
	public String getShippingDate() {
		return ShippingDate;
	}
	public void setShippingDate(String shippingDate) {
		ShippingDate = shippingDate;
	}
	public float getOrderTotal() {
		return OrderTotal;
	}
	public void setOrderTotal(float orderTotal) {
		OrderTotal = orderTotal;
	}
    
   
        

}