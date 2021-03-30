package ejs.com.workshopmongodb.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ejs.com.workshopmongodb.domain.Post;
import ejs.com.workshopmongodb.services.PostService;

@RestController
@RequestMapping("posts")
public class PostResource {

	@Autowired
	private PostService postService;
	
	@GetMapping("{id}")
	public ResponseEntity<?> findById(@PathVariable String id) {
		return ResponseEntity.ok(postService.findById(id));
	}
	
	@GetMapping("search-by-title")
	public ResponseEntity<?> findByTitle( @RequestParam(name = "text", defaultValue = "") String text ){
		List<Post> posts = this.postService.findByTitle(text);
		return ResponseEntity.ok(posts);
	}
	
	@GetMapping("full-search")
	public ResponseEntity<?> fullsearch( 
			@RequestParam(name = "de", required = true) String de,
			@RequestParam(name = "ate", required = true) String ate, 
			@RequestParam(name = "text", defaultValue = "") String text ){
		List<Post> posts = this.postService.fullsearch(de, ate, text);
		return ResponseEntity.ok(posts);
	}
}
