package it.discovery.refactoring.scanner;

public abstract class BaseLine {

    public int stringCount;

    public abstract boolean comment();

    public BaseLine() {
        if (!(this instanceof Line)) {
            System.out.println("Error");
        }
    }
}
