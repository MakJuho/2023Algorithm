package SW역량테스트_1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_19237_어른상어 {
	
	
	static class SHARK{
		int r, c, dir;

		public SHARK(int r, int c, int dir) {
			this.r = r;
			this.c = c;
			this.dir = dir;
		}

		@Override
		public String toString() {
			return "SHARK [r=" + r + ", c=" + c + ", dir=" + dir + "]";
		}

		
		
	}
	
	// 위, 아래, 왼쪽, 오른쪽
	static int[] dirR = {-1, +1, 0, 0};
	static int[] dirC = { 0, 0, -1, +1};
	static int[][] board;
	static int[][] blood;
	static int N, M, K;
	static SHARK[] shark;
	static int[][][] sharkDir;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		
		
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		
		board = new int[N][N];
		blood = new int[N][N];
		shark = new SHARK[M+1];
		sharkDir = new int[M+1][4][4];
		
		for(int r=0; r<N; r++) {
			tokens = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				board[r][c] = Integer.parseInt(tokens.nextToken());
				if(board[r][c] >0) {
					shark[board[r][c]] = new SHARK(r,c,-1);
				}
			}
		}
		
		for(int[] a: board) {
			System.out.println(Arrays.toString(a));
		}
		System.out.println();
		
		for(int[] a: blood) {
			System.out.println(Arrays.toString(a));
		}
		
		
		// 상어 1부터 존재.
		tokens = new StringTokenizer(br.readLine());
		for(int i=1; i<=M; i++) {
			shark[i].dir = Integer.parseInt(tokens.nextToken());
		}

		
		for(int i=0; i<M; i++) {
			for(int r=0; r<4; r++) {
				tokens = new StringTokenizer(br.readLine());
				for(int c=0; c<4; c++) {
					sharkDir[i][r][c] = Integer.parseInt(tokens.nextToken());
				}
			}
		}
		
		int time = solve();
		
		System.out.println(time);
		
		
		return ;
		
	}
	
	private static int solve() {

		// 이동을 시켜야한다.
		// 바라보고 있는 방향으로 이동을 시켜야한다.
		Queue<SHARK> q = new LinkedList<>();

		// 모든 상어들을 담기
		for(int i=1; i<=M; i++) {
			q.offer(shark[i]);
		}
		
		while(!q.isEmpty()) {
			SHARK cur = q.poll();
			
			boolean isPossible = false;
			
			// 이동 가능 여부를 확인!
			int d = 0;
			int nr=0, nc=0;
			while(!isPossible) {
				nr = cur.r+dirR[cur.dir-1];
				nc = cur.c+dirC[cur.dir-1];
				// 이동방향에 피냄새(자기와 다른)가 있을 경우
				// 벽으로 막혀있을 경우
				// 우선순위가 변경된다.
				if( (blood[nr][nc] != 0 && blood[nr][nc] != board[nr][nc]) || 
						isOut(nr,nc)) {
					d++;
					cur.dir = sharkDir[board[nr][nc]][cur.dir-1][d%4];
				}else {
					isPossible = true;
				}				
			}
			
			// 상어가 있을 경우, 더 큰 상어를 만나면 continue;
			if ( board[nr][nc] > board[cur.r][cur.c]) continue;
			
			// 상어가 있을 경우, 작은 상어가 잡아먹는다.
			if ( board[nr][nc] < board[cur.r][cur.c]) {
				board[nr][nc] = board[cur.r][cur.c];
				q.add(new SHARK(nr,nc,cur.dir));
			}
		}
		
		
		return 0;
	}

	private static boolean isOut(int nr, int nc) {
		return 0>nr || nr >= N || 0>nc || nc >= N;
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
