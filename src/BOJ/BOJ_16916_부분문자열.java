package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_16916_부분문자열 {

	public static int[] getPi(String pattern) {
		
		// 패턴의 길이
		int m = pattern.length();
		// idx
		int j = 0;
		
		
		char[] p = new char[m];
		int[] pi = new int[m];
		
		p = pattern.toCharArray();
		
		// 0이 아닌 1부터
		for(int i=1; i<m; i++) {
			while(j>0 && p[i] != p[j]) {
				j = pi[j-1];
			}
			
			// 문자가 같을 때만 j 증가
			if(p[i] == p[j])
				pi[i] = ++j;
		}
		
		return pi;
	}
	
	
	private static ArrayList<Integer> kmp(String str, String pattern){
		ArrayList<Integer> list = new ArrayList<>();
		// getPi 함수 만들기
		int[] pi = getPi(pattern);
		int n = str.length();
		int m = pattern.length();
		int j = 0;
		
		char[] s = str.toCharArray();
		char[] p = pattern.toCharArray();
		
		for( int i = 0; i < n; i++) {
			while(j > 0 && s[i] != p[j]) {
				j = pi[j-1];
			}
			
			if(s[i] == p[j]) {
				if(j == m-1) {
					list.add(i-m+1);
					j = pi[j];
				}else {
					j++;
				}
			}
		}
		
		return list;
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		String str = br.readLine();
		String pattern = br.readLine();
		
		List li = kmp(str, pattern);
		System.out.println(li.size());
		for(int i=0; i<li.size(); i++) {
			Integer a = (Integer) li.get(i);
			int ans = a.intValue()+1;
			System.out.print(ans+ " ");
		}
		
	}
	
	private static String src ="BABABBAB\r\n" + 
			"ABBAB";
}
