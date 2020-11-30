package LGCNS_1016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class 위상정렬2 {

	/*
	 * 자신을 가르키지 않는 노드를 Q에 넣는다.
	 * degrees 배열을 만든다.
	 * List<ArrayList<Integer>>[] list = new ArrayList<ArrayList<Integer>>(); 
	 * 
	 * 밑에서 초기화 시킨다.
	 * for(int i=0; i<n+1; i++){
	 * 	list = new ArrayList<Integer>();
	 * }
	 *
	 * 
	 */
	// 노드, 간선
	static int n;  
	static int m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(tokens.nextToken());
		m = Integer.parseInt(tokens.nextToken());
		
		int[] degrees = new int[n+1];
		
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		
		for(int i=0; i<n+1; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i<m; i++) {
			tokens = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
		
			list.get(a).add(b);
			degrees[b]++;
		
		}
		
		topologicalSort(list, degrees);
		
		
	}
	private static void topologicalSort(List<List<Integer>> list, int[] indegrees) {
			Queue<Integer> q = new LinkedList<>();
			Queue<Integer> result = new LinkedList<>();
			
			for(int i=1; i<n+1; i++) {
				if(indegrees[i] == 0) {
					q.offer(i);
				}
			}
			
			while(!q.isEmpty()) {
				int curNode = q.poll();
				
				result.offer(curNode);
				
				for(Integer idx : list.get(curNode)) {
					
					indegrees[idx]--;
					
					if(indegrees[idx] == 0) {
						q.offer(idx);
					}
					
					
				}
				
			}
			
			for( Integer rlt : result) {
				System.out.println(rlt);
			}
			
			
			
	}
	
	
	
	 static String src ="4 2\r\n" + 
	    		"4 2\r\n" + 
	    		"3 1";
	
}
