package 알고리즘_1022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1647_도시분할계획_NP {
	// 플로이드 워샬
	static int N, M;
	static final int INF = 987654321;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		int[][] board = new int[N+1][N+1];
		for(int []a: board) {
			Arrays.fill(a, INF);
		}
		
		for(int r=0; r<N+1; r++) {
			for(int c=0; c<N+1; c++) {
				if(r==c) board[r][c] = 0;
			}
		}
		
		
		for(int i=0; i<M; i++) {
			tokens = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			int c = Integer.parseInt(tokens.nextToken());
			
			board[a][b] = c;
			board[b][a] = c;
			
		}
		
		for(int k=1; k<N+1; k++) {
			for(int r=1; r<N+1; r++) {
				for(int c=1; c<N+1; c++) {
					if(board[r][c] > board[r][k] + board[k][c]) {
						board[r][c] = board[r][k] + board[k][c];
					}
				}
			}
		}
		
//		for(int[] a: board) {
//			System.out.println(Arrays.toString(a));
//		}
		boolean[] visit = new boolean[N+1];
		
		int sum =0;
		int[] arr = new int[N+1];
		
		for(int r=1; r<N+1; r++) {
			int min = Integer.MAX_VALUE;
			
			for(int c=1; c<N+1; c++) {
				if(!visit[r] && board[r][c]!=INF && r != c) {
					min = Math.min(min, board[r][c]);
				}
			}
			
			visit[r] = true;
			arr[r] = min;
			sum+=min;
			
		}
		
//		System.out.println(Arrays.toString(arr));
		int max = Integer.MIN_VALUE;
		for(int i=1; i<N+1; i++) {
			if(max < arr[i]) {
				max = arr[i];
			}
		}
		
		System.out.println(sum-max);
	}
	static String src = "7 12\r\n" + 
			"1 2 3\r\n" + 
			"1 3 2\r\n" + 
			"3 2 1\r\n" + 
			"2 5 2\r\n" + 
			"3 4 4\r\n" + 
			"7 3 6\r\n" + 
			"5 1 5\r\n" + 
			"1 6 2\r\n" + 
			"6 4 1\r\n" + 
			"6 5 3\r\n" + 
			"4 5 3\r\n" + 
			"6 7 4";
}
