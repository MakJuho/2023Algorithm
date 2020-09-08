package 카카오인턴;

import java.util.Arrays;

public class 자물쇠와열쇠 {
	
	static int[][] map;
	static int[][] tMap;
	static int[][] tKey;
	static int N, M;
	static boolean answer;
	public static void main(String[] args) {
		boolean answer = true;
		int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 0}};
		int[][] lock = {{1, 1, 0, 1}, {1, 1, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 1}};
		map = new int[200][200];
		tMap = new int[200][200];
		N = key.length;
		M = lock.length;
		tKey = new int[N][N];
		/**
		 * 90도 rotate 함수 구현, 완전 탐색 및 백트래킹
		 */
		
	
		// 자물쇠를 먼저 큰 배열에 넣어놓는다.
		for(int r=50; r<50+lock.length; r++) {
			for(int c=50; c<50+lock.length; c++) {
				map[r][c] = lock[r-50][c-50];
			}
		}
		
		// tMap에 복사
		for(int i=0; i<map.length; i++) {
			tMap[i] = map[i].clone();
		}
		for(int i=0; i<key.length; i++) {
			tKey[i] = key[i].clone();
		}
		
		// 4 방향 검색
		for(int rot=0; rot<4; rot++) {
			
			for(int r=50-key.length+1; r<50+lock.length; r++) {
				for(int c=50-key.length+1; c<50+lock.length; c++) {
					
					loop:
					for(int k=0; k<key.length; k++) {
						for(int l=0; l<key.length; l++) {
							if(tKey[k][l] == 1) {
								// tMap에 key를 넣어본다.
								// 자물쇠의 돌기와 만난다면 continue;
								if(tMap[r+k][c+l] == 1) {
									break loop;
								}
								else {
									tMap[r+k][c+l] = 1;
								}
								
							}
						}	
					}
					
					if(isSolve()) {
						System.out.println("TRUE");
						return ;
					}else {
						// tMap 원래대로
						for(int i=0; i<map.length; i++) {
							tMap[i] = map[i].clone();
						}
					}
				}
			}
			
			// rotate 함수
			tKey = rotate(key.length, tKey);
			
		}
		System.out.println("FALSE");
	}

	private static boolean isSolve() {
		
		int cnt = 0;
		for(int r=50; r<50+M; r++) {
			for(int c=50; c<50+M; c++) {
				if(tMap[r][c] == 1 ) cnt++;
			}
		}
		if(cnt == M*M) {
			return true;
		}
		return false;
		
	}

	private static int[][] rotate(int n, int[][] key) {
		int[][] temp = new int[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				temp[i][j] = key[n-1-j][i];
			}
		}
		
		return temp;
		
		
	}
	
	
}
