package com.applaudo.movies.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.applaudo.movies.model.movie;
import com.applaudo.movies.services.MoviesServices;

@RestController
@PreAuthorize("isAuthenticated()")
@RequestMapping("api")
public class MoviesController {

	@Autowired
	MoviesServices moviesServices;
	
			
	@PreAuthorize("permitAll")
	@GetMapping("/movies")
	public List<movie> retrieveAllMovies() {
		
			
		return moviesServices.findAll();
	}
	
	
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	@GetMapping("/search")
    public Page<movie> search(@RequestParam("q") String query,  @PageableDefault(page = 0, size = 6) Pageable pageable) {
        Page<movie> movies = moviesServices.search(query, pageable);
        System.out.println(movies);

        return movies;
    }
    
    	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    	@GetMapping("/buscar/{pageNo}/{pageSize}")
    	public List<movie>getPaginated(@PathVariable int pageNo, @PathVariable int pageSize){
		   
		   return moviesServices.findPaginated(pageNo, pageSize);
	   }
	

    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	@GetMapping("/movies/{id}")
	public ResponseEntity<movie> getMoviesById(@PathVariable("id") long id) {
		Optional<movie> movieData = Optional.ofNullable(moviesServices.getMoviesById(id));

		if (movieData.isPresent()) {
			return new ResponseEntity<>(movieData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/movies")
	public ResponseEntity<movie> createMovies(@RequestBody movie movie) {

		movie savedMovies = moviesServices.save(movie);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedMovies.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/movies/{id}")
	public ResponseEntity<movie> updateMovies(@RequestBody movie movie, @PathVariable long id) {

		Optional<movie> moviesOptional = Optional.ofNullable(moviesServices.getMoviesById(id));

		if (!moviesOptional.isPresent())
			return ResponseEntity.notFound().build();

		movie.setId(id);

		moviesServices.save(movie);

		return ResponseEntity.noContent().build();
	}
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/movies/{id}")
	public ResponseEntity<HttpStatus> deleteMovie(@PathVariable("id") long id) {
		try {
			moviesServices.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	@GetMapping("/movies/availability")
	public ResponseEntity<List<movie>> findByAvailability() {
		try {
			List<movie> moviesAvailability = moviesServices.findByAvailability(true);

			if (moviesAvailability.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(moviesAvailability, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/movies/unavailability")
	public ResponseEntity<List<movie>> findByUnavailability() {
		try {
			List<movie> moviesUnavailability = moviesServices.findByUnavailability(false);

			if (moviesUnavailability.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(moviesUnavailability, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
