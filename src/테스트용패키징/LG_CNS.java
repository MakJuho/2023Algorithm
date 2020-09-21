package 테스트용패키징;

import java.util.*;

public class LG_CNS {
	
	public static void main(String[] args) {
	
		int[] arr = new int [3];
		for(int i=0; i<arr.length; i++) {
			arr[i] = i+1;
		}
		
		LinkedList<Integer> list = new LinkedList<>();
		
//		Combination(list, arr, 2, 0);
		
		HashMap<Integer, String> map = new HashMap<>();
		
		HashSet<String> set = new HashSet<>();
		set.add("주호");
		set.add("주호2");
		set.add("주호3");
		set.add("주호1");
		set.add("주호1");
		System.out.println(set);
		
		Iterator it = set.iterator();
		
		String[] name= new String[set.size()];
		for(int i=0; i<set.size(); i++) {
			name[i] = it.next().toString();
		}
		
		System.out.println(Arrays.toString(name));
	}
/*	
	public static void Combination(LinkedList<Integer> list, int[] arr, int r, int idx) {
		if( r == 0 ) {
			System.out.println(list);
			return ;
		}
		
		if(arr.length == idx) return;
		
		list.add(arr[idx]);
		Combination(list,arr,r-1,idx+1);
		list.removeLast();
		Combination(list,arr,r,idx+1);
		
	}
	*/
	
}
