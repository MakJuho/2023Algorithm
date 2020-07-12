package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_1062_가르침 {

	static int N,K;
	static String[] words;
	static int[] alpha = new int[26];
	static LinkedList<Integer> list = new LinkedList<>();
	static HashSet<Integer> hs = new HashSet<>();
	static boolean[][] check;
	static boolean[][] copy;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		
		words = new String[N];
		check = new boolean[N][26];
		copy= new boolean[N][26];
		for(int i=0; i<N; i++) {
			String word = br.readLine();
			word = word.replace("a", "");
			word = word.replace("n", "");
			word = word.replace("t", "");
			word = word.replace("i", "");
			word = word.replace("c", "");
			
			for(int j=0; j<word.length(); j++) {
				hs.add(word.charAt(j)-97);
				check[i][word.charAt(j)-97] = true;
			}
		}
		Integer[] arr = new Integer[hs.size()];
		Iterator<Integer> iter = hs.iterator();
		
		
		for(int i=0; i<hs.size(); i++) {
			arr[i] = iter.next();
		}
		Arrays.sort(arr);
		
		
		
//		// K<5보다 작으면 0.
		if(K<5) System.out.println("0");
		else if(K==26) System.out.println(N);
		else {
			int Cnt = K-5;
			Com(arr,Cnt, 0);
			
		}
		System.out.println(MAX_total);
		
	}
	static int MAX_total=Integer.MIN_VALUE;
	private static void Com(Integer[] arr, int r, int index) {
		if(r == 0) {
			
			for(int i=0; i< check.length; i++) {
				System.arraycopy(check[i], 0, copy[i], 0, check[i].length);
			}
			for(Integer val : list) {
				for(int i=0; i<N; i++) {
					copy[i][val] = false;
				}
			}
			int result=0;
			// 모두 숫자가 영인 것 찾기
			for(int j=0; j<N; j++) {
				int false_cnt=0;
				for(int k=0; k<26; k++) {
					if(!copy[j][k])
						false_cnt++;
				}
				if(false_cnt==26) {
					result++;
				}
			}
			
			
			if(MAX_total < result ) {
				MAX_total = result;
			}
			
			
			return;
		}
		else if(arr.length==index) return;
		
		list.add(arr[index]);
		Com(arr,r-1,index+1);
		list.removeLast();
		Com(arr,r,index+1);
	}

	static String src = "3 5\r\n" + 
			"antarctica\r\n" + 
			"antahellotica\r\n" + 
			"antacartica";
}
