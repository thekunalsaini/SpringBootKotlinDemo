package com.axis.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.axis.entity.Movie;

@Repository
public interface IMovieDao extends MongoRepository<Movie, Integer> {
	
	@Query("{id :?0}")  //SQL Equivalent : SELECT * FROM BOOK WHERE ID=?
    List<Movie> getMovieById(Integer id);
	@Query("{ name : { $regex : ?0 } }")
    List<Movie> getmovieBynameRegEx(String name);

}
