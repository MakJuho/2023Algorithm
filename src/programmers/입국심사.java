package programmers;

import java.util.Arrays;

public class 입국심사 {
	
	static long ret = Integer.MAX_VALUE;
	public static void main(String[] args) {
		int n = 6;
		int[] times = {7, 10};
		Arrays.sort(times);
		binarySearch(n, times, times[times.length-1]);
		
		System.out.println(ret);
		
	}

	private static void binarySearch(int n, int[] times, int max) {
		int left = 1;
		int right = max*n;
		
		// 걸리는 시간의 최솟값.
		
		
		while(left <= right) {
			int mid = (left + right )/2;
			
			if(isPassed(n, mid, times)) {
				right = mid-1;
			}else {
				left = mid+1;
			}
			
		}

	
		
	}

	private static boolean isPassed(int n, long mid, int[] times) {
		
		long amount = 0;
		for(int i=0; i<times.length; i++) {
			amount += mid/times[i];
		}
		
		if( n <= amount) {
			if(ret > mid) {
				ret = mid;
			}
			return true;
		}
		
		return false;
	}
}
