package it.discovery.refactoring;

import it.discovery.refactoring.calculator.Calculator;
import it.discovery.refactoring.scanner.Scanner;

public class App {

    /**
     * <p>Calculator for math operations Addition, Subtraction and Multiplication with opportunity
     * using different number systems and save result in file.</p>
     * <p>Before run this program set up the arguments in the Program Arguments your IDE:</p>
     * <li>args[0] - sign of math Operation;</li>
     * <li>args[1] - first integer number </li>
     * <li>args[2] - second integer number </li>
     * <li>args[3] - number system(2, 8, 10, 16) that you want to convert results</li>
     * <li>args[4] - show results in console(false) or save results in the file(true)</li>
     * For example: + 2 3 true
     */
    public static void main(String[] args) {
        System.out.println("Calculator");
        Calculator calculator = new Calculator();
        calculator.setMathOperation(args[0]);
        calculator.setFirstNumber(args[1]);
        calculator.setSecondNumber(args[2]);
        try {
            calculator.setNumberSystem(args[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
        }
        try {
            calculator.setPreservation(args[4]);
        } catch (ArrayIndexOutOfBoundsException e) {
        }
        calculator.getResult();
        System.out.println("Scanner");
        new Scanner().printData();
    }
}