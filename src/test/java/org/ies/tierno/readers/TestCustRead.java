package org.ies.tierno.readers;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.when;

import java.util.Scanner;

@Log4j
@AllArgsConstructor
public class TestCustRead {
    private final Scanner scanner;

    @Test
    public void TestCorrect () {
        when(scanner.nextLine())
    }
}
