package KT대비_1029;

import java.util.Arrays;

public class 프로그래머스_정렬 {
	/**
	 * H-Index : h번 이상 인용된 논문 수가 h편 이상일 경우, 과학자의 최댓값은 h
	 */
	
	public static void main(String[] args) {
		int[] citations = {3,0,6,1,5};
		
		
		int h = 0;
		while(true) {
			int cnt = 0;

			for(int i=0; i<citations.length; i++) {
				if(citations[i] >= h) {
					cnt ++;
				}
			}
			if( h > cnt) {
				h--;
				break;
			}
			h++;
			
		}
		System.out.println(h);
		
	}
	
}
