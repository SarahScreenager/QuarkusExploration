package org.agoncal.quarkus.starting;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookRepository {

    @ConfigProperty(name = "books.genre", defaultValue  = "Fantasy")
    String genre;

    public List<Book> getAllBooks() {
        return List.of(
                new Book(1, "BookOne", "Sarah", 2021, genre),
                new Book( 2, "Fellowship", "Tolkein", 1950, genre),
                new Book(3, "Two Towers", "Tolkein", 1950, genre),
                new Book(4, "Return of the King", "Tolkein", 1950, genre)
        );
    }

    public int countAllBooks() {
        return getAllBooks().size();
    }

    public Optional<Book> getBook(int id) {
        return getAllBooks().stream().filter(book -> book.id == id).findFirst();
    }


}
