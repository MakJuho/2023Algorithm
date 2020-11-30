package SW역량테스트_1015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17143_낚시왕 {
	/**
	 * 
	 * 
	 */
	
	static class SHARK{
		int r,c, speed, dir, size, time;

		@Override
		public String toString() {
			return "SHARK [r=" + r + ", c=" + c + ", speed=" + speed + ", dir=" + dir + ", size=" + size + ", time="
					+ time + "]";
		}

		public SHARK(int r, int c, int speed, int dir, int size, int time) {
			this.r = r;
			this.c = c;
			this.speed = speed;
			this.dir = dir;
			this.size = size;
			this.time = time;
		}

		
	
	}
	
	static int[][] board;
	static int R, C, M;
	static SHARK[] sharks;
	// 위, 아래, 오른쪽, 왼쪽
	static int[] dirR = {-1, 1, 0, 0};
	static int[] dirC = {0, 0, 1, -1};
	static int ret=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		board = new int[R+1][C+1];
		sharks = new SHARK[100001];
		
		
		// 맨 윗줄은 낚시왕 자리
		for(int cnt=1; cnt<=M; cnt++) {
			tokens = new StringTokenizer(br.readLine());
			int sr = Integer.parseInt(tokens.nextToken());
			int sc = Integer.parseInt(tokens.nextToken());
			int ss = Integer.parseInt(tokens.nextToken());
			int sd = Integer.parseInt(tokens.nextToken())-1;
			int sz = Integer.parseInt(tokens.nextToken());
			
			board[sr][sc] = sz;
			
			sharks[sz] = new SHARK(sr,sc,ss,sd,sz, 0); 
			
				
		}
		
//		System.out.println("초기");
//		for(int[] a: board) {
//			System.out.println(Arrays.toString(a));
//		}
		
//		System.out.println(Arrays.toString(sharks));
		
		// 낚시왕 오른쪽으로 한칸 이동
		for(int c=1; c<=C; c++) {
			board[0][c-1] = 0;
			board[0][c] = -1; // 낚시왕 위치
			
			
			// 낚시왕과 가장 가까운 상어 사냥
			huntShark(c);
			
			// 상어가 이동
			moveShark();
		
//			System.out.println();
//			for(int[] a: board) {
//				System.out.println(Arrays.toString(a));
//			}
//			System.out.println();
		}
		
		System.out.println(ret);
		
		
		
	}
	


	private static void moveShark() {
		Queue<SHARK> q = new LinkedList<>();
		
		for(SHARK sh: sharks) {
			if(sh != null) {
				q.add(sh);
				
			}
		}
		int now_time =-1;

		if(!q.isEmpty()) {
			now_time = q.peek().time;
		}
		while(!q.isEmpty()) {
			
		
			SHARK cur = q.poll();
			
			if(cur.time == now_time+1) {
				q.add(cur);
				break;
			}
			
			int cur_r = cur.r;
			int cur_c = cur.c;
			int cur_dir = cur.dir;
			
			
			if(cur.speed == 0) {
				q.add(new SHARK(cur_r,cur_c,cur.speed,cur_dir,cur.size, cur.time+1));
			}else {
				// 직접 카운트해서 구현으로 한다.
				// 오른쪽, 왼쪽 움직임
				if(dirR[cur.dir] == 0 ) {
					
					
					// 총 움직일 거리
					int cnt = 0;
					
					int nr=-1;
					int nc=-1;
					int ndir=-1;
					// 한칸 씩 움직이기
					while(Math.abs(cur.speed*dirC[cur.dir]) != cnt) {
						
						// 방향으로 이동
						nr = cur_r + dirR[cur_dir];
						nc = cur_c + dirC[cur_dir];
						ndir = cur_dir;
						
						// 만약 밖으로 초과했으면 숫자를 세지 않는다.
						if(isOut(nr,nc)) {
							if(ndir == 0 ) ndir =1;
							else if(ndir == 1) ndir = 0;
							else if(ndir == 2) ndir = 3;
							else if(ndir == 3) ndir = 2;
							cur_dir = ndir;
							continue;
						}
						
						cur_r = nr;
						cur_c = nc;
						
						cnt++;
						
					}
					
					q.add(new SHARK(nr,nc,cur.speed,ndir,cur.size, cur.time+1));
					
				}else {
					// 위, 아래로 움직임
					
					// 총 움직일 거리
					int cnt = 0;
					int nr=-1;
					int nc=-1;
					int ndir=-1;
					// 한칸 씩 움직이기
					while(Math.abs(cur.speed*dirR[cur.dir]) != cnt) {
						
						// 방향으로 이동
						nr = cur_r + dirR[cur_dir];
						nc = cur_c + dirC[cur_dir];
						ndir = cur_dir;
						
						// 만약 밖으로 초과했으면 숫자를 세지 않는다.
						if(isOut(nr,nc)) {
							if(ndir == 0 ) ndir =1;
							else if(ndir == 1) ndir = 0;
							else if(ndir == 2) ndir = 3;
							else if(ndir == 3) ndir = 2;
							cur_dir = ndir;
							continue;
						}
						
						cur_r = nr;
						cur_c = nc;
						
						cnt++;
						
					}
					
					q.add(new SHARK(nr,nc,cur.speed,ndir,cur.size, cur.time+1));
				}
				
			}
		
		}
		
		board = new int[R+1][C+1];
		
		
		for(SHARK sh : q) {
			sharks[sh.size] = new SHARK(sh.r,sh.c,sh.speed,sh.dir,sh.size, sh.time); 
			if(sh.size == 0) {
				continue;
			}
			if(board[sh.r][sh.c] != 0) {
				
				if(board[sh.r][sh.c] < sh.size) {
					sharks[board[sh.r][sh.c]] = new SHARK(0,0,0,0,0,sh.time);
					board[sh.r][sh.c] = sh.size;
				}
				
			}else {
				board[sh.r][sh.c] = sh.size;
			}
		}

	}



	private static boolean isOut(int nr, int nc) {
		return 1>nr || 1>nc || nr>R || nc>C;
	}



	private static void huntShark(int fisher) {
		for(int r=1; r<=R; r++) {
			if(board[r][fisher] != 0) {
				ret += board[r][fisher];
				sharks[board[r][fisher]] = new SHARK(0,0,0,0,0,0); 
				board[r][fisher] = 0;
				return ;
			}
		}
	}



	static String src ="2 2 4\r\n" + 
			"1 1 1 1 1\r\n" + 
			"2 2 2 2 2\r\n" + 
			"1 2 1 2 3\r\n" + 
			"2 1 2 1 4";
	
	
}
