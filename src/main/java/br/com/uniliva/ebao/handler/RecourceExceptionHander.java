package br.com.uniliva.ebao.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.uniliva.ebao.exceptions.NotFoundException;

public class RecourceExceptionHander {
	
	ResponseEntity<StandardError> notFound(NotFoundException e, HttpServletRequest request){
		StandardError error = new StandardError(404, e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);		
	}

}
