package 다이나믹_프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260_DFS_와_BFS {
	
	static ArrayList<Integer>[] list;
	static int N;
	static boolean[] check;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		int M = Integer.parseInt(tokens.nextToken());
		int start = Integer.parseInt(tokens.nextToken());
		
		list= new ArrayList[N + 1];
		
		for(int i=1; i< N+1; i++) {
			list[i] = new ArrayList<Integer>();
		}
	
		for(int i=0; i< M; i++) {
			tokens = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(tokens.nextToken());
			int v = Integer.parseInt(tokens.nextToken());
		
			list[u].add(v);
			list[v].add(u);
		}
		
		for( int i=1; i< N+1; i++) {
			Collections.sort(list[i]);
		}
		
//		System.out.println(Arrays.toString(list));
		
		check = new boolean[N+1];
		dfs(start);
		System.out.println();
		
		check = new boolean[N+1];
		bfs(start);
		System.out.println();
		
		
		
	}
	
	private static void bfs(int v) {
		Queue<Integer> q= new LinkedList<Integer>();
		q.add(v);
		check[v] = true;
		
		while(!q.isEmpty()) {
			int x = q.poll();
			System.out.print(x+" ");
			
			for(int y : list[x]) {
				if(!check[y]) {
					check[y] = true;
					q.add(y);
				}
			}
			
		}
		
		
	}

	private static void dfs(int v) {
		if(check[v]) {
			return ;
		}
		
		check[v] = true;
		System.out.print(v+" ");
		for(int i: list[v]) {
			if(!check[i]) {
				dfs(i);
			}
		}
	}

	private static String src = "4 5 1\r\n" + 
			"1 2\r\n" + 
			"1 3\r\n" + 
			"1 4\r\n" + 
			"2 4\r\n" + 
			"3 4";
}
