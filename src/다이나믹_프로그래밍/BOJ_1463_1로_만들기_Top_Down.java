package 다이나믹_프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1463_1로_만들기_Top_Down {
	
	static int dp[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(src));
		
		int v = Integer.parseInt(br.readLine());
		
		dp = new int[v+1];
		
		System.out.println(calculate(v));
		
	}

	private static int calculate(int v) {

		if( v == 1) {
			return 0;
		}
		
		if( dp[v] >0 ) {
			return dp[v];
		}
		
		dp[v] = calculate(v-1) +1;
		
		if(v %3 ==0 ) {
			dp[v] = Math.min(dp[v], calculate(v/3)+1);
		}
		if(v %2 == 0) {
			dp[v] = Math.min(dp[v], calculate(v/2)+1);
		}
		
		return dp[v];
		
		
	}
}
