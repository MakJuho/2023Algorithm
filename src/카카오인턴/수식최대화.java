package 카카오인턴;

import java.util.ArrayList;
import java.util.LinkedList;

public class 수식최대화 {
	
	static LinkedList<Character> list = new LinkedList<>();
	static boolean []v;
	static int a,b,c;
	static long ans;
	static String expressions;
	static ArrayList<Long> nums = new ArrayList<>();
	static ArrayList<Character> ops = new ArrayList<>();
	
	
	public static void main(String[] args) {
		String expression = "50*6-3*2";
		expressions = expression;
		long answer = 0;
		char[] exp = {'+', '-', '*'};
		boolean isOut = false;
		v = new boolean[3];
		
		for(int i=0; i<expression.length(); i++) {
			StringBuilder sb = new StringBuilder();
			while(!isOut && expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
				// 숫자
				sb.append(expression.charAt(i));
				i++;
				if(i == expression.length()) isOut = true;
			}
			nums.add(Long.parseLong(sb.toString()));
			
			// 부호
			if(!isOut) ops.add(expression.charAt(i));
		}
		
		/**
		 * +, -, *를 6가지 경우로 우선순위를 정하기
		 */
		Permutation(exp, 3, 0);
		

		System.out.println();
		
		
		
	}

	private static void Permutation(char[] exp, int r, int idx) {
		if(list.size() == r) {
			Calculate();
			return ;
		}
		else if (idx == exp.length) return;
		
		for(int i=0; i<exp.length; i++) {
			if(!v[i]) {
				v[i] = true;
				list.add(exp[i]);
				Permutation(exp, r, idx+1);
				v[i] = false;
				list.removeLast();
			}
		}
	}

	private static void Calculate() {
		/**
		 * 문자열을 0~ length()-1까지 탐색해서 exp1 연산자가 나오면 앞 뒤 숫자 연산해서 문자열 변경
		 * 그 후 , exp2
		 * 그 후 , exp3
		 */
		
		ArrayList<Long> cNums = new ArrayList<>(nums);
		ArrayList<Character> cOps = new ArrayList<>(ops);
		
//		System.out.println(cNums.size()+" : "+cOps.size());
		
		for(int i=0; i < list.size(); i++) {
			for(int j=0; j< cOps.size(); j++) {
				// 계산 부호가 같으면
				if(list.get(i) == cOps.get(j)) {
					Long res = calc(cNums.remove(j), cNums.remove(j), list.get(i));
					cNums.add(j, res);
					cOps.remove(j);
					j--;
				}
			}
			
		}
		
		ans = Math.max(ans, Math.abs(cNums.get(0)));
	
		return ;
		
		
	}

	private static Long calc(Long num1, Long num2, Character op) {
		long num = 0;
		
		switch(op) {
			case '+' :{
				return num1 + num2;
			}
			case '-' :{
				return num1 - num2;
			}
			case '*' :{
				return num1 * num2;
			}
		}
		
		return num;
	}
}
