package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;

public class BOJ_11437_LCA {

	static ArrayList<ArrayList<Integer>> tree = new ArrayList<ArrayList<Integer>>();
	static int[] depth;
	static int[] parent;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N+1; i++) {
			tree.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i<N-1; i++) {
			
			String[] temp = br.readLine().split(" ");
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);
			
			//System.out.println(a+":"+b);
			tree.get(a).add(b);
			tree.get(b).add(a);
			
		}

		depth = new int[N+1];
		parent = new int[N+1];
		
		// 부모 생성 완료
		dfs(1,1);
		
		
		int M = Integer.parseInt(br.readLine());
		int rlt=0;
		for(int i=0; i<M; i++) {
			String[] temp = br.readLine().split(" ");
			
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);
			
//			System.out.println(a+":"+b);
			rlt = solve(a,depth[a],b,depth[b]);
			
			System.out.println(rlt);
			
		}
		
		
		
	}
	
	
	

	private static int solve(int a, int a_depth, int b, int b_depth) {
		
		if(a_depth > b_depth) {
			while(a_depth != b_depth) {
				a_depth --;
				a = parent[a];
			}
		}else if(a_depth < b_depth) {
			while(a_depth != b_depth) {
				b_depth--;
				b = parent[b];
			}
		}
		
		while(a != b) {
			a = parent[a];
			b = parent[b];
		}
		

		return a;
		
		
	}




	private static void dfs(int current, int cnt) {
		depth[current] = cnt;
		cnt++;
		
		for(Integer val : tree.get(current)) {
			if(depth[val] == 0) {
				dfs(val, cnt);
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
