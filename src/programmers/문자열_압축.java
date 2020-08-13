package programmers;

public class 문자열_압축 {
	

	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) {
		
		String s = "abcabcabcabcdededededede";
		StringBuilder sb = new StringBuilder();
		/**
		 * 절반까지만 단위로 계산
		 */
		
		for(int size = 1; size <=s.length()/2; size++) {
			String compressed = "";
			String target = "";
			String current = "";
			
			int cnt = 1; 
			
			/**
			 *  target 지정 : 앞에서부터 크기 1~ size의 절반까지
			 */
			for(int i=0; i<size; i++) {
				target += s.charAt(i);
			}

			for(int i=size; i<s.length(); i+=size) {
				current = "";
				// 현재 값을 채워줌( 크기 만큼 size )
				for(int j= i; j< i+size; ++j) {
					if(j >= s.length()) break;
					current += s.charAt(j);
				}

				// 현재 target과 값이 같을 때
				if( target.equals(current)) {
					cnt++;
				}else {
					// 현재 target과 다를 때 새로운 값을 넣어주고 cnt 1로 초기화
					if(cnt > 1 ) {
						compressed += cnt + target;
					}else {
						compressed += target;
					}
					cnt =1 ;
					target = current;
				}
			
			}
			
			
			// 마지막 단위를 넣어주는 부분
			if(cnt > 1) {
				compressed += cnt + target;
			}else {
				compressed += target;
			}
			
			int length = compressed.length();
			min = Math.min(length, min);
			
			
		}
		if(min == Integer.MAX_VALUE) min =1;
		System.out.println(min);
	
	}
}
