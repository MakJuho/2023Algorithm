package programmers;

import java.util.Arrays;

public class DP_타일장식물 {
	public static void main(String[] args) {
		int N =6;
		
		long[] fibo = new long[N+1];
		fibo[1] = 1;

		for(int i=2; i<fibo.length; i++ ) {
			fibo[i] = fibo[i-1] + fibo[i-2];
		}
		
		
		System.out.println(cal(fibo, N));
	}

	static long cal(long[] fibo, int N) {
		return fibo[N]*4 + fibo[N-1]*2;
	}
}
