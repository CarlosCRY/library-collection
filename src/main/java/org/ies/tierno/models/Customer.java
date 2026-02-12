package org.ies.tierno.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {
    private final String nif;
    private final String name;
    private final String surname;
    private final int cNumber;
    private final int zipCode;
}
