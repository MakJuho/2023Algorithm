package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2636_치즈 {

	static int N,M;
//	static Queue<Pos> q = new LinkedList<>();
	static int[] di = { 0, 0, -1, 1};
	static int[] dj = { -1, 1, 0, 0};
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		map = new int[N][M];
		int cheeze = 0;
		for(int r=0; r<N; r++) {
			tokens = new StringTokenizer(br.readLine());
			for(int c=0; c<M; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
				if(map[r][c] == 1) cheeze++;
			}
		}
		
//		for(int []a : map) {
//			System.out.println(Arrays.toString(a));
//		}
		
//		System.out.println(cheeze);
		
		Queue<Pos> q = new LinkedList<>();
		boolean[][] visit = new boolean[N][M];
		
		
		int time= 0;
		int tmp_cheeze=0;
		while(cheeze != 0) {
			
			for(boolean[] a : visit) {
				Arrays.fill(a, false);
			}
			
			time ++;
			q.add(new Pos(0,0));
			visit[0][0]= true;
			tmp_cheeze = cheeze;
			
			while(!q.isEmpty()) {
				
				Pos tmp = q.poll();
				
				for(int dir=0; dir<4; dir++) {
					int nr = tmp.r+di[dir];
					int nc = tmp.c+dj[dir];
					
					if(isIn(nr,nc) && !visit[nr][nc] ) {
						
						if(map[nr][nc] == 1) {
							// 치즈 외부
							map[nr][nc] = -1;
							
							cheeze--;
						}else {
							q.add(new Pos(nr,nc));
						}
						visit[nr][nc] = true;
					}
				}
			}
			
		}
		System.out.println(time);
		System.out.println(tmp_cheeze);
		
		
		
		
		
	}
	private static boolean isIn(int nr, int nc) {
		return 0<=nr && nr<N && 0<=nc && nc<M;
	}
	static class Pos{
		int r;
		int c;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
		@Override
		public String toString() {
			return "Pos [r=" + r + ", c=" + c + "]";
		}
		
	}
	
	
	static String src ="13 12\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 1 1 0 0 0\r\n" + 
			"0 1 1 1 0 0 0 1 1 0 0 0\r\n" + 
			"0 1 1 1 1 1 1 0 0 0 0 0\r\n" + 
			"0 1 1 1 1 1 0 1 1 0 0 0\r\n" + 
			"0 1 1 1 1 0 0 1 1 0 0 0\r\n" + 
			"0 0 1 1 0 0 0 1 1 0 0 0\r\n" + 
			"0 0 1 1 1 1 1 1 1 0 0 0\r\n" + 
			"0 0 1 1 1 1 1 1 1 0 0 0\r\n" + 
			"0 0 1 1 1 1 1 1 1 0 0 0\r\n" + 
			"0 0 1 1 1 1 1 1 1 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0";
}
