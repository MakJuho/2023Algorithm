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

public class BOJ_1062_가르침_dfs {

	static int N,K;
	static String[] words;
	static boolean[] visit = new boolean[26];
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		
		words = new String[N];
		
		if(K < 5) {
			System.out.println(0);
			return;
		}
		
		else if ( K == 26) {
			System.out.println(N);
			return;
		}
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			words[i] = str.substring(4, str.length()-4);
		}
		K = K-5;
		visit['a'-97] = true;
		visit['n'-97] = true;
		visit['t'-97] = true;
		visit['i'-97] = true;
		visit['c'-97] = true;
		
		dfs(0, 0);
		System.out.println(max);
	}
	
	static void dfs(int start, int count) {
		
		if(count == K) {
			int result =0;
			
			for( int i=0; i<N; i++) {
				boolean flag = true;
				for(int j=0; j<words[i].length(); j++) {
					if(!visit[words[i].charAt(j)-97]) {
						flag = false;
						break;
					}
				}
				if(flag) {
					result++;
				}
			}
			max = Math.max(max, result);
			
			return ;
		}
		
		for(int i=start; i<26; i++) {
			if(!visit[i]) {
				visit[i] = true;
				dfs(i, count+1);
				visit[i] = false;
			}
			
			
		}
		
		
	}

	static String src = "3 6\r\n" + 
			"antarctica\r\n" + 
			"antahellotica\r\n" + 
			"antacartica";
}
