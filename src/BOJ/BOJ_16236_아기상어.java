package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BOJ_16236_아기상어 {
	
	static int[][] map;
	static int N;
	static Pos shark;
	static int[] di = {0,-1,0,1};
	static int[] dj = {-1,0,1,0};
	static boolean[][] visit;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N][N];
		for(int r=0; r<N; r++) {
			StringTokenizer tokens= new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
				if(map[r][c] == 9) {
					shark = new Pos(r,c,2,0,0);
					map[r][c] =0;
				}
			}
		}
		
//		for(int[] a: map) {
//			System.out.println(Arrays.toString(a));
//		}
		
		Queue<Pos> q = new LinkedList<>();
		q.add(shark);
		
		int length=0;
		while(!q.isEmpty()) {
			Pos tmp = q.poll();
			
			for(int dir=0; dir<di.length; dir++) {
				int nr = tmp.r+di[dir];
				int nc = tmp.c+dj[dir];
				
				if(isIn(nr,nc) && map[nr][nc] <= shark.len && !visit[nr][nc]) {
					
					q.add(new Pos(nr,nc,map[nr][nc],tmp.depth+1));
					visit[nr][nc]=true;
					if(map[nr][nc]< shark.len && map[nr][nc] !=0) {
						//System.out.println("길이:"+length);
						map[nr][nc] = 0;
						shark.feed++;
						shark.r = nr;
						shark.c = nc;
						shark.depth = (tmp.depth+1);
						if(shark.feed == shark.len) {
							shark.len++;
							shark.feed = 0;
						}
						
						for(int i=0; i<N; i++) {
							Arrays.fill(visit[i], false);
						}
						q.clear();
						q.add(shark);
						break;
					}
					
					
					
				}

			}
			
		}
		length = shark.depth;
		
		System.out.println(length);
		
		
		
		
		
	}
	
	static boolean isIn(int nr, int nc) {
		
		return 0<=nr && 0<= nc && nr<N && nc<N;
	}

	static class Pos{
		
		private int r;
		private int c;
		private int len;
		private int feed;
		private int depth;
		
		public Pos(int r, int c, int len, int depth) {
			this.r = r;
			this.c = c;
			this.len = len;
			this.depth = depth;
		}
		public Pos(int r, int c, int len, int feed, int depth) {
			this.r = r;
			this.c = c;
			this.len = len;
			this.feed = feed;
			this.depth = depth;
		}
		@Override
		public String toString() {
			return "Pos [x=" + r + ", y=" + c + ", len=" + len + ", depth=" + depth+"]";
		}
		
		
		
	}
	
	static String src = "6\r\n" + 
			"5 4 3 2 3 4\r\n" + 
			"4 3 2 3 4 5\r\n" + 
			"3 2 9 5 6 6\r\n" + 
			"2 1 2 3 4 5\r\n" + 
			"3 2 1 6 5 4\r\n" + 
			"6 6 6 6 6 6";
	
}
