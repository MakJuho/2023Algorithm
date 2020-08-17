package N과M;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class N과M4 {
	
	static int N, M;
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

		reCombination(M, 0);
		
	}
	
	private static void reCombination(int r, int idx) {
		if(r == 0) {
			for(int i=0; i<M; i++) {
				System.out.print(list.get(i));
				if(i != M-1) {
					System.out.print(' ');
				}
			}
			System.out.println();
			return ;
		}
		
		if(idx == N) return;
		list.add(ary[idx]);
		reCombination(r-1, idx);
		list.removeLast();
		reCombination(r, idx+1);
		
	}

	static String src ="3 3";
}
