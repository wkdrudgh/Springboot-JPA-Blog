package com.cos.blog.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class GlobalExptionHandler {
	
	@ExceptionHandler(value = Exception.class)
	public String HandleArgumentExption(Exception e) {
		return "<h1>"+e.getMessage()+"</h1>";
	}
}
