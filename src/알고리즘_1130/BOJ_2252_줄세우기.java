package 알고리즘_1130;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2252_줄세우기 {

	/**
	 * 줄세우기
	 * 노드에 따른 순서를 지정해야한다.
	 * 
	 * 2차원 List 생성 및 초기화
	 * indegrees : Node에 연결된 부분 확인
	 * 해당 indegrees가 0인 부분에 대해 q에 넣고, result에 추가
	 * 
	 */
	static int N, M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		
		for(int i=0; i<N+1; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		//System.out.println(list);
		
		int[] indegrees = new int[N+1];
		
		for(int i=0; i<M; i++) {
			tokens = new StringTokenizer(br.readLine());
			int a= Integer.parseInt(tokens.nextToken());
			int b= Integer.parseInt(tokens.nextToken());
			
			list.get(a).add(b);
			
			indegrees[b]++;
			
		}
		
//		System.out.println(list);
//		System.out.println(Arrays.toString(indegrees));
		
		topologicalSort(list, indegrees);
		
		
	}
	
	private static void topologicalSort(ArrayList<ArrayList<Integer>> list, int[] indegrees) {
		Queue<Integer> q= new LinkedList<>();
		Queue<Integer> result = new LinkedList<>();
		
		for(int i=1; i<N+1; i++) {
			if(indegrees[i] == 0 ) {
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
		
		for(int i : result) {
			System.out.print(i+" ");
		}
		
		
	}
	
	
	static String src ="4 2\r\n" + 
			"4 2\r\n" + 
			"3 1";
}
