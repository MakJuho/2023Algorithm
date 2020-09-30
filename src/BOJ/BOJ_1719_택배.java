package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BOJ_1719_택배 {
	
	static int n, m;
	static int[][] map;
	static int INF = 99999999;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		int i, from, to, w;
		String line[] = br.readLine().split(" ");
		n = Integer.parseInt(line[0]);
		m = Integer.parseInt(line[1]);
		map = new int[n][n];
		
		for(i=0;i<m;i++) {
			line = br.readLine().split(" ");
			from = Integer.parseInt(line[0])-1;
			to = Integer.parseInt(line[1])-1;
			w = Integer.parseInt(line[2]);
			map[from][to] = map[to][from] = w;
		}
		
		StringBuilder res = new StringBuilder();
		for(i=0;i<n;i++) res.append(dijkstra(i));
		
		System.out.println(res);
	}
	
	private static String dijkstra(int s) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.offer(s);
		int i, cur, d[] = new int[n];
		int trace[] = new int[n];
		Arrays.fill(d, INF);
		d[s] = 0; trace[s] = s;
		
		while(!pq.isEmpty()) {
			cur = pq.poll();
			for(i=0;i<n;i++) {
				if(map[cur][i]==0) continue; 
				else if(d[i]>map[cur][i]+d[cur]) {
					d[i] = map[cur][i] + d[cur];
					trace[i] = cur; 
					pq.offer(i);
				}
			}
		}
		return null;
	}
	
	static String src = "6 10\r\n" + 
			"1 2 2\r\n" + 
			"1 3 1\r\n" + 
			"2 4 5\r\n" + 
			"2 5 3\r\n" + 
			"2 6 7\r\n" + 
			"3 4 4\r\n" + 
			"3 5 6\r\n" + 
			"3 6 7\r\n" + 
			"4 6 4\r\n" + 
			"5 6 2";
	
}

