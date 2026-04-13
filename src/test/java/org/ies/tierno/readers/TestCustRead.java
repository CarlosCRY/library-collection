package org.ies.tierno.readers;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.ies.tierno.models.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

import java.util.Scanner;

@Log4j
@AllArgsConstructor
public class TestCustRead {
    private final Scanner scanner;
    private final CustomerReader customerReader;

    @Test
    public void TestCorrect () {
        when(scanner.nextLine()).thenReturn("123456789X")
                .thenReturn("Paco")
                .thenReturn("Gómez");
        when(scanner.nextInt()).thenReturn(6661488)
                .thenReturn(28041);

        Customer testCustomer = customerReader.read();

        Assertions.assertEquals("123456789X", testCustomer.getNif());
        Assertions.assertEquals("Paco", testCustomer.getName());
        Assertions.assertEquals("Gómez", testCustomer.getSurname());
        Assertions.assertEquals(6661488, testCustomer.getCNumber());
        Assertions.assertEquals(28041, testCustomer.getZipCode());
    }
}
