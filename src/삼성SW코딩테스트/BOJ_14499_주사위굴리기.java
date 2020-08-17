package 삼성SW코딩테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BOJ_14499_주사위굴리기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(tokens.nextToken());
		int M = Integer.parseInt(tokens.nextToken());
		
		
		
	}
	static String src = "4 2 0 0 8\r\n" + 
			"0 2\r\n" + 
			"3 4\r\n" + 
			"5 6\r\n" + 
			"7 8\r\n" + 
			"4 4 4 1 3 3 3 2";
}
