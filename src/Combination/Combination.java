package Combination;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Combination {
	
	static char[] arr = {'A', 'B', 'C', 'D'};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println(Arrays.toString(arr));
		
		LinkedList<Character> list = new LinkedList<>();
		
		//조합
		System.out.println("****조  합****");
//		combination(list, arr.length, 2, 0);
		list.clear();
		
		//중복조합
		System.out.println("****중복조합****");
//		reCombination(list, arr.length, 2, 0);
		
		//순열
		//4C3 (3! : 6가지)
		int check[] = new int[5];
		System.out.println("****순  열****");
//		permutation(list, check, arr.length, 2);
		list.clear();
		
		//중복순열
		System.out.println("****중복순열****");
		rePermutation(list, arr.length, 2);
		list.clear();
		

	}
	
	//조합
	private static void combination(LinkedList<Character> list, int n, int r, int index) {
		if(r == 0) {
			for(char a: list) {
				System.out.print(a + " ");
			}
			System.out.println();
			return;
		}
		else if(index == n) return;
		
		list.add(arr[index]);
		combination(list,n,r-1,index+1); // 하나를 선택하고
		list.removeLast();
		combination(list,n,r,index+1); // 하나를 뺀다.
		
	}
	
	/**
	 * 선택을 해도 그자리에서 시작하면 된다.
	 */
	private static void reCombination(LinkedList<Character> list, int n, int r, int index) {
		if(r == 0) {
			for(char a: list) {
				System.out.print(a + " ");
			}
			System.out.println();
			return;
		}
		if(n == index) return;
		
		list.add(arr[index]);
		reCombination(list, n, r-1, index);
		list.removeLast();
		reCombination(list, n, r, index+1);
		
	}
	
	//순열
	private static void permutation(LinkedList<Character> list, int[] check, int n, int r) {
		if(list.size() == r) {
			for(char a: list) {
				System.out.print(a+" ");
			}
			System.out.println();
			return ;
		}

		for(int i=0; i<n; i++) {
			if(check[i] == 0) {
				check[i] = 1;
				list.add(arr[i]);
				permutation(list,check,n,r);
				list.removeLast();
				check[i] = 0;
			}
		}
		
		
		
	}
	//중복순열
	private static void rePermutation(LinkedList<Character> list, int n, int r) {
		if(list.size() == r) {
			for(char a: list) {
				System.out.print(a+" ");
			}
			System.out.println();
			return ;
		}
		
		for(int i=0; i<n; i++) {
			list.add(arr[i]);
			rePermutation(list, n, r);
			list.removeLast();
		}
		
	}

}
