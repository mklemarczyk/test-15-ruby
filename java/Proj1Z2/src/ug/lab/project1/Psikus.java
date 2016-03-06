package ug.lab.project1;

import java.util.Random;

public class Psikus implements IPsikus {

	@Override
	public Integer CyfroKrad(Integer liczba) {
		int len = liczba.toString().length();
		Random r = new Random(); 
		if(len < 2) {
			return null;
		} else {
			int i = r.nextInt(len) +1;
			int w1 = 0;
			int z1 = liczba;
			int n = 0;
			while(n != i)
			{
				w1 = z1 % 10;
				z1 = z1 / 10;
				n++;
			}
			int wynik = 0;
			int rand = i;
			int tmp = rand -1;
			while(tmp > 0) {
				w1 *= 10;
				tmp--;
			}
			wynik = liczba - w1;
			return wynik;
		}
	}

	@Override
	public Integer HultajChochla(Integer liczba) throws NieudanyPsikusException {
		Random r = new Random(); 
		int len = liczba.toString().length();
		if(liczba / 100 < 1) {
			throw new NieudanyPsikusException();
		} else {
			int wynik;
			int r1 = r.nextInt(len)+1;
			int wynik1 = 0;
			int z1 = liczba;
			int n = 0;
			while(n != r1) {
				wynik1 = z1 % 10;
				z1 = z1 / 10;
				n++;
			}
			int r2 = r.nextInt(len) +1;
			while (r1 == r2) {
				r2 = r.nextInt(len) +1;
			}
			n=0;
			int wynik2 = 0;
			int z2 = liczba;
			while(n != r2) {
				wynik2 = z2 % 10;
				z2 /= 10;
				n++;
			}
			int wynik3 = 0;
			int rand1 = r1;
			int rand2 = r2;
			int w1 = wynik1;
			int w2 = wynik2;
			if(len>2) {
				int tmp1 = rand1 -1;
				while(tmp1 > 0) {
					w1 *= 10;
					tmp1--;
				}
				int tmp2 = rand2-1;
				while(tmp2 > 0) {
					w2 *= 10;
					tmp2--;
				}
				wynik3 = liczba - w1 - w2;
			}
			
		    int tmp = r2 -1;
			while(tmp > 0) {
				wynik1 *= 10;
				tmp--;
			}
			tmp = r1 -1;
			while(tmp > 0) {
				wynik2 *= 10;
				tmp--;
			}
			wynik = wynik1 + wynik2 + wynik3;		
			return wynik;
		}
	}

	@Override
	public Integer Nieksztaltek(Integer liczba) {
		int wynik = 0;
		int n = 0;
		int k = 0;
		int w1 = 0;
		int w2 = 0;
		int len = liczba.toString().length();
		int z1 = liczba;
		while(n != len +1) {
			n++;
			w1 = z1 % 10;
			z1 = z1 / 10;
			if(w1==3) {
				w1 = 8;
				n = len +1;
			} else if (w1 == 7) {
				w1 = 1;
				n = len +1;
			} else if (w1 == 6) {
				w1 = 9;
				n = len +1;
			}
			k++;
		}
		int tmp1 = k-1;
		while(tmp1>0) {
			w1 *= 10;
			tmp1--;
		}
		n = 0;
		z1 = liczba;
		while(n != k) {
			w2 = z1 % 10;
			z1 = z1 / 10;
			n++;
		}
		tmp1 = k -1;
		while(tmp1 > 0) {
			w2 *= 10;
			tmp1--;
		}
		wynik = liczba - w2 + w1;
		return wynik;
	}

	@Override
	public Integer Heheszki(Integer liczba) {
		Random r = new Random(); 
		return r.nextInt(liczba);
	}

	@Override
	public boolean Titit(Integer liczba, Integer liczba_dziel) {
		return liczba % liczba_dziel == 0;
	}
}
