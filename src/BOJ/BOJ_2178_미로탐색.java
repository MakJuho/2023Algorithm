package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import BOJ.BOJ_15686_치킨배달.Pos;

public class BOJ_2178_미로탐색 {
	static int M,N;
	static int[][]map;
	static boolean[][]visit;
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	static int cnt = 1;
	static Queue<Pos> q = new LinkedList<>();
	
	static class Pos{
		private int x;
		private int y;
		
		@Override
		public String toString() {
			return "Pos [x=" + x + ", y=" + y + "]";
		}
		
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		
		
	}
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer tokens = new StringTokenizer(br.readLine(), " ");
		
		M= Integer.parseInt(tokens.nextToken());
		N= Integer.parseInt(tokens.nextToken());
		map = new int[M][N];
		visit = new boolean[M][N];
		
		for(int i=0; i<M; i++) {
			tokens = new StringTokenizer(br.readLine());
			String line = tokens.nextToken();
			for(int j=0; j<N; j++) {
				map[i][j]=Integer.parseInt(String.valueOf(line.charAt(j)));
				visit[i][j] = false;
			}
		}
		
		q.add(new Pos(0,0));
		visit[0][0] = true;
		while(!q.isEmpty()) {
			Pos tmp = q.poll();
			
			
			if(tmp.x == M-1 && tmp.y == N-1) {
				break;
			}
			
			for(int d=0; d<4; d++) {
				int ni = tmp.x+di[d];
				int nj = tmp.y+dj[d];
				
				if(0<=ni && ni<M && 0<=nj && nj<N && map[ni][nj]==1 && !visit[ni][nj]) {
					visit[ni][nj]= true;
					q.add(new Pos(ni, nj));
					map[ni][nj] = map[tmp.x][tmp.y]+1;
					
				}
				
			}
			
			
			
		}
		
		
		System.out.println(map[M-1][N-1]);
		
		
	}
	
	
	
	/*
	 * private static void dfs(int i, int j, int cnt) {
	 * 
	 * if(i == (M-1) && j == (N-1)) { if(min > cnt) { min = cnt; } for(boolean[] a:
	 * visit) { System.out.println(Arrays.toString(a)); } System.out.println();
	 * return ; } for(int d=0; d<4; d++) { int ni = i+di[d]; int nj = j+dj[d];
	 * 
	 * if(0<=ni && ni<M && 0<=nj && nj<N && !visit[ni][nj] && map[ni][nj] ==1 ) {
	 * visit[ni][nj] = true; cnt++; dfs(ni,nj,cnt); visit[ni][nj]=false; }
	 * 
	 * }
	 * 
	 * 
	 * }
	 */



	static String src = "7 7\r\n" + 
			"1011111\r\n" + 
			"1110001\r\n" + 
			"1000001\r\n" + 
			"1000001\r\n" + 
			"1000001\r\n" + 
			"1000001\r\n" + 
			"1111111";
}
