package org.ies.tierno.readers;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.ies.tierno.models.Book;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

@Log4j
@AllArgsConstructor
public class BookReader implements Reader <Book> {
    private final Scanner scanner;

    @Override
    public Book read() {
        log.info("Introduzca ISBN");
        String isbn = scanner.nextLine();
        log.info("Introduzca nombre");
        String name = scanner.nextLine();
        log.info("Introduzca autor");
        String author = scanner.nextLine();
        log.info("Introduzca los géneros");
        Set<String> genres = new HashSet<>();
        String genre;
        while(true) {
            genre = scanner.nextLine();
            if (genre.isEmpty()) {
                break;
            } else {
                genres.add(genre);
            }
        }

        return new Book(
                isbn,
                name,
                author,
                genres
                );
    }
}
