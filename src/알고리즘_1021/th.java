package 알고리즘_1021;

import java.util.*;

public class th {
	static int ret = -1;
	static int[] dirR = {-1, 0, 1, 0};
	static int[] dirC = {0, 1, 0, -1};
	
	static class POS{
		int r,c,cnt;
		
		public POS(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
		
		@Override
		public String toString() {
			return "POS [r : "+ r +", c : "+c+", cnt : "+cnt+"]";
		}
		
	}
	
	public static void main(String[] args) {
		int board[][] = {{3,2,3,2},{2,1,1,2},{1,1,2,1},{4,1,1,1}};
//		int board[][] = {{4,2,3,2},{2,1,2,4},{1,2,3,1},{4,1,4,3}};
		Solution(board);
	}
	
	private static void Solution(int[][] board) {
		
		Queue<POS> q = new LinkedList<>();
		for(int r=0; r<4; r++) {
			for(int c=0; c<4; c++) {
				q.add(new POS(r,c, 1));
				boolean[][] visit = new boolean[4][4];

				
				while(!q.isEmpty()) {
					
					POS cur = q.poll();
					
					if(cur.cnt != 1 && cur.cnt>ret) {
						ret = cur.cnt;
					}
					
					for(int d=0; d<4; d++) {
						int nr = cur.r+dirR[d];
						int nc = cur.c+dirC[d];
						
						if(isOut(nr,nc)) continue;
						
						if(visit[nr][nc]) continue;
						
						if(board[cur.r][cur.c] == board[nr][nc] ) {
							visit[nr][nc] = true;
							q.add(new POS(nr,nc,cur.cnt+1));
						}
						
					}
					
				}
				
				
			
			
			
			}
		}
		
		System.out.println(ret);
		
		
		
		
	}
	
	private static boolean isOut(int nr, int nc) {
		return 0>nr || nr >=4 || 0>nc || nc>=4;
	}
	
}
