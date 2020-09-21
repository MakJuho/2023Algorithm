package 카카오_예선테스트;

public class 아이디생성 {
	
	public static void main(String[] args) {
//		solution("...!@BaT#*..y.abcdefghijklm");
		solution("abcdefghijklmn.p");
		return ;
	}
	
	public static String solution(String new_id) {
        
		// 1 단계 : 모든 대문자를 소문자로.
		new_id = new_id.toLowerCase();
		
		// 2단계 : 소문자, 숫자, 빼기, 밑줄, 마침표을 제외하고 나머지 제거
		String tmp = "";
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<new_id.length(); i++) {
			// 소문자
			if(new_id.charAt(i) >= 'a' && new_id.charAt(i) <='z') {
				sb.append(new_id.charAt(i));
			}
			
			// 숫자
			else if(new_id.charAt(i)>='0' && new_id.charAt(i)<='9') {
				sb.append(new_id.charAt(i));
			}
			
			else if(new_id.charAt(i) == '-') {
				sb.append(new_id.charAt(i));
			}
			
			else if(new_id.charAt(i) == '_') {
				sb.append(new_id.charAt(i));
			}
			
			else if(new_id.charAt(i) == '.') {
				sb.append(new_id.charAt(i));
			}
		}
		
		new_id = sb.toString();
		
		// 3단계 : 마침표가 연속으로 나올 경우, .으로 변경
		int cnt = 0;
		sb = new StringBuilder();
		for(int i=0; i<new_id.length(); i++) {
			if(new_id.charAt(i) == '.') {
				cnt++;
			}else {
				if(cnt >= 1) {
					sb.append('.');
					cnt = 0;
				}
				sb.append(new_id.charAt(i));
			}
		}
		new_id = sb.toString();
		

		// 4단계 : 처음이나 끝에 위치한 마침표를 제거한다.
		if(!new_id.isEmpty()) {
			if(new_id.charAt(0) == '.') {
				if(new_id.charAt(new_id.length()-1) == '.') {
					// 처음과 끝에 마침표 위치
					new_id = new_id.substring(1,new_id.length()-1);
				}else {
					// 처음에만 마침표 위치
					new_id = new_id.substring(1,new_id.length());
				}
			}else if(new_id.charAt(new_id.length()-1) == '.') {
				// 마지막에만 마침표 위치
				new_id = new_id.substring(0,new_id.length()-1);
			}
		}
		

		
		// 5단계 : 빈문자열이라면 a대입
		if(new_id.isEmpty()) {
			new_id = "a";
		}
		
		// 6단계 : 문자열의 길이가 16이상이면 첫 15개를 제외하고 삭제
		if(new_id.length()>= 16) {
			new_id=new_id.substring(0,15);
			// 만약 마지막 문자열이 마침표이면 삭제
			if(new_id.charAt(14) =='.') {
				new_id=new_id.substring(0,14);
			}
		}
		
		// 7단계 : new_id가 2자 이하라면, 마지막 문자를 길이 3될 때까지 반복
		while(new_id.length()<=2) {
			new_id += new_id.charAt(new_id.length()-1);
		}
		
	
        
        
        
        
        
        return new_id;
    }
}
