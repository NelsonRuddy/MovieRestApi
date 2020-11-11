package com.applaudo.movies.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.applaudo.movies.model.movie;

@Repository
public interface MoviesRepository extends JpaRepository<movie, Integer>{

	List<movie> findByAvailability(boolean availability);
	
	
}
