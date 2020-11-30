package 알고리즘_1129;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260_DFS와BFS {
	/**
	 * DFS 
	 * 1번부터 N번까지
	 * 
	 * BFS 
	 * 
	 */
	static int N, M, V;
	static int[][] board;
	static boolean[] check;
	public static void main(String[] args) throws IOException {
		// DFS 구하기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		V = Integer.parseInt(tokens.nextToken());
		
		board = new int[N+1][N+1];
		check = new boolean[N+1];
		
		for(int i=0; i<M; i++) {
			tokens = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			
			board[a][b] = board[b][a]= 1;
			
		}
		
//		for(int[] a: board) {
//			System.out.println(Arrays.toString(a));
//		}
		
		// 시작점 V
		dfs(V);
		
		System.out.println();
		// 초기화
		Arrays.fill(check, false);
		
		bfs(V);
		
		
	}
	
	private static void bfs(int v) {
		
		
		Queue<Integer> q = new LinkedList<>();
		q.add(v);
		check[v] = true;
		while(!q.isEmpty()) {
			int cur = q.poll();
			System.out.print(cur+" ");
			
			for(int i=1; i<=N; i++) {
				if(board[cur][i] == 1 && !check[i]) {
					q.add(i);
					check[i] = true;
					
				}
			}
			
		}
		
		
	}
	
	private static void dfs(int v) {
		check[v] = true;
		System.out.print(v+" ");
		
		for(int i=1; i<=N; i++) {
			if(board[v][i] == 1 && !check[i]) {
				dfs(i);
			}
		}
		
	}
	
	static String src = "1000 1 1000\r\n" + 
			"999 1000";
}
