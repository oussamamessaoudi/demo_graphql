package io.infinity.demo_graphql.repository;

import io.infinity.demo_graphql.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> { }

