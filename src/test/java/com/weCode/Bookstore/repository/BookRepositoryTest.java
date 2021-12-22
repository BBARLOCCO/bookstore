package com.weCode.Bookstore.repository;

import java.util.List;
import java.util.stream.StreamSupport;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.weCode.Bookstore.model.Book;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookRepositoryTest {

	@Autowired
	BookRepository bookRepository;
	
	@Test
	@Sql(scripts = {"file:./src/test/resources/InsertInitialBookRecordsForTest.sql"})
	public void shouldBeAbleToFetchAllBooksInDB() {
		Iterable<Book> all = bookRepository.findAll();
		Long totalBookCount = StreamSupport.stream(all.spliterator(),false).count();
		Assertions.assertEquals(2, totalBookCount);
	}
	
	@Test
	@Sql(scripts = {"file:./src/test/resources/InsertInitialBookRecordsForTest.sql"})
	public void shouldReturnExpectedBookWhenFindByTestTitle() {
		
		String searchTitle = "TEST1";
		
		Book book = bookRepository.findByTitle(searchTitle).get(0);
		
		Assertions.assertEquals(searchTitle, book.getTitle());
	}
}
