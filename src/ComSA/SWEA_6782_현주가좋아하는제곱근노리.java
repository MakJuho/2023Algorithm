package ComSA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class SWEA_6782_현주가좋아하는제곱근노리 {
	//인혁 하이~~
	public static void main(String[] args) throws Exception {
		int T, cnt;
		long N, temp;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; ++t) {
			cnt = 0;
			N = Long.parseLong(br.readLine());
			while (true) {
				
				if (N == 2)
					break;
				
				else {
					temp = (long) (Math.sqrt(N));
					if (temp * temp == N) {
						++cnt;
						N = temp;
					} else {
						cnt += ((temp + 1) * (temp + 1) - N); // 9 - 7 = 2 
						++cnt;
						N = temp + 1;
					}
				}
			}
			System.out.println("#" + t + " " + cnt);
		}
	
	}
	
	private static String src = "4\r\n" + 
			"2\r\n" + 
			"3\r\n" + 
			"4\r\n" + 
			"99";
}
