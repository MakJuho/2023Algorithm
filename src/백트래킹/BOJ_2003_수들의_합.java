package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2003_수들의_합 {
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(tokens.nextToken());
		int M = Integer.parseInt(tokens.nextToken());
		
		int[] arr = new int[N];
		
		tokens = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}

		int cnt= 0 ;
		for(int i=0; i<N; i++) {
			int tot = 0;
			for(int j=i; j<N; j++) {
				// 
				if(tot < M) {
					tot += arr[j];
				}
				
				if( tot == M) {
					cnt ++;
					break;
				}
				else if( tot > M) {
					break;
				}
				
			}
		}
		
		System.out.println(cnt);
	}
	
	
	static String src = "10 5\r\n" + 
			"1 2 3 4 2 5 3 1 1 2";
	
}
