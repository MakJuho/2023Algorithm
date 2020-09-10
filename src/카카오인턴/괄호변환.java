package 카카오인턴;

import java.util.Stack;

public class 괄호변환 {

	static int position;
	
	
	public static void main(String[] args) {
		
		solution("()))((()");
		
		return ;
	}

	public static String solution(String p) {
		
		// pattern 비어있을 때
		if(p.isEmpty()) System.out.println(p);
		
		boolean correct = isCorrect(p);
		
		// substring은 마지막 무
		String u = p.substring(0, position);
		String v = p.substring(position, p.length());
		
		if(correct) {
			return u+solution(v);
		}
		
		String answer = "(" + solution(v) + ")";
		
		for(int i=1; i<u.length()-1; i++) {
			if(u.charAt(i) == '(') {
				answer +=")";
			}else {
				answer +="(";
			}
		}
		
		return answer;
	}
	
	// 올바른 괄호문자열
	private static boolean isCorrect(String str) {
		
		boolean ret = true;
		int left = 0, right = 0;
		Stack<Character> st = new Stack<>();
		
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) == '(') {
				left++;
				st.push('(');
			}else {
				right++;
				if(st.isEmpty()) {
					ret = false;
				}else {
					st.pop();
				}
			}
			if(left == right) {
				position = i+1;
				return ret;
			}
		}
		
		return true;
	}
}
