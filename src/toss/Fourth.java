package toss;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Stack;
import java.util.StringTokenizer;

public class Fourth {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringBuilder sb = new StringBuilder();
		Stack<String> st = new Stack<>();
		Stack<String> st2 = new Stack<>();
		
		StringTokenizer tokens = new StringTokenizer(input);
		int spaceCnt=0;
		for(int i=0; i<input.length(); i++) {
			if(input.charAt(i) == ' ') {
				spaceCnt++;
			}
		}
		spaceCnt++;
		
		HashSet<String> hs = new HashSet<>();
		for(int i=0; i<spaceCnt; i++) {
			String bank = tokens.nextToken();
			st.add(bank);
			String popBank = st.peek();
			hs.clear();
			hs.add(popBank);
			Iterator it1 = hs.iterator();
			
			while(it1.hasNext()) {
				System.out.print(it1.next()+" ");
				System.out.println();
			}
			
			
			
		}
		

		
		
	}
}
