package com.how2do.user.management.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.how2do.user.management.entity.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
