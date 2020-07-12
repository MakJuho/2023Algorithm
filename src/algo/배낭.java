package algo;

import java.util.Arrays;

/* 0-1 knapsack
 * DP
*/
public class 배낭 {
	public static void main(String[] args) {
		int W = 10; // 배낭의 무게..
		int[] w = {0, 5, 4, 6, 3}; // 무게(kg)
		int[] v = {0, 10, 40, 30, 50}; // 가치(만원)
		int[][] K = new int[w.length][W+1]; // 최대 배낭에 담은 물건의 가치
		
		for(int i=1; i< w.length; i++) { // 물건의 종류
			for(int j = 0; j < w[i]; j++) { // 임시 배낭의 무게가 5kg보다 적으면 이전 차수에서 값을 가져옴
				K[i][j] = K[i-1][j];
			}
			
			for( int j = w[i]; j <= W; j++) {
				int now = K[i-1][j-w[i]] + v[i];// 물건 선택을 고려한 경우
				int pre = K[i-1][j]; // 물건을 고려하지 않은 경우
				K[i][j] = now >= pre ? now : pre;
			}
		}
		
		for(int i=0; i<K.length; i++) {
			System.out.println(Arrays.toString(K[i]));
		}
		
		
	}
}
