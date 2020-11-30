package SW역량테스트_1009;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17142_연구소3 {
	
	/**
	 * 배운 점!
	 * 1. 조합을 새로운 방법으로 사용해봤다.
	 * 2. 모든 방문을 체크할 필요 없이 전체 개수를 세서 하나씩 지우는 방식도 가능하다는 것을 배웠다.
	 */
	
	static int M, N, ret;
	static int[][] map;
	static POS[] pos = new POS[10];
	static int pos_size = 0;
	static boolean[][] visit;
	static int[] dirR = {-1, 0, 1, 0};
	static int[] dirC = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(tokens.nextToken());
		N = Integer.parseInt(tokens.nextToken());
		
		map = new int[M][M];
		visit = new boolean[M][M];

		for(int r=0; r<M; r++) {
			tokens = new StringTokenizer(br.readLine());
			for(int c=0; c<M; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
				if(map[r][c] == 2) {
					pos[pos_size] = new POS(r,c,0);
					++pos_size;
				}
			
			}
		}
		
		ret = Integer.MAX_VALUE;
		int[] pick = new int[10];
		Arrays.fill(pick, 0);
		
		dfs(-1, 0, pick);
		
		
		if( ret == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(ret);
		}
		
	}
	
	private static void dfs(int last_pick, int pick_count, int[] pick) {
		if(pick_count == N) {
			System.out.println(Arrays.toString(pick));
			int candi = bfs(pick);
			if(ret > candi) {
				ret = candi;
			}
			return ;
		}
		
		// 고른 것을 pick에 넣어준다.
		for(int i= last_pick+1; i< pos_size; i++) {
			pick[pick_count] = i;
			dfs(i, pick_count+1, pick);
		}
		
	}

	private static int bfs(int[] pick) {

		int empty_count = 0;
		for(int r=0; r<M; r++) {
			for(int c=0; c<M; c++) {
				if(map[r][c] == 0)
					++empty_count;
			}
		}

		Queue<POS> q= new LinkedList<>();
		int[][] visit = new int[50][50];
		// 바이러스 개수만큼만.
		for(int i=0; i<N; i++) {
			q.add(pos[pick[i]]);
			visit[pos[pick[i]].r][pos[pick[i]].c] = 1;
			
		}
		
		while(!q.isEmpty()) {
			POS cur = q.poll();
			
			// Queue에서 뺄 때, empty_count를 감소시킨다.
			if(map[cur.r][cur.c] == 0) {
				--empty_count;
			}
			
			if(empty_count ==0) {
				return cur.time;
			}
			
			
			for(int d=0; d<4; d++) {
				int nr = cur.r + dirR[d];
				int nc = cur.c + dirC[d];
				
				if(isOut(nr, nc)) continue;
				
				// 방문하지 않았고, 벽이 아닐 때 Q에 추가
				if(visit[nr][nc] == 0 && map[nr][nc] !=1) {
					q.add(new POS(nr,nc,cur.time+1));
					visit[nr][nc] = 1;
				}
				
			}
			
		}
		
		return Integer.MAX_VALUE;
		
	}



	private static boolean isOut(int nr, int nc) {
		return 0>nr || nr>=M || 0>nc || nc>=M;
	}


	static class POS{
		int r, c, time;

		public POS(int r, int c, int time) {
			this.r = r;
			this.c = c;
			this.time = time;
		}

		@Override
		public String toString() {
			return "POS [r=" + r + ", c=" + c + ", time=" + time + "]";
		}
		
		
	}
	
	static String src = "7 3\r\n" + 
			"2 0 2 0 1 1 0\r\n" + 
			"0 0 1 0 1 0 0\r\n" + 
			"0 1 1 1 1 0 0\r\n" + 
			"2 1 0 0 0 0 2\r\n" + 
			"1 0 0 0 0 1 1\r\n" + 
			"0 1 0 0 0 0 0\r\n" + 
			"2 1 0 0 2 0 2";
}
