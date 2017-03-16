/*
* Name of class : Utilis
* Description   : Contains static methods that are needed in the main:
* 					- partition/partionBW + quickSort/quickSortBW : 2 Quicksorts algorithms (increasing/decreasing) ; 
* 					- sum method for LinkedList;
* 					- evenOdd : separate a LinkedList into a LinkedList of 2 LinkedLists (the first one added composed by even elements and the second by odd elements)
* 
* Version       : 1.0
* Date          : 16/03/2017
* Author		: MEDOUAR Fatime-Zahra
*/

import java.util.LinkedList;

public class Utilis {
	
	/* sum the values of the @param LinkedList<Integer> i , @return the sum value */
	static public int sum(LinkedList<Integer> i){
		int somme=0;
		for (int s : i) {
			somme = somme + s;
		}
		return somme;	
	}
	
	/* separate a LinkedList into a LinkedList of 2 LinkedLists (the first one added composed by even elements and the second by odd elements)   */
	static LinkedList<LinkedList> evenOdd (LinkedList<Integer> listTree){
		LinkedList<Integer> even=new LinkedList();
		LinkedList<Integer> odd=new LinkedList();
		LinkedList<LinkedList> out= new LinkedList();

		for (Integer i : listTree) {
			if (i % 2 == 0) {
				even.add(i);
			} else {
				odd.add(i);
			}
		}	
		out.add(even);
		out.add(odd);
		return out;	
	}
	
	/* Method that does the Quicksort partition part with a list of LinkedList to sort, lo as the lower index and hi the highest index */
	static int partition(LinkedList<Integer> list, int lo, int hi) {
		int i = lo;
		int j = hi;
		int tmp;
		int piv = list.get((lo + hi) / 2);

		while (i <= j) {
			while (list.get(i) < piv)
				i++;
			while (list.get(j) > piv)
				j--;
			if (i <= j) {
				tmp = list.get(i);
				list.set(i, list.get(j));
				list.set(j, tmp);
				i++;
				j--;
			}
		}
		;
		return i;
	}
	
	/* Method that does the Quicksort with a list of LinkedList to sort, lo as the lower index and hi the highest index */

	static void quickSort(LinkedList list, int lo, int hi) {
		int index = partition(list, lo, hi);
		if (lo < index - 1)
			quickSort(list, lo, index - 1);
		if (index < hi)
			quickSort(list, index, hi);
	}
	/*Backward Quicksort partition part */
	static int partitionBW(LinkedList<Integer> list, int lo, int hi) {
		int i = lo, j = hi;
		int tmp;
		int piv = list.get((lo + hi) / 2);

		while (i <= j) {
			while (list.get(i) > piv)
				i++;
			while (list.get(j) < piv)
				j--;
			if (i <= j) {
				tmp = list.get(i);
				list.set(i, list.get(j));
				list.set(j, tmp);
				i++;
				j--;
			}
		}
		;

		return i;
	}

	/*Backward Quicksort */
	static void quickSortBW(LinkedList list, int lo, int hi) {
		int index = partitionBW(list, lo, hi);
		if (lo < index - 1)
			quickSortBW(list, lo, index - 1);
		if (index < hi)
			quickSortBW(list, index, hi);
	}
}
