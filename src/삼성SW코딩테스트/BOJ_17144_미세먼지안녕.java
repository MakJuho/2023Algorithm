package 삼성SW코딩테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17144_미세먼지안녕 {
	
	static int[][] map;
	static int[][] copymap;
	static LinkedList<Pos> dust = new LinkedList<>();
	static Queue<Pos> q = new LinkedList<>();
	static int[] dir_R = {-1, 0, 1, 0};
	static int[] dir_C = {0, 1, 0, -1};
	static int N,M,T;
	static ArrayList<Integer> cleaner = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		
		/**
		 * N : 행 , M : 열, T : 시간
		 */
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		T = Integer.parseInt(tokens.nextToken());
		
		map = new int[N][M];
		
		for(int r=0; r<N; r++) {
			tokens = new StringTokenizer(br.readLine());
			for(int c=0; c<M; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
				if(map[r][c] == -1) {
					cleaner.add(r);
				}
			}
		}
		
		Pos top = new Pos(cleaner.get(0),0,-1);
		Pos bottom = new Pos(cleaner.get(1),0,-1);
		
		
		// 미세먼지 확산 -> 먼지가 있는 부분을 위치와 값을 넣어놔야한다.
		// BFS
		
		while( T != 0) {
			
			copymap = new int[N][M];
			for(int r=0; r<N; r++) {
				copymap[r] = map[r].clone();
			}
			
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<M; c++) {
					// 확산 조건
					if(map[r][c] > 0) {
						// 주변을 살피고 빈공간 확인
						int around = 0;
						for(int i=0; i<4; i++) {
							int nr = r+ dir_R[i];
							int nc = c+ dir_C[i];
							if(isIn(nr,nc) && map[nr][nc] !=-1) {
								around ++;
								copymap[nr][nc] += map[r][c]/5;
							}
						}
						copymap[r][c] -= around * (map[r][c]/5);
					}
				}
			}
			
			for(int r=0; r<N; r++) {
				map[r] = copymap[r].clone();
			}
			
			
			
			
			/**
			 * 위는 반시계방향
			 * 아래는 시계방향
			 */
				
			// top 진행
			for(int r=top.r; r>=1; r--) {
				if(map[r][0] !=-1) {
					map[r][0] = map[r-1][0];
				}
			}
			
			for(int c=0; c<M-1; c++) {
				map[0][c] = map[0][c+1];
			}
			
			for(int r=0; r<top.r; r++) {
				map[r][M-1] = map[r+1][M-1];
			}
			
			for(int c=M-1; c>=1; c--) {
				map[top.r][c] = map[top.r][c-1];
			}
			
			
			
			// bottom 진행
			for(int r=bottom.r; r<N-1 ;r++) {
				if(map[r][0] != -1) {
					map[r][0] = map[r+1][0];
				}
			}
			
			for(int c=0; c<M-1; c++) {
				map[N-1][c] = map[N-1][c+1];
			}
			
			for(int r=N-1; r>bottom.r; r--) {
				map[r][M-1] = map[r-1][M-1];
			}
			
			for(int c=M-1; c>0; c--) {
				map[bottom.r][c] = map[bottom.r][c-1];
			}
			
			
			map[top.r][0] = -1;
			map[bottom.r][0] = -1;
			map[top.r][1] = 0;
			map[bottom.r][1] = 0;
			
			for(int[] a: map) {
				System.out.println(Arrays.toString(a));
			}
			
			
			T--;
			
		}
		
		int tot=0;
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				if(map[r][c] > 0)
					tot += map[r][c]; 
			}
		}
		
		System.out.println(tot);
		
		
//		q.add(dust.poll());
		
//		while(!q.isEmpty()) {
//			Pos tmp = q.poll();
//			
//			for(int i=0; i<4; i++) {
//				int nr = tmp.r +dir_R[i];
//				int nc = tmp.c +dir_C[i];
//				
//				if(isIn(nr,nc)) {
//					
//				}
//				
//			}
//			
//			
//			
//			
//		}
		
		
	}
	
	private static boolean isIn(int nr, int nc) {
		return 0<=nr && 0<=nc && nr<N && nc<M;
	}

	static class Pos{
		private int r;
		private int c;
		private int v;
		
		@Override
		public String toString() {
			return "Pos [r=" + r + ", c=" + c + ", v=" + v + "]";
		}
		public Pos(int r, int c, int v) {
			this.r = r;
			this.c = c;
			this.v = v;
		}
		
		
	
		
		
		
	}
	
	static String src = "7 8 30\r\n" + 
			"0 0 0 0 0 0 0 9\r\n" + 
			"0 0 0 0 3 0 0 8\r\n" + 
			"-1 0 5 0 0 0 22 0\r\n" + 
			"-1 8 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 10 43 0\r\n" + 
			"0 0 5 0 15 0 0 0\r\n" + 
			"0 0 40 0 0 0 20 0";
	
}
