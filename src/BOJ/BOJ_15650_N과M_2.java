package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_15650_N과M_2 {

	static LinkedList<Integer> list = new LinkedList<>();
	static LinkedList<Integer> temp = new LinkedList<>();
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		for(int i=1; i<=N; i++) {
			list.add(i);
		}
		System.out.println(list);
		Combination(temp,M,0);
		
	}
	
	
	
	private static void Combination(LinkedList<Integer> temp2, int r, int index) {
		if(r == 0) {
			for(Integer a: temp2) {
				System.out.print(a+" ");
			}
			System.out.println();
			return;
		}
		else if(list.size() == index) return;
		
		temp2.add(list.get(index));
		Combination( temp2, r-1, index+1);
		temp2.removeLast();
		Combination(temp2, r, index+1);
		
		
	}



	static String src = "4 2";
}
