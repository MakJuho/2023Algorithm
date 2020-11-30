package 알고리즘_1022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 프로그래머스_가장먼노드 {
	
	
	public static void main(String[] args) {
		int n = 6;
		
		int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
		
		solution(n, edge);
		
		return ;
	}
	private static void solution(int n, int[][] edge) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		
		for(int i=0; i<edge.length; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i<edge.length; i++) {
			int a = edge[i][0];
			int b = edge[i][1];
			
			list.get(a).add(b);
			list.get(b).add(a);
			
		}
		
		int[] count = new int[n+1];
		boolean[] visit = new boolean[n+1];
		
		Queue<Integer> q = new LinkedList<>();
		
		q.add(1);
		
		visit[0] = true;
		visit[1] = true;
		
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int val : list.get(cur)) {
				if(!visit[val]) {
					visit[val] = true;
					count[val] = count[cur]+1;
					q.add(val);
				}
			}
			
		}
		
		System.out.println(Arrays.toString(count));
		
		
		//System.out.println(list);
		
		int max = Integer.MIN_VALUE;
		
		for(int cnt : count) {
			if(cnt > max) {
				max = cnt;
			}
		}
		int answer = 0;
		for(int i=0; i<count.length; i++) {
			if(max == count[i]) {
				answer++;
			}
		}
		System.out.println(answer);
		
	}
	
}
