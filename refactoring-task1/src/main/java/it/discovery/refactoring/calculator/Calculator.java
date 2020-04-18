package it.discovery.refactoring.calculator;

import java.io.FileWriter;
import java.io.IOException;

public class Calculator {

    public static final String DEFAULT_PATH = "C:\\Workspace\\IT courses\\";
    private String mathOperation;
    private int firstNumber;
    private int secondNumber;
    private int numberSystem;
    private boolean preservation;

    public Calculator() {
        this.numberSystem = 10;
        this.preservation = false;
    }

    public void setMathOperation(String mathOperation) {
        this.mathOperation = mathOperation;
    }

    public void setFirstNumber(String firstNumber) {
        this.firstNumber = convertStringToInt(firstNumber);
    }

    public void setSecondNumber(String secondNumber) {
        this.secondNumber = convertStringToInt(secondNumber);
    }

    public void setNumberSystem(String numberSystem) {
        this.numberSystem = convertStringToInt(numberSystem);
    }

    public void setPreservation(String preservation) {
        this.preservation = convertSrtingToBoolean(preservation);
    }


    /**
     * <p>Calculator for math operations:
     * <li>Addition</li>
     * <li>Subtraction</li>
     * <li>Multiplication</li>
     * Calculator has an opportunity using different number systems(2, 8, 10, 16) and save result in file.</p>
     */
    public void getResult() {
        String report = "Start\n";
        report += calculate();
        report += "Finish";
        if (!preservation) {
            System.out.println(report);
        } else {
            try (FileWriter file = new FileWriter(DEFAULT_PATH + "test.txt")) {
                file.write(report);
                file.flush();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error save report. Check input data");
            }
        }
    }


    public String calculate() {
        String report = "Argument 1: " + convertToNumberSystem(firstNumber, numberSystem) + "\n";
        report += "Argument 2: " + convertToNumberSystem(secondNumber, numberSystem) + "\n";
        report += "Math operation:" + (mathOperation.equals("+") ? "Addition \n" : mathOperation.equals("-") ? "Subtraction \n" :
                mathOperation.equals("*") ? "Multiplication \n" : "");
        int result = mathOperation.equals("+") ? firstNumber + secondNumber : mathOperation.equals("-") ? firstNumber - secondNumber :
                mathOperation.equals("*") ? firstNumber * secondNumber : 0;
        report += "Result: " + convertToNumberSystem(result, numberSystem) + "\n";
        return report;
    }

    private static String convertToNumberSystem(int number, int numberSystem) {
        System.out.println("Converted " + number + " to " + numberSystem);
        return numberSystem == 2 ? Integer.toBinaryString(number) :
                numberSystem ==8 ? Integer.toOctalString(number) :
                        numberSystem == 16 ? Integer.toHexString(number) : "" + number;
    }

    private int convertStringToInt(String str){
        int number = 0;
        try {
            number = Integer.parseInt(str);
        } catch (Exception ex) {
            System.out.println("This argument isn't integer. Check input data");
        }
        return number;
    }

    private boolean convertSrtingToBoolean(String str){
        return str != null && str.equals("true");
    }
}