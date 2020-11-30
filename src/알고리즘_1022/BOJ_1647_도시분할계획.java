package 알고리즘_1022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1647_도시분할계획 {
	
	
	static class NODE implements Comparable<NODE>{
		int s, e, v;
		
		private NODE(int s, int e, int v) {
			this.s = s;
			this.e = e;
			this.v = v;
		}
		
		@Override
		public String toString() {
			return "Node [s :"+ s + ", e : "+ e + ", v : "+ v + "]";
		}
		
		@Override
		public int compareTo(NODE o) {
			return this.v - o.v;
		}
		
	}
	static int ret = 0;
	static int N, M;
	static PriorityQueue<NODE> pq ;
	static int[] parents;
	// PQ, Union, Find
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		pq = new PriorityQueue<>();
		
		parents = new int[N+1];
		Arrays.fill(parents, -1);
		
		
		for(int i=0; i<M; i++) {
			tokens = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			int c = Integer.parseInt(tokens.nextToken());
			pq.add(new NODE(a,b,c));
		}
//		System.out.println(pq);
		
		makeWay();
		
		System.out.println(ret);
		
		
	}
	private static void makeWay() {
		int cnt = 0;
		// 두 개의 섬으로 나누어야 하니까 N-2일 때까지 반복
		while(!pq.isEmpty()) {
			NODE cur = pq.poll();
			
			// 부모가 같지 않으면 true, 부모가 같으면 더해주지 않는다.
			if(union(cur.s, cur.e)) {
				ret += cur.v;
				cnt++;
				
			}
			
			
			if( N-2 == cnt) {
				break;
			}
			
			
		}
		
	}
	private static boolean union(int s, int e) {
		// 부모 찾기
		int rootX = findParents(s);
		int rootY = findParents(e);
		
		// 근본인 부모가 같지 않으면 한 쪽으로 연결한다.
		if(rootX != rootY) {
			parents[rootX] = rootY;
			return true;
		}
		
		return false;
		
	}
	/**
	 * 부모가 연결되어 있지 않으므로, 처음 값은 자기 자신으로 넣어준다.
	 * 부모값을 계속해서 찾고 부모의 값을 찾아서 넣어준다.
	 */
	private static int findParents(int u) {
		if( parents[u] < 0) {
			return u;
		}

		parents[u] = findParents(parents[u]);
		return parents[u];
		
	}
	static String src = "7 12\r\n" + 
			"1 2 3\r\n" + 
			"1 3 2\r\n" + 
			"3 2 1\r\n" + 
			"2 5 2\r\n" + 
			"3 4 4\r\n" + 
			"7 3 6\r\n" + 
			"5 1 5\r\n" + 
			"1 6 2\r\n" + 
			"6 4 1\r\n" + 
			"6 5 3\r\n" + 
			"4 5 3\r\n" + 
			"6 7 4";
}
