package KT대비_1030;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2559_수열 {
	/**
	 * N : 배열, K : 연속적인 날짜
	 * 
	 * 전역 max에 K가 될 때, 계산
	 * sp ++, ep ++;
	 */
	static int max = Integer.MIN_VALUE;
	static int N, K;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		
		int[] arr = new int[N];
		tokens = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		
//		System.out.println(Arrays.toString(arr));
			
		int sp = 0;
		int ep = 0;
		int sum = 0;
		
		
		
		
		while(ep < N) {
			
			// Base 조건
			if(ep-sp == K-1) {
				
				sum = sum + arr[ep];
				
				if(sum > max ) {
					max = sum;
				}
				
				
				sum = sum - arr[sp];
				sp++; ep++;
			
				
				
			}else {
				// 조건이 될 때까지 계속 더해준다.
				sum = sum + arr[ep];
				ep++;
				
				
			}
			
			
		}
		System.out.println(max);
		
		
	}
	static String src= "10 5\r\n" + 
			"3 -2 -4 -9 0 3 7 13 8 -3";
}
