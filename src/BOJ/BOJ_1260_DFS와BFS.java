package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;
import java.util.*;

public class BOJ_1260_DFS와BFS {

	static int[][] map;
	static boolean[] visit;
	static int M, N, V;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		V = Integer.parseInt(tokens.nextToken());
		
		map = new int[N+1][N+1];
		visit = new boolean[N+1];
		
		for(int t=1; t<=M; t++) {
			tokens = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
		
			map[a][b] = 1;
			map[b][a] = 1;
			
		}

		dfs(V);
		System.out.println();
		Arrays.fill(visit, false);
		bfs(V);
		
	}
	public static void bfs(int idx) {
		Queue<Integer> q = new LinkedList<>();
		
		q.offer(idx);
		visit[idx] = true;
		
		while(!q.isEmpty()) {
			int val = q.poll();
			
			System.out.print(val+" ");
			
			for(int j=1; j<N+1; j++) {
				if(map[val][j]==1 && !visit[j]) {
					q.offer(j);
					visit[j] = true;
				}
			}
			
			
		}
	}
	
	public static void dfs(int idx) {
		visit[idx] = true;
		// 뽑기
		System.out.print(idx+" ");
		
		for(int j=1; j<N+1; j++) {
			if(map[idx][j] == 1 && !visit[j]) {
				dfs(j);
			}
		}
	}
	
	private static String src ="5 5 3\r\n" + 
			"5 4\r\n" + 
			"5 2\r\n" + 
			"1 2\r\n" + 
			"3 4\r\n" + 
			"3 1";
}
