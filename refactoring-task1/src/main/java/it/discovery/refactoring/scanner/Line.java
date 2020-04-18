package it.discovery.refactoring.scanner;

public class Line extends BaseLine {

    public Line() {

    }

    public Line(int stringCount) {
        this.stringCount = stringCount;
    }

    @Override
    public boolean comment() {
        return false;
    }
}
