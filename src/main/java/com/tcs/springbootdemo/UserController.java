package com.tcs.springbootdemo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController { //spring bean, act as request receiver
	@Autowired  //DI
	IUserService userService;
	
	@GetMapping("/user")
	private Iterable<User> getUser() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/user/{id}")
	private Optional<User> getUser(@PathVariable("id") Integer id) {
		return userService.getUser(id);
	}
	
	@ExceptionHandler(value = UserNotFoundException.class)
	   public ResponseEntity<User> exception(UserNotFoundException userNotFoundException) {
	      return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	   }
	@PostMapping("/user")
	private void saveUser(@RequestBody User user) {
		userService.save(user);
		System.out.println(user.getFirstName());
	}
	@PutMapping("/user") //METHOD+Path
	private void updateUser(@RequestBody User user) {
		userService.save(user);
		System.out.println(user.getFirstName());
	}
}
