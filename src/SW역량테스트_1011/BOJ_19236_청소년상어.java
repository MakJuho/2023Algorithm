package SW역량테스트_1011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_19236_청소년상어 {

	/**
	 * 
	 * 청소년 상어가 (0,0) 물고기를 먹고 방향을 가진다.
	 * 
	 * 물고기 이동
	 * 물고기가 작은 번호 순서대로 이동한다.
	 * 상어가 있거나 경계는 이동할 수 없다.
	 * 방향 45도씩 반시계 회전( 이동할 수 있을 때까지)/ 이동할 수 있는 칸이 없으면 이동하지 않는다.
	 * 서로 위치를 바꾸는 식으로 이동
	 * 
	 * 상어 이동
	 * 여러 칸 이동 가능 / 물고기 없는 칸은 이동할 수 없다.
	 * DFS
	 * 한칸 움직였을 때 , 두칸 움직였을 때, 세칸 움직였을때
	 * 
	 */
	static class FISH{
		int r, c, dir;

		public FISH(int r, int c, int dir) {
			this.r = r;
			this.c = c;
			this.dir = dir;
		}

		@Override
		public String toString() {
			return "FISH [r=" + r + ", c=" + c + ", dir=" + dir + "]";
		}
		
		
	}
	
//	 ↑(1), ↖(2), ←(3), ↙(4), ↓(5), ↘(6), →(7), ↗(8)

	static int[] dirR = {-1, -1, 0, +1, +1, +1, 0, -1 };
	static int[] dirC = {0,-1, -1, -1, 0, +1, +1, +1};

	static int ret;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));

		StringTokenizer tokens;
		int[][] board = new int[4][4];
		FISH[] fish = new FISH[16];
		
		for(int r=0; r<4; r++) {
			tokens = new StringTokenizer(br.readLine());
			for(int c=0; c<4; c++) {
				int a=  Integer.parseInt(tokens.nextToken())-1;
				int b=  Integer.parseInt(tokens.nextToken())-1;
				board[r][c] = a;
				fish[board[r][c]] = new FISH(r,c, b);
			}
		}
		
		
		ret = 0;
		
		solve(board, fish, 0, 0, 0);
		System.out.println(ret);
		
	}
	
	private static void solve(int[][] board, FISH[] fish, int shark_r, int shark_c, int sum) {
		
		int[][] candi_board = new int[4][4];
		FISH[] candi_fish= new FISH[16];
		
		for(int r=0; r<4; r++) {
			for(int c=0; c<4; c++) {
				candi_board[r][c] = board[r][c];
			}
		}
		
		for(int i=0; i<16; i++) {
			candi_fish[i] = fish[i];
		}
		
		
		// eat
		int fish_number = candi_board[shark_r][shark_c];
		int shark_dir = candi_fish[fish_number].dir;
		candi_fish[fish_number].r = -1;
		candi_fish[fish_number].c = -1;
		candi_fish[fish_number].dir = -1;
		candi_board[shark_r][shark_c] = -1;
		
		sum += (fish_number+1);
		if ( ret < sum) {
			ret = sum;
		}
		
		
		// fish move
		for(int f=0; f<16; f++) {
			if(candi_fish[f].r == -1) {
				continue;
			}
			int cr = candi_fish[f].r;
			int cc = candi_fish[f].c;
			int cd = candi_fish[f].dir;
			
			int nr = cr + dirR[cd];
			int nc = cc + dirC[cd];
			int nd = cd;
			
			while(isOut(nr, nc) || (nr == shark_r && nc == shark_c)) {
				nd = (nd+1)%8;
				nr = cr + dirR[nd];
				nc = cc + dirC[nd];
			}
			
			if(candi_board[nr][nc] != -1) {
				// swap
				int target = candi_board[nr][nc];
				candi_fish[target].r = cr;
				candi_fish[target].c = cc;
				
				candi_fish[f].r = nr;
				candi_fish[f].c = nc;
				candi_fish[f].dir = nd;

				candi_board[nr][nc] = f;
				candi_board[cr][cc] = target;
				
			}else {
				candi_fish[f].r = nr;
				candi_fish[f].c = nc;
				candi_fish[f].dir = nd;
				
				candi_board[nr][nc] = f;
				candi_board[cr][cc] = -1;
			}
			
			
			
		}
		
		
		
		// shark move
		for(int step=1 ; step<4; step++) {
			int nr = shark_r + dirR[shark_dir]*step;
			int nc = shark_c + dirC[shark_dir]*step;
		
			if(isOut(nr,nc)) break;
			
			if(candi_board[nr][nc] != -1) {
				solve(candi_board, candi_fish, nr, nc, sum);
			}
			
		
		}
		
	}


	private static boolean isOut(int nr, int nc) {
		return 0 > nr || 0> nc || 4<=nr || 4<=nc;
	}

	static String src = "2 6 10 8 6 7 9 4\r\n" + 
			"1 7 16 6 4 2 5 8\r\n" + 
			"3 7 8 6 7 6 14 8\r\n" + 
			"12 7 15 4 11 3 13 3";
}
