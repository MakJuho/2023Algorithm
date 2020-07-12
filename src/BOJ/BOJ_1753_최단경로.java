package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;





public class BOJ_1753_최단경로 {

	static class Edge implements Comparable<Edge>{
		
		int v, weight;
		
		public Edge(int v, int weight) {
			this.v = v;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight,  o.weight);
		}

		@Override
		public String toString() {
			return "Edge [weight=" + weight + "]";
		}

		

	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		String line = br.readLine();
		StringTokenizer tokens = new StringTokenizer(line);
		int V= Integer.parseInt(tokens.nextToken());
		int E= Integer.parseInt(tokens.nextToken());
		int K = Integer.parseInt(br.readLine())-1;
		List<Edge>[] adj = new ArrayList[V];
		
		for(int i=0; i<V; i++) {
			adj[i] = new ArrayList<>();
			
		}
		
		
		for(int i=0; i<E; i++) {
			line = br.readLine();
			tokens = new StringTokenizer(line);
			adj[Integer.parseInt(tokens.nextToken())-1]
					.add(new Edge(Integer.parseInt(tokens.nextToken())-1, Integer.parseInt(tokens.nextToken())));
		}
		
		
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		boolean[] check = new boolean[V];
		Edge[] D = new Edge[V];
		
		
		for( int i=0; i<V; i++) {
			// 원하는 출발지
			if(i == K) {
				D[i] = new Edge(i, 0);
			}
			else {
				D[i] = new Edge(i, Integer.MAX_VALUE);
			}
			pq.add(D[i]);
		}
		while( !pq.isEmpty()) {
			Edge edge = pq.poll();
			if(edge.weight == Integer.MAX_VALUE)
				break;
			
			for( Edge next : adj[edge.v]) {
				// check 되지 않았으면서, D[next.v]가 D[edge.v] + next.weight 보다 더 크다면 갱신
				if( !check[next.v] && D[next.v].weight > D[edge.v].weight+ next.weight) {
					D[next.v].weight = D[edge.v].weight+ next.weight;
					// decrease key
					pq.remove(D[next.v]);
					pq.add(D[next.v]);
				}
			}
			check[edge.v] = true;
		}
		
//		System.out.println(Arrays.toString(D));
		
		for(int i=0; i<V; i++) {
			if(D[i].weight != Integer.MAX_VALUE) {
				System.out.println(D[i].weight);
				
			}else {
				System.out.println("INF");
				
			}
		}
		
		
	}
	
	private static String src = "5 6\r\n" + 
			"1\r\n" + 
			"5 1 1\r\n" + 
			"1 2 2\r\n" + 
			"1 3 3\r\n" + 
			"2 3 4\r\n" + 
			"2 4 5\r\n" + 
			"3 4 6";
	
}
