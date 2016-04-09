package ug.lab.project3;

public class BinaryTree implements IBinaryTree {
	protected class TreeNode {
		protected TreeNode parent;
		protected TreeNode leftChild;
		protected TreeNode rightChild;
		protected int number;
	}
	
	protected TreeNode root;
	protected TreeNode current;
	
	public int getNumber() {
		if(current != null){
			return this.current.number;
		}
		throw new IllegalStateException();
	}

	public boolean moveLeft() {
		if(current != null){
			if(current.leftChild != null){
				current = current.leftChild;
				return true;
			}
		}
		return false;
	}
	
	public boolean moveRight() {
		if(current != null){
			if(current.rightChild != null){
				current = current.rightChild;
				return true;
			}
		}
		return false;
	}
	
	public boolean moveUp() {
		if(current != null){
			if(current.parent != null){
				current = current.parent;
				return true;
			}
		}
		return false;
	}

	public void add(int n) {
		TreeNode newNode = new TreeNode();
		newNode.number = n;
		
		if(root == null){
			root = newNode;
			current = newNode;
		}else{
			TreeNode iterator = root;
			
		}
	}

	public boolean delete(int n){
		if(root != null){
			TreeNode iterator = root;
			
		}
		return false;
	}
	
}
