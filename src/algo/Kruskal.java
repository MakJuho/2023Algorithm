package algo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

//7 11
//0 1 2
//0 2 2
//0 5 8
//1 2 1
//1 3 19
//2 5 5
//3 4 7
//3 5 11
//3 6 15
//4 5 9
//4 6 3


public class Kruskal {

	static int[] parents;
	static int[] rank;
	
	// 입력은 첫 줄에 정점의 갯수와 간선의 갯수가 들어오고
	// 그 다음줄부터 간선의 정보가 정점1 정점2 가중치로 간선의 갯수만큼 들어감
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		parents=  new int[V];
		rank=  new int[V];
		int[][] edges = new int[E][3];
		for(int i =0; i < E; i++) {
			edges[i][0] = sc.nextInt(); // 시작
			edges[i][1] = sc.nextInt(); // 끝
			edges[i][2] = sc.nextInt(); // 가중치
		}
//		간선들을 가중치 오름차순 정렬
		Arrays.sort(edges, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {

				return Integer.compare(o1[2], o2[2]);
			}
			
		});

		
		// 각 정점ㅇ에 대해 유니온파인드 연산 준비.
		for(int i=0; i<V; i++)
			makeSet(i);
		int result = 0;
		int cnt = 0;
		// 정점의 갯수 -1번 반복하면서
		for(int i=0; i< E-1; i++) {
			int a = findSet(edges[i][0]);
			int b = findSet(edges[i][1]);
			if( a == b)
				continue;
			union(a,b);
			
			result += edges[i][2];
			
			cnt++;
			if( cnt == V-1)
				break;
			
		}
		
		System.out.println(result);
		
		
//		정점의 개수 -1번 반복하면서
		
//		간선이 연결하는 두 정점이 같은 팀이 아니라면 한 팀으로 합쳐주고 간선선택
//		같은 팀이라면 패스
		
	}

	
	static void makeSet(int x) {
		parents[x] = x;
	}
	
	static int findSet(int x) {
		if( x == parents[x])
			return x;
		else {
			parents[x] = findSet(parents[x]);
			return parents[x];
		}
	}
	
	static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		
//		parents[py] = px;
		
		if( rank[px] > rank[py]) {
			parents[py] = px;
		}
		else {
			parents[px] = py;
			if( rank[px] == rank[py]) {
				rank[py]++;
			}
		}
		
	}
	
	
	
}
