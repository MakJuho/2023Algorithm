package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_5653_줄기세포배양_sol {

	private static int N,M,K;
	private static int[][] map, copied;
	private static boolean[][] check;
	private static int[] dx = {-1,1,0,0};
	private static int[] dy = {0,0,-1,1};
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		String line = br.readLine();
		StringTokenizer tokens = new StringTokenizer(line);
		
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		
		map = new int[N][M];
		copied = new int[N][M];
		for(int r=0; r<N; r++) {
			line = br.readLine();
			tokens = new StringTokenizer(line);
			for(int c=0; c<M; c++) {
				int value = Integer.parseInt(tokens.nextToken());
				
				if(value > 0) {
					map[r][c] = value+1;
					copied[r][c] = value+1;
				}
				
			}
		}

		
		while(K>0) {
			
			// 출력으로 확인.
			System.out.println(K+"번째");
			for(int[] a : copied) {
				System.out.println(Arrays.toString(a));
			}
			
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<M; c++) {
					
					/*
					 * 1. 만약 0보다 크면 map의 값을 1줄인다 && 1이면 확장 && 2이상이면 1씩 빼기만 한다.
					 * 2-1 확장일 경우 -> 주변 벽을 만났는지 확인, 값이 있는 지?, 있다면 val비교해서 더 크면 대입, 아니면 PASS
					*/
					if(map[r][c]>0) {
						int sp = map[r][c];
						map[r][c]--;
						if(map[r][c]==0) {
							//확장 4방향
							for(int i=0; i<4;i ++) {
								int nr = r+dx[i];
								int nc = c+dy[i];
								
								if(isIn(nr,nc)) {
									// 벽이 아니면
									if(map[nr][nc] == 0) {
										map[nr][nc] = sp;
									}else {
										// 더 큰 값을 넣어야한다.
										if(map[nr][nc]<sp) {
											map[nr][nc] = sp;
										}
									}
								}
								
							}
						}else if(map[r][c]>0) {
							//패스
						}
						
					}
					
				}
			}
			arrayCopy(copied, map);
			
			K--;
		}
		
		// 전체 개수 Count
		int Cnt=0;
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				if(map[r][c]>0)
					Cnt++;
			}
		}
		
		System.out.println("총 줄기 세포 후 :"+Cnt);
		
		
	}
	
	
	
	private static boolean isIn(int nr, int nc) {
		
		return 0<=nr && nr<N && 0<=nc && nc<M;
	}



	private static void arrayCopy(int[][] map2, int[][] copied2) {
		for(int i=0; i<map2.length; i++) {
			copied2[i] = map2[i].clone();
		}
		
	}



	private static String src = "5 5 19\r\n" + 
			"3 2 0 3 0\r\n" + 
			"0 3 0 0 0\r\n" + 
			"0 0 0 0 0\r\n" + 
			"0 0 1 0 0\r\n" + 
			"0 0 0 0 2";
}
