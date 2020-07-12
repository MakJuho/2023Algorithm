package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class 가장큰수 {
//	static LinkedList<Integer> list = new LinkedList<>();
	static ArrayList<Integer> list2 = new ArrayList<>();
	public static void main(String[] args) {
		int[] numbers = { 3, 30 };
		LinkedList<Integer> list = new LinkedList<>();
//		boolean[] check = new boolean[numbers.length];
		int[] check = new int[numbers.length];
		permutation(list, numbers, check, numbers.length, numbers.length);
		

		Collections.sort(list2, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
		System.out.println(list2);
		String answer = "";
		answer = list2.get(0).toString();
		System.out.println(answer);
	}
	//순열
	private static void permutation(LinkedList<Integer> list, int[] numbers, int[] check, int n, int r) {
		if(list.size() == r){
			StringBuilder sb = new StringBuilder();
			for(int i : list){
				sb.append(i);
			}
			list2.add(Integer.parseInt(sb.toString()));
			
			return;
		}
		for(int i=0; i<n; i++){//**중복 순열과 다른 점
			if(check[i] == 0){//자기자신을 못뽑게 해야지 중복이 안됨(이미 뽑은 것은 뽑지 않도록 체크)
				check[i] = 1;//자기자신을 못뽑게 해야지 중복이 안됨
				list.add(numbers[i]);
				permutation(list, numbers, check, n, r);
				list.removeLast();//해당 넘버를 다시 제거 (즉,뽑지 않고 다음 번호 뽑기위함)
				check[i] = 0;
			}
		}
	}
	
}
