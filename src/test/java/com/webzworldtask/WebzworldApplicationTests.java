package com.webzworldtask;

import com.webzworldtask.entity.User;
import com.webzworldtask.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class WebzworldApplicationTests {

	@Autowired
	UserRepository userRepo;

	@Test
	void saveOneUser() {
		User user=new User();
		user.setName("Nasir");
		user.setEmail("nas@gmail.com");
		userRepo.save(user);
	}

	@Test
	void findOneUser(){
		Optional<User> user=userRepo.findById(10L);
		User user1=user.get();
		System.out.println(user1.getId());
		System.out.println(user1.getName());
		System.out.println(user1.getEmail());
	}

	@Test
	void findAllUser(){
		List<User> user=userRepo.findAll();
		System.out.println(user);
	}

	@Test
	void updateOneUser(){
		User user=userRepo.findById(1L).get();
		user.setName("JR");
		user.setName("jr@gmail.com");
		userRepo.save(user);
	}

	@Test
	void deleteOneUser(){
		User user=userRepo.findById(9L).get();
		userRepo.delete(user);
	}

	@Test
	void findUserByName(){
		User user=userRepo.findByName("Nasiruddin");
		System.out.println(user.getId());
		System.out.println(user.getEmail());
	}
}
