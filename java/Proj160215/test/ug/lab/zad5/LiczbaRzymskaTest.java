package ug.lab.zad5;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LiczbaRzymskaTest {

	@Test(expected = Exception.class)
	public void mniejszeSpr() throws Exception {
		new LiczbaRzymska(-1);
	}

	@Test(expected = Exception.class)
	public void zeroSpr() throws Exception {
		new LiczbaRzymska(0);
	}

	@Test(expected = Exception.class)
	public void zaDuzeSpr() throws Exception {
		new LiczbaRzymska(4000);
	}

	@Test
	public void jedenSpr() throws Exception {
		LiczbaRzymska lr = new LiczbaRzymska(1);
		assertEquals("I", lr.toString());
	}

	@Test
	public void piecSpr() throws Exception {
		LiczbaRzymska lr = new LiczbaRzymska(5);
		assertEquals("V", lr.toString());
	}

	@Test
	public void dziesiecSpr() throws Exception {
		LiczbaRzymska lr = new LiczbaRzymska(10);
		assertEquals("X", lr.toString());
	}

	@Test
	public void piecdziesiatSpr() throws Exception {
		LiczbaRzymska lr = new LiczbaRzymska(50);
		assertEquals("L", lr.toString());
	}

	@Test
	public void stoSpr() throws Exception {
		LiczbaRzymska lr = new LiczbaRzymska(100);
		assertEquals("C", lr.toString());
	}

	@Test
	public void piecsetSpr() throws Exception {
		LiczbaRzymska lr = new LiczbaRzymska(500);
		assertEquals("D", lr.toString());
	}

	@Test
	public void tysiacSpr() throws Exception {
		LiczbaRzymska lr = new LiczbaRzymska(1000);
		assertEquals("M", lr.toString());
	}

	@Test
	public void zlozona1111Spr() throws Exception {
		LiczbaRzymska lr = new LiczbaRzymska(1111);
		assertEquals("MCXI", lr.toString());
	}

	@Test
	public void zlozona1333Spr() throws Exception {
		LiczbaRzymska lr = new LiczbaRzymska(1333);
		assertEquals("MCCCXXXIII", lr.toString());
	}

	@Test
	public void zlozona1444Spr() throws Exception {
		LiczbaRzymska lr = new LiczbaRzymska(1444);
		assertEquals("MCDXLIV", lr.toString());
	}

	@Test
	public void zlozona1555Spr() throws Exception {
		LiczbaRzymska lr = new LiczbaRzymska(1555);
		assertEquals("MDLV", lr.toString());
	}

	@Test
	public void zlozona1888Spr() throws Exception {
		LiczbaRzymska lr = new LiczbaRzymska(1888);
		assertEquals("MDCCCLXXXVIII", lr.toString());
	}

	@Test
	public void zlozona1999Spr() throws Exception {
		LiczbaRzymska lr = new LiczbaRzymska(1999);
		assertEquals("MCMXCIX", lr.toString());
	}
}
