create database if not exists booksAuthors
;

use booksAuthors
;

create table Books
(
	id int not null auto_increment primary key,
    title varchar(100) not null,
    isbn varchar(13) not null,
    pubDate Date not null,
    coverImg longblob not null    
)
;

create table Authors
(
	id int not null auto_increment primary key,
    bookId int not null,
    name varchar(50)
)
;

alter table Authors
	add constraint fk_Authors_Books foreign key (bookId)
	references Books (id)
;

alter table Books
	add constraint uq_books_isbn unique (isbn)
;