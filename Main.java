/*
* Name of class : Main
* Description   : Contains a main function to test the code with a simple example:
*  A tree with a root node of value 9, children nodes (nodeA(4) , nodeB (2) , nodeD(5)) and nodeD has a child node nodeC of value: 31  
*  The result should be [5, 9, 31, 51, 4, 2]
*  
* Version       : 1.0
* Date          : 16/03/2017
* Author		: MEDOUAR Fatime-Zahra
*/


import java.util.*;

public class Main {

	

	public static void main(String[] args) {
		
		/* listTree: is the  LinkedList containing the integers of the tree*/
		/* out: LinkedList of LinkedList containing the return of the evenOdd function (one LinkedList of even values and one LinkedList of odd values) */
		/* even & odd the LinkedLists of even and odd element of the listTree extracted from out*/
		/* end is the LinkedList with the final output as a Linkedlist of odd elements ordered ascendantly + the sum of all the element of the tree + the descendant even elements */
		
		LinkedList<Integer> even = new LinkedList();
		LinkedList<Integer> odd = new LinkedList();
		LinkedList<LinkedList> out = new LinkedList();
		LinkedList<Integer> end=  new LinkedList();
		
		/* Example of a Tree*/
		Tree nodeA = new Tree(4,new LinkedList());
		Tree nodeB = new Tree(2, new LinkedList());
		Tree nodeC = new Tree(31,new LinkedList());
		LinkedList<Tree> listNode = new LinkedList<Tree>();
		listNode.add(nodeC);
		Tree NodeD = new Tree(5, listNode);
		LinkedList<Tree> listNodeRoot = new LinkedList<Tree>();
		listNodeRoot.add(nodeA);
		listNodeRoot.add(nodeB);
		listNodeRoot.add(NodeD);
		Tree root = new Tree(9, listNodeRoot);
		
		/* DFS Extract the element of the tree and saves it in a listTree */
		LinkedList<Integer> listTree = root.DFS();
	
		/* evenOdd separate the even values from the odd values and saves them in a LinkedList<LinkedList> */
		out=Utilis.evenOdd(listTree);
		even=out.poll();
		odd=out.poll();
		
		/* Sorting the two LinkedList */
		Utilis.quickSortBW(even, 0,even.size() - 1);
		Utilis.quickSort(odd, 0, odd.size() - 1);
		
		/*Summing the element of the two lits */
		int somme = Utilis.sum(odd)+Utilis.sum(even);			
		
		/*finally concatenating the 3 Lists */
		end.addAll(odd);
		end.add(somme);
		end.addAll(even);
		System.out.println(end);
	
	}
}
