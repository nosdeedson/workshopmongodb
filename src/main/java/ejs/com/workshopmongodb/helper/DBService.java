package ejs.com.workshopmongodb.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ejs.com.workshopmongodb.domain.Comment;
import ejs.com.workshopmongodb.domain.Post;
import ejs.com.workshopmongodb.domain.User;
import ejs.com.workshopmongodb.domain.dto.AuthorDTO;
import ejs.com.workshopmongodb.repository.PostRepository;
import ejs.com.workshopmongodb.repository.UserRepository;

@Service
public class DBService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	public void instantiateUsers() throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post p1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
		Post p2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje", new AuthorDTO(maria));
		
		Comment c1 = new Comment("Boa viagem mano!", sdf.parse("21/03/2018"), new AuthorDTO(alex));
		Comment c2 = new Comment("Aproveite", sdf.parse("22/03/2018"), new AuthorDTO(bob));
		Comment c3 = new Comment("Tenha um ótimo dia!", sdf.parse("23/03/2018"), new AuthorDTO(alex));
		
		p1.setComments(Arrays.asList(c1,c2));
		p2.setComments(Arrays.asList(c3));
		
		postRepository.saveAll(Arrays.asList(p1, p2));
		
		maria.setPosts(Arrays.asList(p1, p2));
		userRepository.save(maria);
	}

}
