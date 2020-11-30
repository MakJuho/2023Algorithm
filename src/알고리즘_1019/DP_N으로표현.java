package 알고리즘_1019;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class DP_N으로표현 {

	
	static int N;
	static int number;
	public static void main(String[] args) {
		N = 5;
		number = 12;
		
		if ( N == number) {
			System.out.println(1);
			return ;
		}
		
		int[] check = new int[(N==1)?number*10:(int)Math.pow(N, 8)+1];
		
//		System.out.println(Arrays.toString(check));
//		System.out.println(check.length);
		
		Map<Integer, LinkedList<Integer>> count = new HashMap<>();
		LinkedList<Integer> tmp = new LinkedList<>();
		tmp.add(N);
		count.put(1,  tmp);
		check[N] =1;
		
		int repeat = N;
		for(int i=2; i<=8; i++) {
			tmp = new LinkedList<Integer>();
			repeat = repeat*10 + N;
			if(repeat == number) {
				System.out.println(i);
				return;
			}
		}
		
		
		
		
	}
}
