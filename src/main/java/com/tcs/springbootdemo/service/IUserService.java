package com.tcs.springbootdemo.service;

import java.util.Optional;

import com.tcs.springbootdemo.User;

public interface IUserService {
	void save(User user);

	Iterable<User> getAllUsers();

	Optional<User> getUser(Integer id);

	void deleteUser(Integer id);
}
