package SW역량테스트_1011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_19236_청소년상어try1 {
	/**
	 * 각 물고기는 번호와 방향을 가지고 있다.
	 * 
	 * 번호는 1 ~ 16, 방향은 8가지
	 * 
	 * 상어는 (0, 0)에 있는 물고기를 먹고 방향을 갖는다.
	 * 
	 * 물고기가 작은 순서대로 이동한다. ( 큐에 넣어서 관리하면 좋을 듯..)
	 * 물고기는 빈칸이나 다른 물고기는 이동 가능하나, 상어가 있으면 이동이 불가능.
	 * 이동할 수 있을 때까지 45도 씩 방향을 전환시킨다.
	 * 이동할 수 있는 칸이 없으면 이동하지 않는다.
	 * 이동할 때는 물고기의 방향과 위치 같이 변경해야한다.
	 * 
	 * 상어 이동
	 * 방향으로 1~3칸중 하나의 칸으로 이동한다.
	 * 
	 * 상어가 먹을 수 있는 물고기 번호의 최대값은??
	 * 
	 */
	static class FISH{
		int r,c, dir;

		@Override
		public String toString() {
			return "FISH [r=" + r + ", c=" + c + ", dir=" + dir + "]";
		}

		public FISH(int r, int c, int dir) {
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
		
		
		
	}
	
	
	static int[] dirR = {-1, -1, 0, +1, +1, +1, 0, -1};
	static int[] dirC = {0, -1, -1, -1, 0, +1, +1, +1};
	
	static int ret;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		FISH[] fish = new FISH[16];
		int[][] board = new int[4][4];
		
		StringTokenizer tokens;
		for(int r=0; r<4; r++) {
			tokens = new StringTokenizer(br.readLine());
			for(int c=0; c<4; c++) {
				int a = Integer.parseInt(tokens.nextToken())-1;
				int b = Integer.parseInt(tokens.nextToken())-1;
				
				fish[a] = new FISH(r,c,b);
				
				board[r][c] =a;
			}
		}
//		System.out.println(Arrays.toString(fish));
		
		ret = 0;
		
		solve(board, fish, 0, 0, 0);
		
		System.out.println(ret);
		
		
	}
	private static void solve(int[][] board, FISH[] fish, int shark_r, int shark_c, int sum) {
		
		// 되돌릴 수 있도록 복사해서 사용하기
		int[][] candi_board= new int[4][4];
		FISH[] candi_fish = new FISH[16];
		
		for(int r=0; r<4; r++) {
			for(int c=0; c<4; c++) {
				candi_board[r][c] = board[r][c];
			}
		}
		
		for(int i=0; i<16; i++) {
			candi_fish[i] = fish[i];
		}
		
		
		// eat물고기를 상어가 잡아먹는다.
		int fish_number = candi_board[shark_r][shark_c];
		int shark_dir = candi_fish[fish_number].dir;
		// 죽은 물고기
		candi_fish[fish_number] = new FISH(-1,-1,-1);
		candi_board[shark_r][shark_c] = -1;
		
		sum += fish_number+1;
		
		
		
		if( ret < sum) {
			ret = sum;
		}
		
		// fish move
		for(int f=0; f<16; f++) {
			if(candi_fish[f].r == -1) {
				continue;
			}
			
			int cr = candi_fish[f].r;
			int cc = candi_fish[f].c;
			int cdir = candi_fish[f].dir;
			
			int nr = cr + dirR[cdir];
			int nc = cc + dirC[cdir];
			int ndir = cdir;
			
			while(isOut(nr,nc) || (nr== shark_r && nc == shark_c)) {
				ndir = (ndir+1) % 8;
				nr = cr + dirR[ndir];
				nc = cc + dirC[ndir];
			}
			
			// 물고기가 있는 경우
			if(candi_board[nr][nc] != -1) {
				int target = candi_board[nr][nc];
				// 타겟 위치에 현재 위치를 바꾼다.
				candi_fish[target].r = cr;
				candi_fish[target].c = cc;
				
				// 현재 위치에 후보 물고기 이동
				candi_fish[f].r = nr;
				candi_fish[f].c = nc;
				candi_fish[f].dir = ndir;
				
				candi_board[nr][nc] = f;
				candi_board[cr][cc] = target;
				
				
			}else {
				candi_fish[f].r = nr;
				candi_fish[f].c = nc;
				candi_fish[f].dir = ndir;
				
				candi_board[nr][nc] = f;
				candi_board[cr][cc] = -1;
			}
			
			
		}
		
		
		// shark move
		for(int step =1; step<4; step++) {
			int nr = shark_r + dirR[shark_dir]*step;
			int nc = shark_c + dirC[shark_dir]*step;
			
			if(isOut(nr,nc)) {
				break;
			}
			
			if(candi_board[nr][nc] == -1) {
				solve(candi_board, candi_fish, nr, nc, sum);
			}
			
		}
		
		
		
	}
	
	private static boolean isOut(int nr, int nc) {
		return 0>nr || nr>=4 || 0>nc || nc>=4;
	}
	
	static String src = "7 6 2 3 15 6 9 8\r\n" + 
			"3 1 1 8 14 7 10 1\r\n" + 
			"6 1 13 6 4 3 11 4\r\n" + 
			"16 1 8 7 5 2 12 2";
	
	
}
