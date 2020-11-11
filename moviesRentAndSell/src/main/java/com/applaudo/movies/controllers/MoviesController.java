package com.applaudo.movies.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.applaudo.movies.model.movie;
import com.applaudo.movies.repository.MoviesRepository;

@RestController
@PreAuthorize("isAuthenticated()")
@RequestMapping("api")
public class MoviesController {

	@Autowired
	MoviesRepository moviesRepository;
	
	
	
	

	@GetMapping("/movies")
	public List<movie> retrieveAllMovies() {
		return moviesRepository.findAll();
	}

	
	@GetMapping("/movies/{id}")
	public ResponseEntity<movie> getMoviesById(@PathVariable("id") int id) {
		Optional<movie> movieData = moviesRepository.findById(id);

		if (movieData.isPresent()) {
			return new ResponseEntity<>(movieData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/movies")
	public ResponseEntity<movie> createMovies(@RequestBody movie movie) {

		movie savedMovies = moviesRepository.save(movie);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedMovies.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/movies/{id}")
	public ResponseEntity<movie> updateMovies(@RequestBody movie movie, @PathVariable int id) {

		Optional<movie> moviesOptional = moviesRepository.findById(id);

		if (!moviesOptional.isPresent())
			return ResponseEntity.notFound().build();

		movie.setId(id);

		moviesRepository.save(movie);

		return ResponseEntity.noContent().build();
	}
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/movies/{id}")
	public ResponseEntity<HttpStatus> deleteMovie(@PathVariable("id") int id) {
		try {
			moviesRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/movies/availability")
	public ResponseEntity<List<movie>> findByAvailability() {
		try {
			List<movie> moviesAvailability = moviesRepository.findByAvailability(true);

			if (moviesAvailability.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(moviesAvailability, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
