package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1944_복제로봇 {

	
	static int ans = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(tokens.nextToken());
		int M = Integer.parseInt(tokens.nextToken());
		
		char[][] map = new char[N][N];
		
		for(int r=0; r<N; r++) {
			String line = br.readLine();
			for(int c=0; c<N; c++) {
				map[r][c] = line.charAt(c);
			}
		}

		// K 까지 도착한 후, BFS로 확인 (MST)
		
		
		
	}
	
	static String src = "5 2\r\n" + 
			"11111\r\n" + 
			"1S001\r\n" + 
			"10001\r\n" + 
			"1K1K1\r\n" + 
			"11111";
}
