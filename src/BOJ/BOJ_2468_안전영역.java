package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2468_안전영역 {

	static int N;
	static int[][] map;
	static boolean[][] visit;
	static int MAX_cnt = Integer.MIN_VALUE;
	
	static int[] di = {0, 0, -1, 1};
	static int[] dj = {-1, 1, 0, 0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		
		for(int r=0; r<N; r++) {
			StringTokenizer tokens = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		for(int h=0; h<=100; h++) {
			
			// 물이 점점 차오른다.
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					// 잠긴 물 확인
					if(map[r][c] <= h) {
						map[r][c] = 0;
					}
				}
			}
		
			// visit 방 bfs()로 탐색하며 개수 세기
			Queue<Pos> q = new LinkedList<>();
			int cnt=0;
			visit = new boolean[N][N];
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					
					if(visit[r][c] == true || map[r][c] == 0) continue;
					
					q.add(new Pos(r,c,cnt++));
					visit[r][c] = true;
					
					while(!q.isEmpty()) {
						Pos tmp = q.poll();
						
						for(int dir=0; dir<4; dir++) {
							int nr = tmp.r+di[dir];
							int nc = tmp.c+dj[dir];
							
							if(isIn(nr,nc) && !visit[nr][nc] && map[nr][nc] != 0) {
								visit[nr][nc] = true;
								q.add(new Pos(nr,nc,cnt));
							}
						}
						
					}
					
					
				}
			}
			
			//System.out.println(cnt);
			if(MAX_cnt < cnt) {
				MAX_cnt = cnt;
			}
			
		
		}
		
		
		System.out.println(MAX_cnt);
		
	}
	
	private static boolean isIn(int nr, int nc) {
		return 0<=nr && nr<N && 0<=nc && nc<N;
	}

	static class Pos{
		int r, c, cnt;

		public Pos(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
		

		@Override
		public String toString() {
			return "Pos [r=" + r + ", c=" + c + ", cnt=" + cnt + "]";
		}
		
	}
	
	static String src= "5\r\n" + 
			"6 8 2 6 2\r\n" + 
			"3 2 3 4 6\r\n" + 
			"6 7 3 3 2\r\n" + 
			"7 2 5 3 6\r\n" + 
			"8 9 5 2 7";
}
