package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1766_문제집 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(tokens.nextToken());
		int r = Integer.parseInt(tokens.nextToken());
		
		// 2차원 인접 리스트를 정의
		List<List<Integer>> array = new ArrayList<List<Integer>>();
		
		for(int i=0; i<n+1; i++) {
			array.add(new ArrayList<>());
		}
		
		// indegree 구해야함
		int[] indegrees = new int[n+1];
		
		for(int i=0; i<r; i++) {
			tokens = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			
			array.get(a).add(b);
			
			indegrees[b] ++;
			
		}
		
		// topology sort
		
//		PriorityQueue<Integer> q= new PriorityQueue<>();
		Queue<Integer> q = new LinkedList<>();
		Queue<Integer> result = new LinkedList<>();
		
		// q에 indegrees가 해당 노드가 0이면 다 담아요.
		for(int i=1; i<n+1; i++) {
			if(indegrees[i] == 0) {
				q.offer(i);
			}
		}
		
		
		while(!q.isEmpty()) {
			int node = q.poll();
			result.offer(node);
			

			for(Integer v : array.get(node)) {
				indegrees[v] --;
				if(indegrees[v] == 0) {
					q.offer(v);
				}
				
			}
		 
		}
		
		for(int i: result) {
			System.out.print(i+" ");
		}
		
		
	}
	
	
	
	
	static String src = "4 2\r\n" + 
			"4 2\r\n" + 
			"3 1";
}
