package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Stack;

public class BOJ_9935_문자열폭발 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		String str = br.readLine();
		String bomb = br.readLine();
		
		Stack<Character> st = new Stack<>();

		for(int i=str.length()-1; i>=0; i--) {
			char val = str.charAt(i);
			boolean isBomb = true;
			st.push(val);
			
			// bomb이랑 일치하는지?
			if(bomb.charAt(0)==val && st.size() >= bomb.length()) {
				for(int j=0; j<bomb.length(); j++) {
					if(bomb.charAt(j) != st.get(st.size()-1-j)) {
						isBomb = false;
						break;
					}
				}
				if(isBomb) {
					for(int j=0; j<bomb.length(); j++) {
						st.pop();
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		if(st.isEmpty()) {
			System.out.println("FRULA");
		}else {
			for(int i=st.size()-1; i>=0; i--) {
				sb.append(st.pop());
			}
		}
		System.out.println(sb);
	
	}
	

	static String src = "12ab112ab2ab\r\n" + 
			"12ab";
}
