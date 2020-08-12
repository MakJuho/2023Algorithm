package programmers;

import java.util.Arrays;

public class 조이스틱 {
	
	public static void main(String[] args) {
		String name = "BBAA";
		
		char[] arr = new char[name.length()];
		
		int cntUpDown = 0;
		
		// 숫자 A~Z 까지 있을 때, 위로 올라가는 게 빠른지 밑으로 내려가는 게 빠른지
		for(int i=0; i<name.length(); i++) {
			arr[i] = name.charAt(i);
			int diff = (int)arr[i]-'A';
			int val =0;
			if(diff > 13) {
				cntUpDown += 26-diff;
			}else {
				cntUpDown += diff;
			}
		}
		
		// 위치 오른쪽으로 가는 게 빠른지, 왼쪽으로 가는게 빠른지 체크
		
		int minMove = name.length() - 1;
        for(int i = 0 ; i < name.length() ; i++) {
            if(name.charAt(i) != 'A') {
                int next = i+1;
                while(next < name.length() && name.charAt(next) == 'A') {
                    next++;
                }
                int move = 2 * i + name.length() - next;
                minMove = Math.min(move, minMove);
            }
        }
		
		
		System.out.println(minMove + cntUpDown);
		
		
		
		return ;
	}
}
