package KT대비_1030;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1197_최소스패닝트리 {
	
	/*
	 *  Kruskal
	 *  1 ) 간선 오름차순 정렬
	 *  2 ) 사이클 생기는 지 판단
	 *  3 ) MST 집합에 추가
	 */
	static class Node implements Comparable<Node>{
		int start;
		int end;
		double cost;
	
		public Node(int start, int end, double cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
		
		@Override
		public String toString() {
			return "NODE [ start: "+start+" , end: "+end+", cost : "+cost+" ]";
		}
		
		@Override
		public int compareTo(Node o) {
			if(o.cost > this.cost) {
				return -1;
			}else if(o.cost == this.cost) {
				return 0;
			}else {
				return 1;
			}
		}
		
		
	}
	
	
	static int V;
	static int E;
	static ArrayList<Node>[] list;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		V = Integer.parseInt(tokens.nextToken());
		E = Integer.parseInt(tokens.nextToken());
	
		list = new ArrayList[V+1];
		visited = new boolean[V+1];
		
		for(int i=1; i<=V; i++) {
			list[i] = new ArrayList<Node>();
		}
		
//		System.out.println(Arrays.toString(list));
		
		for(int i=0; i<E; i++) {
			tokens = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			double c = Double.parseDouble(tokens.nextToken());
		
			list[a].add(new Node(a,b,c));
			list[b].add(new Node(b,a,c));
		
		}

//		System.out.println(Arrays.toString(list));
		double answer = MST();
		System.out.println(Math.round(answer));
		
		
	}
	
	private static double MST() {
		// 우선순위 큐 
		PriorityQueue<Node> pq = new PriorityQueue<>();
		// 리스트
		ArrayList<Node> tempList;
		Node tempNode;
		Queue<Integer> q = new LinkedList<>();
		double answer = 0;
		
		q.add(1);
		while(!q.isEmpty()) {
			int curNode = q.poll();
			visited[curNode] = true;
			tempList = list[curNode];
			
			for(int i=0; i<tempList.size(); i++) {
				if(!visited[tempList.get(i).end]) {
					pq.add(tempList.get(i));
				}
			}
			
			// 우선순위 큐에서 하나씩 빠짐
			while(!pq.isEmpty()) {
				tempNode = pq.poll();
				
				if(!visited[tempNode.end]) {
					visited[tempNode.end] = true;
					answer += tempNode.cost;
					q.add(tempNode.end);
					break;
				}
				
			}
			
			
		}
		
		return answer;
		
		
		
	}
	static String src = "3 3\r\n" + 
			"1 2 1\r\n" + 
			"2 3 2\r\n" + 
			"1 3 3";
	
}
