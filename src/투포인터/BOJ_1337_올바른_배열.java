package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;

public class BOJ_1337_올바른_배열 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);
		
		// 슬라이딩 윈도우
	    int idx_s=0;
	    int cnt=1,Max=1;

	    for(int i=1;i<n;i++){
	        cnt++;
	        while(arr[i]-arr[idx_s]>4){
	            idx_s++;
	            cnt--;
	        }

	        Max=Math.max(Max,cnt);

	    }

	    if(Max>5) Max=5;

	    System.out.println(5-Max);
		
		
		
	}
	
	
	static String src ="6\r\n" + 
			"2\r\n" + 
			"3\r\n" + 
			"10\r\n" + 
			"18\r\n" + 
			"19\r\n" + 
			"20";
}
