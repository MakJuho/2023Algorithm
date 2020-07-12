package ComSA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class SWEA_6719_성수의프로그래밍강좌시청 {
	
	private static ArrayList<Integer> list;
	private static int N,K;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=TC; t++) {
			sb.append("#").append(t).append(" ");
			
			StringTokenizer tokens = new StringTokenizer(br.readLine());
			N = Integer.parseInt(tokens.nextToken());
			K = Integer.parseInt(tokens.nextToken());
			
			list = new ArrayList<>();
			
			tokens = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				list.add(Integer.parseInt(tokens.nextToken()));
			}
			
//			System.out.println(list);
		
			// 정렬
			Collections.sort(list);
			
			// index 만큼 계산
			double val = 0;
			
			for(int i=list.size()-K; i<list.size(); i++) {
//				System.out.println(list.get(i)+":"+i);
				val=(val+list.get(i))/2;
				
			}
			sb.append(String.format("%.6f", val)).append("\n");
			
		}
		System.out.println(sb);
		
		
	}
	
	
	private static String src =
			"3\r\n" + 
			"2 2\r\n" + 
			"2 3\r\n" + 
			"2 1\r\n" + 
			"2 3\r\n" + 
			"5 3\r\n" + 
			"9 5 2 3 5";
}
