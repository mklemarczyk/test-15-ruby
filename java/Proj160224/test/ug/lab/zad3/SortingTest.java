package ug.lab.zad3;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import org.junit.*;

public class SortingTest {

	@Test
	public void sortujNull(){
		try{
			Sorting sorter = new Sorting(null);
			sorter.sortArray();
			fail("Nie ma errora");
		}catch(NullPointerException ex){
			assertTrue(true);
		}
	}

	@Test
	public void sortujPusty(){
		try{
			List<Integer> pusta = new ArrayList<Integer>();
			Sorting sorter = new Sorting(pusta);
			sorter.sortArray();
			fail("Nie ma errora");
		}catch(ClassCastException ex){
			assertTrue(true);
		}
	}

	@Test
	public void sortujPosortowany(){
		Sorting sorter = new Sorting(Arrays.asList(-78, -4, -2, 1, 2, 6, 8, 56));
		assertThat(sorter.sortArray(), contains(-78, -4, -2, 1, 2, 6, 8, 56));
	}

	@Test
	public void sortujOdwrotniePosortowany(){
		Sorting sorter = new Sorting(Arrays.asList(56, 8, 6, 2, 1, -2, -4, -78));
		assertThat(sorter.sortArray(), contains(-78, -4, -2, 1, 2, 6, 8, 56));
	}

	@Test
	public void sortujLosowy(){
		Sorting sorter = new Sorting(Arrays.asList(1, 56, -2, 8, -4, -78, 2, 6));
		assertThat(sorter.sortArray(), contains(-78, -4, -2, 1, 2, 6, 8, 56));
	}

	@Test
	public void sortujLosowyZPowtorzeniami(){
		Sorting sorter = new Sorting(Arrays.asList(1, 56, -2, 8, -4, -78, 56, -2, 6));
		assertThat(sorter.sortArray(), contains(-78, -4, -2, -2, 1, 6, 8, 56, 56));
	}
	
}
