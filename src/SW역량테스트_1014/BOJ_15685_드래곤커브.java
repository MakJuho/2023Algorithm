package SW역량테스트_1014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15685_드래곤커브 {
	/**
	 * 1. 시작점
	 * 2. 시작 방향
	 * 3. 세대
	 * 
	 * 열과 행, 방향, 드래곤 레벨
	 * 드래곤 레벨 별로 map에다가 찍고
	 * 본 판에다가 붙이는 방식으로 해야한다.
	 * 
	 */
	
	static int N;
	static boolean[][] board = new boolean[102][102];
	// 오른쪽->위, 위->왼쪽, 왼쪽->아래, 아래->오른
	static int[] dirR = {0, -1, 0, 1};
	static int[] dirC = {1, 0, -1, 0};
	static boolean[][] curboard = new boolean[102][102];
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		N = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=N; t++) {
			StringTokenizer tokens = new StringTokenizer(br.readLine());
			int sc = Integer.parseInt(tokens.nextToken());
			int sr = Integer.parseInt(tokens.nextToken());
			int dir = Integer.parseInt(tokens.nextToken());
			int level = Integer.parseInt(tokens.nextToken());
			
			int curve_size = 0;
			int[] curve = new int[1024];
			board[sr][sc] = true;
			curve[curve_size++] = dir;
			
			for(int j=0; j<level; j++) {
				for(int k=curve_size-1; k>=0; --k) {
					curve[curve_size++] = (curve[k] +1) % 4;
				}
			}
			
//			System.out.println(Arrays.toString(curve));
			
			for(int j=0; j<curve_size; j++) {
				sr = sr + dirR[curve[j]];
				sc = sc + dirC[curve[j]];
				
				board[sr][sc] = true;
				
			}
			
			
		}
//		for(boolean [] a: board) {
//			System.out.println(Arrays.toString(a));
//		}
		
//		countCurve();
		int ret = 0;
		for(int r=0; r<100; r++) {
			for(int c=0; c<100; c++) {
				if(board[r][c] && board[r][c+1] && board[r+1][c] && board[r+1][c+1])
					ret++;
			}
		}
		
		System.out.println(ret);
	}
	

	static String src = "4\r\n" + 
			"3 3 0 1\r\n" + 
			"4 2 1 3\r\n" + 
			"4 2 2 1\r\n" + 
			"2 7 3 4";
}
