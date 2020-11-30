package LGCNS_1016;

import java.util.Arrays;

public class 이분탐색 {

	/**
	 * 이분탐색은 정렬한 상태에서 가운데 지점을 기준으로 판별하여
	 * 빠르게 가까운 값을 찾을 때 사용한다.
	 * 
	 */
	
	static int ret = 0;
	
	public static void main(String[] args) {
		int target = 39;
		int[] times = {9,0, 1,2,3,4,5,6,10,11,15,20,7,8,39,55,68};
		
		Arrays.sort(times);
		
		binarySearch(times, target);
		System.out.println(ret);
	}
	
	private static void binarySearch(int[] times, int target) {
		int left = 0;
		int right = times.length-1;
		
		while(left <= right) {
			int mid = (left+right) / 2;
			
			if(times[mid] > target) {
				right = mid-1;
			}else if(times[mid] < target) {
				left = mid+1;
			}else if(times[mid] == target){
				ret = mid;
				break;
			}
		}
		
		
	}
	
	
}
