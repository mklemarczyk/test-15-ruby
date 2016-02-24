package ug.lab.zad3;

import java.util.Arrays;
import java.util.List;

public class Sorting {
	
	private List<Integer> table;
	
	public Sorting(List<Integer> table){
		this.table = table;
	}

	public List<Integer> sortArray(){
		Integer[] tmp = (Integer[]) table.toArray();
		quicksort(tmp, 0, tmp.length -1);
		return Arrays.asList(tmp);
	}
	 
	private static void quicksort(Integer tablica[], int x, int y) {
		int i, j, v, tmp;
		i = x;
		j = y;
		v = tablica[(x + y) / 2];
		do {
			while (tablica[i] < v)
				i++;
			while (v < tablica[j])
				j--;
			if (i <= j) {
				tmp = tablica[i];
				tablica[i] = tablica[j];
				tablica[j] = tmp;
				i++;
				j--;
			}
		} while (i <= j);
		if (x < j)
			quicksort(tablica, x, j);
		if (i < y)
			quicksort(tablica, i, y);
	}
	 
}
