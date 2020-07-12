package Combination;

import java.util.LinkedList;

public class Com_Per_1 {
	static LinkedList<Integer> list= new LinkedList<>();
	
	public static void main(String[] args) {
		int[] arr= { 1 , 2 , 5, 13 };
		
		int r = 2;
		
		
		//Com(arr, arr.length, r, 0);
		
		Per(arr, new boolean[4],arr.length, r);
		
	}

	private static void Per(int[] arr, boolean[] check, int n, int r) {

		if(list.size() == r) {
			System.out.println(list);
			return ;
		}
		
		for(int i=0; i<n; i++) {
			if(!check[i]) {
				check[i] = true;
				list.add(arr[i]);
				Per(arr,check,n,r);
				list.removeLast();
				check[i] = false;
				
			}
		}
		
	}

	private static void Com(int[] arr, int n, int r, int idx) {
		if(r == 0) {
			System.out.println(list);
			return;
		}
		else if(idx == n) return;
		
		list.add(arr[idx]);
		Com(arr,n,r-1,idx+1);
		list.removeLast();
		Com(arr,n,r,idx+1);
		
	}
}
