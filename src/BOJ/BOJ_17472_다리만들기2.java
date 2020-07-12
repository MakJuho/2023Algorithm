package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17472_다리만들기2 {

	static ArrayList<ArrayList<Integer>> island = new ArrayList<>();
	static int N,M;
	static int[][] map;
	static int[][] map_level;
	
	static boolean[][] visit;
	
	static Queue<Pos> q = new LinkedList<>();
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	
	
	static class Pos{
		
		private int x;
		private int y;
		private int po;
		
		public Pos(int x, int y, int po) {
			this.x = x;
			this.y = y;
			this.po = po;
		}
		
		@Override
		public String toString() {
			return "Pos [x=" + x + ", y=" + y + ", po=" + po + "]";
		}
		
		
		
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		map = new int[N][M];
		visit = new boolean[N][M];
		map_level = new int[N][M];
		
		int island_num=0;
		for(int r=0; r<N; r++) {
			tokens = new StringTokenizer(br.readLine());
			for(int c=0; c<M; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
				
				
				
			}
		}
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				
				if(map[r][c] == 1 && !visit[r][c]) {
					island_num++;
					q.add(new Pos(r,c, island_num));
					
					while(!q.isEmpty()) {
						
						Pos tmp = q.poll();
						
						for(int dir=0; dir<4; dir++) {
							int nr = tmp.x+di[dir];
							int nc = tmp.y+dj[dir];
							
							if(isIn(nr,nc) && !visit[nr][nc] && map[nr][nc] ==1 ) {
								visit[nr][nc] = true;
								q.add(new Pos(nr,nc,island_num));
								map_level[nr][nc]=island_num;
								
							}
							
						}
					}
				}
			}
		}
		
		for(int i=0; i<N/2; i++) {
			island.add(new ArrayList<Integer>());
		}
		
		for(int[] a: map_level) {
			System.out.println(Arrays.toString(a));
			
		}
	
		
		
	}
	
	private static boolean isIn(int nr, int nc) {
		return 0<=nr && nr<N && 0<=nc && nc<M;
	}

	static String src = "7 8\r\n" + 
			"0 0 0 0 0 0 1 1\r\n" + 
			"1 1 0 0 0 0 1 1\r\n" + 
			"1 1 0 0 0 0 0 0\r\n" + 
			"1 1 0 0 0 1 1 0\r\n" + 
			"0 0 0 0 0 1 1 0\r\n" + 
			"0 0 0 0 0 0 0 0\r\n" + 
			"1 1 1 1 1 1 1 1";
	
}
