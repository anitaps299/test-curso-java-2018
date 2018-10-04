package com.at.test.curso.controller;

import com.at.test.curso.exception.NotFoundException;
import com.at.test.curso.model.dto.BookDto;
import com.at.test.curso.service.Book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public Page<BookDto> findAll(@RequestParam(required = false, value = "page", defaultValue = "0") Integer page,
                                 @RequestParam(required = false, value = "size", defaultValue = "10") Integer size,
                                 @RequestParam(required = false, value = "name") String name) {
        return bookService.findAll(page, size, name);
    }

    @GetMapping("/{id}")
    public BookDto findOne(@PathVariable("id") Integer id) throws NotFoundException {
        return bookService.findOne(id);
    }

    @PostMapping
    public BookDto create(@RequestBody BookDto book) {
        return bookService.create(book);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Integer id, @RequestBody BookDto book) throws NotFoundException {
        bookService.update(id, book);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws NotFoundException {
        bookService.delete(id);
    }
}
