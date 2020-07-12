package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2579_계단오르기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		int []steps = new int[TC+1];
		int []dp = new int[TC+1];
		
		for(int t=1; t<=TC; t++) 
			steps[t] = sc.nextInt();
		
//		System.out.println(Arrays.toString(steps));
		
		dp[1] = steps[1];
		dp[2] = steps[1]+ steps[2];

		int jump_on = 0, jump_off=0;
		for(int i=3; i<=TC; i++) {
		
			jump_on = steps[i]+ steps[i-1] + dp[i-3];
			jump_off = steps[i]+ dp[i-2];
			dp[i] = Math.max(jump_on, jump_off);
			
		}
		
		System.out.println(dp[TC]);
		
	}
	
	private static String src = "6\r\n" + 
			"10\r\n" + 
			"20\r\n" + 
			"15\r\n" + 
			"25\r\n" + 
			"10\r\n" + 
			"20";
}
