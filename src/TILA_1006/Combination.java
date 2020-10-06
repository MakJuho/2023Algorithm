package TILA_1006;

import java.util.LinkedList;

public class Combination {

	
	static LinkedList<String> list = new LinkedList<String>();
	static String[] strs = {"AA", "C", "BB", "DD"};
	public static void main(String[] args) {
		
		
		// 조합 -> 2개씩 출력
		Combination(4, 2, 0);
	
	
	}
	
	static void Combination(int n, int r, int idx) {
		if(r == 0) {
			System.out.println(list);
			return;
		}
		if(idx == strs.length) return;
		
		list.add(strs[idx]);
		Combination(n, r-1, idx+1);
		list.removeLast();
		Combination(n, r, idx+1);
		
		
		
		
	}
	
	
}
