package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Login;
import com.example.demo.model.Paybycash;
import com.example.demo.model.Registration;


@Repository
public class UserRepository extends JdbcDaoSupport {
    
     List<Map<String,Object>> obj=new ArrayList<>();
    //@Autowired
    //JdbcTemplate jdbcTemplate;
    //private DataSource dataSource;
	
    @Autowired 
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
    
    /*
	 * public void setDataSource(DataSource dataSource) { this.dataSource =
	 * dataSource; this.jdbcTemplate = new JdbcTemplate(dataSource); }
	 */
    
    //@Bean
	/*
	 * public JdbcTemplate jdbcTemplate(DataSource dataSource) { return new
	 * JdbcTemplate(dataSource); }
	 */
    
 

    
    
    
    
	/*
	 * public void setDataSource(DataSource dataSource) { this.dataSource =
	 * dataSource; this.jdbcTemplate = new JdbcTemplate(dataSource);
	 * 
	 * }
	 */
          
       public void addUser(Registration registration)
  
        { 
            String email= registration.getEmail();
            getJdbcTemplate().update("insert into Registration (firstname,lastname,email,password,address,Contact)values(?,?,?,?,?,?)",registration.getFirstname(),registration.getLastname(),registration.getEmail(),registration.getPassword(),registration.getAddress(),registration.getContact());
            //int userId =jdbcTemplate.queryForObject("select userId from  registration where email=?",Integer.class,email);
           
        }
    
    //   public void billingAddress(Paybycash paybycash)
       
       //{ 
      //     String email= paybycash.getName();
      //     getJdbcTemplate().update("insert into paybycash (name,address,city ,Zipcode)values(?,?,?,?)",paybycash.getName(),paybycash.getAddress(),paybycash.getCity(),paybycash.getZipcode());
           //int userId =jdbcTemplate.queryForObject("select userId from  registration where email=?",Integer.class,email);
          
      // }
    
    public List<String> getAllUserNames(){
        List<String> usernameList= new ArrayList<>();
    
    
        usernameList.addAll(getJdbcTemplate().queryForList("select firstname from Registration;",String.class));
        
        return usernameList;
        }
    
     public boolean login(Login login) {
//            String em= login.getEmail();
//            String pass= login.getPassword();
//            
//            String sql="select email, password from Registration where email = ? AND password= ?";
//            //jdbcTemplate.update("select emailId, password from registration where emailId=? AND password=?",user.getEmail(),user.getPassword());
//            obj=jdbcTemplate.queryForList(sql,em,pass);
//            System.out.println(obj);
        System.out.println("Inside ");
         String email = login.getEmail();
            String password = login.getPassword();
            System.out.println(email);
            System.out.println(password);

            try {
                String checkUserName = (getJdbcTemplate().queryForObject(
                        "select email from Registration where email = ?", String.class, email));

                String checkPassword = getJdbcTemplate().queryForObject("select password from Registration where email=?",
                        String.class, email);
                
                System.out.println(checkUserName);
                System.out.println(checkPassword);

                if ((checkUserName.equals(email)) && (checkPassword.equals(password))) {
                    return true;
                }
            } catch (EmptyResultDataAccessException e) {

            }
            return false;

        
        }

		// Session Creation on the way
	public int setSessionUid(Login login) {
		
		String email = login.getEmail();
		int sessionUid = (getJdbcTemplate().queryForObject(
				"select userid from Registration where email = ?", 
				Integer.class, email));
		
		System.out.println(sessionUid);
		return sessionUid;
	}
     
     
        
    }