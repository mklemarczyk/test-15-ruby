package ug.lab.zad1;

public class Nwd {
	private int a;
	private int b;

	public Nwd(int a, int b) throws Exception{
		if (a == 0)
			throw new Exception("a nie moze wynosic zero, zero nie ma dzielnikow");
		if (b == 0)
			throw new Exception("b nie moze wynosic zero, zero nie ma dzielnikow");
	}

	public int policz(){
		return Math.abs(rekur(this.a, this.b));
	}

	private static int rekur(int a, int b){
		if(b == 0){
			return a;
		} else{
			return rekur(b, (a % b));
		}
	}

}
