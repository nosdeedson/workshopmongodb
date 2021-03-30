package ejs.com.workshopmongodb.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import ejs.com.workshopmongodb.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {

	List<Post> findByTitleIgnoreCaseContaining( String text);
	
	@Query(" { title: { $regex: ?0, $options: 'i' } } ")
	List<Post> searchByTitle(String text);
	
	@Query( " { $and: [ { date : { $gte: ?0 } }, { date : { $lte: ?1 } },"
			+ " { $or: [ { title: { $regex: ?2, $options: 'i' } }, { body: { $regex: ?2, $options: 'i' } }, "
			+ "{ 'comments.text': { $regex: ?2, $options: 'i' } }   ] } ] } " )
	List<Post> fullSearch( LocalDateTime de, LocalDateTime ate, String text);
}
