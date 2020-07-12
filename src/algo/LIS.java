package algo;

import java.util.Arrays;

/*
 * O[N^2]
*/
public class LIS {
	public static void main(String[] args) {
		int[] a = {3,2,6,4,5,1};
		int[] LIS = new int[a.length]; // i 번째 숫자를 마지막 글자로 사용할 경우의 최장 증가수열의 길이
		int[] path = new int[a.length]; // 경로 역추적을 하기위해
		
		for (int i = 0; i < LIS.length; i++) {
			LIS[i] = 1; // 초기 값(1개짜리 수열);
			path[i] = -1; // 나의 앞에 수열 숫자의 index
			for( int j =0; j< i; j++) { // 내 앞의 숫자중에 나보다 작은 숫자를 찾기
				if(a[j] < a[i] && LIS[i] < LIS[j] + 1) {
					LIS[i] = LIS[j] + 1;
					path[i] = j;
				}
			}
		}
		
//		System.out.println(Arrays.toString(LIS));
		int maxLISIndex = 0;
		for (int i = 0; i < LIS.length; i++) {
			if( LIS[maxLISIndex] < LIS[i] ) {
				maxLISIndex = i;
			}
		}
		System.out.println("최장 증가 수열의 길이: " +LIS[maxLISIndex]);
		System.out.println(Arrays.toString(path));
		
		String result = "";
		
		for (int i = maxLISIndex; i != -1 ;i = path[i]) {
			result = a[i] + " " + result;
		}
		System.out.println(result);
		
	} // end of main
}


