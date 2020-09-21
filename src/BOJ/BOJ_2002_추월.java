package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.HashMap;

public class BOJ_2002_추월 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		
		for(int i=0; i<N; i++) {
			// 각 차량에 대한 번호 매기기
			map.put(br.readLine(), i);
			
		}
		
		for(int i=0; i<N; i++) {
			// Map활용하여 번호 매기기
			arr[i] = map.get(br.readLine());
		}
		
		boolean[] isPass = new boolean[N];
		
		Arrays.fill(isPass, false);
		int cnt = 0;
		int idx = 0;
		for(int i=0; i<N; i++) {
			
			while(isPass[idx]) {
				idx = idx +1;
			}
			
			// 추월을 하지 않음.
			if(arr[i] == idx ) {
				isPass[idx] = true;
				idx ++;
				continue;
			}
			
			isPass[arr[i]] = true;
			cnt ++;
			
			
		}
		
		System.out.println(cnt);
		
	}
	
	static String src = "4\r\n" + 
			"AA\r\n" + 
			"BB\r\n" + 
			"CC\r\n" + 
			"DD\r\n" + 
			"BB\r\n" + 
			"AA\r\n" + 
			"DD\r\n" + 
			"CC";
}
