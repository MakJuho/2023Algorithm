package 카카오인턴;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 경주로_건설_BFS {
	static int[][] board = {{0,0,1,0},
			 {0,0,0,0},
			 {0,1,0,1},
			 {1,0,0,0}};
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int n = board.length;
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) {
		
		Queue<Pos> q = new LinkedList<>();
		
		q.add(new Pos(0,0,0,-1));
		board[0][0] = 1;
		while(!q.isEmpty()){
			
			Pos tmp = q.poll();
		
			if(tmp.r == n-1 && tmp.c == n-1) {
				answer = Math.min(answer, tmp.money);
				continue;
			}
			
			for(int dir=0; dir<4; dir++) {
				int nr = tmp.r+dr[dir];
				int nc = tmp.c+dc[dir];
				
				if(isIn(nr,nc) && board[nr][nc] != 1) {
					// money
					int new_cost =0;
					if(tmp.dir == -1 || tmp.dir == dir ) {
						new_cost = tmp.money+ 100;
					}else if(tmp.dir != dir) {
						new_cost = tmp.money+ 600;
					}
					
					
					
					if(board[nr][nc] == 0 ) {
						board[nr][nc] = new_cost;
						q.add(new Pos(nr,nc, new_cost, dir));
					}else {
						if(board[nr][nc] >= new_cost) {
							board[nr][nc] = new_cost;
							q.add(new Pos(nr,nc, new_cost, dir));
						}
					}
					
					
					
				}
				
				
			}
		
			
			
		}
		
		System.out.println(answer);
		
		
		
	}
		
		
		
	private static boolean isIn(int r, int c) {
		return 0<=r && 0<=c && r<board.length && c<board.length;
	}
	
	
	static class Pos{
		int r,c,money, dir;

		public Pos(int r, int c, int money, int dir) {
			this.r = r;
			this.c = c;
			this.money = money;
			this.dir = dir;
		}

		@Override
		public String toString() {
			return "Pos [r=" + r + ", c=" + c + ", money=" + money + ", dir=" + dir + "]";
		}

		
	}
	
}
