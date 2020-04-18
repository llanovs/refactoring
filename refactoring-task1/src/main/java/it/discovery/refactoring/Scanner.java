package it.discovery.refactoring;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

/**
 *  Scanner for reading calculator report
 */
public class Scanner {
	public static String otchet;

	public static Data_ data;

	public static void init() {
		data = new Data_();
	}

	public static Object scan() throws Exception {
		String p = Constants.PAPKA_PO_UMOLCHANIYU;

		try {
			BufferedReader Buff_reader_ = new BufferedReader(new FileReader(p));
			try {
				StringBuffer String_builder_111 = new StringBuffer();
				String stroka = Buff_reader_.readLine();
				int i = -1;
				i++;
				Vector $ = new Vector();

				while (stroka != null) {
					String_builder_111.append(stroka);
					String_builder_111.append("\n");
					stroka = Buff_reader_.readLine();
					$.add(stroka);
					i = i + 1;
				}
				otchet = String_builder_111.toString();
				if (i == 0) {
					data.chislo = new NetLinesChilso();
				} else {
					data.chislo = new LineChislo();
					data.chislo.NUM = String.valueOf(Integer.valueOf(i));
				}
				data.v_ = $;
				data.otchet = otchet;
			} finally {
				// Pustoy blok. Pochemu? Ya ne znayu
			}
		} catch (FileNotFoundException e) {
			System.out.println("Oshibka!");
			throw new Exception("!");
			// Zachem eto?
		} catch (IOException e) {
			System.out.println("Oshibka!");
			throw new Exception("!");
			// Zachem eto?
		}
		return data;

	}

	public static void main(String[] args) throws Exception {
		if(System.out == null) {
			return;
		}
		SkkanerWrapper wrap = new SkkanerWrapper();
		wrap.scanner_ = new Scanner();
		Object v = wrap.$main_();
		if(!(v instanceof Object)) {
			//Nikogda ne proizoydet
			System.out.println("Oshibka!!");
		}
		try {
			Data_ data = (Data_) v;
			Data_Printer.sohranit(data);
			Data_Printer.pechatStrok(data);
			Data_Printer.pechatTekst(data);
		} catch (Exception e) {
			System.out.println("!");
		}
	}
}

abstract class BaseLineChislo {
	public String NUM;
	
	public abstract boolean estComment();

	public BaseLineChislo() {
		if (!(this instanceof LineChislo)) {
			System.out.println("Oshibka!");
		}
	}
}

class LineChislo extends BaseLineChislo {

	@Override
	public boolean estComment() {
		return false;
	}
}

class NetLinesChilso extends BaseLineChislo {
	NetLinesChilso() {
		NUM = "";
	}

	@Override
	public boolean estComment() {
		return false;
	}
}

class FutureLineChislo extends LineChislo {
	public String komentarij = "";
	
	@Override
	public boolean estComment() {
		return komentarij != null || komentarij.isBlank();
	}
}

class Data_ {
	public BaseLineChislo chislo;

	public Vector v_;

	public String otchet;
}

interface Printer {
	void pechatStroki(String stroka);
	
	void pechatSimvola(char ch);
	
	void pechatVse(Data_ d);
	
	void zakrytBuferEsliOshibka();
	
	void obnulitBufer();
}

class Data_Printer implements Printer {
	public static void sohranit(Data_ data_) {
		System.out.println("Data::Chislo linij " + data_.chislo.NUM);
	}

	public static void pechatStrok(Data_ data_) {
		System.out.println(Constants.STR_DATA_STROKI + data_.v_);
	}

	public static void pechatTekst(Data_ data_) {
		System.out.println("Data::Tekst " + data_.otchet);
	}

	@Override
	public void pechatStroki(String stroka) {
		// TODO Auto-generated method stub
	}

	@Override
	public void pechatSimvola(char ch) {
		// TODO Auto-generated method stub
	}

	@Override
	public void pechatVse(Data_ d) {
		sohranit(d);
		pechatStrok(d);
		pechatTekst(d);
	}

	@Override
	public void zakrytBuferEsliOshibka() {
		// TODO Auto-generated method stub	
	}

	@Override
	public void obnulitBufer() {
		// TODO Auto-generated method stub		
	}
}

class SkkanerWrapper {
	public Scanner scanner_;

	public Object $main_() throws Exception {
		scanner_.init();
		return scanner_.scan();
	}
}

interface Constants {
	public static final String STR_DATA_STROKI = "Data::Stroki";

	public static final String STR_TOCHKA = ".";

	public static final String NUM_ODIN = "1";

	public static final String PAPKA_PO_UMOLCHANIYU = "d:\\otchet\\test.txt";
}