package org.ies.tierno.readers;

import org.ies.tierno.models.Customer;

import java.util.Scanner;

import lombok.AllArgsConstructor;

import lombok.extern.log4j.Log4j;

@Log4j
@AllArgsConstructor
public class CustomerReader implements Reader <Customer> {
    private final Scanner scanner;

    @Override
    public Customer read() {
        log.info("Introduzca NIF");
        String nif = scanner.nextLine();
        log.info("Introduzca nombre");
        String name = scanner.nextLine();
        log.info("Introduzca apellidos");
        String surname = scanner.nextLine();
        log.info("Introduzca código cliente");
        int cNumber = scanner.nextInt();
        scanner.nextLine();
        log.info("Introduzca código ZIP");
        int zipCode = scanner.nextInt();


        return new Customer(
                nif,
                name,
                surname,
                cNumber,
                zipCode
                );
    }
}
