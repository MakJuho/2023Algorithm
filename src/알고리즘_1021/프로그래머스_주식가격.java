package 알고리즘_1021;

import java.util.Arrays;

public class 프로그래머스_주식가격 {
	public static void main(String[] args) {
		int[] prices = {1,2,3,2,3};
		solution(prices);
	}
	
	private static void solution(int[] prices) {
		int[] answer = new int[prices.length];
		
		for(int i=0; i<prices.length; i++) {
			
			int target = prices[i];
			int cnt= 0;
			for(int j=i+1; j<prices.length; j++) {
				
				cnt++;
				if(target <= prices[j]) {
					
				}else {
					break;
				}
			}
			
			answer[i] = cnt;
			
			
		}
		System.out.println(Arrays.toString(answer));
		
	}
}
