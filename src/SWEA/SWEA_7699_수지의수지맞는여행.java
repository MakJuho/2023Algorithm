package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_7699_수지의수지맞는여행 {
	
	static int N,M;
	static char[][] map;
	static boolean[] isvisited;
	// 북, 동, 남, 서
	static int[] dirR = {-1,0,1, 0};
	static int[] dirC = { 0,1,0,-1};
	
	static int ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=TC; t++) {
			StringTokenizer tokens = new StringTokenizer(br.readLine());
			N = Integer.parseInt(tokens.nextToken());
			M = Integer.parseInt(tokens.nextToken());

			map = new char[N][M];
			isvisited = new boolean[26];
			for(int r=0; r<N; r++) {
				String line = br.readLine();
				for(int c=0; c<M; c++) {
					map[r][c] = line.charAt(c);
				}
			}
			
			
			ans = 0;
			isvisited[map[0][0] - 'A'] = true;
			DFS(0,0,1);
			System.out.println("#"+t+" "+ans);
			
		}
		
	}
	private static void DFS(int r, int c, int depth) {
		if(ans < depth) {
			ans = depth;
		}
		
		for(int dir=0; dir<4; dir++) {
			int nr = r+dirR[dir];
			int nc = c+dirC[dir];
			
			if(isIn(nr,nc) && !isvisited[map[nr][nc]-'A']){
				isvisited[map[nr][nc] - 'A']= true;
				DFS(nr, nc, depth+1);
				isvisited[map[nr][nc] - 'A']= false;
				
			}
			
		}
		
	}
	private static boolean isIn(int nr, int nc) {
		return 0<=nr && nr<N && 0<=nc && nc<M;
	}
	//	for(char[] a: map){
//	System.out.println(Arrays.toString(a));
//}
	static class Pos{
		private int r;
		private int c;
		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
		@Override
		public String toString() {
			return "Pos [r=" + r + ", c=" + c + "]";
		}
		
		
		
	}
	
	static String src = 
			"3\r\n" + 
			"2 4\r\n" + 
			"CAAB\r\n" + 
			"ADCB\r\n" + 
			"3 6\r\n" + 
			"HFDFFB\r\n" + 
			"AJHGDH\r\n" + 
			"DGAGEH\r\n" + 
			"5 5\r\n" + 
			"IEFCJ\r\n" + 
			"FHFKC\r\n" + 
			"FFALF\r\n" + 
			"HFGCF\r\n" + 
			"HMCHH";
}
