package com.sjmillington.SpringDemo.repositories;

import com.sjmillington.SpringDemo.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
