package com.weCode.Bookstore.dto;

import java.util.UUID;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "BookDto", description="A book and its details.")
public class BookDto {
	
	@ApiModelProperty(
			value = "UUID",
			dataType = "UUID",
			example = "xxxxxx-xxxxx-xxxx",
			notes = "Unique identifier"
			)
	private UUID id;
	
	@ApiModelProperty(
			value = "title",
			dataType = "String",
			example = "The title",
			notes = "A"
			)
	private String title;
	
	@ApiModelProperty(
			value = "description",
			dataType = "String",
			example = "Some description...",
			notes = "Description"
			)
	private String description;
	
	@ApiModelProperty(
			value = "author",
			dataType = "String",
			example = "Bruno Barlocco",
			notes = "Author of the book"
			)
	private String author;
	
	@ApiModelProperty(
			value = "releaseYear",
			dataType = "int",
			example = "2021",
			notes = ""
			)
	private int releaseYear;

}
