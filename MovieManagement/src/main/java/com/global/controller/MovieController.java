package com.global.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.global.modal.Actor;
import com.global.modal.Movie;
import com.global.service.MovieService;

@RestController
public class MovieController {
	
	@Autowired
	MovieService movieService;
	
	@PostMapping("create")
    public Movie saveMovie(@RequestBody Movie movie){
      return movieService.saveMovie(movie);
    }

    @GetMapping("allmovie")
    public List<Movie> findALl(){
        return movieService.findAllMovie();
    }

    @GetMapping("/movie/{movieId}")
    public Movie findMovieById(@PathVariable int movieId){
        return movieService.findMovie(movieId);
    }
    
    @GetMapping("/movie/findActor/{title}")
    public ResponseEntity<Movie> findActorByMovieName(@PathVariable String title)
    {
    	return new ResponseEntity<Movie>(movieService.findActorByMovieName(title), HttpStatus.OK);
    }
    
    @PutMapping("/movie/{movieId}")
    public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie, @PathVariable int movieId)
    {
    	return new ResponseEntity<Movie>(movieService.updateMovie(movie, movieId), HttpStatus.OK);
    }

    @GetMapping("/movie/actor/{movieId}")
    public ResponseEntity<Set<Actor>> findActorByMovieId(@PathVariable int movieId)
    {
    	return new ResponseEntity<Set<Actor>>(movieService.findActorById(movieId), HttpStatus.OK);
    }
    
    @DeleteMapping("/movie/{movieId}")
    public ResponseEntity<String> deleteByMovieId(@PathVariable int movieId)
    {
    	movieService.deleteByMovieId(movieId);
    	return new ResponseEntity<String>("movie record deleted successfully ", HttpStatus.OK);
    }
	

}
