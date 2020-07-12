package Subset;

import java.util.Scanner;

public class SubSet {

	static int N, totalCnt;
	static int[] input;
	static boolean[] isSelected;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		input = new int[N];
		isSelected = new boolean[N];
		
		generateSubset(0);
		System.out.println(totalCnt);
	}
	
	
	private static void generateSubset(int cnt) {
		if(cnt == N) {
			totalCnt++;
			
			return ;
		}
		
		isSelected[cnt] = true;
		generateSubset(cnt+1);
		
		isSelected[cnt] = false;
		generateSubset(cnt+1);
	}
}
