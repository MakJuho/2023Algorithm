package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_11438_LCA2 {

	static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
	static int[] parent;
	static int[] depth;
	static int N,M;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		N = Integer.parseInt(br.readLine());
		
		parent= new int[N+1];
		depth= new int[N+1];
		
		for(int i=0; i<N+1; i++) {
			tree.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i<N-1; i++) {
			StringTokenizer tokens = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
		
			
			tree.get(a).add(b);
			tree.get(b).add(a);
		}
		
		parent(1, 1);
		
		M = Integer.parseInt(br.readLine());
		
		for(int i=0; i<M; i++) {
			StringTokenizer tokens = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			solve(a,depth[a],b,depth[b]);
		}
	}
	
	
	private static void solve(int a, int a_depth, int b, int b_depth) {
		if(a_depth > b_depth) {
			while(a_depth != b_depth) {
				a_depth--;
				a=parent[a];
			}
			
		}else if(a_depth <b_depth) {
			while(a_depth != b_depth) {
				b_depth--;
				b=parent[b];
			}
		}
		
		while( a != b) {
			a = parent[a];
			b = parent[b];
		}
		
		System.out.println(a);
		
		
		
	}


	private static void parent(int current, int cnt) {
		
		depth[current] = cnt;
		cnt++;
		
		for(Integer val : tree.get(current)) {
			if(depth[val] == 0) {
				parent(val, cnt);
				parent[val] = current;
			}
		}
		
	}


	static String src = "15\r\n" + 
			"1 2\r\n" + 
			"1 3\r\n" + 
			"2 4\r\n" + 
			"3 7\r\n" + 
			"6 2\r\n" + 
			"3 8\r\n" + 
			"4 9\r\n" + 
			"2 5\r\n" + 
			"5 11\r\n" + 
			"7 13\r\n" + 
			"10 4\r\n" + 
			"11 15\r\n" + 
			"12 5\r\n" + 
			"14 7\r\n" + 
			"6\r\n" + 
			"6 11\r\n" + 
			"10 9\r\n" + 
			"2 6\r\n" + 
			"7 6\r\n" + 
			"8 13\r\n" + 
			"8 15";
	
}
