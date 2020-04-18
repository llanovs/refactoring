package scanner;

import it.discovery.refactoring.scanner.Scanner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ScannerTest {
    Scanner scanner;

    @BeforeEach
    void setup(){
        scanner = new Scanner();
    }

    @Test
    @DisplayName("print test.txt")
    void addTwoNumbers() {
        scanner.printData();
    }
}
