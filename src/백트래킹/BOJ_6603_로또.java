package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_6603_로또 {
	
	static LinkedList<Integer> list = new LinkedList<>();
	static boolean[] visited;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	static int Cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		
		
		while(true) {

			StringTokenizer tokens = new StringTokenizer(br.readLine());
			Cnt = Integer.parseInt(tokens.nextToken());
			
			if(Cnt == 0) break;
			
			arr = new int[Cnt];
			visited = new boolean[Cnt];
			
			for(int i=0; i<Cnt; i++) {
				arr[i] = Integer.parseInt(tokens.nextToken());
			}
			
			for(int i=0; i<= Cnt-6; i++) {
				visited[i] = true;
				Combination(i, 1);
				visited[i] = false;
			}
			
			sb.append("\n");
		}
		System.out.println(sb);
		
		
	}
	
	private static void Combination(int cur, int cnt) {

		  if(cnt == 6) {
	            for (int i = 0; i < Cnt; i++) {
	                if(visited[i]) 
	                    sb.append(arr[i]+" ");
	            }
	            sb.append("\n");
	            return;
	        }
	        
	        for (int i = cur; i < Cnt; i++) {
	            if(visited[i]) continue;
	            
	            visited[i] = true;
	            Combination(i, cnt+1);
	            visited[i] = false;
	        }
		
		
	}

	static String src = "7 1 2 3 4 5 6 7\r\n" + 
			"8 1 2 3 5 8 13 21 34\r\n" + 
			"0";
	
}
