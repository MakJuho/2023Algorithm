	package SW역량테스트_1012;
	
	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.io.StringReader;
	import java.util.Arrays;
	import java.util.LinkedList;
	import java.util.Queue;
	import java.util.StringTokenizer;
	
	public class BOJ_17779_게리맨더링2 {
		
		/**
		 * 기준점 (x, y)와 경계의 길이 d1, d2를 정한다. 
		 * d1, d2 ≥ 1, 
		 * 1 ≤ x < x+d1+d2 ≤ N, 
		 * 1 ≤ y-d1 < y < y+d2 ≤ N
		 * d1, d2 ( 1 ~ N )
		 * r, c = (1~ N-2, 2~ N-1)
		 * 
		 * 구역을 5개의 선거구로 나눠야한다.
		 * 기준점 (x, y), 경계의 길이 d1, d2
		 * 경계선인 5번을 먼저 채우고 -> 1, 2, 3, 4번을 순서대로 채운다.
		 * 빈칸을 5번으로 나머지 다 채운다.
		 * 
		 * (인구수 가장 많은 선거구 - 인구 가장 적은 선거구 )의 최소값.
		 * d1, d2에 따라서 값이 달라진다. 
		 */
		static class POS{
			int r, c;
	
			@Override
			public String toString() {
				return "POS [r=" + r + ", c=" + c + "]";
			}
	
			public POS(int r, int c) {
				this.r = r;
				this.c = c;
			}
			
			
		}
		static int N;
		static int ret = Integer.MAX_VALUE;
		static int sum = 0;
		static int[][] board = new int[21][21];
		static int[][] area;
		static int[] dirR = {-1, 0, 1, 0};
		static int[] dirC = {0, 1, 0, -1};
		public static void main(String[] args) throws NumberFormatException, IOException {
	
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			br = new BufferedReader(new StringReader(src));
			
			N = Integer.parseInt(br.readLine());
			
			board = new int[N+1][N+1];
			
			StringTokenizer tokens;
			for(int r=1; r<=N; r++) {
				tokens = new StringTokenizer(br.readLine());
				for(int c=1; c<=N; c++) {
					board[r][c] = Integer.parseInt(tokens.nextToken());
					sum += board[r][c];
				}
			}
			
	//		 * 기준점 (x, y)와 경계의 길이 d1, d2를 정한다. 
	//		 * d1, d2 ≥ 1, 
	//		 * 1 ≤ x < x+d1+d2 ≤ N, 
	//		 * 1 ≤ y-d1 < y < y+d2 ≤ N
			for(int r=1; r<=N; r++) {
				for(int c=1; c<=N; c++) {
					for(int d1=1; d1<=N; d1++) {
						for(int d2=1; d2<=N; d2++) {
							// 경계값 계산
							if(r+d1+d2>N) continue;
							if(1 > c- d1) continue;
							if(c+d2 > N) continue;
							ret = Math.min(ret, solve(r,c,d1,d2));
						}
					}
				}
			}
			System.out.println(ret);
	
			return ;
		}		
	
		private static int solve(int r, int c, int d1, int d2) {
	//		 * 구역을 5개의 선거구로 나눠야한다.
	//		 * 기준점 (x, y), 경계의 길이 d1, d2
	//		 * 경계선인 5번을 먼저 채우고 -> 1, 2, 3, 4번을 순서대로 채운다.
	//		 * 빈칸을 5번으로 나머지 다 채운다.
	//		(x, y), (x+1, y-1), ..., (x+d1, y-d1)
	//		(x, y), (x+1, y+1), ..., (x+d2, y+d2)
	//		(x+d1, y-d1), (x+d1+1, y-d1+1), ... (x+d1+d2, y-d1+d2)
	//		(x+d2, y+d2), (x+d2+1, y+d2-1), ..., (x+d2+d1, y+d2-d1)
			area = new int[N+1][N+1];
			// r : 2 , c : 4 , d1 : 2, d2 : 2
			
			area[r][c] = 5;
			for(int i=1; i<=d1; i++) {
				area[r+i][c-i] = 5;
				area[r+d2+i][c+d2-i] = 5;
			}
			
			for(int i=1; i<=d2; i++) {
				area[r+i][c+i] = 5;
				area[r+d1+i][c-d1+i] = 5;
			}
			
			
	
	//		1번 선거구: 1 ≤ r < x+d1, 1 ≤ c ≤ y
	//		2번 선거구: 1 ≤ r ≤ x+d2, y < c ≤ N
	//		3번 선거구: x+d1 ≤ r ≤ N, 1 ≤ c < y-d1+d2
	//		4번 선거구: x+d2 < r ≤ N, y-d1+d2 ≤ c ≤ N
			int [] arr = new int[5];
			for(int nr = 1; nr<r+d1; nr++) {
				for(int nc = 1; nc<=c; nc++) {
					if(area[nr][nc] == 5) {
						break;
					}
					area[nr][nc] = 1;
					arr[0] += board[nr][nc];
				}
			}
			
			
			for(int nr = 1; nr<=r+d2; nr++) {
				for(int nc = N; nc> c; nc--) {
					if(area[nr][nc] == 5) {
						break;
					}
					area[nr][nc] = 2;
					arr[1] += board[nr][nc];
				}
			}
			
			for(int nr = r+d1; nr<=N; nr++) {
				for(int nc = 1; nc<c-d1+d2; nc++) {
					if(area[nr][nc] == 5) {
						break;
					}
					area[nr][nc] = 3;
					arr[2] += board[nr][nc];
				}
			}
			
			for(int nr= r+d2+1; nr<=N; nr++) {
				for(int nc= N; nc>= c- d1+d2; nc--) {
					if(area[nr][nc] == 5) {
						break;
					}
					area[nr][nc] = 4;
					arr[3] += board[nr][nc];
				}
			}
	
			arr[4] = sum - arr[0] - arr[1] - arr[2] - arr[3];
	//		 
			
			int max=0, min=9999999;
			for(int i=0; i<5; i++) {
				max = Integer.max(max, arr[i]);
				min = Integer.min(min, arr[i]);
			}
	//		System.out.println(Arrays.toString(arr));
	//		System.out.println(max-min);
			return ret = Math.min(ret, max-min);
			
			
		}
	
		private static boolean isOut(int kr, int kc) {
			return 1 > kr || kr > N || 1 > kc || kc > N;
		}
	
		static String src = "6\r\n" + 
				"1 2 3 4 1 6\r\n" + 
				"7 8 9 1 4 2\r\n" + 
				"2 3 4 1 1 3\r\n" + 
				"6 6 6 6 9 4\r\n" + 
				"9 1 9 1 9 5\r\n" + 
				"1 1 1 1 9 9";
		
	}
