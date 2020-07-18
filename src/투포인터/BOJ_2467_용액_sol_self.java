package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_2467_용액_sol_self {

	static long INF = Integer.MAX_VALUE;
	static LinkedList<Integer> list = new LinkedList<>();
	static long min = Integer.MAX_VALUE;
	static long[] ans = new long[2];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		
		int ans1=0, ans2=0;
		long ansSum = INF;
		for(int i=0; i<n; i++) {
			int left = i+1, right = n-1;
			
			while(left <= right) {
				int mid = (left+ right) / 2;
				int sum = arr[i] + arr[mid];
				
				if(ansSum > Math.abs(sum) ) {
					ansSum = Math.abs(sum);
					ans1 = arr[i];
					ans2 = arr[mid];
					
				}
				
				if( sum < 0 )
					left = mid+1;
				else
					right = mid-1;
				
				
			}
			
			
		}
		
		
		System.out.println(ans1+" "+ans2);
		
		
		return ;
		
		
	}
	



	static String src = "7\r\n" + 
			"-99 -2 -1 1 98 100 101";
}
