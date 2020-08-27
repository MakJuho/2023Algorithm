package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_오나의여신님 {
	
	static int N,M;
	static char [][] board;
	static int suR, suC, devilR, devilC;
	
	static Queue<Pos> q1;
	static Queue<Pos> q2;
	
	static boolean v[][];
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=TC; t++) {
			
			StringTokenizer tokens = new StringTokenizer(br.readLine());
			N = Integer.parseInt(tokens.nextToken());
			M = Integer.parseInt(tokens.nextToken());
			q1 = new LinkedList<>();
			q2 = new LinkedList<>();
			ans = Integer.MAX_VALUE;
			board = new char[N][M];
			v = new boolean[N][M];
			for(int r=0; r<N; r++) {
				String Line = br.readLine();
				for(int c=0; c<M; c++) {
					board[r][c] = Line.charAt(c);
					if(board[r][c] == 'S') {
						v[r][c] = true;
						q1.add(new Pos(r,c));
					}else if(board[r][c] == '*') {
						v[r][c] = true;
						q2.add(new Pos(r,c));
					}
				}
			}
			
			
			BFS();
			System.out.print("#"+t+" ");
			if(ans == Integer.MAX_VALUE) {
				System.out.println("GAME_OVER");
			}else {
				System.out.println(ans);
			}
		}
		
	}
	
	private static void BFS() {
		/**
		 * 1초마다 
		 * S의 위치/ *위치
		 */
		while(!q1.isEmpty()) {

			// 수연이 이동
			int len = q1.size();
			for(int i=0; i<len; i++) {
				Pos tmp = q1.poll();
				
				int r = tmp.r;
				int c = tmp.c;
				int cnt = tmp.cnt;
				
				if(board[r][c] == 'D') {
					ans = cnt;
					return ;
				}
				
				for(int j=0; j<4; j++) {
					int nr = r + dr[j];
					int nc = c + dc[j];
					
					if(isOut(nr,nc)) continue;
					
					if(board[nr][nc]=='*') continue;
					
					if(board[nr][nc]=='X') continue;
					
					if(v[nr][nc]) continue;
					
					v[nr][nc] = true;
					
					q1.offer(new Pos(nr, nc, cnt+1));
					
				}
				
			}
			
			// 악마 이동
			len = q2.size();
			for(int i=0; i<len; i++) {
				Pos tmp = q2.poll();
				
				int r = tmp.r;
				int c = tmp.c;
				
				for(int j=0; j<4; j++) {
					int nr = r + dr[j];
					int nc = c + dc[j];
					
					if(isOut(nr,nc)) continue;
					
					if(board[nr][nc] =='.') {
						q2.offer(new Pos(nr,nc));
						board[nr][nc] = '*';
						
					}
					
				}
				
			}
			
			
		}		
	}

	private static boolean isOut(int nr, int nc) {
		
		return 0>nr || 0>nc || nr>=N || nc>=M;
	}

	static class Pos{
		private int r,c,cnt;

		@Override
		public String toString() {
			return "Pos [r=" + r + ", c=" + c + ", cnt=" + cnt + "]";
		}

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
		public Pos(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
		
		
	}
	
	static String src ="2\r\n" + 
			"5 3\r\n" + 
			"D*S\r\n" + 
			".X.\r\n" + 
			".X.\r\n" + 
			".X.\r\n" + 
			"...\r\n" + 
			"5 3\r\n" + 
			"D*S\r\n" + 
			"...\r\n" + 
			".X.\r\n" + 
			".X.\r\n" + 
			"...";
}
