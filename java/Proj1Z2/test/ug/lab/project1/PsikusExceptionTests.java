package ug.lab.project1;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PsikusExceptionTests {

	Psikus instance = new Psikus();
	
	@Test
	public void HultajChochlaException() {
		boolean sprawdz = false;
		try {
			instance.HultajChochla(4);
		} catch(NieudanyPsikusException e) {
			sprawdz = true;
		}
		assertTrue(sprawdz);
	}
}
