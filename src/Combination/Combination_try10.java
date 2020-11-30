package Combination;

import java.util.LinkedList;
import java.util.Scanner;

public class Combination_try10 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int r = sc.nextInt();
		
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = i+1;
		}
		
		//System.out.println(Arrays.toString(arr));
		LinkedList<Integer> list = new LinkedList<>();
		
		System.out.println("=======조 합=======");
//		Combination(list, arr, r, 0);
	
		list.clear();
		
		System.out.println("=======중 복 조 합=======");		
//		reCombination(list, arr, r, 0);
		list.clear();
		
		System.out.println("=======순 열=======");		
		boolean[] check = new boolean[n];
//		Permutation(list,arr,check, r);
		list.clear();
		
		System.out.println("=======중 복 순 열=======");		
		rePermutation(list,arr, r);
		list.clear();
	}
	
	private static void rePermutation(LinkedList<Integer> list, int[] arr, int r) {
		if(list.size() == r) {
			System.out.println(list);
			return ;
		}
		
		for(int i=0; i<arr.length; i++) {
			list.add(arr[i]);
			rePermutation(list, arr, r);
			list.removeLast();
		}
	}
	
	private static void Permutation(LinkedList<Integer> list, int[] arr, boolean[] check, int r) {
		if(list.size() == r) {
			System.out.println(list);
		}
		
		for(int i=0; i<arr.length; i++) {
			if(!check[i]) {
				check[i] = true;
				list.add(arr[i]);
				Permutation(list, arr, check, r);
				list.removeLast();
				check[i] = false;
			}
		}
	}
	
	private static void reCombination(LinkedList<Integer> list, int[] arr, int r, int idx) {
		if( r == 0) {
			System.out.println(list);
			return;
		}
		if( arr.length == idx) return;
		
		list.add(arr[idx]);
		reCombination(list, arr, r-1, idx);
		list.removeLast();
		reCombination(list, arr, r, idx+1);
		
		
	}
	
	private static void Combination(LinkedList<Integer> list, int[] arr, int r, int idx) {
		
		if(r == 0 ) {
			System.out.println(list);
			return ;
		}
		if ( arr.length == idx ) return;
		
		list.add(arr[idx]);
		Combination(list, arr, r-1, idx+1);
		list.removeLast();
		Combination(list, arr, r, idx+1);
		
		
		
	}
}
