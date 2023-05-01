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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.global.modal.Actor;
import com.global.modal.Generes;
import com.global.modal.Movie;
import com.global.repository.GeneresRepo;
import com.global.service.GenereService;

@RestController
public class GeneresController {

	
	@Autowired
	GenereService genereService;

	@PostMapping("genere")
	public ResponseEntity<Generes> addGenere(@RequestBody Generes generes)
	{
		return new ResponseEntity<Generes>(genereService.addGenere(generes),HttpStatus.OK);
	}
	
	@GetMapping("/genere/all")
    public ResponseEntity<List<Generes>> findAll() {
      return new ResponseEntity<List<Generes>>(genereService.findGenere(), HttpStatus.OK);
    }
	
	@GetMapping("/genere/{genId}")
	public ResponseEntity<Generes> findById(@PathVariable int genId)
	{
		return new ResponseEntity<Generes>(genereService.findGenereById(genId), HttpStatus.OK);
	}
	
	@DeleteMapping("/genere/{genId}")
	public ResponseEntity<String> deleteGenere(@PathVariable int genId)
	{
		genereService.deleteGenere(genId);
		return new ResponseEntity<String>("genere record deleted successfully", HttpStatus.OK);
	}
	
	@GetMapping("/genere/movie/{genId}")
	public ResponseEntity<List<Movie>> findMovieByGen(@PathVariable int genId)
    {
    	return new ResponseEntity<List<Movie>>(genereService.findMovieById(genId), HttpStatus.OK);
    }
	
	@GetMapping("/genereByName/movie/{name}")
	public ResponseEntity<List<Movie>> findMovieByName(@PathVariable String name)
    {
    	return new ResponseEntity<List<Movie>>(genereService.findMovieByName(name), HttpStatus.OK);
    }
}
