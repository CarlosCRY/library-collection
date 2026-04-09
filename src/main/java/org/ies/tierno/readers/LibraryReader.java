package org.ies.tierno.readers;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

import org.ies.tierno.models.Book;
import org.ies.tierno.models.BookLend;
import org.ies.tierno.models.Customer;
import org.ies.tierno.models.Library;

import java.time.LocalDate;
import java.util.*;

@Log4j
@AllArgsConstructor
public class LibraryReader implements Reader <Library> {
    private final Random random;
    private final Scanner scanner;
    private final BookReader bookReader;
    private final CustomerReader customerReader;

    @Override
    public Library read() {
        log.info("Introduzca nombre");
        String name = scanner.nextLine();
        log.info("Introduzca los libros");
        Map<String, Book> books = new HashMap<>();
        do {
            Book book = bookReader.read();
            books.put(book.getIsbn(), book);
            log.info("¿Añadir otro libro? escriba \"N\" para parar.");
            if (scanner.nextLine().toUpperCase().contains("N")) {
                break;
            }
        } while(true);
        log.info("Introduzca los clientes");
        List<Customer> customers = new ArrayList<>();
        do {
            customers.add(customerReader.read());
            log.info("¿Añadir otro cliente? escriba \"N\" para parar.");
            if (scanner.nextLine().toUpperCase().contains("N")) {
                break;
            }
        } while(true);

        log.info("Introduzca los préstamos");
        TreeSet<BookLend> lends = new TreeSet<>();
        List<String> isbnList = books.keySet().stream().toList();
        do {
            lends.add(new BookLend(isbnList.get(random.nextInt(isbnList.size())),
                    customers.get(random.nextInt(customers.size())).getNif(),
                    LocalDate.parse(random.nextInt(2025,2026) + "-" + random.nextInt(1,12) + "-" + random.nextInt(1,30))));
            log.info("¿Añadir otro préstamo? escriba \"N\" para parar.");
            if (scanner.nextLine().toUpperCase().contains("N")) {
                break;
            }
        } while(true);

        return new Library(
                name,
                books,
                customers,
                lends
                );
    }
}
