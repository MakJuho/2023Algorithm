package algo;

import java.util.Arrays;

public class LIS_2 {

	public static void main(String[] args) {
		int[] a = {8,2,4,3,6,11,7,10,14,5};
		int[] C = new int[a.length];
		int size = 0; // LIS 개수 관리할 변수
		
		C[size++] = a[0]; // 첫 번째 숫자는 바로 반영
		for (int i = 0; i < a.length; i++) {
			if(C[size-1] < a[i]) {
				C[size++] = a[i];
			}else {
				int temp = Arrays.binarySearch(C, 0, size, a[i]);// return 삽입할 위치* -1
				if(temp<0) temp = -temp-1;
				C[temp] = a[i]; // 수열의 값을 LIS에 삽입할 위치에 덮어쓰기
			}
		}
		System.out.println(Arrays.toString(C)+":C");
		System.out.println("LIS 개수 : "+ size);
		
	}
}
