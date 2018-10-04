package com.at.test.curso.service.Book;

import com.at.test.curso.model.dto.BookDto;
import com.at.test.curso.model.entity.Book;
import org.modelmapper.MappingException;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

@Service
public class BookMapperServiceImpl implements BookMapperService {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Page<BookDto> mapPageBookToPageBookDto(Page<Book> page) {

        if (page == null) {
            throw new IllegalArgumentException("The page must be not null");
        }
        return page.map(p -> modelMapper.map(p, BookDto.class));
    }

    @Override
    public Book mapBookDtoToBook(BookDto dto) {
        return Optional.ofNullable(dto).map(d -> modelMapper.map(d, Book.class))
                .orElseThrow(() -> new MappingException(Arrays.asList(new ErrorMessage("Parameter must be not null"))));
    }

    @Override
    public BookDto mapBookToBookDto(Book book) {
        return Optional.ofNullable(book).map(d -> modelMapper.map(d, BookDto.class))
                .orElseThrow(() -> new MappingException(Arrays.asList(new ErrorMessage("Parameter must be not null"))));
    }

    @Override
    public void merge(Book book, BookDto dto) {
        modelMapper.map(dto, book);
    }

}
