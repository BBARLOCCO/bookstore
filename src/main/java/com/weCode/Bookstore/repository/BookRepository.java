package com.weCode.Bookstore.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.weCode.Bookstore.model.Book;

public interface BookRepository extends CrudRepository<Book,UUID>{

	List<Book> findByTitle(String searchTitle);
	
}
