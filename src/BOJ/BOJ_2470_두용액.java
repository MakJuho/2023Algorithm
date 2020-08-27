package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2470_두용액 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int [N];
		int choice1 = 0, choice2 = 0;
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		
		Arrays.sort(arr);

		int front = 0;
		int end = arr.length-1;
		int ans = Integer.MAX_VALUE;
		
		while(front < end){
			int val = arr[front] + arr[end];
			
			if(Math.abs(val) < ans) {
				ans = Math.abs(val);
				choice1 = arr[front];
				choice2 = arr[end];
			}
			
			if(val > 0) {
				end = end -1;
			}else{
				front = front +1;
			}
			
		}

		System.out.println(choice1 + " " + choice2);
		
	}
	
	static String src = "5\r\n" + 
			"-2 4 -99 -1 98";
	
}
