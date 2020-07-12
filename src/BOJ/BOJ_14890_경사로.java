package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14890_경사로 {
	private static int N=0, L=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(str));
		
		String line = br.readLine();
		StringTokenizer tokens = new StringTokenizer(line);
		
		N = Integer.parseInt(tokens.nextToken());
		L = Integer.parseInt(tokens.nextToken());
		
		int board[][] = new int[N][N];
		
		
		for(int r=0; r<N; r++) {
			String[] strings =br.readLine().split(" ");
			board[r] = Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();
		}
		
//		for(int[] a: board) {
//			System.out.println(Arrays.toString(a));
//		}
		
		// 높이차이가 1이거나 0 아니면 Break;
		
		// 높이차이가 1일 때 변수 체크
		
		
		
		Queue<Integer> q = new LinkedList<>();
		
		
		int ans =0;
		int len =0;
		// 행
		int[] bar;
		for(int r=0; r<N; r++) {
			bar = new int[N];
			int cnt = 0;
			outer :
			for(int c=0; c<N-1; c++) {
				
				int now = board[r][c];
				int after = board[r][c+1];
				int differ = after - now;
				
				if(differ == 0 ) {
				
	
				}
				
				else if (differ == +1) {
					if(isIn(r,c-L+1)) {
						for(int i=0; i<L; i++) {
							if(bar[c-i] != 1) {
								bar[c-i] = 1;
							}else {
								break outer;
							}
							if(now != board[r][c-i]) {
								break outer;
							}
						}
					}else {
						break;
					}
				}
				else if (differ == -1) {
					if(isIn(r,c+L)) {
						for(int i=1; i<=L; i++) {
							if(bar[c+i] != 1) {
								bar[c+i] = 1;
							}else {
								break outer;
							}
							
							if(now-1 != board[r][c+i]) {
								break outer;
							}
						}
					}else {
						break;
					}
				}else {
					break;
				}
				
				cnt ++;
				if(cnt == N-1) {
					ans++;
				}
				
			}
		}
		
		// 열
		for(int c=0; c<N; c++) {
			bar = new int[N];
			int cnt = 0;
			oute :
			for(int r=0; r<N-1; r++) {
				
				int now = board[r][c];
				int after = board[r+1][c];
				int differ = after - now;
				
				if(differ == 0 ) {
					
				}
				
				else if (differ == +1) {
					if(isIn(r-L+1,c)) {
						for(int i=0; i<L; i++) {
							if(bar[r-i] != 1) {
								bar[r-i] = 1;
							}else {
								break oute;
							}
							
							if(now != board[r-i][c]) {
								break oute;
							}
						}
					}else {
						break;
					}
				}
				else if (differ == -1) {
					if(isIn(r+L,c)) {
						for(int i=1; i<=L; i++) {
							if(bar[r+i] != 1) {
								bar[r+i] = 1;
							}else {
								break oute;
							}
							
							if(now-1 != board[r+i][c]) {
								break oute;
							}
						}
					}else {
						break;
					}
				}else {
					break;
				}
				
				cnt ++;
				if(cnt == N-1) {
					ans++;
				}
				
			}
		}
		
		System.out.println(ans);
		
	}
	
	private static boolean isIn(int r, int c) {
		return 0<=r && 0<=c && r<N && c<N;
	}

	private static String str ="6 1\r\n" + 
			"3 2 1 1 2 3\r\n" + 
			"3 2 2 1 2 3\r\n" + 
			"3 2 2 2 3 3\r\n" + 
			"3 3 3 3 3 3\r\n" + 
			"3 3 3 3 2 2\r\n" + 
			"3 3 3 3 2 2";
	
}
