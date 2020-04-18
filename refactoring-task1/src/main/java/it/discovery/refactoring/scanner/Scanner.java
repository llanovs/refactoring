package it.discovery.refactoring.scanner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class Scanner {
	public static final String DEFAULT = "C:\\Workspace\\IT courses\\test.txt";

	public static void main(String[] args){
		Data data = new Data();
		try {
			BufferedReader buffReader = new BufferedReader(new FileReader(DEFAULT));
			try {
				StringBuffer stringBuilder = new StringBuffer();
				String str = buffReader.readLine();
				int i = 0;
				Vector vector = new Vector();
				while (str != null) {
					stringBuilder.append(str + "\n");
					str = buffReader.readLine();
					vector.add(str);
					i++;
				}
				data.line = new Line(i);
				data.vector = vector;
				data.report = stringBuilder.toString();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		 new DataPrinter(data).print();
	}
}



