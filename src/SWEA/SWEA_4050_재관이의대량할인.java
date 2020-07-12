package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA_4050_재관이의대량할인 {

	static int N;
	static Integer[] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=TC; t++) {
			N =Integer.parseInt(br.readLine());
			arr=new Integer[N];
			
			StringTokenizer tokens = new StringTokenizer(br.readLine());
			
			for(int i=0; i<N; i++) {
				arr[i]=Integer.parseInt(tokens.nextToken());
			}
			
			Arrays.sort(arr, Collections.reverseOrder());
			
				
			for(int i=2; i<N; i=i+3) {
				
				arr[i] = 0;
			}
//			System.out.println(Arrays.toString(arr));
			int rlt=0;
			for(int i=0; i<N; i++) {
				rlt+=arr[i];
			}
//			for(int a: list) {
//				rlt+=a;
//			}
			System.out.println("#"+t+" "+rlt);
		}
		
	}
	
	
	static String src="2\r\n" + 
			"4\r\n" + 
			"3 2 3 2\r\n" + 
			"6\r\n" + 
			"6 4 5 5 5 5";
}
