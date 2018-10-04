package com.at.test.curso.service.Book;

import com.at.test.curso.exception.NotFoundException;
import com.at.test.curso.model.dto.BookDto;
import org.springframework.data.domain.Page;

public interface BookService {

    /**
     * Retrieves all books stored in BD
     * @param page Represents an specify slice of the total amount of books stored
     * @param size Represents the quantity of books show in one page
     * @param name
     */
    Page<BookDto> findAll(Integer page, Integer size, String name);

    /**
     * Retrieve a specific book searched by his identification id
     * @param id Represents the identity property from a book
     * @throws NotFoundException If there are not exist any books identify by input parameter then throws a NotFoundException
     */
    BookDto findOne(Integer id) throws NotFoundException;

    /**
     * Creates a new book in BD
     * @param book Represents the book's data to store
     */
    BookDto create(BookDto book);

    /**
     * Updates a book already stored in BD
     * @param id Represents the identity property from a book
     * @param book Represents the book's data to update
     * @throws NotFoundException If there are not exist any books identify by input parameter then throws a NotFoundException
     */
    void update(Integer id, BookDto book) throws NotFoundException;

    /**
     * Removes a book stored in BD
     * @param id Represents the identity property from a book
     * @throws NotFoundException If there are not exist any books identify by input parameter then throws a NotFoundException
     */
    void delete(Integer id) throws NotFoundException;

}
