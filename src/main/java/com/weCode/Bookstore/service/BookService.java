package com.weCode.Bookstore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.weCode.Bookstore.dto.BookDto;
import com.weCode.Bookstore.model.Book;
import com.weCode.Bookstore.repository.BookRepository;

@Service
public class BookService {
	
	
	private final BookRepository bookRepository;
	
	private final ModelMapper modelMapper;
	
	public BookService(BookRepository bookRepository, ModelMapper mapper) {
		this.bookRepository = bookRepository;
		this.modelMapper = mapper;
	}
	
	public List<BookDto> getBooks(){
		Iterable<Book> books = bookRepository.findAll();
		
		return StreamSupport.stream(books.spliterator(), false)
				.map(convertBookModelToBookDto())
				.collect(Collectors.toList());
				
	}

	private Function<Book, BookDto> convertBookModelToBookDto() {
		return book -> modelMapper.map(book, BookDto.class);
	}

}
