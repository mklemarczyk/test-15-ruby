package ug.lab.project1;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import org.junit.*;

public class MyStackTest {
	MyStack stos = new MyStack();
	
	@Test
	public void dodajNaStos(){
		stos.MyPush(12);
		assertThat(stos.getData(), is(not(equalTo(null))));
		assertThat(stos.getData().size(), is(equalTo(1)));
		assertThat(stos.getData(), contains(12));
	}

	@Test
	public void usunZPustegoStosu(){
		try{
			stos.MyPop();
			fail("Nie ma errora");
		}catch(ArrayIndexOutOfBoundsException ex){
			assertTrue(true);
		}
	}

	@Test
	public void usunZeStosu(){
		stos.MyPush(12);
		assertThat(stos.getData(), is(not(equalTo(null))));
		assertThat(stos.getData().size(), is(equalTo(1)));
		stos.MyPop();
		assertThat(stos.getData(), is(not(equalTo(null))));
		assertThat(stos.getData().size(), is(equalTo(0)));
	}

	@Test
	public void czytajZPustegoStosu(){
		try{
			stos.MyTop();
			fail("Nie ma errora");
		}catch(ArrayIndexOutOfBoundsException ex){
			assertTrue(true);
		}
	}

	@Test
	public void czytajZeStosu(){
		stos.MyPush(12);
		assertThat(stos.getData(), is(not(equalTo(null))));
		assertThat(stos.getData().size(), is(equalTo(1)));
		assertThat(stos.MyTop(), is(equalTo(12)));
	}

	@Test
	public void sprawdzCzyPustyStos(){
		assertThat(stos.getData(), is(not(equalTo(null))));
		assertThat(stos.getData().size(), is(equalTo(0)));
		assertThat(stos.IsNull(), is(equalTo(true)));
		stos.MyPush(3);
		assertThat(stos.getData(), is(not(equalTo(null))));
		assertThat(stos.getData().size(), is(equalTo(1)));
		assertThat(stos.IsNull(), is(equalTo(false)));
	}
	
}
