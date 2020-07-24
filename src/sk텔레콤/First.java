package sk텔레콤;

public class First {
	public static void main(String[] args) {
		int A = 3;
		int B = 7;
		
		int val = A*B;
		
		String ans = Integer.toBinaryString(val);
		int ansCnt=0;
		for(int i=0; i<ans.length(); i++) {
			if(ans.charAt(i) == '1') {
				ansCnt++;
			}
		}
		
		System.out.println(ansCnt);
		
	}
}
