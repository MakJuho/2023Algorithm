package Combination;

import java.util.LinkedList;
import java.util.Scanner;

public class Combination_try2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int r = sc.nextInt();
		
		int arr[] = new int[n];
		for(int i=1; i<=n; i++) arr[i-1] = i;
	
		LinkedList<Integer> list = new LinkedList<>();
		
		//순열
		//4C3 (3! : 6가지)
		
		boolean check[] = new boolean[n];
		System.out.println("****순  열****");
//		permutation(check, list, arr, 2);
		list.clear();
		System.out.println("****중 복 순  열****");
//		repermutation( list, arr, 2);
		list.clear();
		
		//조합
		System.out.println("****조  합****");
//		combination(list, arr, 2, 0);
		list.clear();
		
		
		//중복 조합
		System.out.println("****중 복 조  합****");
//		recombination(list, arr, 2, 0);
		list.clear();
		
		//부분 집합
		System.out.println("****부 분 집 합****");
		for(int i=0; i<arr.length; i++) {
			subset(list, arr, i, 0);
		}
		list.clear();
		
		

	}
	private static void subset(LinkedList<Integer> list, int[] arr, int r, int idx) {
		if(r == 0) {
			System.out.println(list);
			return;
		}
		else if ( idx == arr.length) return;
		
		list.add(arr[idx]);
		subset(list,arr,r-1,idx+1);
		list.removeLast();
		subset(list,arr,r,idx+1);
	}
	
	private static void recombination(LinkedList<Integer> list, int[] arr, int r, int idx) {
		if(r == 0 ) {
			System.out.println(list);
			return;
		}
		else if(arr.length == idx) return;
		
		list.add(arr[idx]);
		recombination(list, arr, r-1, idx);
		list.removeLast();
		recombination(list, arr, r, idx+1);
		
	}

	private static void repermutation(LinkedList<Integer> list, int[] arr, int r) {
		if(list.size() == r) {
			System.out.println(list);
			return ;
		}
		
		for(int i=0; i<arr.length; i++) {
			list.add(arr[i]);
			repermutation(list,arr,r);
			list.removeLast();
		}
	}

	private static void combination(LinkedList<Integer> list, int[] arr, int r, int idx) {
		if(r == 0) {
			System.out.println(list);
			return ;
			
		}
		else if(idx == arr.length) return;
		
		list.add(arr[idx]);
		combination(list,arr,r-1,idx+1);
		list.removeLast();
		combination(list,arr,r,idx+1);
		
	}

	private static void permutation(boolean[] check, LinkedList<Integer> list, int[] arr, int r) {
		if(list.size() == r) {
			System.out.println(list);
		}
		
		for(int i=0; i<arr.length; i++) {
			if(!check[i]) {
				check[i] = true;
				list.add(arr[i]);
				permutation(check,list,arr,r);
				list.removeLast();
				check[i] = false;
				
				
			}
		}
		
		
	}
	
}
