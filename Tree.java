
/*
* Name of class : Tree 
* Description   : created Tree data structure, characterized by a value (integer > 0) called node and a LinkedList of Tree characterizing the children trees;
*						and the define the Depth-first search method for the Tree.
* Version       : 1.0
* Date          : 16/03/2017
* Author		: MEDOUAR Fatime-Zahra
*/

import java.util.LinkedList;

public class Tree {
	/* value of the node */
	public int node;
	/* link to children trees */
	public LinkedList<Tree> children;

	
	/* Construction method taking the value of the node and the children tree as input*/ 
	Tree(int node, LinkedList<Tree> children) {
		this.node = node;
		this.children = children;

	}

	/* Depth First Search, recursive method that @return LinkedList<Integer> representing the values of all the nodes of the tree */ 
	public LinkedList<Integer> DFS() {
		LinkedList<Integer> tmp = new LinkedList<Integer>();
		if (this.children.isEmpty()) {
			tmp.add(this.node);
		} else {
			for (Tree t : this.children) {
				tmp.addAll(t.DFS());
			}
			tmp.add(this.node);

		}
		return tmp;
	}

}
