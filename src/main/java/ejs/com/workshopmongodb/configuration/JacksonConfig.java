package ejs.com.workshopmongodb.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Configuration
public class JacksonConfig {
	
	
	@Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper()
            .setAnnotationIntrospector(new JacksonAnnotationIntrospector())
            .registerModule(new JavaTimeModule())
            .setDateFormat(new StdDateFormat())
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }
	
	//@DateTimeFormat(iso = ISO.DATE_TIME) LocalDateTime ate

}
