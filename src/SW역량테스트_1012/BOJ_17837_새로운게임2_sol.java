package SW역량테스트_1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_17837_새로운게임2_sol {

	private static int N;
	private static int K;
	private static int[][] color;
	private static int[][] horse;
	
	private static LinkedList<Integer>[][] map;
//	→, ←, ↑, ↓
	private static int[] dirR = {0, 1, 0, -1};
	private static int[] dirC = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		
		color = new int[N][N];
		horse = new int[K][3];
		map = new LinkedList[N][N];
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				map[r][c] = new LinkedList<>();
			}
		}
		
		
		for(int r=0; r<N; r++) {
			tokens = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				color[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		int r, c, dir;
		
		for(int i=0; i<K; i++) {
			tokens = new StringTokenizer(br.readLine());
			r = Integer.parseInt(tokens.nextToken())-1;
			c = Integer.parseInt(tokens.nextToken())-1;
			dir = Integer.parseInt(tokens.nextToken());
			
			if(dir == 1 ) dir =0;
			else if(dir == 4 ) dir=1;
			
			horse[i][0] = r;
			horse[i][1] = c;
			horse[i][2] = dir;
			
			map[r][c].add(i);
			
		}
		
		game();
		
		
		
	}
	
	private static void game() {
		for(int t=1; t<=1000; t++) {
			for(int k=0; k<K; k++) {
				int r= horse[k][0];
				int c= horse[k][1];
				int dir= horse[k][2];
				
				int num = searchOrder(k,r,c);
				
				int nr = r + dirR[dir];
				int nc = c + dirC[dir];
				
				if(isOut(nr,nc) || color[nr][nc] == 2) {
					horse[k][2] = dir = (dir+2) %4;
					nr = r+ dirR[dir];
					nc = c+ dirC[dir];
					
					if(isOut(nr,nc)|| color[nr][nc]==2) continue;
				}
				
				if(move(r,c,nr,nc,num,color[nr][nc])) {
					System.out.println(t);
					return;
				}
				
				
			}
		}
		System.out.println(-1);
	}

	private static boolean move(int r, int c, int nr, int nc, int num, int order) {
		while(map[r][c].size() > num) {
			int temp = -1;
			if ( order == 0) {
				temp = map[r][c].remove(num);
			}
			else {
				temp = map[r][c].removeLast();
			}
			
			horse[temp][0] = nr;
			horse[temp][1] = nc;
			
			map[nr][nc].add(temp);
			
		}
		
		if(map[nr][nc].size() >= 4)
			return true;
		
		return false;
	}

	private static boolean isOut(int nr, int nc) {
		return 0>nr || nr >=N || 0>nc || nc >=N;
	}

	private static int searchOrder(int n, int r, int c) {
		for(int i=0; i<map[r][c].size(); i++) {
			if(map[r][c].get(i) == n) {
				return i;
			}
		}
		return -1;
	}

	static String src = "4 4\r\n" + 
			"0 0 2 0\r\n" + 
			"0 0 1 0\r\n" + 
			"0 0 1 2\r\n" + 
			"0 2 0 0\r\n" + 
			"2 1 1\r\n" + 
			"3 2 3\r\n" + 
			"2 2 1\r\n" + 
			"4 1 2";
}
