package com.manytomany.mapper;

import com.manytomany.entity.AuthorEntity;
import com.manytomany.entity.BookEntity;
import com.manytomany.model.Author;
import com.manytomany.model.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookAuthorMapper {

    BookEntity modelTOEntity(Book book);

    AuthorEntity modelToEntity(Author author);

    Book entityToModel(BookEntity bookEntity);

}
