package com.global.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.global.modal.Book;
import com.global.repository.BookRepo;

@RestController
public class BookController {

	@Autowired
	BookRepo bookRepo;
	
	@PostMapping("/add")
	public Book addBook(@RequestBody Book book)
	{
	
		return bookRepo.save(book);
	}
	
	@GetMapping("allbook")
	public List<Book> getBooks()
	{
		return bookRepo.getBook();
	}
	
	@GetMapping("native/allbook")
	public List<Book> getAllBooks()
	{
		return bookRepo.getAllBook();
	}
	
	@GetMapping("findBookById/{bookId}")
	public Book findbook(@PathVariable int bookId)
	{
		return bookRepo.getBookById(bookId);
	}
	
	@GetMapping("findBookByName/{bname}")
	public List<Book> findBookByName(@PathVariable String bname)
	{
		return bookRepo.getBookByBname(bname);
	}
	
	@PutMapping("/updateBook/{bname}/{aname}/{bookId}")
	public Integer updateBook(@PathVariable String bname, @PathVariable String aname, @PathVariable int bookId)
	{
		return bookRepo.updateBookById(bname, aname, bookId);
		
	}
	
	
	@DeleteMapping("deleteBook/{bookId}")
	public String deleteBookById(@PathVariable int bookId)
	{
		bookRepo.deleteBookById(bookId);
		return "book deleted successfully";
	}
}
