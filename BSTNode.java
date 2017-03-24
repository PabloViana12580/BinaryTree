//Clase tomada de http://www.sanfoundry.com
public class BSTNode <E extends Comparable<E>>{
	private Node<E> root;
	public BSTNode(){
		this.root = null;
	}
	
	public E find(E id){
		Node<E> current = root;
		while(current!=null){
			if(current.data.equals(id)){
				return current.data;
			}else if(current.data.compareTo(id)>0){
				current = current.left;
			}else{
				current = current.right;
			}
		}
		return null;
	}
	public Node<E> getRoot() {
		return root;
	}

	public void setRoot(Node<E> root) {
		this.root = root;
	}

	public boolean delete(E id){
		Node<E> parent = root;
		Node<E> current = root;
		boolean isLeftChild = false;
		while(!current.data.equals(id)){
			parent = current;
			if(current.data.compareTo(id)>0){
				isLeftChild = true;
				current = current.left;
			}else{
				isLeftChild = false;
				current = current.right;
			}
			if(current ==null){
				return false;
			}
		}
		//if i am here that means we have found the node
		//Case 1: if node to be deleted has no children
		if(current.left==null && current.right==null){
			if(current==root){
				root = null;
			}
			if(isLeftChild ==true){
				parent.left = null;
			}else{
				parent.right = null;
			}
		}
		//Case 2 : if node to be deleted has only one child
		else if(current.right==null){
			if(current==root){
				root = current.left;
			}else if(isLeftChild){
				parent.left = current.left;
			}else{
				parent.right = current.left;
			}
		}
		else if(current.left==null){
			if(current==root){
				root = current.right;
			}else if(isLeftChild){
				parent.left = current.right;
			}else{
				parent.right = current.right;
			}
		}else if(current.left!=null && current.right!=null){
			
			//now we have found the minimum element in the right sub tree
			Node<E> successor	 = getSuccessor(current);
			if(current==root){
				root = successor;
			}else if(isLeftChild){
				parent.left = successor;
			}else{
				parent.right = successor;
			}			
			successor.left = current.left;
		}		
		return true;		
	}
	
	public Node<E> getSuccessor(Node<E> deleleNode){
		Node<E> successsor =null;
		Node<E> successsorParent =null;
		Node<E> current = deleleNode.right;
		while(current!=null){
			successsorParent = successsor;
			successsor = current;
			current = current.left;
		}
		//check if successor has the right child, it cannot have left child for sure
		// if it does have the right child, add it to the left of successorParent.
//		successsorParent
		if(successsor!=deleleNode.right){
			successsorParent.left = successsor.right;
			successsor.right = deleleNode.right;
		}
		return successsor;
	}
	public void insert(E id){
		Node<E> newNode = new Node<E>(id);
		if(root==null){
			root = newNode;
			return;
		}
		Node<E> current = root;
		Node<E> parent = null;
		while(true){
			parent = current;
			if(id.compareTo(current.data)<0){				
				current = current.left;
				if(current==null){
					parent.left = newNode;
					return;
				}
			}else{
				current = current.right;
				if(current==null){
					parent.right = newNode;
					return;
				}
			}
		}
	}
	public void display(Node<E> root){
		if(root!=null){
			display(root.left);
			System.out.print(root.data + " ");
			display(root.right);
		}
	}
}

class Node<E>{
	E data;
	Node<E> left;
	Node<E> right;	
	public Node(E data){
		this.data = data;
		left = null;
		right = null;
	}
}