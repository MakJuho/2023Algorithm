package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;

public class BOJ_2447_별찍기 {
	
	static char arr[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		int v = Integer.parseInt(br.readLine());
		
		arr = new char[v][v];
		
		for(int i=0; i<arr.length; i++) {
			Arrays.fill(arr[i], ' ');
		}
		
		makeStar(0, 0, v);
		
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		
	}
	
	
	private static void makeStar(int r, int c, int v) {
		int div = 0;
		if(v == 1 ) {
			arr[r][c] = '*';
			return ;
		}
		
		div = v/3;
		
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if( i == 1 && j == 1) continue;
				// 시작점을 이동시킨다.
				makeStar(r+(div*i), c+(div*j), div);
			}
		}
		
	}


	static String src = "3";
	
}
