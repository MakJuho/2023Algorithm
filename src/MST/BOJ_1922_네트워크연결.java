package MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1922_네트워크연결 {
	/**
	 * 노드 간에 모두 연결된 최소 비용을 구하는 문제
	 * 단, Cycle이 없어야한다.
	 * 
	 * 간단한 로직,
	 * 1. 연결비용을 기준으로 오름차순으로 정렬한다.
	 * 2. startNode와 endNode를 비교해서 rootNode가 같지 않다면 각각의 rootNode를 연결한다.
	 * 
	 */
	
	// 노드 시작점, 도착점, 비용
	static class Node implements Comparable<Node>{
		int start;
		int end;
		int cost;
		
		
		@Override
		public String toString() {
			return "Node [start=" + start + ", end=" + end + ", cost=" + cost + "]";
		}
		
		public Node(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			if(this.cost> o.cost) {
				return 1;
			}else if(this.cost < o.cost) {
				return -1;
			}else {
				return 0;
			}
			
		}
		
	}
	
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer tokens;
		
		
		// N은 노드 수, M은 간선 수
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		parent = new int[N+1];
		
		Node[] nodeList = new Node[M];
		
		// 총 금액
		int weightOfCost = 0;
		
		// 부모 배열을 자기자신으로 초기화
		for(int i=1; i<=N; i++) {
			parent[i] = i;
		}
		
		for(int i=0; i<M; i++) {
			tokens = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(tokens.nextToken());
			int end = Integer.parseInt(tokens.nextToken());
			int cost = Integer.parseInt(tokens.nextToken());
			nodeList[i] = new Node(start, end, cost);
			
		}
		
		// cost 순으로 오름차순 정렬
//		System.out.println(Arrays.toString(nodeList));
		Arrays.sort(nodeList);
//		System.out.println(Arrays.toString(nodeList));

		for(int i=0; i<M; i++) {
			int rootX = findRoot(nodeList[i].start);
			int rootY = findRoot(nodeList[i].end);
			
			if(rootX == rootY){
				continue;
			}else {
				parent[rootX] = rootY;
				weightOfCost += nodeList[i].cost;
			}
		}
		
		System.out.println(weightOfCost);
		
		
		
	}
	
	private static int findRoot(int u) {
		// u node값( u랑 같다면 u는 root node)
		if(u == parent[u]) { 
			return u;
		}
		else {
			// u의 parent node를 찾기 위해 parameter로 parent[i]를 넘겨줌
			parent[u] = findRoot(parent[u]);
			return parent[u];
		}
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
