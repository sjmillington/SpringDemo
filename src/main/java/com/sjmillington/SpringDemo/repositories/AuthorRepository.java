package com.sjmillington.SpringDemo.repositories;

import com.sjmillington.SpringDemo.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
