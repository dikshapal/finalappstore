package com.example.demo.model;

public class Registration {
	 private String firstname;
	    private String lastname;
	    private String password;
	    private String email;
	   
	    private String address;
	    
	    private int Contact;
	    
	    
		public String getFirstname() {
			return firstname;
		}
		public void setFirstname(String i) {
			this.firstname = i;
		}
		public String getLastname() {
			return lastname;
		}
		public void setLastname(String lastname) {
			this.lastname = lastname;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		
			
		 public String getAddress() {
				return address;
			}
		  public void setAddress(String address) {
				this.address = address;
			}
		 
			
			
		public int getContact() {
			return Contact;
		}
		public void setContact(int contact) {
			this.Contact = contact;
		}

}
