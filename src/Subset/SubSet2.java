package Subset;

import java.util.Scanner;

public class SubSet2 {

	static int data[] = {1,2,3};
	static int flag[] = {0,0,0};
	
	public static void main(String[] args) {
		powerset(3, 0);
		return ;
	}

	private static void powerset(int n, int depth) {
		if(n == depth) {
			
			for(int i=0; i<n; i++) {
				if(flag[i] == 1) {
					System.out.print(data[i]+" ");
				}
			}
			System.out.println();
			return;
		}
		
		flag[depth] = 1;
		powerset(n,depth+1);
		flag[depth] = 0;
		powerset(n,depth+1);
		
		
	}
	
	
}
