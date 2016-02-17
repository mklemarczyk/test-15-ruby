package ug.lab.zad1;

import static org.junit.Assert.*;
import org.junit.*;

public class NwdTest {

	@Test
	public void rowneSpr(){
		Nwd nwd = new Nwd(5, 5);
		assertEquals(5, nwd.policz());
	}

	@Test
	public void drugaWiekszaSpr(){
		Nwd nwd = new Nwd(9, 12);
		assertEquals(3, nwd.policz());
	}

	@Test
	public void drugaMniejsaSpr(){
		Nwd nwd = new Nwd(12, 9);
		assertEquals(3, nwd.policz());
	}

	@Test
	public void ujemneSpr(){
		Nwd nwd = new Nwd(-12, -9);
		assertEquals(-3, nwd.policz());
	}

	@Test
	public void pierwsaUjemnaSpr(){
		Nwd nwd = new Nwd(-12, 9);
		assertEquals(-3, nwd.policz());
	}

	@Test
	public void drugaUjemnaSpr(){
		Nwd nwd = new Nwd(12, -9);
		assertEquals(3, nwd.policz());
	}

	@Test(expected = Exception.class)
	public void pierwszaZeroSpr(){
		new Nwd(0, 3);
	}

	@Test(expected = Exception.class)
	public void drugaZeroSpr(){
		new Nwd(3, 0);
	}

}
