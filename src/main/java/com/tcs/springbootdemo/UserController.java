package com.tcs.springbootdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController { //spring bean, act as request receiver
	@GetMapping("/getuser")
	private String getUser() {
		System.out.println("called");
		return "hello";
	}
	@PostMapping("/user")
	private void saveUser(@RequestBody User user) {
		System.out.println(user.getFirstName());
	}
}
