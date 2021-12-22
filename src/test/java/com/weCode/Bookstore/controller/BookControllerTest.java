package com.weCode.Bookstore.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.weCode.Bookstore.dto.BookDto;
import com.weCode.Bookstore.service.BookService;

@ExtendWith(MockitoExtension.class)
public class BookControllerTest {

	@InjectMocks
	private BookController bookController;
	
	@Mock
	private BookService bookService;
	
	@Test
	void shouldReturnListOfBookDtoWhenFindBooksIsCalled() {
		List<BookDto> books = new ArrayList<>();
		BookDto book = getBookDto();
		books.add(book);
		when(bookService.getBooks()).thenReturn(books);
		ResponseEntity<List<BookDto>> expected = ResponseEntity.ok(books);
		ResponseEntity<List<BookDto>> result = bookController.getBooks();
		assertThat(result).isEqualTo(expected);
		
	}
	
	private BookDto getBookDto() {
		return BookDto.builder()
				.title("test title")
				.description("test description")
				.id(UUID.randomUUID())
				.releaseYear(2020)
				.build();
	}
}
