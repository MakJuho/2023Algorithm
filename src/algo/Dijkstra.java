package algo;

import java.util.Arrays;
import java.util.Scanner;

//7 11
//0 1 9
//0 2 5
//0 5 10
//2 3 1
//2 5 15
//3 0 2
//3 1 7
//3 5 17
//3 4 8
//4 6 4
//6 1 3

public class Dijkstra {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		int[][] adj = new int[V][V];
		int[] D = new int[V];
		
		for(int i=0; i<E; i++) {
			adj[sc.nextInt()][sc.nextInt()] = sc.nextInt();
		}
		
		Arrays.fill(D, Integer.MAX_VALUE);

		boolean[] check = new boolean[V];
		
		// 시작점이 a정점이면 D[a] = 0;
		D[0] = 0;
		
		for(int i =0; i< V-1; i++) {
			int min = Integer.MAX_VALUE; // 가장 작은 값을 기억할 곳
			int index = -1; // 그 위치를 기억할 변수
			
			for(int j = 0; j<V; j++) {
				// 아직 처리하지 않았으면서, 가장 짧은 거리라면
				if(!check[j] && min > D[j] ) {
					min = D[j];
					index = j;
				}
			}
			// 연결이 없는 경우 끝
			if(index == -1)
				break;
			
			// 새로운 친구로부터 갈 수 있는 경로들을 업데이트
			for(int j =0; j< V; j++) {
				// 아직 처리하지 않았으면서, adj[index][j] != 0, D[index] + index부터 j까지의 거리가 D[j]보다 작다면
				if(!check[j] && adj[index][j] !=0 && D[index] + adj[index][j] < D[j]) {
					D[j] = D[index] + adj[index][j];
				}
			}
			
			// 내 편으로 된 것 체크
			check[index] = true;
			
		}
		
		System.out.println(Arrays.toString(D));
		
		
		
		
	}
}
