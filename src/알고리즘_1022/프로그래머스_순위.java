package 알고리즘_1022;

import java.util.Arrays;

public class 프로그래머스_순위 {
	
	
	public static void main(String[] args) {
	
		int n = 5;
		int[][] results = {{4,3},{4,2},{3,2},{1,2},{2,5}};
		
		solution(n, results);
	}
	
	

	static final int INF = 987654321;
	private static void solution(int n, int[][] results) {
		
		int[][] board = new int[n+1][n+1];
		
		
		for(int i=0; i<n+1; i++) {
			Arrays.fill(board[i], INF);
			
		}
		
		for(int i=0; i<n+1; i++) {
			for(int j=0; j<n+1; j++) {
				if(i == j) board[i][j] = 0;
			}
		}
		
		for(int i=0; i<results.length; i++) {
			
			int win = results[i][0];
			int lose = results[i][1];

			board[win][lose] =1;
		
		}
		
//		for(int[] a: board) {
//			System.out.println(Arrays.toString(a));
//		}
		
		
		// 플로이드 워샬
		
		for(int k=1; k<=n; k++) {
			for(int r=1; r<=n; r++) {
				for(int c=1; c<=n; c++) {
					if(board[r][c] > board[r][k] + board[k][c]) {
						board[r][c] = board[r][k] + board[k][c];
					}
				}
			}
		}
		
//		for(int[] a: board) {
//			System.out.println(Arrays.toString(a));
//		}
		
		boolean[] flag = new boolean[n+1];
		Arrays.fill(flag, true);
		for(int r=1; r<n+1; r++) {
			for(int c=1; c<n+1; c++) {
				if(r==c) continue;
				
				if(board[r][c] == INF && board[c][r] == INF) {
					flag[r] = false;
					break;
				}
				
			}
		}
		int ans=0;
		for(int i=1; i<flag.length; i++) {
			if(flag[i]) {
				ans++;
			}
		}
		 System.out.println(ans);
		
		
		
		
		
	}
	
}
