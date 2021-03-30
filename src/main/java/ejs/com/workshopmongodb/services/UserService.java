package ejs.com.workshopmongodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ejs.com.workshopmongodb.domain.User;
import ejs.com.workshopmongodb.repository.UserRepository;
import ejs.com.workshopmongodb.services.exception.ObjectNotFound;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public void delete(String id) {
		this.findById(id);
		this.userRepository.deleteById(id);
	}
	
	public List<User> findAll(){
		List<User> users = this.userRepository.findAll();
		return users;
	}
	
	public User findById( String id) {
		User user = this.userRepository.findById(id)
				.orElseThrow(() -> new ObjectNotFound("Usuário não encontrado") );
		return user;
	}
	
	public User insert( User user) {
		return this.userRepository.insert(user);
	}
	
	public void update( User user, String id) {
		User newUser = this.findById(id);
		newUser.setEmail(user.getEmail());
		newUser.setName(user.getName());
	}
}
