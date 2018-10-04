package com.at.test.curso.model.dto;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
public class BookDto implements Serializable {

    private Integer id;
    @NotNull
    private String isbn;
    @
    private String name;
    private String synopsis;
    private Integer pages;
}
