package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class BOJ_16916_부분문자열2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		
		// 길이는 100만을 넘지 않는다.
		String line = br.readLine();
		String pattern = br.readLine();

		kmp(line, pattern);
		
	}
	
	private static void kmp(String line, String pattern) {
		//getPi함수 구하기
		getPi();
		
	}

	static String src = "baekjoon\r\n" + 
			"bak";
}
