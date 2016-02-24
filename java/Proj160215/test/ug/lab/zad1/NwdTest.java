package ug.lab.zad1;

import static org.junit.Assert.*;
import org.junit.*;

public class NwdTest {

	@Test
	public void rowneSpr() throws Exception{
		Nwd nwd = new Nwd(5, 5);
		assertEquals(5, nwd.policz());
	}

	@Test
	public void drugaWiekszaSpr() throws Exception{
		Nwd nwd = new Nwd(9, 12);
		assertEquals(3, nwd.policz());
	}

	@Test
	public void drugaMniejsaSpr() throws Exception{
		Nwd nwd = new Nwd(12, 9);
		assertEquals(3, nwd.policz());
	}

	@Test
	public void ujemneSpr() throws Exception{
		Nwd nwd = new Nwd(-12, -9);
		assertEquals(3, nwd.policz());
	}

	@Test
	public void pierwsaUjemnaSpr() throws Exception{
		Nwd nwd = new Nwd(-12, 9);
		assertEquals(3, nwd.policz());
	}

	@Test
	public void drugaUjemnaSpr() throws Exception{
		Nwd nwd = new Nwd(12, -9);
		assertEquals(3, nwd.policz());
	}

	@Test(expected = Exception.class)
	public void pierwszaZeroSpr() throws Exception{
		new Nwd(0, 3);
	}

	@Test(expected = Exception.class)
	public void drugaZeroSpr() throws Exception{
		new Nwd(3, 0);
	}

}
