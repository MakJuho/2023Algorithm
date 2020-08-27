package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_19238_스타트택시 {
	
	static int N, M, fuel;
	static int curR, curC;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = { -1, 0, +1, 0};
	static int[] dc = { 0, +1, 0, -1};
	static Queue<Pos> q = new LinkedList<>();
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		fuel = Integer.parseInt(tokens.nextToken());
		
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for(int r=0; r<N; r++) {
			tokens = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		tokens = new StringTokenizer(br.readLine());
		
		curR = Integer.parseInt(tokens.nextToken());
		curC = Integer.parseInt(tokens.nextToken());

		Pos curTexi = new Pos(curR, curC, fuel);
		
		int[][] st2ep = new int[M][4];
		
		for(int r=0; r<M; r++) {
			tokens = new StringTokenizer(br.readLine());
			for(int c=0; c<4; c++) {
				st2ep[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}

		/**
		 * Q에 현재 위치에서
		 */
		q.add(curTexi);
		visited[curTexi.r][curTexi.c] = true;
		
		// 최단 거리 계산
		while(!q.isEmpty()) {
			Pos tmp = q.poll();
			
			for(int i=0; i<4; i++) {
				int nr = tmp.r + dr[i];
				int nc = tmp.c + dc[i];
				
				/**
				 * 배열 범위 안
				 * 방문 여부
				 * 벽인지 아닌지
				 */
				if(isIn(nr, nc) && !visited[nr][nc] && map[nr][nc] != 1) {
					q.add(new Pos(nr,nc,tmp.fuel-1));
					visited[nr][nc] = true;
				}
				
				
			}
		}
		
		
		
	}
	
	private static boolean isIn(int nr, int nc) {
		return 0<= nr && nr<N && 0<=nc && nc<N;
	}

	static class Pos{
		private int r, c, fuel;

		public Pos(int r, int c, int fuel) {
			this.r = r;
			this.c = c;
			this.fuel = fuel;
		}

		@Override
		public String toString() {
			return "Pos [r=" + r + ", c=" + c + ", fuel=" + fuel + "]";
		}
		
		
		
	}
	
	static String src = "6 3 15\r\n" + 
			"0 0 1 0 0 0\r\n" + 
			"0 0 1 0 0 0\r\n" + 
			"0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0\r\n" + 
			"0 0 0 0 1 0\r\n" + 
			"0 0 0 1 0 0\r\n" + 
			"6 5\r\n" + 
			"2 2 5 6\r\n" + 
			"5 4 1 6\r\n" + 
			"4 2 3 5";
}
