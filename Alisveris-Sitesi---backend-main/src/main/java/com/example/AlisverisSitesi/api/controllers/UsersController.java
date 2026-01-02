package com.example.AlisverisSitesi.api.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.AlisverisSitesi.business.abstracts.UserService;
import com.example.AlisverisSitesi.core.entities.User;
import com.example.AlisverisSitesi.core.utilities.results.ErrorDataResult;

import jakarta.validation.Valid;

@RestController
@RequestMapping (value = "/api/users")
public class UsersController {
	
  private UserService userService;

  @Autowired
public UsersController(UserService userService) {
	super();
	this.userService = userService;
}
  
  @PostMapping (value = "/add")
  public ResponseEntity<?> add( @Valid @RequestBody User user) {
	  return ResponseEntity.status(HttpStatus.CREATED)
              .body(this.userService.add(user));

  }
	
  //global hata denetleyicmiz
  @ExceptionHandler (MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErrorDataResult<Object> handleValidationException (MethodArgumentNotValidException exceptions){
	  Map <String,String> validationErrors= new HashMap<String, String>();
	  for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
		  validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
	  }
	  
	  ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, "Doğrulama hataları");
	  return errors;
	  
  }
  
}
