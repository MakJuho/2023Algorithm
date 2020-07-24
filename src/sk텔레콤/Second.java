package sk텔레콤;

import java.util.Arrays;
import java.util.LinkedList;

public class Second {

	static LinkedList<Integer> selected = new LinkedList<>();
	static int sumPartB;
	static int[] dice = {1,2,3,4,5,6};
	static int[] check = new int[6];
	static boolean isPossible = false;
	static int[] ans;
	
	
	public static void main(String[] args) {
		int[] A = {6, 1} ;
		int F = 1;
		int M = 1;
		int sumA=0;

		for(int i=0; i<A.length; i++) {
			sumA += A[i];
		}
		
		ans = new int[F];
		sumPartB = M*(F+A.length)-(sumA);
		rePermutation(F,0);
		if(!isPossible) {
			ans = new int[1];
			ans[0] = 0;
			System.out.println(Arrays.toString(ans));
		}else {
			System.out.println(Arrays.toString(ans));
		}
		
	}
	
	private static void rePermutation(int r, int idx) {
		
		
		if(selected.size() == r) {
			int selectedSum =0;
			for(int dice: selected) {
				selectedSum += dice;
			}
			
			if(selectedSum == sumPartB) {
//				System.out.println(selected);
				isPossible = true;
				for(int i=0; i<selected.size(); i++) {
					ans[i] = selected.get(i);
				}
				// System.exit(0);
				// exit? 
			}
			return;
		}

		for(int i=0; i<dice.length; i++) {
			selected.add(dice[i]);
			rePermutation(r,idx);
			// boolean 조건
			selected.removeLast();
		}
		
		
	}
	
	
}
