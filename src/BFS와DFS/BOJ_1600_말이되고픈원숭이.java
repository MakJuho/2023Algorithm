package BFS와DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1600_말이되고픈원숭이 {
	
	static final int[] dr_horse = {-1, +1, -2, +2, -2, +2, -1, +1};
	static final int[] dc_horse = {-2, -2, -1, -1, +1, +1, +2, +2};
	
	static final int[] dr_monkey = {-1, 0, 0, 1};
	static final int[] dc_monkey = {0, -1, +1, 0};
	
	static int W, H, K;
	
	static int[][] board = new int[201][201];
	static boolean[][][] discovered = new boolean[201][201][31];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		K = Integer.parseInt(br.readLine());
		
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		W = Integer.parseInt(tokens.nextToken());
		H = Integer.parseInt(tokens.nextToken());
		
		//boolean[][] visited = new boolean[H][W];
		
		for(int r=0; r<H; r++) {
			tokens = new StringTokenizer(br.readLine());
			for(int c=0; c<W; c++) {
				board[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		int step = -1;
		Queue<pos> q = new LinkedList<pos>();

		q.add(new pos(0, 0, K));
		discovered[0][0][0] = true; // monkey
		discovered[0][0][1] = true; // horse
		
		
//		boolean isPossible = false;
//		int minDist = Integer.MAX_VALUE;
		
		while(!q.isEmpty()) {
			
			step ++;
			
			int size = q.size();
			
			for(int i=0; i<size; i++) {
				
				pos tmp = q.poll();
				
				if(tmp.r == H-1 && tmp.c == W-1) {
					System.out.println(step);
					return;
				}
				
				// Monkey일 때
				for(int j=0; j<4; j++) {
					
					int nr = tmp.r + dr_monkey[j];
					int nc = tmp.c + dc_monkey[j];
					
					if(!isIn(nr,nc)) continue;
					if(discovered[nr][nc][tmp.k] == true) continue;
					if(board[nr][nc] == 1) continue;

					q.add(new pos(nr, nc, tmp.k));
					discovered[nr][nc][tmp.k] = true;
					
				}
				
				
				if(tmp.k == 0) continue;
				
				// Horse일 때
				
				for(int j=0; j<8; j++) {
						
					int nr = tmp.r + dr_horse[j];
					int nc = tmp.c + dc_horse[j];
					
					if(!isIn(nr,nc)) continue;
					if(discovered[nr][nc][tmp.k-1] == true) continue;
					if(board[nr][nc] == 1) continue;
						
					q.add(new pos(nr, nc, tmp.k-1));
					discovered[nr][nc][tmp.k-1] = true;
					
				}
				
				
				
			}
			
		}
		
		System.out.println(-1);
		
	}


	private static boolean isIn(int nr, int nc) {
		return 0<=nr && 0<=nc && nr<H && nc<W;
	}

	static class pos{
		int r;
		int c;
		int k;
		
		public pos(int r, int c, int k) {
			this.r = r;
			this.c = c;
			this.k = k;
		}

		
		
		
	}
	
	static String src = "1\r\n" + 
			"4 4\r\n" + 
			"0 0 0 0\r\n" + 
			"1 0 0 0\r\n" + 
			"0 0 1 0\r\n" + 
			"0 1 0 0";
}
