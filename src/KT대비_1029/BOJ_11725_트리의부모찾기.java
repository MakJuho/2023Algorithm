package KT대비_1029;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11725_트리의부모찾기 {

	/**
	 * 루트 없는 트리
	 * 각 노드의 부모를 구하는 프로그램
	 * ArrayList<Integer>[] list, parents[] 만드는 게 핵심
	 * 
	 */
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		N = Integer.parseInt(br.readLine());
		
		ArrayList<Integer>[] list = new ArrayList[N+1];
		
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		
		for(int i=1; i<N; i++) {
			StringTokenizer tokens = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			
			list[a].add(b);
			list[b].add(a);
			
			
		}
//		System.out.println(Arrays.toString(list));
		
		int[] parents = new int[N+1];
		boolean[] visit = new boolean[N+1];
		dfs(list, parents, visit, 1);
		
//		System.out.println(Arrays.toString(parents));
		for(int i=2; i<=N; i++) {
			System.out.println(parents[i]);
		}
		
	}
	private static void dfs(ArrayList<Integer>[] list, int[] parents, boolean[] visit, int v) {
		visit[v] = true;
		
		for(int i: list[v]) {
			if(!visit[i]) {
				parents[i] = v;
				dfs(list, parents, visit, i);
			}
		}

	}
	
	static String src = "7\r\n" + 
			"1 6\r\n" + 
			"6 3\r\n" + 
			"3 5\r\n" + 
			"4 1\r\n" + 
			"2 4\r\n" + 
			"4 7";
	
	
	
}
