package com.tcs.springbootdemo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tcs.springbootdemo.entity.User;
import com.tcs.springbootdemo.exceptions.UserNotFoundException;
import com.tcs.springbootdemo.repository.IUserRepository;

@Service
public class UserService implements IUserService {
	@Autowired
	IUserRepository userRepository;

	@Override
	@Transactional(rollbackFor = Exception.class, noRollbackFor = IllegalStateException.class) // Do rollback for all
	public void save(User user) {
		userRepository.save(user);
//		throw new IllegalStateException(); //just simulating a problem to test transactions
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
	@Transactional(rollbackFor = Exception.class)
	public void deleteUser(Integer id) {
		userRepository.deleteById(id);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void update(User user, Integer id) {
		Optional<User> userFromDB = userRepository.findById(id);
		if (userFromDB.isPresent()) {
			//proceed with merging
			userFromDB.get().setEmail(user.getEmail());
		}
//		if (StringUtils.hasText(user.getFirstName()))
//			user1.setFirstName(user.getFirstName());
		userRepository.save(userFromDB.get());
	}

}
