package io.infinity.demo_graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import io.infinity.demo_graphql.model.Author;
import io.infinity.demo_graphql.model.Book;
import io.infinity.demo_graphql.repository.AuthorRepository;
import io.infinity.demo_graphql.repository.BookRepository;

public class Query implements GraphQLQueryResolver {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    public Query(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public Iterable<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Iterable<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public long countBooks() {
        return bookRepository.count();
    }
    public long countAuthors() {
        return authorRepository.count();
    }
}
