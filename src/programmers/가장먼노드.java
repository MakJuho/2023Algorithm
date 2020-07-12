package programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 가장먼노드 {

	static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
	
	public static void main(String[] args) {
		int n = 6;
		int[][] edge = {
				{3, 6}, {4, 3}, {3, 2}, 
				{1, 3}, {1, 2}, {2, 4}, {5, 2}
		};
		int answer = 0;
		
		for(int i=0; i<edge.length; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		int a,b;
		for(int[] node: edge) {
			a = node[0];
			b = node[1];
			list.get(a).add(b);
			list.get(b).add(a);
		}

		int[] count = new int[n+1];
		boolean[] visit = new boolean[n+1];
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.add(1);
		visit[0]= visit[1] = true;
		
		int now;
		
		while(!q.isEmpty()) {
			now = q.poll();
			
			for(int val: list.get(now)) {
				if(!visit[val]) {
					count[val] = count[now]+1;
					visit[val] = true;
					q.add(val);
				}
				
			}
		}
		
		int max = Integer.MIN_VALUE;
		for(int cnt : count) {
			if(cnt > max) {
				max = cnt;
				answer =1;
			}else if(cnt == max) {
				answer ++;
			}
			
			
		}
		
		System.out.println(answer);
		
	}
}
