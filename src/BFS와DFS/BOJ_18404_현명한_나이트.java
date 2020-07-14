package BFS와DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_18404_현명한_나이트 {
	
	static int N, M;
	static int[] nr = {-1, +1, -2, +2, -2, +2, -1, +1};
	static int[] nc = {-2, -2, -1, -1, +1, +1, +2, +2};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		int[][] ansBoard = new int[M][3];
		//		char [][] board = new char[N+1][N+1];
		
		// K : Knight
		tokens = new StringTokenizer(br.readLine());
		int start_r = Integer.parseInt(tokens.nextToken());
		int start_c = Integer.parseInt(tokens.nextToken());
//		board[start_r][start_c]='K';
		
		// E : Enemy
		int[][] check = new int[N+1][N+1];
	
		
		for(int i=0; i<check.length; i++) {
			Arrays.fill(check[i], -1);
		}

		check[start_r][start_c] = 0;
		
		
		for(int i=0; i<M; i++) {
			tokens = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(tokens.nextToken());
			int c = Integer.parseInt(tokens.nextToken());
//			board[r][c] = 'E';
			ansBoard[i][0]=r;
			ansBoard[i][1]=c;
		}
		
//		for(int i=0; i<check.length; i++) {
//			System.out.println(Arrays.toString(check[i]));
//		}
		
		Queue<pos> q= new LinkedList<>();
				
		q.add(new pos(start_r, start_c, 0));
		
		while(!q.isEmpty()) {
			pos tmp = q.poll();
			
 			for(int i=0; i<8; i++) {
				int r = tmp.r+nr[i];
				int c = tmp.c+nc[i];
				
				if(isIn(r,c)) {
						
					if(check[r][c] == -1) {
						check[r][c] = tmp.cnt+1;
						q.add(new pos(r ,c , tmp.cnt+1));
					}
					
				}
				
			}
		}
		
		
		
		
		
		for(int i=0; i<ansBoard.length; i++) {
			System.out.print(check[ansBoard[i][0]][ansBoard[i][1]]+" ");
		}
		
		
	}
	

	private static boolean isIn(int i, int j) {
		return 1<=i && i<N+1 && 1<=j && j<N+1;
	}

	static class pos{
		int r;
		int c;
		int cnt;
		
		public pos(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "pos [r=" + r + ", c=" + c + ", cnt=" + cnt + "]";
		}
		
		
	}
	
	static String src = "5 3\r\n" + 
			"2 4\r\n" + 
			"3 2\r\n" + 
			"3 5\r\n" + 
			"4 5";
}
