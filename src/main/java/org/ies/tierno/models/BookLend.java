package org.ies.tierno.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class BookLend implements Comparable<BookLend> {
    private final String isbn;
    private final String nif;
    private final LocalDate date;

    public int compareTo (BookLend other) {
        int compare = date.compareTo(other.date);
        if (compare == 0) {
            compare = isbn.compareTo(other.isbn);
            if (compare == 0) {
                compare = nif.compareTo(other.nif);
            }
        }
        return compare;
    }


}
