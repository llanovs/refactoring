package it.discovery.refactoring;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 *  Class for basic mathematic calculations
 *  Fixme large class
 */
public class Calculator {
    public static String report = null;

    // Primer ispolzovaniya: zapustit is IDE s argumentami
    // 1) znak operacii
    // 2) argument #1,
    // 3) argument #2
    // 4) sistema schisleniya - 2, 8, 10 ili 16 (opcionalno, po umolchaniyu 10)
    // 5) vyvod v konsol(false) ili fayl(true) (opcionalno)
    // naprimer, + 2 2 true
    public static void main(String[] argumenty) {
        String operand = argumenty[0];
        String firstArg = argumenty[1];
        String secondArg = argumenty[2];
        String system = null;
        try {
            system = argumenty[3];
        } catch (ArrayIndexOutOfBoundsException iskl) {
            system = "10";
        }

        String toFile = null;
        try {
            toFile = argumenty[4];
        } catch (ArrayIndexOutOfBoundsException iskl) {
            toFile = "false";
        }

        calculateAndGenerateReport(operand, firstArg, secondArg, system, toFile, "");
    }

    /**
     * Performs basic mathematic calculation and generate reports
     * about its activities
     * FIXME long method
     * FIXME primitive obsession
     * FIXME long parameter list
     *
     * @param operand
     * @param firstArg
     * @param secondArg
     * @param system
     * @param toFile
     * @param temp
     * @return
     */
    public static int calculateAndGenerateReport(String operand, String firstArg,
                                                 String secondArg, String system,
                                                 String toFile, String temp) {
        report = "";
        report += "Nachali rabotu\n";

        boolean con = false;
        //proverit toFile
        if (toFile != null && toFile.equals("true")) {
            con = true;
        }

        switch (operand) {
            case "+": {
                report += "Operaciya slojit\n";
                int pervoeInt = 0;
                try {
                    pervoeInt = Integer.parseInt(firstArg);
                } catch (Exception ex) {
                    System.out.println("Oshibka");
                }
                int vtoroeInt = 0;
                try {
                    vtoroeInt = Integer.parseInt(secondArg);
                } catch (Exception ex) {
                    System.out.println("Oshibka");
                }

                report += "Argument 1 " + convert(pervoeInt, system) + "\n";
                report += "Argument 2 " + convert(vtoroeInt, system) + "\n";
                int summa = pervoeInt + vtoroeInt;
                report += "Rezultat " + convert(summa, system) + "\n";
                System.out.println(summa);
                try {
                    report += "Zakonchili rabotu\n";
                    if (con) {
                        System.out.println(report);
                    } else {
                        FileWriter w = new FileWriter("d:\\otchet\\test.txt");
                        BufferedWriter out = new BufferedWriter(w);
                        out.write(report);
                        out.close();
                    }

                } catch (Exception e) {
                    System.out.println("Oshibka");
                }
            }
            ;
            break;

            case "-": {
                report += "Operaciya vychitanie\n";
                int pervoeInt = 0;
                try {
                    pervoeInt = Integer.parseInt(firstArg);
                } catch (Exception ex) {
                    System.out.println("Oshibka");
                }
                int vtoroeInt = 0;
                try {
                    vtoroeInt = Integer.parseInt(secondArg);
                } catch (Exception ex) {
                    System.out.println(getError());
                }

                report += "Argument 1 " + convert(pervoeInt, system) + "\n";
                report += "Argument 2 " + convert(pervoeInt, system) + "\n";
                pervoeInt -= vtoroeInt;
                report += "Rezultat " + convert(pervoeInt, system) + "\n";
                System.out.println(pervoeInt);
                try {
                    report += "Zakonchili rabotu\n";
                    if (con) {
                        System.out.println(report);
                    } else {
                        FileWriter w = new FileWriter("d:\\otchet\\test.txt");
                        BufferedWriter out = new BufferedWriter(w);
                        out.write(report);
                        out.close();
                    }

                } catch (Exception e) {
                    System.out.println(getError());
                }
            }
            ;
            break;
            case "*": {
                report += "Operaciya umnojeniya\n";
                int pervoeInt = 0;
                try {
                    pervoeInt = Integer.parseInt(firstArg);
                } catch (Exception ex) {
                    System.out.println(getError());
                }
                int vtoroeInt = 0;
                try {
                    vtoroeInt = Integer.parseInt(secondArg);
                } catch (Exception ex) {
                    System.out.println(getError());
                }
                report += "Argument 1 " + convert2(pervoeInt, system) + "\n";
                report += "Argument 2 " + convert2(pervoeInt, system) + "\n";
                int itogo = pervoeInt * vtoroeInt;
                report += "Rezultat " + convert2(itogo, system) + "\n";
                System.out.println(itogo);
                try {
                    report += "Zakonchili rabotu\n";
                    FileWriter w = new FileWriter("d:\\otchet\\test.txt");
                    BufferedWriter out = new BufferedWriter(w);
                    out.write(report);
                    out.close();

                } catch (Exception e) {
                    System.out.println(getError());
                    return -1;
                }

            }
            ;
            break;
        }
        return 0;

    }

    /**
     * Converts integer value into string format
     * based on calculation system
     * @param value
     * @param system
     * @return
     */
    private static String convert(int value, String system) {
        switch (system) {
            case "2":
                String rez = Integer.toBinaryString(value);
                return rez;
            case "8":
                String rez2 = Integer.toOctalString(value);
                return rez2;
            case "16":
                String rez3 = Integer.toHexString(value);
                return rez3;
            default:
                String rez4 = "" + value;
                return rez4;
        }
    }

    private static String convert2(int value, String system) {
        int sc = 10;
        try {
            sc = Integer.parseInt(system);
        } catch (NumberFormatException iskl) {

        }

        system = Integer.toString(value, sc);
        System.out.println("Converted " + value + " to " + system);
        return system;
    }

    private void print(String text) {
    }

    private static String getError() {
        return "Oshibka";
    }
}

// Ne udalyat!!
//class OtchetTools {
//	public static void zapusk() {
//		String otchet = MainClass.otchet;
//		System.out.println(otchet);
//	}
//	
//	public static void main(String[] argumenty) {
//		OtchetTools otchet = new OtchetTools();
//		otchet.zapusk();
//	}
//}
