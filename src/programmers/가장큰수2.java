package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class 가장큰수2 {
//	static LinkedList<Integer> list = new LinkedList<>();
	static ArrayList<Integer> list2 = new ArrayList<>();
	public static void main(String[] args) {
		int[] numbers = { 6, 10, 2 };
		String answer ="";
		String[] arr = new String[numbers.length];
		
		for(int i=0; i<numbers.length; i++) {
			arr[i] = (String.valueOf(numbers[i]));
		}
		
		Arrays.sort(arr, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return (o2+o1).compareTo(o1+o2);
				
			}
		});
		
		if(arr[0].equals("0")) System.out.println("0");;
		
		for(int i=0; i<arr.length; i++) {
			answer +=arr[i];
		}
		
		System.out.println(answer);
		
		
	}
	
}
