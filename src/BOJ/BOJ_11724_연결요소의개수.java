package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_11724_연결요소의개수 {

	static int N; // 정점
	static int M; // 간선
	static int count=0;
	
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> map =  new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		String line = br.readLine();
		StringTokenizer tokens = new StringTokenizer(line);
		
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		
		for(int i=0; i<=N; i++) {
			map.add(new ArrayList<>());
		}
		
		visited = new boolean[N+1];
		
		for(int i=0; i<M; i++) {
			line = br.readLine();
			tokens = new StringTokenizer(line);
			
			int x = Integer.parseInt(tokens.nextToken());
			int y = Integer.parseInt(tokens.nextToken());
			
			map.get(x).add(y);
			map.get(y).add(x);
		}
		
		for(int i=1; i<=N; i++) {
			if(!visited[i]) {
				dfs(i);
				count++;
			}
		}
		
		System.out.println(count);
		
	}
	
	
	private static void dfs(int i) {
		visited[i] = true;
		
		for(int val : map.get(i)) {
			if(!visited[val]) {
				dfs(val);
			}
		}
		
	}


	private static String src = "6 8\r\n" + 
			"1 2\r\n" + 
			"2 5\r\n" + 
			"5 1\r\n" + 
			"3 4\r\n" + 
			"4 6\r\n" + 
			"5 4\r\n" + 
			"2 4\r\n" + 
			"2 3";
	
}
