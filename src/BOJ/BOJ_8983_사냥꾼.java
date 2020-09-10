package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.SocketTimeoutException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_8983_사냥꾼 {

	static int M,N,L; // 사대 수, 동물 수, 사정거리
	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
	
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(tokens.nextToken());
		N = Integer.parseInt(tokens.nextToken());
		L = Integer.parseInt(tokens.nextToken());
		
		int[] arr = new int[M];
		tokens = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		
		
		int[][] animal = new int[N][2];
		
		for(int i=0; i<N; i++) {
			tokens = new StringTokenizer(br.readLine());
			animal[i][0] = Integer.parseInt(tokens.nextToken());
			animal[i][1] = Integer.parseInt(tokens.nextToken());
		}

		// 사대 정렬
		Arrays.sort(arr);
		
		
		for(int i=0; i<N; i++) {
				
			int left = 0;
			int right = M-1;

			while(left <= right) {
				int middle = (left+right)/2;
				// 사대 거리 안에 들어올 경우
				if((Math.abs(arr[middle] - animal[i][0])+animal[i][1]) <= L ) {
					ans++;
					break ;
				}else {
					// 사대 거리 밖일 경우
					if((arr[middle] - animal[i][0]) <= 0) {
						left = middle +1;
					}else {
						right = middle -1;
					}
				}
			}
			
		}
		
		System.out.println(ans);
		
		
	}
	
	static String src = "4 8 4\r\n" + 
			"6 1 4 9\r\n" + 
			"7 2\r\n" + 
			"3 3\r\n" + 
			"4 5\r\n" + 
			"5 1\r\n" + 
			"2 2\r\n" + 
			"1 4\r\n" + 
			"8 4\r\n" + 
			"9 4";
	
}
