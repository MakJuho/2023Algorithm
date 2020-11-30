package SW역량테스트_1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17837_새로운게임2 {

	/**
	 * 흰색, 빨간색, 파란색
	 * 1번 ~ K번 말까지 순차적으로 이동
	 * 올려져 있는 말도 함께 이동
	 * 말이 4개 이상 쌓이면 게임 종료.
	 * 
	 * 흰색 -> 그 위에 말을 쌓는다. stack
	 * 
	 * 빨간색 -> A번말과 그 위의 말들을 순서를 바꾼다.
	 * 말이 있으면 거꾸로 쌓는다.
	 * 
	 * 파란색 -> A번 말과 반대 방향으로 한칸 이동/ 반대 방향도 파란색 바닥이면 가만히 유지
	 * 
	 * 체스판을 벗어나면 파란색과 같은 경우
	 * 
	 * 1000번 턴에도 게임이 종료되지 않을 경우 -1
	 */
	
	static int N, K;
	static int[][] color;
	static int[][][] board;
//	→, ←, ↑, ↓
	static int[] dirR = {0, 0, -1, 1};
	static int[] dirC = {1, -1, 0, 0};
	static POS[] horse;
	static int ret = Integer.MAX_VALUE;
	
	static class POS{
		int r,c, dir;

		public POS(int r, int c, int dir) {
			this.r = r;
			this.c = c;
			this.dir = dir;
		}

		@Override
		public String toString() {
			return "POS [r=" + r + ", c=" + c + ", dir=" + dir + "]";
		}

		
		
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		
		/**
		 * [0] 현재 위치 말의 개수
		 * [1] POS 배열의 인덱스
		 * [2] POS 배열의 인덱스
		 * [3] POS 배열의 인덱스
		 */
		
		color = new int[N][N];
		board = new int[N][N][5];
		
		
		for(int r=0; r<N; r++) {
			tokens = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				color[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		
//		for(int[] a: color) {
//			System.out.println(Arrays.toString(a));
//		}
		
		horse = new POS[K];
		
		for(int i=0; i<K; i++) {
			tokens = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			int c = Integer.parseInt(tokens.nextToken());
			a--; 
			b--; 
			c--;
			horse[i] = new POS(a,b,c);
			int size = board[a][b][0];
			board[a][b][++size] = i;
			
		}
		
		
		int loop =0, ret = -1;
		while(loop <= 1000 && ret == -1) {
			loop++;
			for(int i=0; i<K; i++) {
				int h = turn(i);
				if(h >= 4) {
					ret = loop;
					break;
				}
			}
			
		}
		
		System.out.println(ret);
		
	}
	private static int turn(int idx) {

		POS cur = horse[idx];
//		POS next = new POS(0,0,0);
		int nr = cur.r + dirR[cur.dir];
		int nc  = cur.c + dirC[cur.dir];
		int ndir = cur.dir;
		
		if(isOut(nr,nc) || color[nr][nc] == 2) {
			ndir = (cur.dir == 0 || cur.dir ==2) ? (cur.dir+1) : (cur.dir-1);
			nr = cur.r + dirR[ndir];
			nc = cur.c + dirC[ndir];
			horse[idx].dir = ndir;
			if(isOut(nr,nc) || color[nr][nc] == 2) {
				return board[cur.r][cur.c][0];
			}
		
		}
		
		
		int bottom = -1;
		int cur_size = board[cur.r][cur.c][0];
		for(int i=1; i <= cur_size; i++) {
			if(board[cur.r][cur.c][i] == idx) {
				bottom = i;
				break;
			}
		}
		
		
		int[] move = new int[5];
		int move_size = move[0];
		
		
		
		
		
		
		
		
		return 0;
	}
	private static boolean isOut(int nr, int nc) {
		return 0>nr || nr >=N || 0>nc || nc >=N;
	}
	static String src = "4 4\r\n" + 
			"0 0 2 0\r\n" + 
			"0 0 1 0\r\n" + 
			"0 0 1 2\r\n" + 
			"0 2 0 0\r\n" + 
			"2 1 1\r\n" + 
			"3 2 3\r\n" + 
			"2 2 1\r\n" + 
			"4 1 2";
}
