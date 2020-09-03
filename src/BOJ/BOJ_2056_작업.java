package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2056_작업 {

	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		
		for(int i=1; i<N+1; i++) {
			StringTokenizer tokens = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(tokens.nextToken());
			
			int cntIdx = Integer.parseInt(tokens.nextToken());
			int lastIdx = i-1;
			for(int j=0; j<cntIdx; j++) {
				lastIdx = Integer.parseInt(tokens.nextToken());
			}
			
			arr[i] = arr[lastIdx] + time;
		}
		Arrays.sort(arr);

		System.out.println(arr[arr.length-1]);
	}
	
	static String src ="7\r\n" + 
			"5 0\r\n" + 
			"1 1 1\r\n" + 
			"3 1 2\r\n" + 
			"6 1 1\r\n" + 
			"1 2 2 4\r\n" + 
			"8 2 2 4\r\n" + 
			"4 3 3 5 6";
}
