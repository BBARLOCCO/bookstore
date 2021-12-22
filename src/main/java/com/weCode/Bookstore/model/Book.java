package com.weCode.Bookstore.model;

import java.util.UUID;

import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
	private UUID id;
	
	@Column
	@NotNull
	private String title;
	
	@Column
	@NotNull
	private String author;
	
	@Column
	@NotNull
	private String description;
	
	@Column
	@NotNull
	private int releaseYear;

	public Object getTitle() {
		// TODO Auto-generated method stub
		return title;
	}
}
