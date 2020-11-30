package 면접대비_1103;

import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {
		int [] arr = {6,4,7,2,6,11,0};
		
		QuickSort(arr, 0, arr.length-1);

		System.out.println(Arrays.toString(arr));
		
	}
	
	private static void QuickSort(int[] arr, int low, int high) {
		if(low >= high) return;
		
		// 중간 값을 구한다.
		int mid = partition(arr, low, high);
	
		QuickSort(arr,low,mid-1);
		QuickSort(arr,mid,high);
		
	}
	
	private static int partition(int[] arr, int low, int high) {
		
		int pivot = arr[(low+high)/2];
		
		while(low <= high) {
			while(arr[low] < pivot) low++;
			while(arr[high] > pivot) high--;
			
			if(low<=high) {
				swap(low,high,arr);
				low++;
				high--;
			}
		}
		
		return low;
		
	}
	
	private static void swap(int low, int high, int[] arr) {
		int tmp = arr[low];
		arr[low] = arr[high];
		arr[high] = tmp;
	}
	
	
	
	
}
