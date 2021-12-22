package com.weCode.Bookstore.integrationTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.jdbc.Sql;

import com.weCode.Bookstore.BookstoreApplication;
import com.weCode.Bookstore.dto.BookDto;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(
		classes = BookstoreApplication.class,
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD )
@AutoConfigureTestDatabase(replace = Replace.ANY)
public class BookControllerTest {

	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@Test
	@Sql(scripts = {"file:./src/test/resources/InsertInitialBookRecordsForTest.sql"})
	void shouldReturnBooksWhenBookApiCalled() {
		BookDto[] books = testRestTemplate.getForObject("http://localhost:"+port+"/api/v1/books",BookDto[].class);
		assertThat(books).isNotNull();
		assertThat(books.length).isEqualTo(2);
	}

	
}
