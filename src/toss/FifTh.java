package toss;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FifTh {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer tokens = new StringTokenizer(input);
//		System.out.println(input);
//		input = br.readLine();
//		System.out.println(input);
		
		int spaceCnt=0;
		for(int i=0; i<input.length(); i++) {
			if(input.charAt(i) == ' ') {
				spaceCnt++;
			}
		}
		spaceCnt++;
		
		int[][] Cost = new int[2][spaceCnt];
		boolean isFirst = true;
		
		for(int r=0; r<2; r++ ) {
			if(isFirst) {
				isFirst=false;
			}else {
				tokens = new StringTokenizer(br.readLine());
			}
			for(int c=0; c<spaceCnt; c++) {
				Cost[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		int[] ans = new int[spaceCnt];
		
		for(int i=0; i<spaceCnt; i++) {
			if(Cost[0][i] - Cost[1][i] < 0 ) {
				ans[i] = 0;
			}else {
				ans[i] = Cost[0][i] - Cost[1][i];
			}
		}
		
		System.out.println(Arrays.toString(ans));
		

		
	}
}
