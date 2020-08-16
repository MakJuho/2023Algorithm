package N과M;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class N과M3 {

	static int N,M;
	static int[] ary;
	static LinkedList<Integer> list = new LinkedList<>();
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer tokens = new StringTokenizer(src);
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		ary = new int[N];
		
		for(int i=0; i<N; i++) {
			ary[i] = i+1;
		}

		// 중복 조합
		reCombination();
		
		
	}
	
	private static void reCombination() {
		if(list.size() == M) {
			for(int i=0; i<list.size(); i++) {
				System.out.print(list.get(i)+" ");
			}
			System.out.println();
			return ;
		}
		for(int i=0; i<N; i++) {
			list.add(ary[i]);
			reCombination();
			list.removeLast();
		}
		
		
		
	}

	static String src ="8 3";
}
