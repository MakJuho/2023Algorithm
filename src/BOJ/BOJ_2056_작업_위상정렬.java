package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2056_작업_위상정렬 {

	static int N;
	static int[] indegree, workingTime, cost;
	static ArrayList<ArrayList<Integer>> adList;
	static Queue<Integer> queue;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		N = Integer.parseInt(br.readLine());

		adList = new ArrayList<>();
		adList.add(new ArrayList<>());
		
		for(int i=0; i<N; i++) {
			adList.add(new ArrayList<>());
		}
		
		indegree = new int[N+1];
		workingTime = new int[N+1];
		cost = new int[N+1];
		
		
		
		for(int i=1; i<N+1; i++) {
			StringTokenizer tokens = new StringTokenizer(br.readLine());
			workingTime[i] = Integer.parseInt(tokens.nextToken());

			// 0 1 1 1 2 2 3
			int Cnt = Integer.parseInt(tokens.nextToken());
			
			while(Cnt-- > 0) {
				int head = Integer.parseInt(tokens.nextToken());
				adList.get(head).add(i);
				indegree[i] ++;
				
			}
		}
		
		queue = new LinkedList<>();
		topological_sort();
		
		int answer = 0;
		for(int i=1; i<=N; i++) {
			answer = answer > cost[i] ? answer : cost[i];
		}
		System.out.println(answer);
		

	}
	
	private static void topological_sort() {

		for(int i=1; i<=N; i++) {
			// 선행 작업이 필요 없는 경우
			if(indegree[i] == 0) {
				cost[i] = workingTime[i];
				queue.add(i);
			}
		}
		
		for(int i=1; i<=N; i++) {
			int curNode = queue.poll();
			
			ArrayList<Integer> curNodeList = adList.get(curNode);
			while(!curNodeList.isEmpty()) {
				int target=  curNodeList.remove(0);
				indegree[target]--;
				
				cost[target] = Math.max(cost[target], workingTime[target]+cost[curNode]);
				
				if(indegree[target] == 0) {
					queue.add(target);
				}
			}
		}
		
		
	}

	static String src ="7\r\n" + 
			"5 0\r\n" + 
			"1 1 1\r\n" + 
			"3 1 2\r\n" + 
			"6 1 1\r\n" + 
			"1 2 2 4\r\n" + 
			"8 2 2 4\r\n" + 
			"4 3 3 5 6";
}
