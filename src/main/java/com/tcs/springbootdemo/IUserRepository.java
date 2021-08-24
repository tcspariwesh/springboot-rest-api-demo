package com.tcs.springbootdemo;

import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<User, Integer>{

}
