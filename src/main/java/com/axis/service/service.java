package com.axis.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.dao.IMovieDao;
import com.axis.dto.Moviedto;
import com.axis.entity.Movie;


@Service
public class service implements Iservice {

	@Autowired
	IMovieDao movieDao;
	
	@Override
	public Moviedto addProduct(Moviedto moviedto) {
		
		Movie m = new Movie();
		m.setId(moviedto.getId());
		m.setName(moviedto.getName());
		
		
		movieDao.save(m);
		
		
		return moviedto;
	}

	
	@Override
	public List<Moviedto> viewAllProduct() throws RuntimeException{

	List<Movie> products =	movieDao.findAll();
	
	List<Moviedto> productDtos = new ArrayList<Moviedto>();
		
	for(Movie product : products)
	{
		productDtos.add(new Moviedto(product.getId(), product.getName()));
	}
		
		return productDtos;
	}


	@Override
	public List<Moviedto> getmovieById(int id) {
		
		List<Movie> pd = movieDao.getMovieById(id);
		List<Moviedto> pdto = new ArrayList<Moviedto>();
		for(Movie p :pd)
		{
			pdto.add(new Moviedto(p.getId(),p.getName()));
		}
		
		return pdto;
		
	}


	@Override
	public List<Moviedto> getmovieBynameRegEx(String name) {
		// TODO Auto-generated method stub
		List<Movie> pd =  movieDao.getmovieBynameRegEx(name);
		
		List<Moviedto> pdto = new ArrayList<Moviedto>();
		for(Movie p :pd)
		{
			pdto.add(new Moviedto(p.getId(),p.getName()));
		}
		
		return pdto;
	}
}
