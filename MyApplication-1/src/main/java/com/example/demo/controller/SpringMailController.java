package com.example.demo.controller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.MailuserRepository;


@Repository
public class SpringMailController {
    
    int times= 0;
    
    @Autowired
    private JavaMailSender sender;
    @Autowired
    MailuserRepository userrepository;

    public String sendMail(int uid) {
        
        if(times<=4) {
       
        
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        
      
        String email="" ;
        System.out.println("1");
        
       

        try {
            email = userrepository.getemail(uid);
       
            System.out.println("12");
            System.out.println(email);
           
            //Notifications
            if(times==0) {
                helper.setTo(email);
                System.out.println("3");
                helper.setText("Your order is Confermed.");
                System.out.println("4");
                helper.setSubject("Order Status.");
                System.out.println("5");
                }
            
            if(times==1) {
            helper.setTo(email);
            System.out.println("3");
            helper.setText("Your order is Dispached!!");
            System.out.println("4");
            helper.setSubject("Order Status.");
            System.out.println("5");
            }
            
            
            if(times==2) {
            helper.setTo(email);
            System.out.println("3");
            helper.setText("Your order is Arriving in 2 hours");
            System.out.println("4");
            helper.setSubject("Order Status.");
            System.out.println("5");
            }
            
            if(times==3) {
            helper.setTo(email);
            System.out.println("3");
            helper.setText("Your order is Arriving in 1 hours");
            System.out.println("4");
            helper.setSubject("Order Status.");
            System.out.println("5");
            }
            
            
            if(times==4) {
            helper.setTo(email);
            System.out.println("3");
            helper.setText("Your order is delivered successfully!!");
            System.out.println("4");
            helper.setSubject("Order Status.");
            System.out.println("5");
            }
            
           
            System.out.println("done " + times);
            
        } catch (MessagingException e) {
            e.printStackTrace();
            return "Error while sending mail ..";
        }
        System.out.println("Try Block executeted successfully");
        sender.send(message);
        System.out.println("Message sent!!");
        
    
        times++;
            
        }
        return "Mail Sent Success!";
    }


}