package 카카오인턴;

import java.util.Arrays;

public class 경주로_건설 {
	static int[][] board = {{0,0,1,0},
			 {0,0,0,0},
			 {0,1,0,1},
			 {1,0,0,0}};
	static int[] nr = {-1,0,1,0};
	static int[] nc = {0,1,0,-1};
	static boolean[][] visited;
	public static void main(String[] args) {
		
		visited = new boolean[board.length][board.length];
		
		for(int r=0; r<board.length; r++) {
			for(int c=0; c<board.length; c++) {
				if(board[r][c] == 1) visited[r][c] = false;
				else visited[r][c] = true;
			}
		}
		visited[0][0] = false;
		dfs(0,0,0); // n, r, money
		
		
	}
	private static void dfs(int r, int c, int money) {
		// 목적지 도착
		if(r == board.length-1 && c == board.length-1) {
			System.out.println(money);
			return;
		}
		
		
		for(int dir=0; dir<4; dir++) {
			// 벽인지 배열을 넘어 가는 지 체크
			int dirR = r+nr[dir];
			int dirC = c+nc[dir];
			if(isIn(dirR,dirC) && visited[dirR][dirC] == true) {
				visited[dirR][dirC] = false;
				// 위쪽으로 진행
				System.out.println(dirR + ":"+ dirC);
				dfs(dirR, dirC, 0);
				visited[dirR][dirC] = true;
			}
		}
		
		
		
	}
	private static boolean isIn(int r, int c) {
		return 0<=r && 0<=c && r<board.length && c<board.length;
	}
}
