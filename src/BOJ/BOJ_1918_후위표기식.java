package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Stack;

public class BOJ_1918_후위표기식 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		String line = br.readLine();
		String ans="";
		Stack<Character> st = new Stack<>();
		
		for(int i=0; i<line.length(); i++) {
			if(line.charAt(i) >='A' && line.charAt(i) <='Z') {
				ans+= line.charAt(i);
			}
			else if(line.charAt(i) == '(') {
				st.push('(');
			}
			else if(line.charAt(i) == ')') {
				// '('만날 때까지 모든 연산자 출력.
				while(!st.isEmpty()) {
					char op = st.pop();
					if(op == '(') break;
					ans += op;
				}
			}
			/**
			 * 우선순위
			 * +, -: 1
			 * *, /: 2
			 * 우선순위가 같거나 낮다면 pop()
			 */
			else {
				while(!st.isEmpty() && precedence(st.peek()) >= precedence(line.charAt(i))) {
					ans+=st.pop();
				}
				st.push(line.charAt(i));
			}
//			else if(line.charAt(i) == '*' || line.charAt(i) == '/' ) {
//				if(!st.isEmpty()) {
//					while(st.peek() == '*' || st.peek() == '/') {
//						ans += st.pop();
//					}
//				}
//				st.push(line.charAt(i));
//			}
//			else if(line.charAt(i) == '+' || line.charAt(i) == '-') {
//				if(!st.isEmpty()) {
//					while(st.peek() == '*' || st.peek() =='/' || st.peek() == '+' || st.peek() =='-') {
//						ans+= st.pop();
//					}
//				}
//				st.push(line.charAt(i));
//			}
//			
			
			
		}
		while(!st.isEmpty()) {
			ans+=st.pop();
		}
		System.out.println(ans);
		
	}
	
	private static int precedence(Character ch) {
		if(ch =='(') return 0;
		else if(ch == '+' || ch =='-') return 1;
		return 2;
	}

	static String src = "(A+(B*C))-(D/E)";
}
