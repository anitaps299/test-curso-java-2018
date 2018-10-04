package com.at.test.curso.service.Book;

import com.at.test.curso.model.dto.BookDto;
import com.at.test.curso.model.entity.Book;
import org.springframework.data.domain.Page;

public interface BookMapperService {

    /**
     * Transforms the Page content from Book to BookDto class
     * @param page
     * @return
     */
    Page<BookDto> mapPageBookToPageBookDto(Page<Book> page);

    /**
     * Transforms the dto into entity
     * @param dto
     * @return
     */
    Book mapBookDtoToBook(BookDto dto);

    /**
     * Transforms the entity into dto
     * @param book
     * @return
     */
    BookDto mapBookToBookDto(Book book);

    /**
     * Maps all data from dto to book
     * @param book
     * @param dto
     */
    void merge(Book book, BookDto dto);
}
