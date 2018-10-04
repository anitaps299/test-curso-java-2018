package com.at.test.curso.dao;

import com.at.test.curso.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDao extends JpaRepository<Book, Integer> {
}
