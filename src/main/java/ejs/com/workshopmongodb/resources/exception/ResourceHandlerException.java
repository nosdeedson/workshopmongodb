package ejs.com.workshopmongodb.resources.exception;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import ejs.com.workshopmongodb.services.exception.ObjectNotFound;

@ControllerAdvice
public class ResourceHandlerException {

	@ExceptionHandler(ObjectNotFound.class)
	public ResponseEntity<StandardError> objectNotFound( ObjectNotFound e, HttpServletRequest req){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:MM:ss");
		StandardError err = new StandardError( dtf.format(LocalDateTime.now()), HttpStatus.NOT_FOUND.value() ,
				"Não encontrado", e.getMessage(), req.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
}
