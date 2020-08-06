package 삼성SW코딩테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_19236_청소년상어 {

	// 화살표 방향
	static int[] dirR = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dirC = { 0, -1,-1,-1, 0, 1, 1,  1};
	
	static Pos[][] board = new Pos [4][4];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		// board 4x4 Pos 형식으로 삽입
		for(int r=0; r<4; r++) {
			StringTokenizer tokens = new StringTokenizer(br.readLine());
			for(int c=0; c<4; c++) {

				int num = Integer.parseInt(tokens.nextToken());
				int dir = Integer.parseInt(tokens.nextToken());
				
				board[r][c] = new Pos(num, dir);
			
			}
		}
		
		// 상어 (0, 0)에 위치.
		
		
		
		
		
	}
	
	
	static class Pos{
		
		private int num;
		private int arrow;
		public Pos(int num, int arrow) {
			this.num = num;
			this.arrow = arrow;
		}
		@Override
		public String toString() {
			return "Pos [num=" + num + ", arrow=" + arrow + "]";
		}
		
		
	}
	
	static String src = "7 6 2 3 15 6 9 8\r\n" + 
			"3 1 1 8 14 7 10 1\r\n" + 
			"6 1 13 6 4 3 11 4\r\n" + 
			"16 1 8 7 5 2 12 2";
}
