package 알고리즘_1023;

import java.util.ArrayList;

public class 프로그래머스_단어변환 {

	static int ret = 0;
	public static void main(String[] args) {
		String begin = "hit";
		String target = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		
		ArrayList<String> list = new ArrayList<>();
		
		
		while(true) {

			if(begin.equals(target)) break;
			
			// 단어 한글자 차이를 찾는다.
			for(String word : words) {
				int cnt = 0;
				for(int i=0; i<begin.length(); i++) {
					if(word.charAt(i) != begin.charAt(i)) {
						cnt++;
					}
				}
				
				if(cnt == 1) {
					list.add(word);
				}
			}
			
			
			
			
		}
		
		System.out.println(ret);
		
		
		
		
		
		
	}
}
