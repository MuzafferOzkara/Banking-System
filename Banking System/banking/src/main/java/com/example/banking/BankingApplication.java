package com.example.banking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.example.banking.dao.UserDAO;
import com.example.banking.model.User;

@SpringBootApplication
@EnableJpaAuditing
@AutoConfigureAfter(value=HibernateJpaAutoConfiguration.class)
public class BankingApplication implements CommandLineRunner{
	
	@Autowired
	private UserDAO userDAO;

	public static void main(String[] args) {
		SpringApplication.run(BankingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
//		User user1=new User((long) 1,"muzq@gmail.com","1234", "muzqqq", "muz", 520);
//		User user2=new User((long) 2,"furq@gmail.com","1234", "furqqq", "fur", 452);
//		User user3=new User((long) 3,"sevq@gmail.com","1234","sevqqq", "sev", 697);
//		User user4=new User((long) 4,"burq@gmail.com","1234", "burqqq", "bur", 560);
//		
//		userDAO.save(user1);
//		userDAO.save(user2);
//		userDAO.save(user3);
//		userDAO.save(user4);
//		
		
	}

}
