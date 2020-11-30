package SW역량테스트_1013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17822_원판돌리기 {
	
	/**
	 * 회전
	 * 인접한 수가 같은 것을 찾기
	 * -> 같은 행이나 같은 열 바로 옆에 있을 경우 인접하다.
	 * -> %M
	 * 
	 * 없는 경우, 적힌 수의 평균을 구하고, 평균보다 큰 수는 1을 빼고, 작은 경우 1을 더한다.
	 * 사방 탐색으로 인접한 수를 찾으면 된다.
	 * 
	 */
	static class POS{
		int r,c;

		public POS(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "POS [r=" + r + ", c=" + c + "]";
		}
		
	}
	
	static int[][] board;
	static int N, M, T;
	// 위, 오른, 아래, 왼
	static int[] dirR = {-1,0,1,0};
	static int[] dirC = {0,1,0,-1};
	static int ret = 0;
	static boolean isChange = false;
	static boolean[][] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		T = Integer.parseInt(tokens.nextToken());
		
		board = new int[N][M];
		visit = new boolean[N][M];
		
		for(int r=0; r<N; r++) {
			tokens = new StringTokenizer(br.readLine());
			for(int c=0; c<M; c++) {
				board[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		
//		for(int[] a: board) {
//			System.out.println(Arrays.toString(a));
//		}
		
		for(int rot=0; rot<T; rot++) {
			tokens = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(tokens.nextToken());
			int d = Integer.parseInt(tokens.nextToken());
			int k = Integer.parseInt(tokens.nextToken());

			// 회전
			rotate(x,d,k);
			
			// 인접한 부분 찾기
			findNear();
		}
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				ret += board[r][c];
			}
		}
		System.out.println(ret);
	}
	

	private static void rotate(int x, int d, int k) {
		
//		for(int[] a: board) {
//			System.out.println(Arrays.toString(a));
//		}
		for(int r=0; r<N; r++) {
			if((r+1)%x == 0) {
				// 시계, 반시계
				if( d == 0) {
					for(int i=0; i<k; i++) {
						int tmp = board[r][M-1];
						for(int c=M-1; c>0; c--) {
							board[r][c] = board[r][c-1];
						}
						board[r][0] = tmp; 
					}
				}else if( d == 1) {
					for(int i=0; i<k; i++) {
						int tmp = board[r][0];
						for(int c=0; c<M-1; c++) {
							board[r][c] = board[r][c+1];
						}
						board[r][M-1] = tmp;
					}
				}
			}
		}
//		System.out.println();
//		System.out.println("회전");
//		for(int[] a: board) {
//			System.out.println(Arrays.toString(a));
//		}
		
		
	}

	private static void findNear() {
	
		isChange = false;
		visit = new boolean[N][M];
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				int target = board[r][c];
				if(target != 0 ) {
					visit[r][c] = true;
					DFS(r,c, target);
					
				}
			}
		}
		
//		System.out.println();
//		System.out.println("삭제");
//		for(int[] a: board) {
//			System.out.println(Arrays.toString(a));
//		}
		
		// 변화 없음.
		if(!isChange) {
			// 평균
			int tot = 0;
			int cnt = 0;
			float avg =0;
			for(int r=0; r<N; r++) {
				for(int c=0; c<M; c++) {
					tot += board[r][c];
					if(board[r][c] != 0 ) cnt ++;
				}
			}
			avg = ((float)tot / (float)cnt);
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<M; c++) {
					if(board[r][c] > avg) {
						board[r][c]--;
					}else if(board[r][c] < avg && board[r][c] !=0) {
						board[r][c]++;
					}
				}
			}
		}
		
//		for(int[] a: board) {
//			System.out.println(Arrays.toString(a));
//		}
		
	}
	
	
	


	private static void DFS(int r, int c, int target) {
		for(int d=0; d<4; d++) {
			int nr = (r + dirR[d]);
			int nc = (c + dirC[d]+M)%M;
			
			if(isOut(nr,nc)) continue;;
			
			if( target == board[nr][nc] && !visit[nr][nc]) {
				board[r][c] = 0;
				board[nr][nc] =0;
				visit[nr][nc] = true;
				isChange = true;
				DFS(nr,nc, target);
				
			}
			
			
		}
		
		
	}


	private static boolean isOut(int nr, int nc) {
		return 0>nr || 0>nc || nr >=N || nc >= M;
	}



	static String src = "4 6 3\r\n" + 
			"1 2 3 4 5 6\r\n" + 
			"2 3 4 5 6 7\r\n" + 
			"3 4 5 6 7 8\r\n" + 
			"4 5 6 7 8 9\r\n" + 
			"2 1 4\r\n" + 
			"3 0 1\r\n" + 
			"2 1 2";
}
