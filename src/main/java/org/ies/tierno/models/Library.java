package org.ies.tierno.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

@Data
@AllArgsConstructor
public class Library {
    private final String name;
    private final Map<String, Book> booksByIsbn;
    private final List<Customer> customers;
    private final TreeSet<BookLend> booklends;

    public List<Book> findByGenre(String genre) {
        List<Book> rBooks = new ArrayList<>();
        for (Book book : booksByIsbn.values()) {
            if (book.getGenres().contains(genre)) {
                rBooks.add(book);
            }
        }
        return rBooks;
    }

    public List<Customer> findByZip(int zip) {
        List<Customer> rCustomers = new ArrayList<>();
        for (Customer customer : customers) {
            if (customer.getZipCode() == zip) {
                rCustomers.add(customer);
            }
        }
        return rCustomers;
    }

    public void addBookLend(String isbn, String nif) {
        BookLend newBL = new BookLend(isbn, nif, LocalDate.now());
        booklends.add(newBL);
    }

    public void removeGenre(String isbn, String genre) {
        if (booksByIsbn.containsKey(isbn)) {
            Book bRGenre = booksByIsbn.get(isbn);
            bRGenre.getGenres().remove(genre);
        }
    }

    public boolean confirmLend(String isbn, int number) {
        for (Customer customer : customers) {
            if (customer.getCNumber() == number) {
                for (BookLend bLend: booklends) {
                    if (bLend.getNif().equals(customer.getNif()) && bLend.getIsbn().equals(isbn)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public Set<String> bookGenre (String isbn) {
        if (booksByIsbn.containsKey(isbn)) {
            return booksByIsbn.get(isbn).getGenres();
        } else {
            return null;
        }
    }

    public TreeSet<BookLend> bookLends(String isbn) {
        if (booksByIsbn.containsKey(isbn)) {
            TreeSet<BookLend> rBLend = new TreeSet<>();
            for (BookLend bLend: booklends) {
                if (bLend.getIsbn().equals(isbn)) {
                    rBLend.add(bLend);
                }
            }
            return rBLend;
        } else {
            return null;
        }
    }
}
