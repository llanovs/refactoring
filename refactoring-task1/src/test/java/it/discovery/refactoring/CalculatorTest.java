package it.discovery.refactoring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

	Calculator calculator;

	@BeforeEach
	void setup() {
		calculator = new Calculator();
	}
	
	@Test
	@DisplayName("2 + 3 = 5")
	void addTwoNumbers_returnsCorrectResult() {
		calculator.calculateAndGenerateReport("+", "2", "3", "", "", "");
	}

	@Test
	void addTwoNumbersInBinaryFormat_returnsCorrectResult() {
		calculator.calculateAndGenerateReport("+", "01", "11", "2", "", "");
	}

	@Test
	void addTwoNumbersAndPrintToConsole_returnsCorrectResult() {
		calculator.calculateAndGenerateReport("+", "01", "11", "10", "false", "");
	}

	@Test
	void subtractTwoNumbers_returnsCorrectResult() {
		calculator.calculateAndGenerateReport("-", "2", "3", "", "", "");
	}

	@Test
	void multipleTwoNumbers_returnsCorrectResult() {
		calculator.calculateAndGenerateReport("*", "2", "3", "", "", "");
	}

}
