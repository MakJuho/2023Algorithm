package KMP;

import java.util.Arrays;

public class KMP {
	public static void main(String[] args) {
		/**
		 * 문자열, 패턴 값 입력
		 */
		char[] parent = "ABABABC".toCharArray();
		char[] pattern = "ABAB".toCharArray();
		
		System.out.println("target : "+Arrays.toString(parent));
		System.out.println("pattern : "+Arrays.toString(pattern));
		
		kmp(parent,pattern);
		
		
		
	}

	private static void kmp(char[] parent, char[] pattern) {
		int[] table = getPi(pattern);
		
		int parentSize = parent.length;
		int patternSize = pattern.length;
		int j = 0;
		
		for( int i=0; i<parentSize; i++) {
			while( j>0 && parent[i] != pattern[j]) {
				j = table[j-1];
			}
			
			if(parent[i] == pattern[j]) {
				if(j == patternSize-1) {
					System.out.println(i-patternSize+1);
					j=table[j];
				}else {
					j++;
				}
			}
			
		}
		
		
	}

	private static int[] getPi(char[] pattern) {
		int[] table = new int[pattern.length];
		int j = 0;
		for(int i=1; i<pattern.length; i++) {
			while( j>0 && pattern[i] != pattern[j]) {
				j = table[i-1];
			}
			
			if(pattern[i] == pattern[j]) {
				table[i] = ++j;
			}
		}
		
		
		return table;
	}
	
	
}
