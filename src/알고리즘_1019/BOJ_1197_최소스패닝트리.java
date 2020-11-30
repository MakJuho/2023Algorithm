package 알고리즘_1019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1197_최소스패닝트리 {
	
	static class Node implements Comparable<Node>{
		int start;
		int end;
		int cost;
		
		public Node(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			if(this.cost > o.cost) {
				return 1;
			}else if(this.cost == o.cost) {
				return 0;
			}else if(this.cost < o.cost) {
				return -1;
			}
			return 0;
		}

		@Override
		public String toString() {
			return "Node [start="+ start + ", end="+end+ ", cost="+ cost + "]";
		}
		
	}
	
	static int ret = 0;
	static int[] parents;
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		parents = new int[N+1];
		
		// 자기 자신으로 초기화
		for(int i=0; i<=N; i++) {
			parents[i] = i;
		}
		
		Node[] nodeList = new Node[M];
		
		for(int i=0; i<M; i++) {
			tokens = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(tokens.nextToken());
			int end = Integer.parseInt(tokens.nextToken());
			int cost = Integer.parseInt(tokens.nextToken());
		
			nodeList[i] = new Node(start, end, cost );
		
		}
//		System.out.println(Arrays.toString(nodeList));
		Arrays.sort(nodeList);
//		System.out.println(Arrays.toString(nodeList));
		
		// 부모 이어주기.
		for(int i=0; i<M; i++) {
			
			int rootX = findParents(nodeList[i].start);
			int rootY = findParents(nodeList[i].end);
			
			if(rootX == rootY) {
				continue;
			}
			parents[rootX] = rootY;
			
			ret += nodeList[i].cost;
			
			
		}
		
		
		System.out.println(ret);
		
	}
	
	private static int findParents(int u) {
		if(parents[u]== u) {
			return u;
		}
		
		parents[u] = findParents(parents[u]);
		return parents[u];
	}

	static String src = "3 3\r\n" + 
			"1 2 1\r\n" + 
			"2 3 2\r\n" + 
			"1 3 3";
}
