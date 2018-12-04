package io.infinity.demo_graphql;

import io.infinity.demo_graphql.model.Author;
import io.infinity.demo_graphql.model.Book;
import io.infinity.demo_graphql.repository.AuthorRepository;
import io.infinity.demo_graphql.repository.BookRepository;
import io.infinity.demo_graphql.resolver.BookResolver;
import io.infinity.demo_graphql.resolver.Mutation;
import io.infinity.demo_graphql.resolver.Query;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoGraphqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoGraphqlApplication.class, args);
    }
    @Bean
    public BookResolver authorResolver(AuthorRepository authorRepository) {
        return new BookResolver(authorRepository);
    }

    @Bean
    public Query query(AuthorRepository authorRepository, BookRepository bookRepository) {
        return new Query(authorRepository, bookRepository);
    }

    @Bean
    public Mutation mutation(AuthorRepository authorRepository, BookRepository bookRepository) {
        return new Mutation(authorRepository, bookRepository);
    }

    @Bean
    public CommandLineRunner demo(AuthorRepository authorRepository, BookRepository bookRepository) {
        return (args) -> {
            Author author = new Author("Herbert", "Schildt");
            authorRepository.save(author);

            bookRepository.save(new Book("Java: A Beginner's Guide, Sixth Edition", "0071809252", 728, author));
        };
    }
}
