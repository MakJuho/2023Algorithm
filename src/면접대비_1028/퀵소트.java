package 면접대비_1028;

import java.util.Arrays;

public class 퀵소트 {
	// 이상적일 경우 O(NlogN)
	// pivot을 기준으로 분리했을 때, 값들을 한 편으로 치우치게 되면 성능 저하로 O(N^2)
/*	먼저 리스트의 정 가운데 있는 값을 pivot 값으로 선택하고,
 *  pivot 값보다 작은 값, 동일한 값 그리고 큰 값을 담아둘 3개의 리스트를 생성합니다. 
 *  그리고 반복문을 통해 각 값을 pivot과 비교 후에 해당하는 리스트에 추가시킵니다. 
 *  그 다음 작은 값과 큰 값을 담고 있는 배열을 대상으로 퀵 정렬 함수를 재귀적으로 호출합니다.
 *   마지막으로 재귀 호출의 결과를 다시 크기 순으로 합치면 정렬된 리스트를 얻을 수 있습니다.
 */
	
	public static void main(String[] args) {
		int[] arr = {8,7,6,5,4,6,2,1,0};
		quickSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}

	private static void quickSort(int[] arr, int low, int high) {
		
		if( low >= high ) return;
		
		int mid = partition(arr, low, high);
		quickSort(arr, low, mid-1);
		quickSort(arr, mid, high);
		
	}
	
	private static int partition(int[] arr, int low, int high) {
		int pivot = arr[(low+high)/2];
		
		while(low <= high) {
			while(arr[low] < pivot) low++;
			while(arr[high] > pivot) high--;
			if(low <= high) {
				swap(arr, low, high);
				low++;
				high--;
			}
		}
		
		return low;
		
		
	}
	private static void swap(int[] arr, int low, int high) {
		int tmp = arr[low];
		arr[low] = arr[high];
		arr[high] = tmp;
	}
	
	
	
}
