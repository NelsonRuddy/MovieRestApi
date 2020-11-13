package com.applaudo.movies.services;

import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.applaudo.movies.model.movie;
import com.applaudo.movies.repository.MoviesRepository;

@Service
public class MoviesServices {

	@Autowired
	MoviesRepository moviesRepository;
	
	private static final String _ROLE="ROLE_USER";
	
	
	
	//get all movies
	@Transactional()
	public List<movie> findAll() {

		if (RolCapute().equals(_ROLE)) {

			return findByAvailability(true);

		}

		else {
			return (List<movie>) moviesRepository.findAll();
		}

	}
	//get movies by a id
	@Transactional
	public movie getMoviesById(long id) {
		return moviesRepository.findById(id).get();
	}
	//save movies
	@Transactional
	public movie save(movie movie) {
		movie savedMovies = moviesRepository.save(movie);

		return savedMovies;
	}

	@Transactional
	public void update(movie movies) {
		moviesRepository.save(movies);
	}
	//delete movies
	@Transactional
	public void delete(long id) {
		moviesRepository.deleteById(id);
	}

	//get availability movies
	@Transactional
	public List<movie> findByAvailability(boolean valor) {

		return moviesRepository.findByAvailability(valor);

	}
	//get unavailability movies
	@Transactional
	public List<movie> findByUnavailability(boolean valor) {

		return moviesRepository.findByAvailability(valor);

	}
	//sortable by title 
	@Transactional
	public Page<movie> search(String query, Pageable pageable) {
		Page<movie> movies = moviesRepository.findByTitle(query, pageable);

		return movies;
	}
	// pagination
	@Transactional
	public List<movie> findPaginated(int pageNo, int pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);
		Page<movie> pagedResult = moviesRepository.findAll(paging);

		return pagedResult.toList();

	}
    //// verify if user contain ROLE_USER to be sure to show only availabilily movies.
	public String RolCapute() {

		SecurityContextHolder auth;
		Collection<? extends GrantedAuthority> granted = SecurityContextHolder.getContext().getAuthentication()
				.getAuthorities();

		String role = "";
		for (int i = 0; i < granted.size(); i++) {
			role = granted.toArray()[i] + "";
						
				System.out.println(role);			
		}

		return role;
	}

}
