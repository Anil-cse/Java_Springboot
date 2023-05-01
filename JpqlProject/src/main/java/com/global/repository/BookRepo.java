package com.global.repository;



import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.global.modal.Book;


@Repository
public interface BookRepo extends JpaRepository<Book, Integer>{

	@Query("select b from Book b")
	List<Book> getBook();
	
	@Query(value = "select * from book", nativeQuery = true)
	List<Book> getAllBook();
	
	@Query("select b from Book b where b.bookId = :id")
	Book getBookById(@Param("id") int bookId);
	
	@Query("select b from Book b where b.bname = :name")
	List<Book> getBookByBname(@Param("name") String banme);
	
	@Transactional
	@Modifying
	@Query("UPDATE Book SET bname = :bname, aname = :aname WHERE bookId = :bookId")
	Integer updateBookById(String bname, String aname, int bookId);
	
	@Transactional
	@Modifying
	@Query("delete from Book b where b.bookId =:id")
	Integer deleteBookById(@Param("id") int bookId);
	
	
}
