package ejs.com.workshopmongodb.domain;

import java.io.Serializable;
import java.util.Date;

import ejs.com.workshopmongodb.domain.dto.AuthorDTO;

public class Comment implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Date date;
	private String text;
	
	private AuthorDTO author;
	
	public Comment() {}

	public Comment( String text, Date date, AuthorDTO author) {
		this.date = date;
		this.text = text;
		this.author = author;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}
	
}
