package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17070_파이프옮기기_1 {
	
	static Queue<Pos> q = new LinkedList<>();
	static int[][] map;
	static int cnt = 0;
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int r=0; r<N; r++) {
			StringTokenizer tokens =new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		
//		for(int[] a: map) {
//			System.out.println(Arrays.toString(a));
//		}
		
		q.add(new Pos(0,0));
		q.add(new Pos(0,1));
		
		dfs(0,1,0); // r, c, type
					// type 0 : 가로 , type 1 : 대각선, type 2 : 세로.
		
		System.out.println(cnt);
		
		
	}
	
	private static void dfs(int r, int c, int type) {
		if(r== N-1 && c == N-1) {
//			System.out.println("type:"+type);
			cnt++;
			return;
		}
		
		// 오른쪽
		if(isIn(r,c+1) && map[r][c+1]==0 ) {
			if(type==0 || type ==1) {
//				System.out.println(r+":"+c+":"+type);
				dfs(r, c+1, 0);
			}
		}
		// 대각선
		if(isIn(r+1, c+1) && map[r][c+1]==0 && map[r+1][c+1]==0 && map[r+1][c]==0) {
//			System.out.println(r+":"+c+":"+type);
			dfs(r+1, c+1, 1);
		}
		// 아래
		if(isIn(r+1, c) && map[r+1][c]==0) {
			if(type ==1 || type==2) {
//				System.out.println(r+":"+c+":"+type);
				dfs(r+1, c, 2);
			}
		}
		
	}

	private static boolean isIn(int r, int c) {
		return 0<=r && r<N && 0<=c && c<N;
	}

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
	
	
	static String src = "6\r\n" + 
			"0 0 0 0 0 0\r\n" + 
			"0 1 0 0 0 0\r\n" + 
			"0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0";
}
