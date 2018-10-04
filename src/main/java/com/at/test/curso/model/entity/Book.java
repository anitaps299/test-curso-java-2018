package com.at.test.curso.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue
    private Integer id;
    private String isbn;
    private String name;
    private String synopsis;
    private Integer pages;

}
