package com.applaudo.movies.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.applaudo.movies.model.movie;

@Repository
public interface MoviesRepository extends PagingAndSortingRepository<movie, Long>{

	List<movie> findByAvailability(boolean availability);
	
	
	 Page<movie> findByTitle(String name, Pageable pageable);
	 
	 
	

			
}
