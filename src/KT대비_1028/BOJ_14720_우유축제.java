package KT대비_1028;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14720_우유축제 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		int[][] dp = new int[N][3];
//		System.out.println(Arrays.toString(arr));
		
		if(arr[0] == 0) {
			dp[0][0] = 1;
		}
		
		for(int i=1; i<N; i++) {
			int milk = arr[i];
			
//			dp[i][0] = milk == 0 ? dp[i - 1][2] + 1 : dp[i - 1][0]; 
//			dp[i][1] = milk == 1 && dp[i][2] < dp[i][0] ? dp[i - 1][0] + 1 : dp[i - 1][1];
//			dp[i][2] = milk == 2 && dp[i][0] < dp[i][1] ? dp[i - 1][1] + 1 : dp[i - 1][2];

			// 딸기
			if(milk == 0) {
			
				dp[i][0] = dp[i-1][2]+1; 
				
				dp[i][1] = dp[i-1][1];
				dp[i][2] = dp[i-1][2];
			}else if(milk == 1) {
				// 초코
				dp[i][0] = dp[i-1][0];
				if(dp[i-1][0] > dp[i-1][2]) {
					dp[i][1] = dp[i-1][0]+1;
				}else {
					dp[i][1] = dp[i-1][1];
				}
				dp[i][2] = dp[i-1][2];
				
			}else if(milk == 2) {
				// 바나나
				dp[i][0] = dp[i-1][0];
				dp[i][1] = dp[i-1][1];
				if(dp[i-1][1] > dp[i-1][0]) {
					dp[i][2] = dp[i-1][1]+1;
				}else {
					dp[i][2] = dp[i-1][2];
				}
			}
			
		}
		
//		for(int[] a: dp) {
//			System.out.println(Arrays.toString(a));
//		}
		
		int ret = Math.max(dp[N-1][0], Math.max(dp[N-1][1], dp[N-1][2]));
		
		System.out.println(ret);
		
	}
	
	static String src = "7\r\n" + 
			"0 2 1 0 1 2 0";
}
