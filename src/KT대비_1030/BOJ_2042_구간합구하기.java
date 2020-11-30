package KT대비_1030;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2042_구간합구하기 {
	
	static int N;
	static int M;
	static int K;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
//		System.out.println(Arrays.toString(arr));
		
		for(int i=0; i<M+K; i++) {
			tokens = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken())-1;
			int c = Integer.parseInt(tokens.nextToken())-1;
		
			if(a == 1) {
				arr[b] = c+1;
			}else if ( a == 2) {
				long sum = 0;
				for(; b<=c; b++) {
					sum += arr[b];
				}
				System.out.println(sum);
			}
		
		}
		
	}
	static String src="5 2 2\r\n" + 
			"1\r\n" + 
			"2\r\n" + 
			"3\r\n" + 
			"4\r\n" + 
			"5\r\n" + 
			"1 3 6\r\n" + 
			"2 2 5\r\n" + 
			"1 5 2\r\n" + 
			"2 3 5";
}
