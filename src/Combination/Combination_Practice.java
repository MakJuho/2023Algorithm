package Combination;

import java.util.LinkedList;
import java.util.Arrays;

public class Combination_Practice {
	public static void main(String[] args) {
		
		int n = 5;
		int r = 3;
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		
		Combination(list, n, r, 0);
		
		
	}

	private static void Combination(LinkedList<Integer> list, int n, int r, int index) {
		if(r == 0) {
			for(int i : list) {
				System.out.print(i+" ");
			}
			System.out.println();
			return ;
		}
		if(index == n) return;
		
		list.add(index);
		Combination(list, n, r-1, index+1);
		list.removeLast();
		Combination(list, n, r, index);
		
	}
}
