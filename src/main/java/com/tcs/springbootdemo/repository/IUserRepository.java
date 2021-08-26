package com.tcs.springbootdemo.repository;

import org.springframework.data.repository.CrudRepository;

import com.tcs.springbootdemo.entity.User;

public interface IUserRepository extends CrudRepository<User, Integer>{

}
