package com.myreflectionthoughts.jwt.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.myreflectionthoughts.jwt.entity.User;

@Repository
public interface UserRepository extends MongoRepository<User,String>{
   User findByUserName(String userName);	
}
 