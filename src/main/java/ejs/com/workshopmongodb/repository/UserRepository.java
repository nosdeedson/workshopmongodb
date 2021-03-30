package ejs.com.workshopmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import ejs.com.workshopmongodb.domain.User;

public interface UserRepository extends MongoRepository<User, String> {

}
