package 브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1107_리모컨 {
	
	
	static boolean[] btn;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		int target = Integer.parseInt(br.readLine());
		int t = Integer.parseInt(br.readLine());
		
		btn = new boolean[10];
		//Arrays.fill(btn, true); // 고장난 게 False

		if( t>0) {
			StringTokenizer tokens = new StringTokenizer(br.readLine());
			for(int i=0; i<t; i++) {
				int removeBtn = Integer.parseInt(tokens.nextToken());
				btn[removeBtn] = true;
			}
			
		}

		// 1. 주어진 값과 100의 절대값 차이
		int ans = Math.abs(target-100);

		// 0~500,000까지 모두 탐색
		for(int i=0; i<=999999; i++) {
			int c = i;
			int len = possible(c);
			
			if(len > 0) {
				int press = Math.abs(target - c);
				ans = Math.min(ans, len+press);
			}
			
		}
		
		System.out.println(ans);
	}
	
	private static int possible(int c) {
		
		if(c == 0 ) {
			if(!btn[c]) {
				return 1;
			}else {
				return 0;
			}
		}

		int len = 0;
		
		while( c > 0 ) {
			
			if(btn[c % 10]) {
				return 0;
			}
			len ++;
			c = c/10;
			
		}
		
		return len;
	}

	private static String src = "500000\r\n" + 
			"8\r\n" + 
			"0 2 3 4 6 7 8 9";
}
