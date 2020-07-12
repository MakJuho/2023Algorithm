package programmers;

import java.util.Arrays;

public class 그래프_순위 {

	public static void main(String[] args) {
		int n = 5;
		int[][] results = {
				{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}
		};
		int INF = 987654321;
		
		int[][] scores = new int[n+1][n+1];
		for(int[] score : scores)
			Arrays.fill(score, INF);
		
		for(int r=0; r<n+1; r++) {
			for(int c=0; c<n+1; c++) {
				if(r == c)  scores[r][c] =0;
			}
		}
		
//		for(int []a : scores)
//			System.out.println(Arrays.toString(a));
		
		for(int [] result : results) {
			int win = result[0];
			int lose = result[1];
			
			scores[win][lose] = 1;
			
		}
		
//		for(int []a : scores)
//		System.out.println(Arrays.toString(a));
		
		for(int k=1; k<n+1; k++) {
			for(int r=1; r<n+1; r++) {
				for(int c=1; c<n+1; c++) {
					if(scores[r][c] > scores[r][k] + scores[k][c]) {
						scores[r][c] = scores[r][k] + scores[k][c];
					}
				}
			}
		}
		
		
//		for(int []a : scores)
//		System.out.println(Arrays.toString(a));
		boolean[] flag = new boolean[n+1];
		Arrays.fill(flag, true);
		for(int r=1; r<n+1; r++) {
			for(int c=1; c<n+1; c++) {
				if(r==c) continue;
				
				if(scores[r][c] == INF && scores[c][r] == INF) {
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
