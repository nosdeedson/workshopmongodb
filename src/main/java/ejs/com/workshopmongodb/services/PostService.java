package ejs.com.workshopmongodb.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ejs.com.workshopmongodb.domain.Post;
import ejs.com.workshopmongodb.repository.PostRepository;
import ejs.com.workshopmongodb.services.exception.ObjectNotFound;
import ejs.com.workshopmongodb.util.URL;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
		
	public Post findById(String id) {
		return postRepository.findById(id)
				.orElseThrow( () -> new ObjectNotFound("Post não encontrado"));
	}

	public List<Post> findByTitle( String text ){
//		text = URL.decodeStringParam(text); Não precisa decodificar pois não inseri caractere especial
//		return this.postRepository.findByTitleIgnoreCaseContaining(text);
		return this.postRepository.searchByTitle(text);
	}
	
	public List<Post> fullsearch( String de, String ate, String text ){
		LocalDateTime dataDe = null;
		LocalDateTime dataAte = null;
		if ( de == "") {
			dataDe = this.stringVaziaToDataInicio();
		}
		else {			
			dataDe = URL.converteStringToDate(de);
		}
		if ( ate == "") {
			dataAte = this.stringVaziaToDataFim();
		}
		else {			
			dataAte = URL.converteStringToDate(ate);
		}
		List<Post> posts = this.postRepository.fullSearch(dataDe, dataAte, text);
		return posts;
	}
	
	private LocalDateTime stringVaziaToDataInicio() {
		return LocalDateTime.of(1970, 1, 1, 0, 0);
	}
	
	private LocalDateTime stringVaziaToDataFim() {
		return LocalDateTime.now();
	}
}
