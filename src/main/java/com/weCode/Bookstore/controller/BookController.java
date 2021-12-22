package com.weCode.Bookstore.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weCode.Bookstore.dto.BookDto;
import com.weCode.Bookstore.service.BookService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@Api(value = "Book Api", tags = "Book Api", produces = "application/json")
@RestController
@RequestMapping("api/v1/books")
public class BookController {

	@Autowired
	BookService bookService;
	
	@ApiOperation(value = "get list ofbooks", response = BookDto[].class, produces = "application/json")
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Successfully retreived list of books"),
		@ApiResponse(code = 403, message = "Forbiden access"),
		@ApiResponse(code = 404, message = "Not found")
	})
	@GetMapping
	public ResponseEntity<List<BookDto>> getBooks(){
		
		List<BookDto> list = bookService.getBooks();
		
		return ResponseEntity.ok(list);
	}
}
