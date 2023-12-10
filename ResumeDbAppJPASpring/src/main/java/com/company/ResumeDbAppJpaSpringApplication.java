package com.company;

import com.company.dao.impl.UserRepository;
import com.company.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ResumeDbAppJpaSpringApplication {
	@Autowired
   private UserRepository userRepository;

//	@Autowired
//	@Qualifier("myObj")
//	private  Object obj;
	public static void main(String[] args) {
		SpringApplication.run(ResumeDbAppJpaSpringApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner run(){
//		CommandLineRunner clr=new CommandLineRunner() {
//			@Override
//			public void run(String... args) throws Exception {
//				List<User> list=userDao.getAll(null,null,null);
//				User u=list.get(0);
//				u.setName(u.getName().toLowerCase());
//				userDao.updateUser(u);
//			}
//		};
//		return  clr;
//	}
@Bean
public CommandLineRunner run(){
	CommandLineRunner clr=new CommandLineRunner() {
		@Override
		public void run(String... args) throws Exception {
//			List<User> list=userRepository.findAll();
//			System.out.println(list);
//			 list=userRepository.findAll(Sort.by(Sort.Order.desc("id")));
//			System.out.println(list);
//			User u=userRepository.findById(6).get();
//			System.out.println(u);
//			User u=userRepository.findByName("heyder3");
//			System.out.println(u);
//			User u2=userRepository.findByNameAndSurname("test2","test2");
//			System.out.println(u2);
			List<User> u=userRepository.getAll(null,null,null);
			System.out.println(u);
		}
	};
	return  clr;
}
}
