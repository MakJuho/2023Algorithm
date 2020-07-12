package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_d9_1949_등산로조성 {

	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int[][] map;
	static boolean[][] visit;
	static int N,K,max;
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T =Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			N=Integer.parseInt(st.nextToken()); // 지도크기 3<=N<=8
			K=Integer.parseInt(st.nextToken()); // 공사가능깊이 1<=K<=5
			
			map = new int[N][N];
			visit = new boolean[N][N];
			
			int high=0;
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<N; j++) {
					map[i][j]=Integer.parseInt(st.nextToken()); // 1<=지형의 높이<=20
					high = Math.max(high, map[i][j]);
				}
			}

			max=-1; // 등산로의 길이
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j]==high) {
						dfs(i,j,1,false);
					}
				}
			}
			
			sb.append("#"+t+" "+max+"\n");
			
		
		}
		System.out.println(sb.toString());
		br.close();
	}



	private static void dfs(int i, int j, int cnt, boolean use) {
		max = Math.max(max,  cnt); // 가장 긴 등산로 갱신
		visit[i][j] = true;
		for(int d=0; d<4; d++) {
			int ni = i+di[d];
			int nj = j+dj[d];
			if(0<=ni && ni <N && 0<=nj && nj<N && !visit[ni][nj]) {
				if(map[ni][nj]<map[i][j]) {
					//이동 가능
					dfs(ni,nj,cnt+1,use);
				}else {
					if(!use) {
						for(int k=1; k<=K; k++) {
							if(map[ni][nj]-k <map[i][j]) {
								map[ni][nj] = map[ni][nj]-k; // 깎아 놓음
								dfs(ni,nj,cnt+1,true);
								map[ni][nj] = map[ni][nj]+k; // 원위치
							}
						}
					}
				}
			}
		}
		
		
		visit[i][j] = false;
		
	}
	
	
	
}
