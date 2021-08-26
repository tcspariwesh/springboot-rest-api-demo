package com.tcs.springbootdemo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.tcs.springbootdemo.entity.User;
import com.tcs.springbootdemo.exceptions.UserNotFoundException;
import com.tcs.springbootdemo.repository.IUserRepository;

@Service
public class UserService implements IUserService {
	@Autowired
	IUserRepository userRepository;

	@Override
	@Transactional(rollbackFor = Exception.class) //Do rollback for all type of Exceptions
	public void save(User user) throws Exception {
		userRepository.save(user);
		System.out.println("saved");
		throw new Exception();
	}

	@Override
	public Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public Optional<User> getUser(Integer id) {
		Optional<User> user = userRepository.findById(id);
		if (!user.isPresent()) {
			throw new UserNotFoundException("user does not exist");
		}
		return user;
	}

	@Override
	public void deleteUser(Integer id) {
		userRepository.deleteById(id);
	}

	@Override
	public void update(User user, Integer id) {
		Optional<User> userFromDB = userRepository.findById(id);
		User user1 = userFromDB.get();
		if(user1.getId() != null) {
			
		}
		if (StringUtils.hasText(user.getFirstName()))
			user1.setFirstName(user.getFirstName());
		userRepository.save(user1);
	}

}
