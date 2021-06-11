package com.wyhw.pmp.jpa;

import com.wyhw.pmp.jpa.dao.UserRepository;
import com.wyhw.pmp.jpa.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserOp {
	@Autowired
	private UserRepository userRepository;

	@Test
	void testAdd() {
		User user = new User();
		user.setName("小王");
		user.setSex("1");
		user.setBirthday("1993-03-30");
		userRepository.save(user);
	}
	@Test
	void testGet() {
		Optional<User> one = userRepository.findById(1);
		if (!one.isPresent()) {
			System.out.println("无数据");
			return;
		}
		System.out.println(one.get().getName());
	}
}
