package com.sjmillington.SpringDemo.repositories;

import com.sjmillington.SpringDemo.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
