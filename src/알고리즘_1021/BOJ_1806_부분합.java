package 알고리즘_1021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1806_부분합 {
	
	static int N,S;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		S = Integer.parseInt(tokens.nextToken());
		
		int[] arr= new int[N];
		
		tokens = new StringTokenizer(br.readLine());
		for(int i=0; i<arr.length; i++) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		
//		System.out.println(Arrays.toString(arr));
		
		
		int firstPointer = 0;
		int secondPointer = 0;
		
		int ans = 1000001;
		int sum = 0;
		
		while(true) {
			if( sum >= S) {
				sum = sum - arr[firstPointer];
				firstPointer++;
				ans = Math.min(ans, secondPointer-firstPointer+1);
				
			}else if(secondPointer == N) {
				break;
			}else {
				sum = sum + arr[secondPointer];
				secondPointer++;
			}
		}
		if(ans == 1000001) {
			System.out.println(0);
		}else {
			System.out.println(ans);
		}
		
		
		
		
		
		
	}
	static String src = "10 15\r\n" + 
			"5 1 3 5 10 7 4 9 2 8";
}
