package Subset;

import java.util.Scanner;

public class SubSet_example {
	static int n, count = 0;
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		
		f(n, 1);
		
		System.out.println(count);
		return ;
	}
	
	static void f(int n, int bit) {
		if(n==0) {
			count++;
			return ;
		}
		
		f(n-1, 1);
		if(bit==1) f(n-1, 0);
	}
}
