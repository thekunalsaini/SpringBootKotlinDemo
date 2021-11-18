package com.axis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axis.dto.Moviedto;
import com.axis.service.Iservice;

@RestController
@RequestMapping(value="/movieapi")
public class controller {
	
	@Autowired
	Iservice service;
	
	@PostMapping(value="/addmovie")
	public ResponseEntity<Object> addProduct(@RequestBody Moviedto productDto)
	{
		return new ResponseEntity<Object>(service.addProduct(productDto),HttpStatus.OK);
	}
	@GetMapping(value="/viewallproduct")
	public ResponseEntity<Object> viewallproduct()
	{
		return new ResponseEntity<Object> (service.viewAllProduct(),HttpStatus.OK);
		
	}
	@GetMapping(value="/viewmoviebyid/{id}")
	public ResponseEntity<Object> getmovieById(@PathVariable int id)
	{
		return new ResponseEntity<Object> (service.getmovieById(id),HttpStatus.OK);
		
	}
	@GetMapping(value="/viewmoviebyregex/{id}")
	public ResponseEntity<Object> getmovieByregex(@PathVariable String id)
	{
		return new ResponseEntity<Object> (service.getmovieBynameRegEx(id),HttpStatus.OK);
		
	}
}
