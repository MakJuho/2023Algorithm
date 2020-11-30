package MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MST_try1 {
	/**
	 * 노드 간에 모두 연결된 최소 비용을 구하는 문제
	 * 단, Cycle이 없어야한다.
	 * 
	 * 간단한 로직,
	 * 1. 연결비용을 기준으로 오름차순으로 정렬한다.
	 * 2. startNode와 endNode를 비교해서 rootNode가 같지 않다면 각각의 rootNode를 연결한다.
	 * 
	 */
	
	static class Node implements Comparable<Node>{
		
		int start;
		int end;
		int cost;
		
		
		// Constructor(생성자)
		public Node(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
		
		// 비교
		@Override
		public int compareTo(Node o) {
			if(this.cost > o.cost) {
				return 1;
			}else if(this.cost < o.cost) {
				return -1;
			}
			return 0;
		}
		
		
		
		
	}
	
	
	static int N, M;
	static int[] parents;
	static Node[] nodeList;
	static int cost=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer tokens;
	
		// 노드, 간선
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		parents = new int[N+1];
		nodeList = new Node[M];
		
		for(int i=1; i<=N; i++) {
			parents[i] = i;
		}
		
		for(int i=0; i<M; i++) {
			tokens = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(tokens.nextToken());
			int end = Integer.parseInt(tokens.nextToken());
			int cost = Integer.parseInt(tokens.nextToken());
		
			nodeList[i] = new Node(start, end, cost);
					
		}
		
		// 비용을 오름차순으로 정렬
		Arrays.sort(nodeList);
		
		
		// 부모 찾기
		for(int i=0; i<M; i++) {
			int rootX = findParent(nodeList[i].start);
			int rootY = findParent(nodeList[i].end);
			
			// 부모가 같을 경우
			if(rootX == rootY) {
				continue;
			}else {
				parents[rootX] = rootY;
				cost += nodeList[i].cost;
			}
			
			
		}
		System.out.println(cost);
		
		
		
	}

	private static int findParent(int u) {
		// 자신이 root node
		if(parents[u] == u) {
			return u;
		}
		
		parents[u] = findParent(parents[u]);
		return parents[u];
		
	}

	static String src = "6\r\n" + 
			"9\r\n" + 
			"1 2 5\r\n" + 
			"1 3 4\r\n" + 
			"2 3 2\r\n" + 
			"2 4 7\r\n" + 
			"3 4 6\r\n" + 
			"3 5 11\r\n" + 
			"4 5 3\r\n" + 
			"4 6 8\r\n" + 
			"5 6 8";
	
}
