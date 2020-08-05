package toss;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Third {

	
	public static void main(String[] args) throws Exception {
		// [!!주의!!] Function.compute 함수는 이미 구현되어있지만, 숨김처리되어 있습니다. 호출해서 테스트 해주세요.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
	
		int spaceCnt=0;
		for(int i=0; i<input.length(); i++) {
			if(input.charAt(i) == ' ') {
				spaceCnt++;
			}
		}
		spaceCnt++;
		
		HashMap<Integer, Integer> hm = new HashMap<>();
		
		StringTokenizer tokens = new StringTokenizer(input);
		for(int i=0; i<spaceCnt; i++) {
			hm.put(Integer.parseInt(tokens.nextToken()), i);
		}

		tokens = new StringTokenizer(input);
		for(int i=0; i<spaceCnt; i++) {
			System.out.print(hm.get(Integer.parseInt(tokens.nextToken()))+" ");
		}
		
	}
}
