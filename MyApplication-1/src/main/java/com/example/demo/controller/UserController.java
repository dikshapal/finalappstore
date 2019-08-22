package com.example.demo.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.GetCartJDBCTemplate;
import com.example.demo.GroceryJDBCTemplate;
import com.example.demo.model.Cart;
import com.example.demo.model.Feedback;
import com.example.demo.model.Grocery;
import com.example.demo.model.Login;
import com.example.demo.model.Paybycash;
import com.example.demo.model.Registration;
import com.example.demo.repository.CartRepository;
import com.example.demo.repository.FeedbackRepository;
import com.example.demo.repository.MailuserRepository;
import com.example.demo.repository.UserRepository;

@CrossOrigin(origins = "http://localhost:4200")

@RestController

public class UserController {
	
	HttpSession session;
	
	
	
	ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	 
	
	GroceryJDBCTemplate groceryJDBCTemplate = 
	         (GroceryJDBCTemplate)context.getBean("groceryJDBCTemplate");
	
	GetCartJDBCTemplate getCartJDBCTemplate = 
	         (GetCartJDBCTemplate)context.getBean("getCartJDBCTemplate");
//
//
//	//private UserDetailsJDBCTemplate userDetailsJDBCTemplate;
//	
//	List<Registration> cs = RegistrationJDBCTemplate.list();
//	
//	@RequestMapping(value= {"/getstatus/{email}"},method=RequestMethod.GET)
//	@GetMapping(produces = "application/json")
//	public List<Registration> getStatus(){
//		return cs;
//	}
//	
    
    @Autowired
    UserRepository userRepository;
//    @GetMapping
//    public String check() {
//        return "welcome to app";
//        
//    }
//    
    @GetMapping(path="/getusernames")
       public List<String> getAllUserNames(){
        return userRepository.getAllUserNames();
    
}
    
    @RequestMapping(path="/register")
         public Registration create(@RequestBody Registration registration) {
          
          System.out.println("hi");
           userRepository.addUser(registration);
            //System.out.println(userId);
           return registration;
            
         }
    
    
  //  @RequestMapping(path="/register")
       //  public Paybycash create(@RequestBody Paybycash paybycash) {
          
         // System.out.println("hi");
        //   userRepository.billingAddress(paybycash);
            //System.out.println(userId);
         //  return paybycash;
            
       //  }
    
       //  @RequestMapping
    @RequestMapping( path="/login" , method=RequestMethod.POST)
     public boolean login(@RequestBody Login login, HttpServletRequest request) {
      boolean result=    userRepository.login(login);
      if(result== true) {
			int uid = userRepository.setSessionUid(login);
		
			session= request.getSession();
			session.setAttribute("UserId", uid);
		}
      System.out.println(result);
          return result;  
    }
    
    @RequestMapping( path="/fruit" , method=RequestMethod.GET)
    public List<Grocery> getFruit() {
    	List<Grocery> obj=groceryJDBCTemplate.list("fruitsandveggies");
    	return obj;
   //  System.out.println(result);
          
   }
    
    @RequestMapping( path="/cereal", method=RequestMethod.GET)
    public List<Grocery> getCereal() {
    	List<Grocery> obj=groceryJDBCTemplate.list("cereals");
    	for(Grocery g:obj) {
    		System.out.println(g.getFname());
    	}
    	return obj;
   //  System.out.println(result);
          
   }
    @RequestMapping( path="/packaged" , method=RequestMethod.GET)
    public List<Grocery> getPackaged() {
    	List<Grocery> obj=groceryJDBCTemplate.list("PackagedItem");
    	return obj;
   //  System.out.println(result);
          
   }
    @RequestMapping( path="/misc" , method=RequestMethod.GET)
    public List<Grocery> getMisc() {
    	List<Grocery> obj=groceryJDBCTemplate.list("Miscellaneous");
    	return obj;
   //  System.out.println(result);
          
   }
    
    @Autowired
    CartRepository cartRepository;
    
    @RequestMapping( path="/addtocart" , method=RequestMethod.POST)
    public Cart addtocart(@RequestBody Cart cart) {
    	System.out.println(cart.getFname());
    	int uid=(int) session.getAttribute("UserId");
    	cartRepository.addtocart(cart,uid);
    	return cart;
    }
    
    @RequestMapping( path="/getdetails" , method=RequestMethod.GET)
    public List<Cart>  getdetails(){
    	int uid=(int) session.getAttribute("UserId");
    	
    	List<Cart> obj=getCartJDBCTemplate.list(uid);
    	
    	return obj;
    }
    
    
    @RequestMapping( path="/updatequantity" , method=RequestMethod.POST)
    public int updatecart(@RequestBody Cart cart) {
    	int q= cart.getQuantity();
    	System.out.println("Quantity:"+ q);
    	int uid=(int) session.getAttribute("UserId");
    	int total =cartRepository.updatecart(uid,cart);
    	return  total;
    }
    
    
    @Autowired
    FeedbackRepository feedbackRepository;
    
    @RequestMapping( path="/feedback" , method=RequestMethod.POST)
    public Feedback feedback(@RequestBody Feedback feedback) {
    	
    	int uid=(int) session.getAttribute("UserId");
    	
    	System.out.println("UserId = " + uid);
    	feedbackRepository.insertFeedback(uid, feedback);
    	
    	return feedback;
 
    }
    
    @Autowired
    SpringMailController springMailController;
    
    @RequestMapping( path="/sendmail" , method=RequestMethod.GET)
    @Scheduled(fixedRate = 6000,initialDelay = 10000)
    public Boolean mailOrder()
    {
    	int uid=(int) session.getAttribute("UserId");
    	
    	springMailController.sendMail(uid);
    	return true;
    }
    
    @Autowired
    FeedbackmailController feedbackmailController;

    @RequestMapping( path="/feedbackmail" , method=RequestMethod.GET)
    @Scheduled(fixedRate = 6000,initialDelay = 10000)
    public Boolean FeedbackOrder()
  
  {
	  
	  System.out.println("UserId = feedback");
	  int uid=(int) session.getAttribute("UserId");
  	
	  feedbackmailController.sendMail(uid);
	  return true;
  }
}