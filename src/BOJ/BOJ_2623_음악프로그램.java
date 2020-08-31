package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2623_음악프로그램 {

	static ArrayList<Integer>[] list;
	static ArrayList<Integer> result = new ArrayList<>();
	static Queue<Integer> q = new LinkedList<>();
	static int[] indegree;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(tokens.nextToken());
		int M = Integer.parseInt(tokens.nextToken());
		
		list = new ArrayList[N+1];
		indegree = new int [N+1];

		// ArrayList 초기화.
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		
		// PD 순서
		for(int i=0; i<M; i++) {
			tokens = new StringTokenizer(br.readLine());
			
			int num = Integer.parseInt(tokens.nextToken());
			int[] tmp = new int[num];
			
			for(int j=0; j<num; j++) {
				tmp[j] = Integer.parseInt(tokens.nextToken());
			}
			
			for(int j=0; j<num-1; j++) {
				list[tmp[j]].add(tmp[j+1]);
				indegree[tmp[j+1]]++;
			}
		}

		// 자식이 없는 노드를 Queue에 삽입
		for(int i=1; i<= N; i++) {
			if(indegree[i] == 0) {
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int tmp = q.poll();
			result.add(tmp);
			
			// 자식이 없는 노드에 속한 list 간선 제거 
			for(int num: list[tmp]) {
				indegree[num]--;
				if(indegree[num] ==0) {
					q.add(num);
				}
			}
		}
		
		// 모두 선택완료했다면
		if(result.size() == N) {
			for(int num : result) {
				System.out.println(num);
			}
			return;
		}
		System.out.println(0);
		
	}
	
//	static String src = "6 3\r\n" + 
//			"3 1 4 3\r\n" + 
//			"4 6 2 5 4\r\n" + 
//			"2 2 3";
	static String src = "3 2\r\n"
			+ "2 1 2\r\n"
			+ "2 1 3";
}
