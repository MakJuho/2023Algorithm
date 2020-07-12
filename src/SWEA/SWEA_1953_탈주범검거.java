package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1953_탈주범검거 {

	static int TC, N, M, R, C, L;
	static int[][] tunnel;
	static boolean[][] visit;
	static int[] di = {0, 0, -1, 1}; // 왼쪽, 오른쪽, 위쪽, 아래쪽
	static int[] dj = {-1, 1, 0, 0};
	static Queue<Pos> q= new LinkedList<>();
	static int cnt=0;
	static Pos tmp = null;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringBuilder sb = new StringBuilder();
		
		TC = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=TC; t++) {
			sb.append("#").append(t).append(" ");
			StringTokenizer tokens = new StringTokenizer(br.readLine());
			N =Integer.parseInt(tokens.nextToken());
			M =Integer.parseInt(tokens.nextToken());
			R =Integer.parseInt(tokens.nextToken());
			C =Integer.parseInt(tokens.nextToken());
			L =Integer.parseInt(tokens.nextToken());
			
			tunnel = new int[N][M];
			visit = new boolean[N][M];
			cnt=0;
			q.clear();
			
			for(int r=0; r<N; r++) {
				tokens = new StringTokenizer(br.readLine()," ");
				for(int c=0; c<M; c++) {
					tunnel[r][c] = Integer.parseInt(tokens.nextToken());
				}
			}
			
			q.add(new Pos(R,C,tunnel[R][C],1));
			visit[R][C] = true;
			cnt++;
			
			tmp = q.peek();
			while(!q.isEmpty()) {
				
				tmp = q.poll();
				if(tmp.time==L) {
					break;
				}
				
				int dir = 0, nr=0, nc=0;
				switch(tmp.type) {
					case 1: // 왼쪽, 오른쪽, 위쪽, 아래쪽
						// 왼쪽
						dir = 0;
						nr = tmp.r+0;
						nc = tmp.c-1;
						Check(nr,nc,dir);
						// 오른쪽
						dir = 1;
						nr = tmp.r+0;
						nc = tmp.c+1;
						Check(nr,nc,dir);
						// 위쪽
						dir = 2;
						nr = tmp.r-1;
						nc = tmp.c+0;
						Check(nr,nc,dir);
						// 아래쪽
						dir = 3;
						nr = tmp.r+1;
						nc = tmp.c+0;
						Check(nr,nc,dir);
						break;

					case 2: // 위, 아래
						// 위쪽
						dir = 2;
						nr = tmp.r-1;
						nc = tmp.c+0;
						Check(nr,nc,dir);
						// 아래쪽
						dir = 3;
						nr = tmp.r+1;
						nc = tmp.c+0;
						Check(nr,nc,dir);
						break;
					
					case 3: // 오른쪽, 왼쪽
						// 왼쪽
						dir = 0;
						nr = tmp.r+0;
						nc = tmp.c-1;
						Check(nr,nc,dir);
						// 오른쪽
						dir = 1;
						nr = tmp.r+0;
						nc = tmp.c+1;
						Check(nr,nc,dir);
						break;
						
					case 4: // 위, 오른쪽
						// 오른쪽
						dir = 1;
						nr = tmp.r+0;
						nc = tmp.c+1;
						Check(nr,nc,dir);
						// 위쪽
						dir = 2;
						nr = tmp.r-1;
						nc = tmp.c+0;
						Check(nr,nc,dir);
						break;
					case 5: // 아래, 오른쪽
						// 아래쪽
						dir = 3;
						nr = tmp.r+1;
						nc = tmp.c+0;
						Check(nr,nc,dir);
						// 오른쪽
						dir = 1;
						nr = tmp.r+0;
						nc = tmp.c+1;
						Check(nr,nc,dir);
						break;
					case 6: // 아래, 왼쪽
						// 아래쪽
						dir = 3;
						nr = tmp.r+1;
						nc = tmp.c+0;
						Check(nr,nc,dir);
						// 왼쪽
						dir = 0;
						nr = tmp.r+0;
						nc = tmp.c-1;
						Check(nr,nc,dir);
						break;
					case 7: // 위, 왼쪽
						// 위쪽
						dir = 2;
						nr = tmp.r-1;
						nc = tmp.c+0;
						Check(nr,nc,dir);
						// 왼쪽
						dir = 0;
						nr = tmp.r+0;
						nc = tmp.c-1;
						Check(nr,nc,dir);
						break;
				}
				
				
			}
			
			
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
	
	private static void Check(int nr, int nc, int dir) {
		if(isIn(nr,nc) && !visit[nr][nc]) {
			//왼쪽
			if(dir == 0 && (tunnel[nr][nc] ==1 ||tunnel[nr][nc] ==3||tunnel[nr][nc] ==4||tunnel[nr][nc] ==5)) {
				q.add(new Pos(nr,nc,tunnel[nr][nc],tmp.time+1));
				visit[nr][nc] = true;
				cnt++;
			}
			// 오른쪽
			else if(dir==1 && (tunnel[nr][nc] ==1 ||tunnel[nr][nc] ==3||tunnel[nr][nc] ==6||tunnel[nr][nc] ==7)) {
				q.add(new Pos(nr,nc,tunnel[nr][nc],tmp.time+1));
				visit[nr][nc] = true;
				cnt++;
			}
			// 위쪽
			else if(dir==2 && (tunnel[nr][nc] ==1 ||tunnel[nr][nc] ==2||tunnel[nr][nc] ==5||tunnel[nr][nc] ==6)) {
				q.add(new Pos(nr,nc,tunnel[nr][nc],tmp.time+1));
				visit[nr][nc] = true;
				cnt++;
			}
			// 아래쪽
			else if(dir==3 && (tunnel[nr][nc] ==1 ||tunnel[nr][nc] ==2||tunnel[nr][nc] ==4||tunnel[nr][nc] ==7)) {
				q.add(new Pos(nr,nc,tunnel[nr][nc],tmp.time+1));
				visit[nr][nc] = true;
				cnt++;
			}
			
		}		
	}

	private static boolean isIn(int nr, int nc) {
		return 0<= nr && nr<N && 0<= nc && nc<M;
	}

	static class Pos{
		
		private int r,c,type,time;

		public Pos(int r, int c, int type,int time) {
			this.r = r;
			this.c = c;
			this.type = type;
			this.time = time;
		}

		@Override
		public String toString() {
			return "Pos [r=" + r + ", c=" + c + ", type=" + type +", time="+time+ "]";
		}
		
		
	}
	
	static String src ="5\r\n" + 
			"5 6 2 1 3\r\n" + 
			"0 0 5 3 6 0\r\n" + 
			"0 0 2 0 2 0\r\n" + 
			"3 3 1 3 7 0\r\n" + 
			"0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0\r\n" + 
			"5 6 2 2 6\r\n" + 
			"3 0 0 0 0 3\r\n" + 
			"2 0 0 0 0 6\r\n" + 
			"1 3 1 1 3 1\r\n" + 
			"2 0 2 0 0 2\r\n" + 
			"0 0 4 3 1 1\r\n" + 
			"10 10 4 3 9\r\n" + 
			"0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 7 5 0 5 0 0 0\r\n" + 
			"0 0 3 2 2 6 0 0 0 0\r\n" + 
			"0 4 7 2 2 2 7 0 0 4\r\n" + 
			"0 3 0 1 1 2 2 0 0 5\r\n" + 
			"0 5 6 1 1 1 1 6 2 5\r\n" + 
			"7 4 1 2 0 0 4 6 0 0\r\n" + 
			"5 3 1 7 0 2 2 6 5 7\r\n" + 
			"7 3 2 1 1 7 1 0 2 7\r\n" + 
			"3 4 0 0 4 0 5 1 0 1\r\n" + 
			"20 20 13 11 13\r\n" + 
			"0 0 0 1 4 4 4 0 0 0 0 0 0 0 0 1 2 3 1 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 4 2 7 7 2 0 1 1 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 6 2 4 4 2 0 4 7 0 6 0\r\n" + 
			"0 0 0 7 5 5 3 0 0 7 5 0 5 6 4 2 6 3 1 5\r\n" + 
			"0 0 0 1 2 6 3 3 7 0 3 6 2 4 5 6 7 7 5 7\r\n" + 
			"0 0 0 3 7 6 1 5 3 3 4 5 7 6 0 4 3 3 1 1\r\n" + 
			"0 1 2 1 5 6 1 6 1 6 5 1 6 0 0 3 4 1 7 6\r\n" + 
			"0 2 3 2 2 7 3 0 0 3 2 5 2 1 0 6 5 1 6 5\r\n" + 
			"0 2 5 7 0 7 1 3 3 4 1 3 3 0 2 3 3 2 4 1\r\n" + 
			"4 0 0 7 2 4 2 2 1 3 1 6 5 5 6 2 5 1 1 6\r\n" + 
			"5 6 4 0 3 6 5 2 2 6 1 2 0 1 7 5 7 2 2 2\r\n" + 
			"1 6 3 1 4 4 1 0 3 0 4 2 7 2 0 2 3 6 2 5\r\n" + 
			"1 5 7 2 1 1 4 4 2 1 0 2 7 1 6 2 6 6 2 2\r\n" + 
			"3 7 0 6 5 0 4 0 6 6 7 1 3 1 1 1 5 1 6 6\r\n" + 
			"0 4 0 1 6 2 1 0 7 0 4 2 5 2 7 0 2 7 1 6\r\n" + 
			"0 7 3 0 1 7 6 2 0 0 4 2 4 1 3 3 7 0 1 3\r\n" + 
			"0 1 1 4 3 7 4 5 2 2 4 7 4 7 7 4 6 0 1 6\r\n" + 
			"0 5 2 2 1 4 6 3 7 0 6 3 5 0 0 6 4 4 2 1\r\n" + 
			"0 1 2 4 5 6 0 2 0 0 5 6 2 4 6 4 7 6 3 7\r\n" + 
			"7 7 4 2 3 0 0 4 0 0 7 2 7 5 6 1 4 5 5 4\r\n" + 
			"50 50 20 12 18\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 4 5 0 0 0 0 0 4 2 0 5 2 1 5 3 3 0 0 4 0 5 1 7 2 6 0 7 0 0 0 2 0 0 0 0 0 0 0\r\n" + 
			"6 7 0 0 0 0 0 0 0 0 0 0 4 5 5 3 6 3 0 2 3 3 0 0 5 6 1 5 3 4 7 6 2 2 1 1 6 5 6 4 6 2 0 0 0 0 2 3 1 0\r\n" + 
			"0 2 6 5 7 6 0 0 0 0 0 0 6 2 0 5 6 2 0 4 1 5 0 0 2 0 7 7 0 6 0 6 2 2 4 1 2 2 1 6 6 6 0 2 2 5 0 6 5 0\r\n" + 
			"0 0 0 4 7 2 7 3 7 0 0 0 0 6 7 6 5 1 1 1 2 2 1 3 1 2 7 6 1 2 1 2 4 1 6 1 1 7 3 1 6 6 6 1 1 1 7 0 0 0\r\n" + 
			"0 0 0 5 4 0 6 3 3 7 0 0 0 6 4 3 2 5 3 1 6 1 0 4 1 0 5 7 6 3 1 1 3 6 1 1 6 3 6 7 3 3 6 5 0 7 2 2 4 6\r\n" + 
			"0 6 0 7 6 0 7 4 0 5 3 0 4 3 2 0 5 7 3 0 1 3 6 7 7 5 1 7 5 2 0 5 3 1 3 7 1 1 1 5 2 5 1 3 6 7 7 6 4 3\r\n" + 
			"5 2 0 2 6 5 0 5 6 1 6 5 5 1 7 1 2 3 6 5 1 6 7 7 6 4 1 7 5 2 0 1 3 4 6 4 5 7 2 6 5 6 2 5 6 5 6 5 1 6\r\n" + 
			"1 2 0 7 0 5 5 0 7 6 2 2 1 3 5 5 3 6 3 7 6 4 1 3 1 3 7 0 3 7 0 2 5 6 1 3 4 1 5 1 7 4 1 7 7 0 4 7 5 5\r\n" + 
			"7 6 0 3 5 1 4 0 5 2 5 0 1 3 5 5 4 4 6 1 6 5 7 6 2 1 6 5 5 3 0 5 7 1 1 3 6 2 2 2 4 5 7 4 5 1 1 0 7 3\r\n" + 
			"2 5 4 0 3 1 4 5 6 3 7 0 4 5 3 6 4 5 1 7 4 7 3 1 1 7 7 1 1 5 6 4 7 1 2 6 4 1 7 2 7 1 6 0 5 0 0 0 1 0\r\n" + 
			"3 0 2 5 1 7 1 1 1 6 5 1 3 1 3 1 1 7 1 3 6 5 5 3 1 3 1 6 2 3 2 6 6 1 1 7 5 7 5 7 1 6 0 3 5 1 5 3 0 0\r\n" + 
			"0 0 3 2 0 1 4 1 4 1 0 7 3 2 2 4 2 4 4 6 1 1 1 7 2 4 7 4 3 6 3 5 1 6 1 3 7 7 2 6 3 2 1 0 4 6 2 6 3 0\r\n" + 
			"0 0 5 4 7 2 4 6 4 1 6 7 2 2 1 6 2 1 5 4 7 2 2 1 0 7 6 1 7 2 5 7 0 4 1 6 4 0 3 0 0 5 5 0 7 7 0 3 0 0\r\n" + 
			"0 0 6 4 3 1 3 1 4 7 2 1 2 4 3 4 1 6 2 1 5 1 1 6 0 7 2 7 2 4 7 4 0 3 7 7 3 3 5 2 0 4 3 0 4 2 0 1 3 5\r\n" + 
			"0 1 0 5 6 4 4 6 5 7 0 6 1 4 5 6 2 1 2 4 4 1 1 2 6 1 6 2 0 3 7 3 0 0 5 1 7 6 6 6 1 3 4 2 1 0 7 0 5 5\r\n" + 
			"0 7 2 1 4 2 7 3 0 2 1 4 3 5 1 1 1 1 7 1 4 4 1 7 6 0 1 2 0 5 2 0 0 0 5 4 0 3 7 5 3 1 4 1 2 7 2 6 6 4\r\n" + 
			"0 1 3 0 3 4 6 3 4 2 4 0 7 5 1 1 2 7 1 6 4 2 2 0 5 6 3 3 1 1 0 0 0 3 0 4 5 4 3 1 1 6 1 6 2 0 1 4 7 7\r\n" + 
			"0 3 0 0 2 6 1 4 7 5 1 4 3 2 5 1 4 3 6 3 0 2 4 5 7 5 6 2 0 5 6 3 6 4 6 2 0 0 6 0 7 2 2 6 0 0 0 0 0 0\r\n" + 
			"0 6 7 1 6 4 3 6 0 2 6 7 6 2 1 6 6 6 2 0 0 7 3 0 1 1 2 0 0 0 3 1 6 7 5 6 4 1 7 5 2 0 2 6 0 0 0 0 4 0\r\n" + 
			"0 6 7 7 3 3 0 2 0 1 6 4 1 1 1 6 2 3 3 4 2 3 5 0 5 7 7 6 2 7 2 7 3 1 0 5 6 7 1 6 4 1 5 0 0 0 0 0 0 0\r\n" + 
			"0 7 3 0 4 3 0 0 6 6 0 5 1 1 1 1 1 6 0 0 7 0 0 0 2 4 3 2 3 3 6 0 0 1 0 2 6 7 3 4 0 3 2 4 0 0 0 0 0 7\r\n" + 
			"0 0 4 7 2 0 0 0 1 4 2 4 7 7 2 4 2 4 0 5 6 0 0 0 7 0 2 7 4 4 1 6 1 4 2 3 6 2 0 6 5 3 5 0 3 5 6 0 0 1\r\n" + 
			"0 0 7 4 7 0 3 0 4 4 6 2 4 7 0 5 7 1 3 6 5 6 6 7 3 3 6 6 4 2 0 0 3 0 4 7 2 6 4 0 6 2 4 6 7 1 7 2 7 1\r\n" + 
			"0 0 2 6 0 0 6 5 0 4 1 2 2 2 2 7 2 1 0 4 6 4 1 0 1 1 2 2 0 4 4 2 0 0 3 0 3 6 2 2 7 6 6 0 4 6 0 2 2 2\r\n" + 
			"0 0 4 4 7 1 1 1 7 3 7 6 2 3 3 0 5 0 0 6 1 2 6 3 1 7 0 4 7 4 3 6 1 5 1 0 3 7 4 0 3 0 5 6 2 0 0 3 0 5\r\n" + 
			"0 0 7 3 0 5 4 0 7 4 0 0 4 5 7 1 3 2 3 3 5 3 5 3 5 5 5 5 4 2 3 6 0 3 1 7 2 4 5 3 0 0 5 3 6 0 0 7 3 6\r\n" + 
			"0 0 3 5 0 0 1 1 1 0 0 0 5 3 5 5 1 2 7 0 4 3 1 6 7 1 5 7 4 4 5 7 0 3 6 3 3 7 7 4 1 3 5 2 0 0 0 7 7 4\r\n" + 
			"0 0 7 6 3 5 0 7 2 7 7 5 4 0 0 7 0 4 0 0 3 2 3 1 5 7 4 6 0 3 5 5 2 0 6 0 0 0 2 1 1 4 3 6 2 0 5 1 1 6\r\n" + 
			"0 0 1 0 4 1 0 2 5 0 0 0 6 7 3 7 0 0 0 0 4 3 3 3 0 1 0 0 0 1 5 1 5 4 5 1 7 0 0 5 0 5 6 0 3 2 5 0 3 4\r\n" + 
			"0 0 0 0 0 4 0 2 3 1 6 6 6 3 5 3 6 0 0 0 4 7 0 6 1 7 1 0 0 5 5 2 5 1 0 1 1 3 3 4 1 4 2 0 6 3 0 0 6 4\r\n" + 
			"6 4 2 2 0 0 0 3 3 0 0 1 4 0 5 0 2 0 7 0 1 7 7 1 5 7 0 0 0 3 1 5 5 6 0 6 2 6 4 0 7 6 5 1 3 3 7 0 2 5\r\n" + 
			"0 0 0 7 7 0 0 4 4 3 1 6 1 0 1 3 3 1 4 5 7 3 7 0 0 4 0 0 0 7 3 7 2 2 0 1 5 0 7 5 5 2 5 1 0 2 0 0 3 2\r\n" + 
			"0 0 0 3 0 0 0 0 1 2 6 7 1 6 7 0 3 5 2 7 3 0 4 5 2 0 0 0 0 2 5 7 3 7 5 6 0 0 2 2 5 4 7 6 4 5 1 4 4 6\r\n" + 
			"0 4 3 0 0 0 0 3 5 6 3 2 0 3 6 0 6 0 0 1 4 3 6 2 4 7 4 7 1 5 0 4 0 0 2 0 0 0 3 7 6 1 2 5 3 5 2 3 3 3\r\n" + 
			"0 0 0 1 4 0 0 2 1 0 2 0 0 1 7 3 4 3 3 4 7 0 6 7 4 7 3 1 6 1 7 3 4 4 7 5 2 1 3 7 2 5 2 3 3 2 3 0 1 2\r\n" + 
			"0 0 0 0 1 1 0 0 5 7 3 6 6 0 0 6 5 4 2 7 0 0 4 5 5 0 5 7 3 3 0 3 5 5 3 6 0 0 3 5 4 0 0 7 5 1 6 0 0 7\r\n" + 
			"0 0 0 0 5 6 3 1 5 2 0 7 7 7 0 0 1 0 3 6 4 1 6 7 2 1 6 5 2 0 0 7 4 5 0 0 0 0 0 6 6 0 0 5 6 0 2 3 4 5\r\n" + 
			"0 0 7 1 0 1 6 5 6 0 0 5 4 5 7 1 1 6 5 2 2 0 3 7 4 5 2 6 4 0 0 3 4 0 0 0 0 0 0 7 7 7 7 6 4 3 4 4 0 0\r\n" + 
			"0 0 0 1 3 0 0 3 7 1 1 0 4 1 4 4 2 6 1 6 2 2 7 4 2 4 1 7 1 6 4 3 3 1 3 4 0 0 3 2 0 2 0 1 3 3 4 7 1 5\r\n" + 
			"0 0 0 3 4 0 0 2 0 5 5 0 0 1 4 4 0 4 0 1 6 6 4 2 1 0 0 3 7 0 4 3 3 2 3 5 3 5 0 4 0 5 0 3 0 7 7 3 5 6\r\n" + 
			"0 0 0 7 2 0 0 4 2 2 6 2 2 5 0 5 0 3 4 3 5 5 2 0 4 0 0 5 0 0 4 1 6 4 4 3 4 0 0 5 0 1 1 2 0 7 3 4 0 4\r\n" + 
			"0 0 1 1 4 4 1 0 0 0 3 5 4 5 4 2 7 4 6 1 6 7 0 3 0 7 1 7 6 6 3 0 5 7 6 6 4 7 3 4 5 0 0 0 0 6 1 1 5 3\r\n" + 
			"0 0 4 2 5 7 4 4 2 1 2 1 3 4 7 2 7 2 1 6 3 3 0 7 5 6 6 4 5 5 3 3 2 7 5 3 1 4 7 0 0 0 0 0 0 3 1 5 6 5\r\n" + 
			"0 0 0 4 4 1 0 0 6 0 0 7 5 7 5 1 7 3 6 0 2 4 3 4 7 7 3 0 0 0 1 5 5 0 6 7 7 7 4 4 3 6 3 7 5 0 1 1 0 2\r\n" + 
			"0 0 0 1 3 4 7 2 5 0 0 4 4 0 5 2 2 0 1 7 0 1 1 3 6 5 2 6 2 7 7 3 6 7 1 3 4 6 7 5 3 7 4 6 0 0 0 4 3 1\r\n" + 
			"0 0 0 2 1 6 3 5 4 0 0 6 0 0 6 7 0 0 5 2 0 7 7 0 7 0 0 7 7 6 0 0 1 1 0 1 0 1 3 1 0 0 4 7 7 0 0 0 2 6\r\n" + 
			"0 0 0 2 4 0 6 7 2 4 1 5 6 3 0 0 0 0 4 2 7 1 1 5 2 0 0 7 2 2 3 1 3 5 5 7 7 4 0 3 4 2 3 0 0 4 6 6 0 1\r\n" + 
			"0 0 0 4 6 1 0 3 6 4 7 3 5 0 0 0 0 0 0 7 0 0 3 6 2 1 0 2 3 4 6 7 5 0 7 0 5 4 5 1 5 0 0 0 0 4 5 3 1 0\r\n" + 
			"1 3 6 5 5 2 3 7 6 1 0 6 7 3 2 5 6 7 6 6 0 0 7 1 0 5 5 0 3 0 2 0 7 4 5 3 2 5 1 5 3 0 0 0 1 2 0 1 0 0\r\n" + 
			"1 7 3 0 2 0 7 0 4 6 1 1 5 0 7 0 5 7 7 2 6 0 0 1 0 2 3 3 4 2 7 5 3 7 0 0 4 6 6 6 3 0 0 0 7 7 7 5 7 2"; 
}
