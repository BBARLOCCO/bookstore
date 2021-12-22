CREATE TABLE book(
	id uuid NOT NULL primary key,
	author VARCHAR NOT NULL,
	title VARCHAR NOT NULL,
	description VARCHAR NOT NULL,
	release_year int NOT NULL
);