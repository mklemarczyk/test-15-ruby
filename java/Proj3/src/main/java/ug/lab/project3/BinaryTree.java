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
			}else{
				return false;
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
			boolean inserted = false;
			while(!inserted){
				if(iterator.number < n){
					if(iterator.rightChild != null){
						iterator = iterator.rightChild;
					}else{
						iterator.rightChild = newNode;
						newNode.parent = iterator;
						inserted = true;
					}
				}else{
					if(iterator.leftChild != null){
						iterator = iterator.leftChild;
					}else{
						iterator.leftChild = newNode;
						newNode.parent = iterator;
						inserted = true;
					}
				}
			}
		}
	}

	public boolean delete(int n){
		if(root != null){
			TreeNode iterator = root;
			
		}
		return false;
	}
	
}
