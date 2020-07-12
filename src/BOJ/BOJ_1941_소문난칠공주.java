package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1941_소문난칠공주 {

	static char[][] map = new char[5][5];
	static int result=0;
	static boolean[] visit = new boolean[25];
	static int[] di = {0,0,-1,1};
	static int[] dj = {-1,1,0,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		for(int r=0; r<5; r++) {
			String line = br.readLine();
			for(int c=0; c<5; c++) {
				map[r][c] = line.charAt(c);
			}
		}
		
//		for(char[] a: map) {
//			System.out.println(Arrays.toString(a));
//		}
		
		// 아나칼 아모칼
		
		for(int i=0; i< 25 ; i++) {
			dfs(i, 1, 0);
		}
		
		System.out.println(result);
		
		
		
		
	}
	
	static void dfs(int idx, int cnt, int sCnt) {
		visit[idx] = true;
		if(map[idx/5][idx%5] == 'S') {
			sCnt++;
		}
		// 종료
		if( cnt == 7) {
			// 이다솜 파가 4명인가?
			if(sCnt >= 4) {
				// 7공주파 인접하기
				if(bfs(idx/5, idx%5)) {
					result++;
				}
			}
			
			visit[idx] = false;
			return;
		}
		//visit[idx] = true;

		for(int i= idx+1; i<25; i++) {
			if(!visit[i]) { // 선택
				dfs(i, cnt+1, sCnt);
			}
		}
		// 백트래킹
		visit[idx] = false;
	}
	
	static boolean bfs(int r, int c) {
		Queue<Pos> q = new LinkedList<>();
		q.offer(new Pos(r,c));
		boolean[][] v1 = new boolean[5][5];
		v1[r][c] = true;
		
		Pos d1 = null;
		int vCnt = 1;
		
		while(!q.isEmpty()) {
			d1 = q.poll();
			for(int dir =0; dir<4; dir++) {
				int nr = d1.r+di[dir];
				int nc = d1.c+dj[dir];
				
				if(isIn(nr,nc)) {
					if(v1[r][c]) {
						continue;
					}
					// 같은 팀 이수연
					if(!visit[nr*5+nc]) {
						continue;
					}
					
					v1[r][c] = true;
					q.offer(new Pos(nr,nc));
					vCnt ++;
				}
				
			}
		}
		
		return vCnt == 7 ? true : false;
	}
	static boolean isIn(int nr, int nc) {
		return 0<=nr && nr<5 && 0<=nc && nc<5;
	}
	
	static class Pos{
		int r, c;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Pos [r=" + r + ", c=" + c + "]";
		}
		
		
		
	}

	static String src ="YYYYY\r\n" + 
			"SYSYS\r\n" + 
			"YYYYY\r\n" + 
			"YSYYS\r\n" + 
			"YYYYY";
}
