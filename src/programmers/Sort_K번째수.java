package programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Sort_K번째수 {

	
	public static void main(String[] args) {
		int[] array = {1, 5, 2, 6, 3, 7, 4}; 
		int[][] commands= {
				{2, 5, 3},
				{4, 4, 1},
				{1, 7, 3}
		};
		int[] answer = new int[commands.length];
//		LinkedList<Integer> list = new LinkedList<>();
		for(int a=0; a<commands.length; a++) {
			
			int i = commands[a][0];
			int j = commands[a][1];
			int k = commands[a][2];
			int cnt=0;
			int [] temp = new int[j-i+1];
			for(int b=i-1; b<j; b++) {
				
				temp[cnt++] = array[b];
			}
//			System.out.println(Arrays.toString(temp));
			Arrays.sort(temp);
//			System.out.println(Arrays.toString(temp));
			
			answer[a]= temp[k-1];
			
			
			
			
			/*
			 * list.clear(); for(int b=i-1; b<j; b++) { list.add(array[b]); }
			 * 
			 * //System.out.println(list); Collections.sort(list);
			 */
			
			
//			answer[a] = list.get(k-1);
		}
	
		System.out.println(Arrays.toString(answer));
	}
}
