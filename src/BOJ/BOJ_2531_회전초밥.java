package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_2531_회전초밥 {
	
	static int N,D,K,C;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		D = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		
		int[] arr = new int[N];
		int max = Integer.MIN_VALUE;
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=0; i<arr.length; i++) {
			HashSet<Integer> hs = new HashSet<>();
			
			for(int j=0; j<K; j++) {
				hs.add(arr[(i+j)%N]);
			}
			hs.add(C);
			
			if(max < hs.size()) {
				max = hs.size();
			}
			
			
		}
		
		System.out.println(max);
		
		
		
	}
	
	static String src = "2 2 2 2\r\n" + 
			"1\r\n" + 
			"1"; 
}
