package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15683_감시 {
	
	static int N,M;
	static int [][] map;
	static int result = Integer.MAX_VALUE;
	static ArrayList<CCTV> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		map = new int[N][M];
		
		for(int r=0; r<N; r++) {
			tokens = new StringTokenizer(br.readLine());
			for(int c=0; c<M; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
				if(1 <= map[r][c] && map[r][c] <= 5) {
					list.add(new CCTV(r, c, map[r][c]));
				}
			}
		}
		
//		for(int [] a : map) {
//			System.out.println(Arrays.toString(a));
//		}
		
		dfs(0, map);
		
		System.out.println(result);
	}

	static void dfs(int idx, int[][] nMap) {
		// 종료
		
		if( idx == list.size()) {
			int cnt = 0;
			// 사각지대 개수 세기
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<M; c++) {
					if(nMap[r][c] == 0) {
						cnt++;
					}
				}
			}
			
			System.out.println();
			for(int []a : nMap) {
				System.out.println(Arrays.toString(a));
			}
			
			result = Math.min(result, cnt);
			return;
		}
		
		// 재귀 호출
		// 리스트에서 CCTV 하나하나 뽑아서 감시 솔루션
		CCTV cctv = list.get(idx);
		int r = cctv.r;
		int c = cctv.c;
		int[][] vMap = new int[N][M];
		
		switch(cctv.type) {
			case 1: 
				for(int dir=0; dir<4; dir++) {
					
					// 감시 - deep copy
					for(int i=0; i<N; i++) {
						// M개의 열 ,복사
						vMap[i] = Arrays.copyOf(nMap[i], M);
						//vMap[r] = nMap[r].clone();
					}
					detect(r, c, vMap, dir);
					
					// 두 번째 CCTV 호출
					dfs(idx+1,vMap);
					
					// 백트래킹
					
				}
				break;
			case 2:
				for(int dir=0; dir<2; dir++) {
					
					// 감시 - deep copy
					for(int i=0; i<N; i++) {
						// M개의 열 ,복사
						vMap[i] = Arrays.copyOf(nMap[i], M);
						//vMap[r] = nMap[r].clone();
					}
					detect(r, c, vMap, dir);
					detect(r, c, vMap, dir+2);
					
					// 두 번째 CCTV 호출
					dfs(idx+1,vMap);
					
					// 백트래킹
					
				}
				break;
			case 3:
				for(int dir=0; dir<4; dir++) {
					
					// 감시 - deep copy
					for(int i=0; i<N; i++) {
						// M개의 열 ,복사
						vMap[i] = Arrays.copyOf(nMap[i], M);
						//vMap[r] = nMap[r].clone();
					}
					detect(r, c, vMap, dir);
					detect(r, c, vMap, (dir+1)%4);
					
					// 두 번째 CCTV 호출
					dfs(idx+1,vMap);
					
					// 백트래킹
					
				}
				break;
			case 4:
				for(int dir=0; dir<4; dir++) {
					
					// 감시 - deep copy
					for(int i=0; i<N; i++) {
						// M개의 열 ,복사
						vMap[i] = Arrays.copyOf(nMap[i], M);
						//vMap[r] = nMap[r].clone();
					}
					detect(r, c, vMap, dir);
					detect(r, c, vMap, (dir+1)%4);
					detect(r, c, vMap, (dir+2)%4);
					
					// 두 번째 CCTV 호출
					dfs(idx+1,vMap);
					
					// 백트래킹
					
				}
				break;
			case 5:
					
				// 감시 - deep copy
				for(int i=0; i<N; i++) {
					// M개의 열 ,복사
					vMap[i] = Arrays.copyOf(nMap[i], M);
					//vMap[r] = nMap[r].clone();
				}
				detect(r, c, vMap, 0);
				detect(r, c, vMap, 1);
				detect(r, c, vMap, 2);
				detect(r, c, vMap, 3);
				
				// 두 번째 CCTV 호출
				dfs(idx+1,vMap);
				
				// 백트래킹
					
				break;
		}
		
		
		
	}
	
	static void detect(int r, int c, int[][] cMap, int dir) {
		// 0: 왼쪽, 1: 상, 2: 오른쪽, 3: 아래
		
		switch(dir) {
			case 0: // 왼쪽
				for(int i = c; i >=0; i--) {
					if(cMap[r][i] == 6) { // 벽이 되면,
						break;
					}
					cMap[r][i] = 9;
				}
			break;
			
			case 1: // 오른쪽
				for(int i = c; i <M; i++) {
					if(cMap[r][i] == 6) { // 벽이 되면,
						break;
					}
					cMap[r][i] = 9;
				}
			break;
				
			case 2: // 위쪽
				for(int i = r; i >=0; i--) {
					if(cMap[i][c] == 6) { // 벽이 되면,
						break;
					}
					cMap[i][c] = 9;
				}
				break;

			case 3: // 아래쪽
				for(int i = r; i < N; i++) {
					if(cMap[i][c] == 6) { // 벽이 되면,
						break;
					}
					cMap[i][c] = 9;
				}
				break;
				
		}
		
	}
	
	static class CCTV{
		private int r,c;
		private int type;


		public CCTV(int r, int c, int type) {
			this.r = r;
			this.c = c;
			this.type = type;
		}
		
		
		
		
	}
	

	static String src = "3 7\r\n" + 
			"4 0 0 0 0 0 0\r\n" + 
			"0 0 0 2 0 0 0\r\n" + 
			"0 0 0 0 0 0 4";
}
