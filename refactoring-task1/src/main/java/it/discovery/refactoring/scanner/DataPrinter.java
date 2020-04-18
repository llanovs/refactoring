package it.discovery.refactoring.scanner;

public class DataPrinter implements Printer{

    public Data data;

    public DataPrinter(Data data) {
        this.data = data;
    }

    @Override
    public void printString() {
        System.out.println("String: " + data.vector);
    }

    @Override
    public void printCountOfLines() {
        System.out.println("Count of Strings: " + data.line.stringCount);
    }

    @Override
    public void printReport() {
        System.out.println("Text: \n" + data.report);
    }

    public void print() {
        printString();
        printCountOfLines();
        printReport();
    }

    @Override
    public void closeBuffer() {

    }

    @Override
    public void resetBuffer() {

    }
}
