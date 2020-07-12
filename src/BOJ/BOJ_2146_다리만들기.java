package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2146_다리만들기 {
	
	static int [][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
	static int [][] map;
	static int N;
	static int islandIdx, MinDist;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer tokens = null;
		map = new int[N][N];
		for(int r=0; r<N; r++) {
			tokens = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		// 1. 섬구별해주기
		islandIdx= 2;
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(map[r][c]==1) {
					bfs(r,c);
					islandIdx++;
				}
			}
		}
		
		// 2. 섬까지의 최단거리
		MinDist = Integer.MAX_VALUE;
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(map[r][c] > 1) {
					getShortBridgeLength(r,c);
				}
			}
		}
		
		System.out.println(MinDist);
		
	}
	
	
	private static void getShortBridgeLength(int row, int col) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(row, col, map[row][col], 0));
		
		boolean[][] visited = new boolean[N][N];
		visited[row][col] = true;
		
		while(!q.isEmpty()) {
			Point front = q.poll();
			
			if(front.d>=MinDist) {
				break;
			}
			
			for(int d=0; d<dirs.length; d++) {
				int nr = front.r + dirs[d][0];
				int nc = front.c + dirs[d][1];
				
				if(isIn(nr, nc) && !visited[nr][nc]) {
					visited[nr][nc]= true;
					// 내륙
					if(map[nr][nc] == front.idx) {
						continue;
					}
					
					// 바다 -> 다리 연결
					else if(map[nr][nc] == 0) {
						q.offer(new Point(nr, nc, front.idx, front.d+1));
					}
					
					// 다른 섬
					else if(map[nr][nc] != front.idx) {
						MinDist = Math.min(MinDist, front.d);
						return ;
					}
				}
			}
		}
		
		
		
	}


	static void bfs(int row, int col) {

		Queue<Point> q= new LinkedList<>();
		q.offer(new Point(row, col, islandIdx));
		
		// 방문 처리
		map[row][col] = islandIdx;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for(int d=0; d<dirs.length; d++) {
				int nr = p.r + dirs[d][0];
				int nc = p.c + dirs[d][1];
				
				if(isIn(nr, nc) && map[nr][nc] ==1) {
					map[nr][nc] = islandIdx;
					q.offer(new Point(nr, nc, islandIdx));
				}
			}
		}
		
		
	}

	private static boolean isIn(int nr, int nc) {
		return 0<=nr && nr<N && 0<=nc && nc<N;
	}

	static class Point{
		int r, c, idx;
		int d; // bfs의 depth저장
		
		public Point(int r, int c, int idx) {
			this.r = r;
			this.c = c;
			this.idx = idx;
		}
		
		public Point(int r, int c, int idx, int d) {
			this.r = r;
			this.c = c;
			this.idx = idx;
			this.d = d;
		}

		
		
		
	}
	

	static String src = "10\r\n" + 
			"1 1 1 0 0 0 0 1 1 1\r\n" + 
			"1 1 1 1 0 0 0 0 1 1\r\n" + 
			"1 0 1 1 0 0 0 0 1 1\r\n" + 
			"0 0 1 1 1 0 0 0 0 1\r\n" + 
			"0 0 0 1 0 0 0 0 0 1\r\n" + 
			"0 0 0 0 0 0 0 0 0 1\r\n" + 
			"0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 1 1 0 0 0 0\r\n" + 
			"0 0 0 0 1 1 1 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0";
	
}
