package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class BOJ_2839_설탕배달 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		int num = Integer.parseInt(br.readLine());
		int ans = 0;
		
		while(num % 5 != 0 && num >= 0) {
			num = num-3;
			ans ++;
		}
		if(num < 0) {
			System.out.println(-1);
		}else {
			ans += num/5;
			System.out.println(ans);
		}
		
	}
	
	static String src = "6";
}
