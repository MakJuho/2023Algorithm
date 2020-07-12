package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_15649_N과M_1 {

	static int N, M;
	static boolean[] check;
	static LinkedList<Integer> list = new LinkedList<>();
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		String line = br.readLine();
		StringTokenizer tokens = new StringTokenizer(line);
		
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		int index = 0;
		check = new boolean[N];
		Combination(index);
		
		
	}
	
	private static void Combination(int idx) {
		if(idx == M) {
			// 출력
			for(int i : list) {
				System.out.print(i+ " ");
			}
			System.out.println();
			return ;
		}
		for(int i=0; i<N; i++) {
			if(!check[i]) {
				check[i] = true;
				list.add(i+1);
				Combination(idx+1);
				check[i] = false;
				list.removeLast();
			}
		}
		
	}

	private static String src= "4 4";
}
