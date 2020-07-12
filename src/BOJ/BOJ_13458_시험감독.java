package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_13458_시험감독 {
	static int[] arr;
	static int K,  main, sub;
	static long tot=0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		K = Integer.parseInt(br.readLine());
		arr= new int[K];

		StringTokenizer tokens = new StringTokenizer(br.readLine());
		
		for(int i=0; i<K; i++) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		
		tokens = new StringTokenizer(br.readLine());
		main = Integer.parseInt(tokens.nextToken());
		sub = Integer.parseInt(tokens.nextToken());

		for(int i=0; i<arr.length; i++) {
			if(arr[i] > main) {
				arr[i] = arr[i] - main;
				tot++;
				if((arr[i] % sub) == 0) {
					tot =tot+ arr[i]/sub;
				}else if((arr[i] % sub) != 0 ) {
					tot =tot+ arr[i]/sub+1;
				}
			}
			else {
				arr[i] = 0;
				tot++;
			}
		}
		System.out.println(tot);
	}
	
	
	static String src=  "5\r\n" + 
			"10 9 10 9 10\r\n" + 
			"7 2";
}
