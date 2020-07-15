package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_2467_용액 {

	
	static LinkedList<Integer> list = new LinkedList<>();
	static long min = Integer.MAX_VALUE;
	static long[] ans = new long[2];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		int n = Integer.parseInt(br.readLine());
		long[] arr = new long[n];
		
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		
		combination(arr, 2, 0);
		
		for(long a: ans) {
			System.out.print(a+" ");
		}
		
	}
	

	private static void combination(long[] arr, int r, int idx) {
		if(r == 0 ) {
			long val =0;
			
			for(Integer i:list) {
				val += i;
			}

			if(min > Math.abs(val)) {
				min = Math.abs(val);
				ans[0] = list.get(0);
				ans[1] = list.get(1);
				
			}
			
			return;
		}
		if(arr.length == idx) return;
		
		list.add((int)(long)arr[idx]);
		combination(arr, r-1, idx+1);
		list.removeLast();
		combination(arr, r, idx+1);
		
	}


	static String src = "5\r\n" + 
			"-99 -2 -1 4 98";
}
