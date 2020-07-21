package 해싱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ_5052_전화번호_목록 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			int n = Integer.parseInt(br.readLine());
			String[] arr = new String[n];
			
			for(int j=0; j<n; j++) {
				arr[j] = br.readLine();
			}
			
			Arrays.sort(arr);
			
			boolean isPossible = true;
			
			for(int j=0; j<arr.length-1; j++) {
				if(arr[j+1].startsWith(arr[j])) {
					isPossible = false;

				}
			}

			if(isPossible)	System.out.println("YES");
			else System.out.println("NO");
			
			// 내림차순 정렬
//			Arrays.sort(arr, new Comparator<String>() {
//				@Override
//				public int compare(String o1, String o2) {
//					if(Long.parseLong(o2) > Long.parseLong(o1)) {
//						return 1;
//					}else {
//						return -1;
//					}
//				}
//			});
			
			
			
		}
		
	}
	
	static String src = "2\r\n" + 
			"3\r\n" + 
			"911\r\n" + 
			"97625999\r\n" + 
			"91125426\r\n" + 
			"5\r\n" + 
			"113\r\n" + 
			"12340\r\n" + 
			"123440\r\n" + 
			"12345\r\n" + 
			"98346";
	
}
