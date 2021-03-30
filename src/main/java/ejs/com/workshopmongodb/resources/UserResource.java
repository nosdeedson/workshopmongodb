package ejs.com.workshopmongodb.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import ejs.com.workshopmongodb.domain.User;
import ejs.com.workshopmongodb.services.UserService;

@RestController
@RequestMapping("users")
public class UserResource {
	
	@Autowired
	private UserService userService;
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> delete(@PathVariable String id){
		this.userService.delete(id);
		return ResponseEntity.ok().body("Deletado com sucesso");
	}

	@GetMapping
	public ResponseEntity<?> findAll(){
		List<User> users = userService.findAll();
		return ResponseEntity.ok(users);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> findById(@PathVariable String id ){
		User user = this.userService.findById(id);
		return ResponseEntity.ok(user);
	}
	
	@GetMapping("{id}/posts")
	public ResponseEntity<?> findPosts(@PathVariable String id){
		User user = this.userService.findById(id);
		return ResponseEntity.ok(user.getPosts());
	}
	
	@PostMapping
	public ResponseEntity<?> insert(@RequestBody User user){
		user = this.userService.insert(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).body(user);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> update(@RequestBody User user, @PathVariable String id){
		this.userService.update(user, id);
		return ResponseEntity.ok("Atualizado com sucesso.");
	}
}
