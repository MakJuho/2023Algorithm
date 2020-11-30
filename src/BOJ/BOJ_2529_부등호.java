package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_2529_부등호 {
	
	
	static int[] numArr = {0,1,2,3,4,5,6,7,8,9};
	
	static char[] arr;
	static int N;
	static int max, min;
	static ArrayList<String> ans = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		N = Integer.parseInt(br.readLine());
		
		
		arr = new char[N];
		
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			arr[i] = tokens.nextToken().charAt(0);
		}
		
//		System.out.println(Arrays.toString(arr));
		
		LinkedList<Integer> list = new LinkedList<>();
		boolean[] check = new boolean[10];
		Permutation(list,check,N+1);
		System.out.println(ans.get(ans.size()-1));
		System.out.println(ans.get(0));
	}
	
	private static void Permutation(LinkedList<Integer> list, boolean[] check, int r) {
		if( list.size() == r) {
//			System.out.println(list);
			boolean success = true;
			for(int i=0; i<list.size()-1; i++) {
				if(list.get(i) < list.get(i+1)) {
					if(arr[i] != '<') {
						// 성공
						success = false;
						return;
					}
				}else {
					if(arr[i] != '>') {
						// 성공
						success = false;
						return;
					}
				}
			}
			
			if(success) {
				StringBuilder sb = new StringBuilder();
				for(int i=0; i<list.size(); i++) {
					sb.append(list.get(i));
				}
				ans.add(sb.toString());
				
			}
			
			
			return;
		}
		for(int i=0; i<numArr.length; i++) {
			if(!check[i]) {
				check[i] = true;
				list.add(numArr[i]);
				Permutation(list,check,r);
				list.removeLast();
				check[i] = false;
			}
			
		}
		
	}

	static String src ="2\r\n" + 
			"< > ";
}
