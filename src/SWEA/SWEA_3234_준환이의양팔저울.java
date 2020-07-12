package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA_3234_준환이의양팔저울 {
	
	static int T, len, rlt=0;
	static int[] arr;
	static boolean[] check;
	static LinkedList<Integer> list = new LinkedList<>();
	
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			sb.append("#"+t+" ");
			len = Integer.parseInt(br.readLine());
			
			arr = new int[len];
			
			StringTokenizer tokens = new StringTokenizer(br.readLine()," ");
			for(int i=0; i<arr.length; i++) {
				arr[i]= Integer.parseInt(tokens.nextToken());
			}
			rlt=0;
			perm(0, 0, 0);			
			
			sb.append(rlt).append("\n");
		}
		System.out.println(sb);
		
	}
	

	private static void perm(int step, int l, int r) {
		if( step == arr.length) {// 단게별 배열 길이만큼.
			rlt++;
		}
		else {
			for(int i= step; i< arr.length; i++) {
				// 치환
				int temp = arr[step];
				arr[step] = arr[i];
				arr[i] = temp;
				
				perm(step +1, l+arr[step], r); // 왼쪽에 값을 더해라
				
				if( l >= r+ arr[step]) {
					perm(step +1, l, r+arr[step]); // 오른쪽에 값을 더해라
				}
				
				// 치환 
				temp = arr[step];
				arr[step] = arr[i];
				arr[i] = temp;
				
			}
		}
		
	}




	static String src = "3\r\n" + 
			"3\r\n" + 
			"1 2 4\r\n" + 
			"3\r\n" + 
			"1 2 3\r\n" + 
			"9\r\n" + 
			"1 2 3 5 6 4 7 8 9";
	
}
