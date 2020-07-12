package programmers;

import java.util.LinkedList;
import java.util.Arrays;
public class 숫자_야구 {

	static LinkedList<Integer> list = new LinkedList<>();
	static int rlt=0;
	public static void main(String[] args) {
		int[][] baseball= {{123, 1, 1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}};
		
//		서로 다른 경우의 수 구하는 경우
		int[] arr = {1,2,3,4,5,6,7,8,9};
		boolean[] check = new boolean[arr.length];
		Arrays.fill(check,false);
		Per(arr, 3, check, baseball);
//		Com(arr, 0, 3, baseball);
		
		System.out.println(rlt);
		
	}

	private static void Per(int[] arr, int r, boolean[] check, int[][] baseball) {
		if(list.size()==r) {
			int tot=0;
			
			for(int i=0; i<baseball.length; i++) {
				int strike=0;
				int ball=0;
				// 첫째 자리
				if(baseball[i][0]/100 == list.get(0).intValue()) {
					strike++;
				}else if(baseball[i][0]/100 == list.get(1).intValue() ||
						baseball[i][0]/100 == list.get(2).intValue()) {
					ball++;
				}
				
				
				// 둘째 자리
				if((baseball[i][0]/10)%10 == list.get(1).intValue()) {
					strike++;
				}else if((baseball[i][0]/10)%10 == list.get(0).intValue() ||
						(baseball[i][0]/10)%10 == list.get(2).intValue()) {
					ball++;
				}
				
				// 셋째 자리
				if(baseball[i][0]%10 == list.get(2).intValue()) {
					strike++;
				}else if(baseball[i][0]%10 == list.get(0).intValue() ||
						baseball[i][0]%10 == list.get(1).intValue()) {
					ball++;
				}
				
				if(strike == baseball[i][1] && ball == baseball[i][2]) {
					tot++;
				}
				
				
			}
			if(tot == baseball.length) {
				rlt++;
			}
			return ;
		}
		
		for(int i=0; i<arr.length; i++) {
			if(!check[i]) {
				check[i] = true;
				list.add(arr[i]);
				Per(arr,r,check, baseball);
				list.removeLast();
				check[i] = false;
			}
		}
		
	}
	
	
}
