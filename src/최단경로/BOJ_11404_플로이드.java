package 최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11404_플로이드 {
	
	static int n,m;
	static int INF = 10000000;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		int[][] city = new int[n+1][n+1];
		
		for(int r=1; r<=n; r++) {
			for(int c=1; c<=n; c++) {
				city[r][c] = INF;
			}
		}


		
		for(int i=0; i<m; i++) {
			StringTokenizer tokens = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(tokens.nextToken());
			int c = Integer.parseInt(tokens.nextToken());
			int cost = Integer.parseInt(tokens.nextToken());
			if(city[r][c] > cost)
				city[r][c] = cost;
		}
		
		
		
		
		
		for(int k=1; k<=n; k++) {
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					city[i][j] = Math.min(city[i][k]+city[k][j], city[i][j]);
				}
			}
		}
		
		
		for(int r=1; r<=n; r++) {
			for(int c=1; c<=n; c++) {
				if(r==c || city[r][c] == INF) city[r][c] = 0;
			}
		}
		
//		for(int r=1; r<=n; r++) {
//			for(int c=1; c<=n; c++) {
//				if(city[r][c] == INF) {
//					city[r][c] = 0;
//				}
//			}
//		}
		
		for(int r=1; r<=n; r++) {
			for(int c=1; c<=n; c++) {
					System.out.print(city[r][c]+" ");
			}
			System.out.println();
		}
		
		
	}
	
	
	static String src = "5\r\n" + 
			"14\r\n" + 
			"1 2 2\r\n" + 
			"1 3 3\r\n" + 
			"1 4 1\r\n" + 
			"1 5 10\r\n" + 
			"2 4 2\r\n" + 
			"3 4 1\r\n" + 
			"3 5 1\r\n" + 
			"4 5 3\r\n" + 
			"3 5 10\r\n" + 
			"3 1 8\r\n" + 
			"1 4 2\r\n" + 
			"5 1 7\r\n" + 
			"3 4 2\r\n" + 
			"5 2 4";
}
