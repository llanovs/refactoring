package it.discovery.refactoring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class ScannerTest {

    Scanner scanner;

    @BeforeEach
    void setup() {
        scanner = new Scanner();
    }

    @Test
    void readReportFile_fileExists_returnsReport() throws Exception {
        assumeTrue(new File("d:\\otchet\\otchet.txt").exists());

        SkkanerWrapper wrap = new SkkanerWrapper();
        wrap.scanner_ = scanner;
        wrap.$main_();
    }

    @Test
    void readReportFile_fileNonExists_error() throws Exception {
        assumeFalse(new File("d:\\otchet\\otchet.txt").exists());

        SkkanerWrapper wrap = new SkkanerWrapper();
        wrap.scanner_ = scanner;
        assertThrows(Exception.class, () -> wrap.$main_());
    }
}
