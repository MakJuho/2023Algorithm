package programmers;

import java.util.*;

public class 기능개발 {
	
	static int checkpt = -1;
	public static void main(String[] args) {
		int[] progresses= {40, 93, 30, 55, 60, 65};
		int[] speeds = {60, 1, 30, 5 , 10, 7};
		
		int[] check = new int[progresses.length];
		
		
		Stack<Integer> st = new Stack<>();
		ArrayList<Integer> list = new ArrayList<>();
		
		while(!isOut(check)) {
			boolean flag = false;
			for(int i=0; i<progresses.length; i++) {
				
				progresses[i] += speeds[i];
				if(progresses[i] >= 100) {
					if(checkpt == i) {
						flag = true;
					}
					if(check[i]==0) {
						check[i] = 1;
						st.add(i);
					}
					
				}
			}
			
			
			
			if(flag) {
				int cnt=0;
				for(int i=checkpt; i<check.length; i++) {
					if(check[i] == 1) {
						check[i] = 2;
						cnt++;
					}
					if(check[i] == 0) break;
				}
				
				list.add(cnt);
				while(!st.isEmpty()) {
					st.pop();
				}
			}
			
			
		}
		
		int[] answer = new int[list.size()];
        
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        
        System.out.println(Arrays.toString(answer));
		
		
		//System.out.println(list);
		// 1. 시간 증가함
		
		//
		
		
	}

	private static boolean isOut(int[] check) {
		int tot=0;
		boolean flag = false;
		
		for(int i=0; i<check.length; i++) {
			
			if(check[i]==1 || check[i] ==2) {
				tot ++;
			}
			else {
				if(!flag) {
					checkpt = i;
					flag = true;
				}
				
			}
		}
		
		if(tot == check.length) {
			return true;
		}
		
		return false;
	}
}
