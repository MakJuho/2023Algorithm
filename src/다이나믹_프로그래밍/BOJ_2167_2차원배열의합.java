package 다이나믹_프로그래밍;

import java.util.Scanner;

public class BOJ_2167_2차원배열의합 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[][] arr = new int[N][M];
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				arr[r][c] = sc.nextInt();
			}
		}
		
		int K = sc.nextInt();
		
		for(int t=0; t<K; t++) {
			
			int i = sc.nextInt()-1;
			int j = sc.nextInt()-1;
			int x = sc.nextInt()-1;
			int y = sc.nextInt()-1;
			
			int sum =0;
			for(int r=i; r<=x; r++) {
				for(int c=j; c<=y; c++) {
					sum += arr[r][c];
				}
			}
			
			System.out.println(sum);
			
		}
		
		
		
		
	}
	
	static private String src = "2 3\r\n" + 
			"1 2 4\r\n" + 
			"8 16 32\r\n" + 
			"3\r\n" + 
			"1 1 2 3\r\n" + 
			"1 2 1 2\r\n" + 
			"1 3 2 3";
}
