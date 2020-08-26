package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_17298_오큰수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		int N = Integer.parseInt(br.readLine());
		int[] numbers = new int[N];
		int[] answers = new int[N];
		
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			numbers[i] = Integer.parseInt(tokens.nextToken());
		}
		
		Stack<Integer> st = new Stack<>();
		
		st.push(0);
		
		for(int i=1; i<N; i++) {
			if(st.isEmpty()) {
				st.push(i);
			}
			
			while(!st.isEmpty() && numbers[i] > numbers[st.peek()]) {
				answers[st.pop()] = numbers[i];
			}
			
			st.push(i);
		}
		
		while(!st.isEmpty()) {
			answers[st.pop()] = -1;
		}

		for(int a: answers) {
			System.out.print(a+" ");
		}
	}
	
	static String src = "4\r\n" + 
			"9 5 4 8";
}
