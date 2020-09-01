package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEA_3378_스타일리쉬들여쓰기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=TC; t++) {
			StringTokenizer tokens = new StringTokenizer(br.readLine());
			int mLine = Integer.parseInt(tokens.nextToken());
			int nLine = Integer.parseInt(tokens.nextToken());
			
			int R, C, S = 0;
			
			Stack<Character> st = new Stack<>();
			
			/**
			 * stack에 (, {, [ 만 입력받아서 최대한 적은 수 받기
			 * 
			 */
			HashMap<Character, Integer> hm = new HashMap<>();
			
			for(int i=0; i<mLine; i++) {
				String line = br.readLine();
				int indentCnt = 0;
				for(int j=0; j<line.length(); j++) {
					
					if(!st.isEmpty()) {
						
					}
					
					// 연속된 .(띄어쓰기)가 나올 경우
					if(line.charAt(j) == '.') {
						indentCnt ++;
					}
					
					
					if(line.charAt(j) == '(' ) {
						st.push('(');
					}else if(line.charAt(j) == '{' ) {
						st.push('{');
					}else if(line.charAt(j) == '[' ) {
						st.push('[');
					}else if(line.charAt(j) == ')' || line.charAt(j)=='}' || line.charAt(j)==']') {
						st.pop();
					}
					
				}
				
				
				
			}
			
			
			
			
		}
		
	}

	static String src = "1\r\n" + 
			"5 4\r\n" + 
			"(Follow.my.style\r\n" + 
			".........starting.from.round.brackets)\r\n" + 
			"{then.curly.brackets\r\n" + 
			".....[.and.finally\r\n" + 
			".......square.brackets.]}\r\n" + 
			"(Thank.you\r\n" + 
			"{for.showing.me\r\n" + 
			"[all\r\n" + 
			"the.secrets]})";
}
