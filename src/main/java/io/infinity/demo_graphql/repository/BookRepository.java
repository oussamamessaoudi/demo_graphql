package io.infinity.demo_graphql.repository;

import io.infinity.demo_graphql.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> { }

