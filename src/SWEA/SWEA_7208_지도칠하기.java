package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_7208_지도칠하기 {
	static int [][] map;
	static int N;
	static int[] color;
	static int[] fill;
	static int min;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			color = new int[N];
			fill = new int[N];
			min = Integer.MAX_VALUE;
			
			StringTokenizer tokens = new StringTokenizer(br.readLine(), " ");
			for(int r=0; r<N; r++) {
				color[r] = Integer.parseInt(tokens.nextToken());
			}
			for(int r=0; r<N; r++) {
				tokens = new StringTokenizer(br.readLine(), " ");
				for(int c=0; c<N; c++) {
					map[r][c] = Integer.parseInt(tokens.nextToken());
				}
			}
			
//			System.out.println(Arrays.toString(color));
			
			// 순열 생성후,
			dfs(0);
			// 결과를 출력
			System.out.println("#"+t+" "+min);
		}
	}
	static void dfs(int cnt) {
		if(cnt == N) {
			// 인접된 국가가 다른 color로 칠할 수 있는 순열인 경우
			if(check()) {
				// 인접된 국가의 색이 다르게 작성된 순열이 생성된 경우 기존의 color와 생성된 순열이 다른 지를 카운트.
				int count = 0;
				for(int i=0; i<N; i++) {
					if(color[i] != fill[i]) {
						count++;
					}
				}
				
				min = Math.min(count, min);
				
			}
			return ;
		}
		// 중복 순열
		for (int i=1; i<=4; i++) {
			fill[cnt] = i;
			dfs(cnt+1);
		}
		
		
	}
	
	
	private static boolean check() {
		for(int r=0; r<N; r++) { // cur
			for(int c=0; c<N; c++) { // 인접 국가
				if(map[r][c] == 1 && fill[r] == fill[c]) {
					return false;
				}
			}
		}
		return true;
	}

	static String src="3\r\n" + 
			"4\r\n" + 
			"1 2 3 4\r\n" + 
			"0 1 1 1\r\n" + 
			"1 0 1 1\r\n" + 
			"1 1 0 1\r\n" + 
			"1 1 1 0\r\n" + 
			"4\r\n" + 
			"1 2 2 1\r\n" + 
			"0 1 0 0\r\n" + 
			"1 0 1 0\r\n" + 
			"0 1 0 1\r\n" + 
			"0 0 1 0\r\n" + 
			"4\r\n" + 
			"1 1 2 2\r\n" + 
			"0 1 0 0\r\n" + 
			"1 0 1 0\r\n" + 
			"0 1 0 1\r\n" + 
			"0 0 1 0";
}
