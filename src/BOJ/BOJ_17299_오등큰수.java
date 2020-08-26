package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_17299_오등큰수 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		// 1 ~ 1,000,000
		int N = Integer.parseInt(br.readLine());
		
		int[] numbers = new int[N];
		int[] counts = new int[1000001];
		int[] answer = new int[N];
		
		StringTokenizer tokens = new StringTokenizer(br.readLine());

		/**
		 * numbers에는 배열 input
		 * counts : 숫자 개수만큼 카운트
		 */
		for(int i=0; i<N; i++) {

			numbers[i] = Integer.parseInt(tokens.nextToken());
			counts[numbers[i]] ++;
		}
		
		Stack<Integer> st = new Stack<>();

		
		st.push(0);
		
		
		//st은 거꾸로 카운트 하기 위해 사용.
		for(int i=1; i<N; i++) {
			
			if(st.isEmpty()) {
				st.push(i);
			}
			
			/**
			 * 이 부분 이해하기 빡세다..
			 * 자기보다 큰 F(Ai)나오면 그때 answer에 값을 넣어준다.
			 */
			while(!st.isEmpty() && counts[numbers[i]]>counts[numbers[st.peek()]]) {
				answer[st.pop()] = numbers[i];
			}
			st.push(i);
			
		}
		
		while(!st.isEmpty()) {
			answer[st.pop()] = -1;
		}
		
		for(int a: answer) {
			System.out.print(a+" ");
		}
	}
	
	static String src="7\r\n" + 
			"1 1 2 3 4 2 1";
}
