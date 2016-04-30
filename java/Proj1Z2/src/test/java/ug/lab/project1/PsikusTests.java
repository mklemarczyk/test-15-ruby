package ug.lab.project1;

import static org.junit.Assert.*;

import java.util.Collection;

import static org.hamcrest.Matchers.*;
import org.junit.*;

import com.google.common.primitives.Chars;

public class PsikusTests {

	Psikus instance = new Psikus();
	
	@Test
	public void CyfroKradOneDigitTest() {
		assertThat(instance.CyfroKrad(1), is(nullValue()));
	}
	
	@Test
	public void CyfroKradMoreThanOneDigitTest() {
		Integer n = 12;
		Integer result = instance.CyfroKrad(n);
		assertThat(result, is(not(nullValue())));
		
		String nAsString = n.toString();
		String resultAsString = result.toString();
		assertThat(resultAsString.length(), is(nAsString.length()-1));
		
		Collection<Character> nAsArray = Chars.asList(result.toString().toCharArray());
		Collection<Character> resultAsArray = Chars.asList(n.toString().toCharArray());
		assertThat(nAsArray, everyItem(isIn(resultAsArray)));
	}
	
	@Test
	public void CyfroKradDigitWithManyZerosTest() {
		Integer n = 100000;
		Integer result = instance.CyfroKrad(n);
		assertThat(result, is(not(nullValue())));
		
		String nAsString = n.toString();
		String resultAsString = result.toString();
		assertThat(resultAsString.length(), is(nAsString.length() -1));
		
		Collection<Character> nAsArray = Chars.asList(result.toString().toCharArray());
		Collection<Character> resultAsArray = Chars.asList(n.toString().toCharArray());
		assertThat(nAsArray, everyItem(isIn(resultAsArray)));
	}

	@Test
	public void CyfroKrad2Digits() {
		assertThat(instance.CyfroKrad(37), anyOf(is(30), is(7)));
	}

	@Test
	public void CyfroKrad3Digits() {
		assertThat(instance.CyfroKrad(137), anyOf(is(130), is(107), is(37)));
	}

	@Test
	public void HultajChochlaSameItem() throws NieudanyPsikusException {
		Integer n = 456789;
		Integer result = instance.HultajChochla(n);
		assertThat(result, is(not(nullValue())));
		
		String nAsString = n.toString();
		String resultAsString = result.toString();
		assertThat(resultAsString.length(), is(nAsString.length()));
		
		Collection<Character> nAsArray = Chars.asList(nAsString.toCharArray());
		Collection<Character> resultAsArray = Chars.asList(resultAsString.toCharArray());
		assertThat(nAsArray, everyItem(isIn(resultAsArray)));
		assertThat(resultAsArray, everyItem(isIn(nAsArray)));
	}

	@Test
	public void HultajChochla2Digits() throws NieudanyPsikusException {
		assertThat(instance.HultajChochla(37), is(73));
	}

	@Test
	public void HultajChochla3Digits() throws NieudanyPsikusException {
		assertThat(instance.HultajChochla(123), anyOf(is(132), is(213), is(321)));
	}

	@Test
	public void HultajChochla4Digits() throws NieudanyPsikusException {
		assertThat(instance.HultajChochla(1234), anyOf(is(1243), is(1432), is(4231),is(1324), is(3214), is(2134)));
	}

	@Test
	public void NieksztaltekNoMatch() {
		assertThat(instance.Nieksztaltek(124), is(124));
	}

	@Test
	public void NieksztaltekRule3() {
		assertThat(instance.Nieksztaltek(453), is(458));
	}

	@Test
	public void NieksztaltekRule7(){
		assertThat(instance.Nieksztaltek(874), is(814));
	}

	@Test
	public void NieksztaltekRule6(){
		assertThat(instance.Nieksztaltek(624), is(924));
	}

	@Test
	public void Heheszki() {
		Integer n = Integer.MAX_VALUE;
		Integer result = instance.Heheszki(n);
		
		assertThat(result, is(not(nullValue())));
		assertThat(result, is(greaterThan(-1)));
		assertThat(result, is(lessThan(n)));
	}

	@Test
	public void Titit() {
		assertThat(instance.Titit(20, 2), is(true));
		assertThat(instance.Titit(20, 3), is(false));
	}
	
}
