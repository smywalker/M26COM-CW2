package rules;

import java.util.Scanner;
import java.util.Random;

public class Rules {
	
	public static void main(String[] args) {
		// create objects and variables
		Random rand = new Random();
		BinaryTree thetree = new BinaryTree();
		int rules;
		int ruleKey = 1;
		Scanner in = new Scanner(System.in);
		//get events from user
		int a;
		System.out.println("How many Events do you want? ");
	    a = in.nextInt();
	    //necessary to do due to Enter key pressed by user
	    in.nextLine();
	    String events[] = new String[a];
	    for (int i=0; i<a; i++) {
	    	System.out.println("Enter an Event: ");
	        events[i] = in.nextLine();
	    }   
	    //get actions from the user
		int b;
	    System.out.println("How many Actions do you want? ");
	    b = in.nextInt();
	    //necessary to do due to Enter key pressed by user
	    in.nextLine();
	    String actions[] = new String[b];
	    for (int k=0; k<b; k++) {
	    	System.out.println("Enter an action: ");
	        actions[k] = in.nextLine();
	    }   
		//get the number of rules form the user
		System.out.println("How many rules do you want?");
		rules = in.nextInt();
		//generate random rules using the events and actions provided by the user
		for(int r=0; r<rules; r++) {
			//add event to start of the string
			String nodeToAdd;
			String comma = ",";
			int  value = rand.nextInt(events.length);
			nodeToAdd = events[value];
			nodeToAdd = nodeToAdd.concat(comma);
			for(int l=0; l<10; l++) {
				String action;
				int  value2 = rand.nextInt(actions.length);
				action = actions[value2];
				nodeToAdd = nodeToAdd.concat(action);
				nodeToAdd = nodeToAdd.concat(comma);
			}
			thetree.addNode(ruleKey, nodeToAdd);
			ruleKey++;
		}
		//call the BST functions to traverse the tree and print the duplicates
		thetree.inOrderTraverseTree(thetree.root);
		thetree.searchTree();
	}
}
