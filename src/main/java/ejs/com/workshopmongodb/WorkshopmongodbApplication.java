package ejs.com.workshopmongodb;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WorkshopmongodbApplication implements CommandLineRunner{
	
//	@Autowired
//	private DBService db;
//	
	public static void main(String[] args) {
		SpringApplication.run(WorkshopmongodbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		this.db.instantiateUsers();
	}

}
