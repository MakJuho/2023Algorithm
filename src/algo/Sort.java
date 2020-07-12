package algo;

import java.util.*;

public class Sort {
	public static void main(String[] args) {
		int[] arr = {1,3,4,6,2,8};
		Integer[] arr_2 = new Integer[arr.length];
		
		int[][] arr3 = {{1,8},{2,7},{3,6}};
		
		
		Integer[][] arr_3= {{1,8},{2,7},{3,6}};
				
				
				
		for(int i=0; i<arr.length; i++) {
			arr_2[i] = arr[i];
		}

		Arrays.sort(arr_2, Collections.reverseOrder());
		
		System.out.println(Arrays.toString(arr_2));
	
		Arrays.sort(arr_2, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				
				return o2.compareTo(o1);
			}
		});
		System.out.println(Arrays.toString(arr_2));

		Arrays.sort(arr_3);
		
		System.out.println(Arrays.toString(arr_3));
		
		
	}
}
