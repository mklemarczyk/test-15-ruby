package ug.lab.zad5;

public class LiczbaRzymska {

	private int liczba;
	
	public LiczbaRzymska(int liczba) throws Exception{
		if (liczba < 0)
			throw new Exception("Liczby mniejsze od zera nie sa obslugiwane");
		if (liczba == 0)
			throw new Exception("0 nie jest obslugiwane");
		if (liczba > 3999)
			throw new Exception("Liczby wieksze od 3999 nie sa obslugiwane");
		this.liczba = liczba;
	}
	
	private static final int arabskie[] = {1000, 500, 100, 50, 10, 5, 1};
	private static final char rzymskie[] = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
	private static final int ILE = arabskie.length;
	
	public String toString(){
		int i = 0;
		int n = liczba;
		String wynik = "";
		
		while ((n > 0) && (i < ILE)) {
			if(n >= arabskie[i]) {
					n -= arabskie[i];
					wynik += rzymskie[i];
			} else if ((i % 2 == 0) &&
					(i < ILE -2) &&
					(n >= arabskie[i] - arabskie[i +2]) &&
					(arabskie[i +2] != arabskie[i] - arabskie[i +2])) {
				n -= arabskie[i] - arabskie[i +2];
				wynik += rzymskie[i +2];
				wynik += rzymskie[i];
				i++;
			} else if ((i % 2 == 1) &&
					(i < ILE -1) &&
					(n >= arabskie[i] - arabskie[i +1]) &&
					(arabskie[i +1] != arabskie[i] - arabskie[i +1])) {
				n -= arabskie[i] - arabskie[i +1];
				wynik += rzymskie[i +1];
				wynik += rzymskie[i];
				i++;
			} else {
				i++;
			}
		}
		 
		return wynik;
	}

}
