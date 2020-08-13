package 삼성SW코딩테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14502_연구소 {

	static int N, M;
	static int[][] map;
	static LinkedList<Pos> list = new LinkedList<>();
	static LinkedList<Pos> virus = new LinkedList<>();
	static LinkedList<Pos> tmp = new LinkedList<>();
	static Queue<Pos> q = new LinkedList<>();
	/**
	 * 바이러스 전파 방향
	 */
	static int[] dirR = {-1,0,1,0}; 
	static int[] dirC = {0,1,0,-1};

	static int ans = Integer.MIN_VALUE;
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer tokens = null;
		
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		map = new int[N][M];
		
		
		for(int r=0; r<N; r++) {
			tokens = new StringTokenizer(br.readLine());
			for(int c=0; c<M; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
				if(map[r][c] == 0) {
					list.add(new Pos(r,c));
				}else if(map[r][c] == 2) {
					virus.add(new Pos(r,c));
				}
				
			}
		}
		
		// 벽으로 바꿀 3개 선택
		Combination(3, 0);
		
		System.out.println(ans);
	}
	
	private static void Combination(int r, int idx) {
		if(r == 0 ) {
//			System.out.println(tmp);
			
			int[][] copymap = new int[N][M];
			
			/*
			 * copymap 생성
			 */
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					copymap[i][j] = map[i][j];
				}
			}
			
			/**
			 * 벽 생성
			 */
			for(int i=0; i<3; i++) {
				copymap[tmp.get(i).r][tmp.get(i).c] = 1;
//				System.out.println(tmp.get(i).r);
//				System.out.println(tmp.get(i).c);
			}
//			for(int[] a : copymap) {
//				System.out.println(Arrays.toString(a));
//			}
//			System.out.println();
//			System.out.println();
			
			/**
			 * BFS를 이용해서 바이러스 전파
			 */
			
			for(int i=0; i<virus.size(); i++) {
				q.add(virus.get(i));
				
			}
			
			while(!q.isEmpty()) {
				Pos tmpQ = q.poll();
				
				for(int i=0; i<4; i++) {
					int nr = tmpQ.r + dirR[i];
					int nc = tmpQ.c + dirC[i];
					
					if(isIn(nr,nc) && copymap[nr][nc] == 0) {
						copymap[nr][nc] = 2;
						q.add(new Pos(nr,nc));
					}
					
				}
			}
			
			
//			for(int[] a : copymap) {
//				System.out.println(Arrays.toString(a));
//			}
//			System.out.println();
//			System.out.println();
			
			int cnt=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(copymap[i][j] == 0) {
						cnt++;
					}
				}
			}
			
			ans = Math.max(ans, cnt);
			return ;
		}
		else if(list.size() == idx) return;
		
		tmp.add(list.get(idx));
		Combination(r-1, idx+1);
		tmp.removeLast();
		Combination(r, idx+1);
		
	}

	private static boolean isIn(int nr, int nc) {
		return 0<=nr && 0<=nc && nr<N && nc<M;
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
	
	
	static String src = "8 8\r\n" + 
			"2 0 0 0 0 0 0 2\r\n" + 
			"2 0 0 0 0 0 0 2\r\n" + 
			"2 0 0 0 0 0 0 2\r\n" + 
			"2 0 0 0 0 0 0 2\r\n" + 
			"2 0 0 0 0 0 0 2\r\n" + 
			"0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0";
	
	
}
