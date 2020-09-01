package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;

public class BOJ_2839_설탕배달_DP {
	
	final static int INF = 987654321;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
        int N = Integer.parseInt(br.readLine());
        int[] list = {3,5};
        int[] dp = new int[5001];
        
        Arrays.fill(dp,INF);
        
        
        dp[0] = 0;

        for (int weight : list) {
            for (int j = weight; j <= N; j++) {
                dp[j] = Math.min(dp[j], dp[j-weight] + 1);
                System.out.println(dp[j]);
            }
        }
        System.out.println(dp[N] == INF ? -1 : dp[N]);
		
	}
	
	static String src = "11";
}
