package SW역량테스트_1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_19237_어른상어_review {

	/**
	 * 1의 번호가 가장 강력
	 * 
	 * N : 배열
	 * M : 상어 개수
	 * 
	 * 맨처음 모든 상어가 자신의 위치에 자신의 냄새를 뿌린다.
	 * 
	 * 한칸씩 이동하면서 냄새를 뿌리고, K번 이동하고 나면 사라진다.
	 * 
	 * 이동할 때는 아무 냄새 없는 인접한 칸을 찾고, 다 존재하면 자신의 냄새가 있는 방향을 찾는다.
	 * 
	 * 특정 우선순위를 따른다.
	 * 
	 * 한칸에 여러마리 상어가 존재한다면 가장 작은 번호를 가진 상어를 제외하고 모두 격자 밖으로 쫓겨난다.
	 * 
	 * 1: 위, 2: 아래, 3: 왼쪽, 4: 오른쪽
	 */
	static int[] dirR = {-1, 1, 0, 0};
	static int[] dirC = {0, 0, -1, +1};
	
	// shark의 특정 우선순위를 갖는다.
	static class SHARK{
		int r,c,dir;
		int priority[][]= new int[4][4];

		public SHARK(int r, int c, int dir, int[][] priority) {
			this.r = r;
			this.c = c;
			this.dir = dir;
			this.priority = priority;
		}
		
		@Override
		public String toString() {
			return "SHARK [r=" + r + ", c=" + c + ", dir=" + dir + ", priority=" + Arrays.toString(priority) + "]";
		}
		
	}
	
	static int N, M, K;
	/**
	 * [r][c][0] : r, c에 있는 상어의 number
	 * [r][c][1] : r, c에 있는 냄새의 상어 num
	 * [r][c][2] : r, c에 있는 냄새의 강도
	 * 
	 */
	static int[][][]board = new int[20][20][3];
	static SHARK[] shark = new SHARK[400];
	
	static int ret = -1;
	
	public static void main(String[] args) throws IOException  {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		
//		int[][] initial = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
//		for(int i=0; i<shark.length; i++) {
//			shark[i] = new SHARK(0,0,0,initial);
//		}
		
		for(int r=0; r<N; r++) {
			tokens = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				board[r][c][0] = Integer.parseInt(tokens.nextToken());
				if(board[r][c][0] != 0) {
					int shark_number = board[r][c][0] - 1;
					shark[shark_number].r = r;
					shark[shark_number].c = c;
					
					board[r][c][1] = board[r][c][0];
					board[r][c][2] = K;
				}
			}
		}
		

		tokens = new StringTokenizer(br.readLine());
		
		for(int i=0; i<M; i++) {
			shark[i].dir = Integer.parseInt(tokens.nextToken())-1;
		}
		
		for(int i=0; i<M; i++) {
			for(int d=0; d<4; d++) {
				tokens = new StringTokenizer(br.readLine());
				for(int j=0; j<4; j++) {
					shark[i].priority[d][j] =Integer.parseInt(tokens.nextToken())-1;
					
				}
			}
		}
		
		
		ret = -1;
		solve();
		System.out.println(ret);
		 
		return ;
	}
	
	private static void solve() {

		// 시간을 하나 할때마다 증가시켜주고
		// 시간이 1000초 이상 되면 종료시켜주고
		// 턴
		
		int time =0;
		int kill_shark = 0;
		while(time<= 1000) {
			++time;
			
			int[][][] new_board = new int[20][20][3];
			// 복사해서 쓴다음에 본 board에 갱신시켜준다.
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					new_board[r][c][0] = board[r][c][0];
					new_board[r][c][2] = board[r][c][2];
					if (new_board[r][c][2] > 0) {
						new_board[r][c][2] --;
					}
					
					if(new_board[r][c][2] > 0) {
						new_board[r][c][1] = new_board[r][c][1];
					}
				}
			}
			
			
			for( int i=0; i<M; i++) {
				int cr = shark[i].r;
				int cc = shark[i].c;
				int cdir = shark[i].dir;
				
				if(cr == -1) {
					continue;
				}
				
				boolean is_move = false;
				
				
				for(int d=0; d<4; d++) {
					int nd = shark[i].priority[cdir][d];
					int nr = cr + dirR[nd];
					int nc = cc + dirC[nd];
					
					if(isOut(nr,nc) || board[nr][nc][2] != 0) continue;
					
					is_move = true;
					new_board[cr][cc][0] = 0;
					if(new_board[nr][nc][0] == 0 ) {
						new_board[nr][nc][0] = i+1;
						new_board[nr][nc][1] = i+1;
						new_board[nr][nc][2] = K;
						
						
						shark[i].r = nr;
						shark[i].c = nc;
						shark[i].dir = nd;
						
					}else {
						++kill_shark;
						shark[i].r = -1;
					}
					break;
					
				}
				
				if(is_move == false) {
					for(int d=0; d<4; d++) {
						int nd = shark[i].priority[cdir][d];
						int nr = cr + dirR[nd];
						int nc = cc + dirC[nd];
						
						if(isOut(nr,nc) || board[nr][nc][2] != 0) continue;
						
						
						if(board[nr][nc][2] != 0 && board[nr][nc][1] != i+1) continue;

						new_board[cr][cc][0] = 0;
						if(new_board[nr][nc][0] == 0 ) {
							new_board[nr][nc][0] = i+1;
							new_board[nr][nc][1] = i+1;
							new_board[nr][nc][2] = K;
							
							
							shark[i].r = nr;
							shark[i].c = nc;
							shark[i].dir = nd;
							
						}else {
							++kill_shark;
							shark[i].r = -1;
						}
						break;
						
					}
				}
			}
			
			
			
			
			
			// 모든 상어가 죽었을 때
			if(kill_shark == M-1) {
				break;
			}
			
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					board[r][c][0] = new_board[r][c][0];
					board[r][c][1] = new_board[r][c][1];
					board[r][c][2] = new_board[r][c][2];
 				}
			}
			
			
		}
		
		if( time <= 1000) {
			ret = time;
		}
		
		
	}

	private static boolean isOut(int nr, int nc) {
		return nr<0 || nr>=N || nc<0 || nc>=N;
	}

	static String src = "5 4 4\r\n" + 
			"0 0 0 0 3\r\n" + 
			"0 2 0 0 0\r\n" + 
			"1 0 0 0 4\r\n" + 
			"0 0 0 0 0\r\n" + 
			"0 0 0 0 0\r\n" + 
			"4 4 3 1\r\n" + 
			"2 3 1 4\r\n" + 
			"4 1 2 3\r\n" + 
			"3 4 2 1\r\n" + 
			"4 3 1 2\r\n" + 
			"2 4 3 1\r\n" + 
			"2 1 3 4\r\n" + 
			"3 4 1 2\r\n" + 
			"4 1 2 3\r\n" + 
			"4 3 2 1\r\n" + 
			"1 4 3 2\r\n" + 
			"1 3 2 4\r\n" + 
			"3 2 1 4\r\n" + 
			"3 4 1 2\r\n" + 
			"3 2 4 1\r\n" + 
			"1 4 2 3\r\n" + 
			"1 4 2 3";
	
	
	
	
}
