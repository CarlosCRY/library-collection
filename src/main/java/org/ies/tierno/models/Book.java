package org.ies.tierno.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class Book {
    private final String isbn;
    private final String title;
    private final String author;
    private final Set<String> genres;
}
