package ug.lab.zad1;

import static org.junit.Assert.*;
import org.junit.*;

public class KalkulatorTest {
	
	Kalkulator kalkulator = new Kalkulator();
	
	@Test
	public void dodajSpr(){
		assertEquals(5, kalkulator.dodaj(3,2));
	}

	@Test
	public void odejmSpr(){
		assertEquals(1, kalkulator.odejm(3,2));
	}

	@Test
	public void mnozSpr(){
		assertEquals(6, kalkulator.mnoz(3,2));
	}

	@Test
	public void dzielSpr(){
		assertEquals(1, kalkulator.dziel(3,2));
	}

	@Test
	public void wiekszeSpr(){
		assertEquals(true, kalkulator.wieksze(3,2));
		assertEquals(false, kalkulator.wieksze(2,3));
		assertEquals(false, kalkulator.wieksze(3,3));
	}
	
}
