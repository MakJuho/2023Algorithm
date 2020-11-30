package KT대비_1030;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2606_바이러스 {


	static int n;
	static int m;
	static ArrayList<Integer>[] list;
	static boolean[] visit;
	static int cnt =0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		list = new ArrayList[n+1];
		
		for(int i=1; i<=n; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
//		System.out.println(Arrays.toString(list));
		
		for(int i=0; i<m; i++) {
			StringTokenizer tokens = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());

			list[a].add(b);
			list[b].add(a);
			
			
		}
		
//		System.out.println(Arrays.toString(list));
		visit = new boolean[n+1];
		dfs(1);
		System.out.println(cnt);
		
	}
	private static void dfs(int v) {
		visit[v] = true;
		
		for(int item: list[v]) {
			if(!visit[item]) {
				cnt++;
				dfs(item);
			}
		}
		
		
	}
	static String src = "7\r\n" + 
			"6\r\n" + 
			"1 2\r\n" + 
			"2 3\r\n" + 
			"1 5\r\n" + 
			"5 2\r\n" + 
			"5 6\r\n" + 
			"4 7";
}

