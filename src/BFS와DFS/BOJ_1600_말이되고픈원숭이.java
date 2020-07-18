package BFS와DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1600_말이되고픈원숭이 {
	
	static int[] dr_horse = {-1, +1, -2, +2, -2, +2, -1, +1};
	static int[] dc_horse = {-2, -2, -1, -1, +1, +1, +2, +2};
	
	static int[] dr_monkey = {-1, 0, 0, 1};
	static int[] dc_monkey = {0, -1, +1, 0};
	
	static int W, H;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		int K = Integer.parseInt(br.readLine());
		
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		W = Integer.parseInt(tokens.nextToken());
		H = Integer.parseInt(tokens.nextToken());
		
		int[][] board = new int [H][W];
		boolean[][] visited = new boolean[H][W];
		
		for(int r=0; r<H; r++) {
			tokens = new StringTokenizer(br.readLine());
			for(int c=0; c<W; c++) {
				board[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		Queue<pos> q = new LinkedList<>();
		
		q.add(new pos(0, 0, K,0));
		visited[0][0] = true;
		
		boolean isPossible = false;
		int minDist = Integer.MAX_VALUE;
		while(!q.isEmpty()) {
			pos tmp = q.poll();
			
			if(visited[H-1][W-1] == true) {
				if(minDist > tmp.dist) {
					minDist = tmp.dist;
				}
				isPossible = true;
			}
			
			// horse일 때
			if(tmp.k > 0) {
				for(int i=0; i<8; i++) {
					
					int nr = tmp.r + dr_horse[i];
					int nc = tmp.c + dc_horse[i];
					
					if(isIn(nr,nc)) {
						if(visited[nr][nc] == false && board[nr][nc] == 0) {
							visited[nr][nc] = true;
							q.add(new pos(nr,nc,tmp.k-1,tmp.dist+1));
						}
					}
					
				}
			}
			// 원숭이일 때
			else if( tmp.k == 0) {
				for(int i=0; i<4; i++) {
					
					int nr = tmp.r + dr_monkey[i];
					int nc = tmp.c + dc_monkey[i];
					
					if(isIn(nr,nc)) {
						if(visited[nr][nc] == false && board[nr][nc] == 0) {
							visited[nr][nc] = true;
							q.add(new pos(nr,nc,0,tmp.dist+1));
						}
					}
					
				}
			}
			
			
			
		}
		
		if(isPossible == false) {
			System.out.println(-1);
		}else {
			System.out.println(minDist);
		}
		
		
		
		
		
		
	}


	private static boolean isIn(int nr, int nc) {
		return 0<=nr && 0<=nc && nr<H && nc<W;
	}

	static class pos{
		int r;
		int c;
		int k;
		int dist;
		
		public pos(int r, int c, int k, int dist) {
			this.r = r;
			this.c = c;
			this.k = k;
			this.dist = dist;
		}
		
		@Override
		public String toString() {
			return "pos [r=" + r + ", c=" + c + ", k=" + k + ", dist=" + dist + "]";
		}
		
		
		
	}
	
	static String src = "1\r\n" + 
			"4 4\r\n" + 
			"0 0 0 0\r\n" + 
			"1 0 0 0\r\n" + 
			"0 0 1 1\r\n" + 
			"0 1 0 0";
}
