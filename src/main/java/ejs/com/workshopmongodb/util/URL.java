package ejs.com.workshopmongodb.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class URL {
	
	public static String decodeStringParam ( String text) {
		try {
			return URLDecoder.decode(text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return "";
		}
	}
	
	public static LocalDateTime converteStringToDate( String data) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		try {			
			LocalDateTime dia = LocalDate.parse(data, dtf).atStartOfDay().plusDays(1L).minusSeconds(1L);
			return dia;
		} catch (Exception e) {
			throw new RuntimeException("Data inválida.");
		}
	}
}
