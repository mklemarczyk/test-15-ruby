package ug.lab.zad4;

import static org.junit.Assert.*;
import org.junit.*;

public class KalkulatorTest {
	
	Kalkulator kalkulator = new Kalkulator();
	
	@Test
	public void dodajSpr(){
		assertEquals(5.0, kalkulator.dodaj(3.0, 2.0), 0);
	}

	@Test
	public void odejmSpr(){
		assertEquals(1.0, kalkulator.odejm(3.0, 2.0), 0);
	}

	@Test
	public void mnozSpr(){
		assertEquals(6.0, kalkulator.mnoz(3.0, 2.0), 0);
	}

	@Test
	public void dzielSpr(){
		assertEquals(1.5, kalkulator.dziel(3.0, 2.0), 0);
	}

	@Test
	public void dzielPrzezZeroSpr(){
		assertEquals(Double.POSITIVE_INFINITY, kalkulator.dziel(3.0, 0.0), 0);
		assertEquals(Double.NEGATIVE_INFINITY, kalkulator.dziel(-3.0, 0.0), 0);
		assertEquals(Double.NaN, kalkulator.dziel(0.0, 0.0), 0);
	}

	@Test
	public void wiekszeSpr(){
		assertEquals(true, kalkulator.wieksze(3.0, 2.0));
		assertEquals(false, kalkulator.wieksze(2.0, 3.0));
		assertEquals(false, kalkulator.wieksze(3.0, 3.0));
	}
	
}
