package io.infinity.demo_graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import io.infinity.demo_graphql.model.Author;
import io.infinity.demo_graphql.model.Book;
import io.infinity.demo_graphql.repository.AuthorRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public class BookResolver implements GraphQLResolver<Book> {
    private AuthorRepository authorRepository;

    public BookResolver(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Optional<Author> getAuthor(Book book) {
        return authorRepository.findById(book.getAuthor().getId());
    }
}
