package com.example.demo.controller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.FeedbackMailRepository;
import com.example.demo.repository.RegistrationRepository;

@RestController
public class FeedbackmailController {
    
    int times= 6;
 
   // private ThreadPoolTaskScheduler scheduler;
    
    @Autowired
    private JavaMailSender sender;
    
    @Autowired
    FeedbackMailRepository mailrepository;
    
    @Autowired
    RegistrationRepository RegistrationRepository;
  
    public String sendMail(int uid) {
        
        System.out.println("0");
       
        
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
         
      
        int status = RegistrationRepository.feedbackstatus(uid);
        
        String email = RegistrationRepository.registeremail(uid);
  
       
        if(status == 0) {

        try {
         
            
       
            System.out.println("12");
            System.out.println(email);
            
            System.out.println("2");
            
            
           if(times==6) {
                helper.setTo(email);
                System.out.println("3");
                helper.setText("Please Give Feedback.");
                System.out.println("4");
                helper.setSubject("About feedback");
                System.out.println("5");
                }
            
            if(times==12) {
                helper.setTo(email);
                System.out.println("3");
                helper.setText("Please Give Feedback.");
                System.out.println("4");
                helper.setSubject("About feedback");
                System.out.println("5");
                }
            
            if(times==18) {
                helper.setTo(email);
                System.out.println("3");
                helper.setText("Please Give Feedback.");
                System.out.println("4");
                helper.setSubject("About feedback");
                System.out.println("5");
               }
            if(times==24) {
                helper.setTo(email);
                System.out.println("3");
                helper.setText("Please Give Feedback.");
                System.out.println("4");
                helper.setSubject("About feedback");
                System.out.println("5");
               }
                
            
            System.out.println("done " + times);
            
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("Error................");
            return "Error while sending mail ..";
        }
        
        System.out.println("6");
        sender.send(message);
        System.out.println("7");
        }
    
        System.out.println("status"+status);
        
        if(times==24 && status == 0) {

            mailrepository.incr_negative_point(uid);
        }
        times = times+6;
        
//        if(times>=25) {
//            scheduler.shutdown();
//        }
        return "Mail Sent Success!";
    }
    
}
