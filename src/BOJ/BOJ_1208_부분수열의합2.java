package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_1208_부분수열의합2 {
	
	static int N,S;
	static int Result;
	static LinkedList<Integer> list = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		S = Integer.parseInt(tokens.nextToken());
		
		int[] arr = new int[N];
		tokens = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		
		for(int i=1; i<=arr.length; i++) {
			list.clear();
			Com(arr, arr.length, i, 0);
		}
		System.out.println(Result);
		//System.out.println(Arrays.toString(arr));
	}
	
	static void Com(int[] arr, int n, int r, int index) {
		if(r == 0) {
			int total =0;
			for(Integer val : list) {
				total+=val;
			}
			if(S == total) Result++;
			
			return;
		}
		if(index == n) return;
		
		list.add(arr[index]);
		Com(arr, n, r-1, index+1);
		list.removeLast();
		Com(arr, n, r, index+1);
	}
	
	static String src ="5 0\r\n" + 
			"-7 -3 -2 5 8";
}
