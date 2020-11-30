package SW역량테스트_1011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17144_미세먼지안녕 {
	
	/**
	 * 1. 미세먼지 확산
	 * 		네 방향으로 확산 ( 방향에 공기청정기가 있거나 칸이 없으면 확산이 일어나지 않는다. )
	 * 		A-(A/5)*(확산된 방향 개수)
	 * 		임시 공기 확산 2차원 배열 생성
	 * 		
	 * 2. 공기청정기 작동
	 * 		위쪽은 반시계 방향 / 아래쪽은 시계 방향
	 * 
	 */		
	static int R,C,T;
	static int[][] board;
	static int[][] dustBoard;
	static int totDust;
	static int[] dirR = {-1, 0, 1, 0};
	static int[] dirC = {0, 1, 0, -1};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		T = Integer.parseInt(tokens.nextToken());
		
		board = new int[R][C];
		
		for(int r=0; r<R; r++) {
			tokens = new StringTokenizer(br.readLine());
			for(int c=0; c<C; c++) {
				board[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
//		
//		for(int[] a: board) {
//			System.out.println(Arrays.toString(a));
//		}
		
		for(int t=0; t<T; t++) {
//		 * 1. 미세먼지 확산
//		 * 		네 방향으로 확산 ( 방향에 공기청정기가 있거나 칸이 없으면 확산이 일어나지 않는다. )
//		 * 		A-(A/5)*(확산된 방향 개수)
			diffusion();
			
//		 * 2. 공기청정기 작동
//		 * 		위쪽은 반시계 방향 / 아래쪽은 시계 방향
			working();
			
		}
		
		countDust();
		
		System.out.println(totDust);
		
		
	}
	
	private static void countDust() {
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				totDust += board[r][c];
			}
		}
		totDust+=2;
	}

	private static void working() {

		int upPos=-1;
		int downPos=-1;
		
//		System.out.println();
//		for(int[] a: board) {
//			System.out.println(Arrays.toString(a));
//		}
		
		for(int r=0; r<R; r++) {
			if(board[r][0] == -1) {
				downPos = r;
			}
		}
		upPos = downPos-1;
		// 위쪽은 반시계방향
		// 왼쪽, 위, 오른쪽, 아래 순서대로 채우기
		for(int r=upPos; r>0; r--) {
			if(board[r][0] != -1) {
				board[r][0] = board[r-1][0];
			}
		}
		
		for(int c=0; c<C-1; c++) {
			board[0][c] = board[0][c+1];
		}
		
		for(int r=0; r<upPos; r++) {
			board[r][C-1] = board[r+1][C-1];
		}
		
		for(int c=C-1; c>1; c--) {
			board[upPos][c] = board[upPos][c-1];
		}
		board[upPos][1] = 0;
		
		// 아래쪽은 시계방향
		for(int r=downPos; r<R-1 ; r++) {
			if(board[r][0] != -1) {
				board[r][0] = board[r+1][0];
			}
		}
		
		for(int c=0; c<C-1; c++) {
			board[R-1][c] = board[R-1][c+1];
		}
		
		for(int r=R-1 ; r>downPos; r--) {
			board[r][C-1] = board[r-1][C-1];
		}
		
		for(int c=C-1; c>1; c--) {
			board[downPos][c] = board[downPos][c-1];
		}
		board[downPos][1] = 0;
		
//		System.out.println();
//		for(int[] a: board) {
//			System.out.println(Arrays.toString(a));
//		}
	}

	private static void diffusion() {
		// 미세먼지 초기화
		dustBoard = new int[R][C];
		
		
		
		// dustBoard에 확산
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				if(board[r][c] > 0 ) {
					int diffDir = 0;
					for(int d=0; d<4; d++) {
						int nr = r + dirR[d];
						int nc = c + dirC[d];
						
						if(isOut(nr,nc)) continue;
						
						if(board[nr][nc] == -1) continue;
						
						diffDir ++;
						dustBoard[nr][nc] += board[r][c]/5;
						
					}
					
					// 확산되는 방향
					board[r][c] -= diffDir * (board[r][c]/5);
					
				}
			}
		}
		
		

		// board에 각 칸 더하기 
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				board[r][c] += dustBoard[r][c];
			}
		}
		
		
		
	}

	private static boolean isOut(int nr, int nc) {
		return 0 > nr || nr >= R || nc < 0 || nc >= C;
	}

	static String src = "7 6 1\r\n" + 
			"1 2 3 4 5 6\r\n" + 
			"6 5 4 3 2 1\r\n" + 
			"-1 2 3 4 5 6\r\n" + 
			"-1 6 5 4 3 2\r\n" + 
			"1 2 3 4 5 6\r\n" + 
			"6 5 4 3 2 1\r\n" + 
			"1 2 3 4 5 6";
}
