package rules;

import java.util.ArrayList;

public class BinaryTree {
	//create node and array variabels
	Node root;
	ArrayList myList = new ArrayList();
	ArrayList<String> duplist = new ArrayList();
	
	//add node to the tree(key value pairs)
	public void addNode(int key, String name) {
		//create new node with the data inputed
		Node newNode = new Node(key,name);
		//if no root assign the new node as the root
		if(root == null) {
			root = newNode;
		// find an empty child and put it in there
		}else {
			Node focusNode = root;
			Node parent;
			while(true) {
				parent = focusNode;
				if(key < focusNode.key) {
					focusNode= focusNode.leftChild;
					if(focusNode==null) {
						parent.leftChild = newNode;
						return;
					}
				}else {
					focusNode= focusNode.rightChild;
					if(focusNode==null) {
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}
	//print out each node and add the node to list for comparison
	public void inOrderTraverseTree(Node focusNode) {
		if(focusNode != null) {
			inOrderTraverseTree(focusNode.leftChild);
			System.out.println(focusNode);
			myList.add(focusNode.name);
			inOrderTraverseTree(focusNode.rightChild);
		}
	}
	//chech if there are any duplicate rules
	public void searchTree(){
		System.out.println("The rules that occur multiple times are:");
		for (int i=0; i<myList.size(); i++) {
			for (int j=0; j<myList.size(); j++) {
				if(i!=j){
					if(myList.get(i) == myList.get(j) ) {
						System.out.println(myList.get(i));
					}
				}
		
		    }  
	    }
	}
}
//class for each node in the tree
class Node{
	int key;
	String name;
	Node leftChild;
	Node rightChild;
	//Constructor
	Node(int key, String name){
		this.key = key;
		this.name = name;
	}
	//print each node
	public String toString(){
		//return name +"has a key"+ key;
		return "Rule"+key+"-"+name;
	}
	
}
