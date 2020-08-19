package 카카오인턴;

import java.util.Stack;

public class 괄호변환 {

	static int position;
	
	
	public static void main(String[] args) {
		
		solution("(()())()");
		
		return ;
	}

	public static String solution(String p) {
		
		if(p.isEmpty()) System.out.println(p);
		
		boolean correct = isCorrect(p);
		
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
	
	private static boolean isCorrect(String str) {
		
		boolean ret = true;
		int left = 0, right = 0;
		Stack<Character> mystack = new Stack<>();
		
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) == '(') {
				left++;
				mystack.push('(');
			}else {
				right++;
				if(mystack.isEmpty()) {
					ret = false;
				}else {
					mystack.pop();
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
