package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16234_인구이동 {

	/*	1. 배열 - CopyMap, Map, isVisited  / 클래스 C - x,y 좌표 생성
	 *  2. 입력을 모두 받는다.
	 *  3. for문 i, j로 완탐.
	 *  4. dfs조건문 -> 비교해서 주변에 범위 안이 존재하면 dfs 다시 한다. (방문 x , 차이 L <= R, sum을 계산)
	 *  5. dfs를 마치고 온 부분에 평균값을 넣는다.
	*/	
	
	static class C{
		int y;
		int x;
		
		
		public C(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}


		@Override
		public String toString() {
			return "y=" + y + ", x=" + x;
		}
	}
	
	static int N, L, R;
	static int[][] map;
	static int[][] copymap;
	static boolean[][] isvisited;
	
	static int dy[] = {0,-1,0,1};
	static int dx[] = {1,0,-1,0};
	
	static int c;
	static int result=0;
	static int sum, cnt;
	static ArrayList<int[]> arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		String line = br.readLine();
		StringTokenizer tokens = new StringTokenizer(line);
		
		N = Integer.parseInt(tokens.nextToken());
		L = Integer.parseInt(tokens.nextToken());
		R = Integer.parseInt(tokens.nextToken());
		
		map = new int[N][N];
		copymap = new int[N][N];
		isvisited = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			line = br.readLine();
			tokens = new StringTokenizer(line);
			
			for(int j=0; j<N; j++) {
				map[i][j]= Integer.parseInt(tokens.nextToken());
			}
		}
		
		
		while(true) {
			
			copymap = new int[N][N];
			isvisited = new boolean[N][N];
			
			c = 1;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(copymap[i][j] == 0 ) {
						arr = new ArrayList<>();
						sum = map[i][j];
						arr.add(new int[]{i,j});
						cnt = 1;
						
						dfs(i,j);
						c++;

						// 평균으로 나누기
						if(cnt >= 2) {
							for(int t=0; t<arr.size(); t++) {
								map[arr.get(t)[0]][arr.get(t)[1]] = sum / cnt;
							}
						}
					}
					
				}
			}
			
			int [] cnt = new int[--c];
			
			if( cnt.length == N*N) {
				break;
			}
			result++;
			
			
			
		}
		System.out.println(result);
		
		
		
		
		
		/*
		 * for(int[] a: map) { System.out.println(Arrays.toString(a)); }
		 */
		
		
	}
	
	public static void dfs(int y, int x) {
		
		copymap[y][x]= c;
		isvisited[y][x] = true;
		
		for(int dir =0; dir<4; dir++) {
			int ny = y + dy[dir];
			int nx = x + dx[dir];
			
			if(isIn(ny,nx)) {
				int k = Math.abs(map[y][x] - map[ny][nx]);
				
				if(L<=k && k<=R && !isvisited[ny][nx]) {
					
					cnt++;
					sum += map[ny][nx];
					arr.add(new int[] {ny,nx});
					dfs(ny,nx);
					
				}
			}
		}
	}

	public static boolean isIn(int ny, int nx) {
		return 0<=ny && 0<=nx && ny<N && nx<N;
	}

	private static String src = "3 5 10\r\n" + 
			"10 15 20\r\n" + 
			"20 30 25\r\n" + 
			"40 22 10";
	
}
