package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2660_회장뽑기 {
	static int N;
	static int[][] map;
	static int[] ans;
	static boolean[] v = new boolean[N+1];
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		ans = new int[N+1];
		while(true) {
			StringTokenizer tokens = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			
			if( a == -1) break;
			
			map[a][b] = 1;
			map[b][a] = 1;
			
		}
		int min = Integer.MAX_VALUE;

		for(int i=1; i<N+1; i++) {
			bfs(i);
			min = (min > ans[i]) ? ans[i] : min;
		}
		
		int cnt2 =0;
		for(int a: ans) {
			if( min == a) {
				cnt2++;
			}
		}
		System.out.println(min +" "+cnt2);
		for(int i=0; i<ans.length; i++) {
			if( min == ans[i]) {
				System.out.print(i+" ");
			}
		}
		
	}

	private static void bfs(int start) {
		Queue<Pair> q = new LinkedList<>();
		v = new boolean[N+1];
		v[start] = true;
		q.add(new Pair(start, 0));

		int max = 0;
		while(!q.isEmpty()) {
			
			Pair tmp = q.poll();
			
			for(int i=1; i<N+1; i++) {
				if(v[i]|| map[tmp.x][i] == 0 ) continue;
				q.add(new Pair(i, tmp.depth+1));
				max = (max < tmp.depth+1) ? tmp.depth+1 : max;
				v[i] = true;
			}
			
		}
		
		ans[start] = max;
		
	}

	static class Pair{
		int x, depth;

		public Pair(int x, int depth) {
			this.x = x;
			this.depth = depth;
		}

		@Override
		public String toString() {
			return "Pair [x=" + x + ", depth=" + depth + "]";
		}
		
		
		
	}
	
	static String src = "5\r\n" + 
			"1 2\r\n" + 
			"2 3\r\n" + 
			"3 4\r\n" + 
			"4 5\r\n" + 
			"2 4\r\n" + 
			"5 3\r\n" + 
			"-1 -1";
}
