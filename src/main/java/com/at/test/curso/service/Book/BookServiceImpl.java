package com.at.test.curso.service.Book;

import com.at.test.curso.dao.BookDao;
import com.at.test.curso.exception.NotFoundException;
import com.at.test.curso.model.dto.BookDto;
import com.at.test.curso.model.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Autowired
    private BookMapperService bookMapperService;

    @Override
    public Page<BookDto> findAll(Integer page, Integer size, String name) {

        final Pageable pagination = createPageable(page, size);
        final Example<Book> queryBook = createExample(name);
        final Page<Book> books = bookDao.findAll(queryBook, pagination);

        return bookMapperService.mapPageBookToPageBookDto(books);
    }

    @Override
    public BookDto findOne(Integer id) throws NotFoundException {

        return Optional.ofNullable(id)
                .flatMap(bookDao::findById)
                .map(bookMapperService::mapBookToBookDto)
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public BookDto create(BookDto book) {

        return Optional.ofNullable(book)
                .map(bookMapperService::mapBookDtoToBook)
                .map(bookDao::save)
                .map(bookMapperService::mapBookToBookDto)
                .orElseThrow(PersistenceException::new);
    }

    @Override
    public void update(Integer id, BookDto book) throws NotFoundException {

        final Book storedBook = bookDao.findById(id).orElseThrow(NotFoundException::new);

        throwExceptionIfSomeParameterIsNull(book);

        bookMapperService.merge(storedBook, book);
        bookDao.save(storedBook);
    }

    @Override
    public void delete(Integer id) throws NotFoundException {
        try {
            bookDao.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException(e.getMessage());
        }
    }

    /**
     * Create a Pageable objet
     * @param page Represents the slice of total amount to search
     * @param size Represent the limit size of elements to search
     */
    private Pageable createPageable(Integer page, Integer size) {
        throwExceptionIfSomeParameterIsNull(page, size);
        return new PageRequest(page, size);
    }

    /**
     * Throws an IllegalArgumentException if some input parameter are null
     * @param obj List of objets to check
     */
    private void throwExceptionIfSomeParameterIsNull(Object ... obj) {

        final Boolean thereAreSomeNullParameter = Arrays.asList(obj).stream().anyMatch(Objects::isNull);

        if (thereAreSomeNullParameter) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Creates a Example to match with some book stored in BD
     * @param name Parameter that represent the name of the book to search
     */
    private Example<Book> createExample(String name) {

        final Book sample = new Book();
        Optional.ofNullable(name).ifPresent(sample::setName);

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("name", match -> match.contains());

        return Example.of(sample, matcher);
    }
}
