package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 타겟넘버 {

	public static void main(String[] args) {
		int [] numbers = { 1, 1, 1, 1, 1 };
		int target = 3;
		
		Queue<Integer> q1 = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();
		int cnt = 0;
		q1.add(numbers[0]);
		for(int i=1; i<numbers.length; i++) {
			while(!q1.isEmpty()) {
				int a = q1.poll().intValue();
				int b = numbers[i];
				
				q2.add(a+b);
				q2.add(a-b);

			}
			System.out.println(q2);
			
			q1.addAll(q2);
			q2.clear();
			
			
		}
//		System.out.println(q1.size());
		for(Integer c : q1) {
			if(c.intValue() == target || c.intValue() == -target) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}


}
