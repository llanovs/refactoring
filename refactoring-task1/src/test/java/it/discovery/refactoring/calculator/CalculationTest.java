package it.discovery.refactoring.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculationTest {
    Calculator calculator;

    @BeforeEach
    void setup(){
        calculator = new Calculator();
    }

    @Test
    @DisplayName("2 + 3 = 5")
    void addTwoNumbers() {
        calculator.setMathOperation("+");
        calculator.setFirstNumber("2");
        calculator.setSecondNumber("3");
        calculator.setNumberSystem("10");
        calculator.getResult();
        assertEquals(5, calculator.calculate());
    }

    @Test
    @DisplayName("5 - 3 = 2")
    void subtractNumber() {
        calculator.setMathOperation("-");
        calculator.setFirstNumber("5");
        calculator.setSecondNumber("3");
        calculator.getResult();
        assertEquals(2, calculator.calculate());
    }

    @Test
    @DisplayName("5 * 3 = 15")
    void multiplyNumbers() {
        calculator.setMathOperation("*");
        calculator.setFirstNumber("5");
        calculator.setSecondNumber("3");
        calculator.getResult();
        assertEquals(15, calculator.calculate());
    }

    @Test
    @DisplayName("Binary 2 + 3")
    void addTwoNumbersBinary() {
        calculator.setMathOperation("+");
        calculator.setFirstNumber("2");
        calculator.setSecondNumber("3");
        calculator.setNumberSystem("2");
        calculator.setPreservation("true");
        calculator.getResult();
    }

    @Test
    @DisplayName("Binary 5 - 3")
    void subtractNumberBinary() {
        calculator.setMathOperation("-");
        calculator.setFirstNumber("5");
        calculator.setSecondNumber("3");
        calculator.setNumberSystem("2");
        calculator.setPreservation("true");
        calculator.getResult();
    }

    @Test
    @DisplayName("Binary 5 * 3")
    void multiplyNumbersBinary() {
        calculator.setMathOperation("*");
        calculator.setFirstNumber("5");
        calculator.setSecondNumber("3");
        calculator.setNumberSystem("2");
        calculator.setPreservation("true");
        calculator.getResult();
    }
}
