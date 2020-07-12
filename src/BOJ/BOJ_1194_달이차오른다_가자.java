package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BOJ_1194_달이차오른다_가자 {
	
	static int N,M;
	static char [][] maze;
	static boolean [][][] visit;
	static final int[] key = {1,2,4,8,16,32};
	static int minCnt = Integer.MAX_VALUE;
	static int start_r, start_c;
	static int []di = {0,0,-1,1};
	static int []dj = {-1,1,0,0};
	
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		maze = new char[N][M];
		visit = new boolean[N][M][1<<6]; // 64 (0~63) 열쇠를 가지고 있는 경우의 수
		
		for(int r=0; r<N; r++) {
			String str = br.readLine();
			for(int c=0; c<M; c++) {
				maze[r][c] = str.charAt(c);
				if(maze[r][c] == '0') {
					// 시작점
					start_r = r;
					start_c = c;
				}
			}
		}
		
		/*
		 * for(char []a : maze) { System.out.println(Arrays.toString(a)); }
		 */
		
		Queue<Pos> q = new LinkedList<>();
		
		q.add(new Pos(start_r, start_c, 0, 0));
		visit[start_r][start_c][0] = true;
		
		while(!q.isEmpty()) {
			Pos tmp = q.poll();
			
			int r= tmp.r;
			int c= tmp.c;
			int keys = tmp.keys;
			int move = tmp.move;
			
			for(int dir=0; dir<4; dir++) {
				int nr = r+di[dir];
				int nc = c+dj[dir];
			
				if(isIn(nr,nc)) {
					
					int cur = maze[nr][nc];
					
					// 키가 있는 칸.
					if( cur >= 'a' && cur <= 'f') {
						cur -= 'a';
						int nKey = keys;
						if(!tmp.containsKey(key[cur])) {
							nKey += key[cur];
						}
						
						if(!visit[nr][nc][nKey]) {
							visit[nr][nc][nKey] = true;
							q.add(new Pos(nr, nc, nKey, move+1));
						}
					}
					
					// 문이 있는 칸
					else if( cur >= 'A' && cur <='F') {
						cur -= 'A';
						if(!tmp.containsKey(key[cur])) {
							continue;
						}
						
						else if(!visit[nr][nc][keys]) {
							visit[nr][nc][keys] = true;
							q.add(new Pos(nr, nc, keys, move+1));
						}
					}
					
					else if(cur == '#') continue;
					
					// 빈 칸일 경우
					else if(cur == '.' || cur == '0') {
						if(!visit[nr][nc][keys]) {
							visit[nr][nc][keys] = true;
							q.add(new Pos(nr, nc, keys, move+1));
						}
					}
					
					else if(cur == '1') {
						if(minCnt > move+1)
							minCnt = move+1;
					}
					
				}
			}
			
			
			
		}
		
		if(minCnt == Integer.MAX_VALUE)
			minCnt = -1;
		
		System.out.println(minCnt);
		
		
	}
	
	private static boolean isIn(int nr, int nc) {
		return 0<=nr && nr< N && 0<=nc && nc < M;
	}

	static class Pos{
		int r;
		int c;
		int keys;
		int move;
		
		public Pos(int r, int c, int keys, int move) {
			this.r = r;
			this.c = c;
			this.keys = keys;
			this.move = move;
		}

		@Override
		public String toString() {
			return "Pos [r=" + r + ", c=" + c + ", key=" + key + ", move=" + move + "]";
		}
		boolean containsKey(int key) {
			if(keys % (key * 2) / key ==1) return true;
			return false;
		}
		
		
	}
	
  
	static String src = "7 8\r\n" + 
			"a#c#eF.1\r\n" + 
			".#.#.#..\r\n" + 
			".#B#D###\r\n" + 
			"0....F.1\r\n" + 
			"C#E#A###\r\n" + 
			".#.#.#..\r\n" + 
			"d#f#bF.1";
}
