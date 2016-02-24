package ug.lab.zad2;

import java.util.ArrayList;
import java.util.List;

public class MyStack {
	
	private List<Integer> data = new ArrayList<Integer>();
	
	public void MyPush(int a){
		data.add(a);
	}
	
	public void MyPop(){
		data.remove(data.size() -1);
	}
	
	public boolean IsNull(){
		return data.size() == 0;
	}
	
	public int MyTop(){
		return data.get(data.size() -1);
	}

	public List<Integer> getData() {
		return data;
	}

}
