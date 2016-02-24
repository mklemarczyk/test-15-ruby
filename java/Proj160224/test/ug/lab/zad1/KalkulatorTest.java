package ug.lab.zad1;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import org.junit.*;

public class KalkulatorTest {
	
	Kalkulator kalkulator = new Kalkulator();
	
	@Test
	public void dodajSpr(){
		assertThat(kalkulator.dodaj(3,2), is(equalTo(5)));
	}

	@Test
	public void odejmSpr(){
		assertThat(kalkulator.odejm(3,2), is(equalTo(1)));
	}

	@Test
	public void mnozSpr(){
		assertThat(kalkulator.mnoz(3,2), is(equalTo(6)));
	}

	@Test
	public void dzielSpr(){
		assertThat(kalkulator.dziel(3,2), is(equalTo(1)));
	}

	@Test
	public void dzielPrzezZeroSpr(){
		try{
			kalkulator.dziel(3,0);
			fail("Nie errror");
		}catch(ArithmeticException ex){
			assertTrue(true);
		}
	}

	@Test
	public void wiekszeSpr(){
		assertThat(kalkulator.wieksze(3,2), is(equalTo(true)));
		assertThat(kalkulator.wieksze(2,3), is(equalTo(false)));
		assertThat(kalkulator.wieksze(3,3), is(equalTo(false)));
	}
	
}
