package com.weCode.Bookstore.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weCode.Bookstore.dto.BookDto;

@RestController
@RequestMapping("api/v1/books")
public class BookController {

	@GetMapping
	public ResponseEntity<List<BookDto>> getBooks(){
		BookDto book = BookDto.builder()
					.title("Ficciones")
					.build();
		
		BookDto book2 = BookDto.builder()
				.title("Rayuela")
				.build();
		
		List<BookDto> list = new ArrayList<BookDto>();
		list.add(book);
		list.add(book2);
		
		return ResponseEntity.ok(list);
	}
}
