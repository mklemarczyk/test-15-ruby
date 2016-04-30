package ug.lab.project3;

public interface IBinaryTree {
	public int getNumber() ;

	public boolean moveLeft();

	public boolean moveRight();
	
	public boolean moveUp();
	
	public void add(int n);

	public boolean delete(int n);
}
