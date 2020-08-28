package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;

public class BOJ_5525_IOIOI {
	
	static int N, len;
	static int cnt=0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			sb.append("IO");
		}
		sb.append("I");
		
		char[] pattern = sb.toString().toCharArray();
		len = Integer.parseInt(br.readLine());
		char[] parent = new char[len];
		parent = br.readLine().toCharArray();

		KMP(parent, pattern);
		
		System.out.println(cnt);
		
	}
	
	private static void KMP(char[] parent, char[] pattern) {
		int[] table = getPi(pattern);
		
		int parentSize = parent.length;
		int patternSize = pattern.length;
		
		int j =0;
		
		for(int i=0; i<parentSize; i++) {
			while( j>0 && parent[i] != pattern[j]) {
				j = table[j-1];
			}
			if(parent[i] == pattern[j]) {
				if( j == patternSize-1 ) {
					cnt++;
					j = table[j];
				}else {
					j ++;
				}
			}
			
		}
		
		
	}

	private static int[] getPi(char[] pattern) {
		int pSize = pattern.length;
		int[] table = new int[pSize];
		int j = 0;
		
		for(int i=1; i<pSize; i++) {
			while( j>0 && pattern[i] != pattern[j]) {
				j = table[i-1];
			}
			if(pattern[i] == pattern[j]) {
				table[i] = ++j;
			}
			
		}
		
		
		return table;
	}

	static String src = "1\r\n" + 
			"13\r\n" + 
			"OOIOIOIOIIOII";
}
