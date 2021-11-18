package com.axis.service;

import java.util.List;

import com.axis.dto.Moviedto;
import com.axis.entity.Movie;

public interface Iservice {
	
	public Moviedto addProduct(Moviedto dto);
	//public ProductDto addProduct(ProductDto productDto);
	public List<Moviedto> viewAllProduct();
	public List<Moviedto> getmovieById(int id);
	public List<Moviedto> getmovieBynameRegEx(String name);

}
