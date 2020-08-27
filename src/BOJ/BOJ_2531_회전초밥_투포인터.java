package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_2531_회전초밥_투포인터 {
	
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
		int[] v = new int[D+1];
		for(int i=0; i<arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int max = 0;
		int total = 0;
		
		for(int i=0; i<K; i++) {
			if(v[arr[i]]==0) total ++;
			v[arr[i]] ++;
		}
		
		max = total;
		
		for(int i=1; i<N; i++) {
			
			if(max <= total) {
				if(v[C] == 0) {
					max = total +1;
				}else {
					max = total;
				}
			}
			
			v[arr[i-1]]--;
			if(v[arr[i-1]]==0) total--; 
			
			if(v[arr[(i-1+K)%N]]==0) total++;
			v[arr[(i-1+K)%N]]++;
			
			
		}
		
		System.out.println(max);
		
		
	}
	
	static String src = "8 50 4 7\r\n" + 
			"2\r\n" + 
			"7\r\n" + 
			"9\r\n" + 
			"25\r\n" + 
			"7\r\n" + 
			"9\r\n" + 
			"7\r\n" + 
			"30"; 
}
