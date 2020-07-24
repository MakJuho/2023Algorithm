package sk텔레콤;

public class Third {
	public static void main(String[] args) {
		String S = "bbbbb";
	
		if(S.length() <=2){
//			return 0;
		}
		
		int ans =0;
		for(int forwardIdx = 1; forwardIdx < S.length()-1; forwardIdx++ ) {
			for(int backwardIdx = forwardIdx+1; backwardIdx < S.length(); backwardIdx++) {
				String forward = S.substring(0, forwardIdx);
				String middle = S.substring(forwardIdx, backwardIdx);
				String backward = S.substring(backwardIdx, S.length());
				int aCnt=0, bCnt=0, cCnt=0;
				for(int i=0; i<forward.length(); i++) {
					if(forward.charAt(i) == 'a') {
						aCnt++;
					}
				}
				for(int i=0; i<middle.length(); i++) {
					if(middle.charAt(i) == 'a') {
						bCnt++;
					}
				}
				for(int i=0; i<backward.length(); i++) {
					if(backward.charAt(i) == 'a') {
						cCnt++;
					}
				}
				if( aCnt == bCnt && bCnt == cCnt) {
					ans ++;
				}
				
			}
		}
		
		System.out.println(ans);
		
	}
}
