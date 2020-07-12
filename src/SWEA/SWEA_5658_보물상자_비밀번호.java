package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class SWEA_5658_보물상자_비밀번호 {

	
	static int N,K;
	static Character [] ary;
	static HashSet<String> set;
	static int[] arr2;
	static int rotate;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		set=new HashSet<>();
		int T = Integer.parseInt(br.readLine());
		
	
		
		for(int t=1; t<=T; t++) {
			StringTokenizer tokens = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(tokens.nextToken());
			int K = Integer.parseInt(tokens.nextToken());
			ary = new Character[N];
			
			tokens = new StringTokenizer(br.readLine());
			
			String line = tokens.nextToken();
			for(int i=0; i<N; i++) {
				ary[i] = line.charAt(i);
			}
			
			// 출력 확인
//			System.out.println(Arrays.toString(ary));
		
			rotate = N/4;
			set.clear();
			for(int i=0; i<N; i++) {
				StringBuilder sb = new StringBuilder();
				for(int j=0; j<rotate; j++) {
					sb.append(ary[(i+j)%N]);
				}
				set.add(sb.toString());
			}
			arr2 = new int[set.size()];
			int i =0;
			for(String code: set) {
				arr2[i]=Integer.parseInt(code,16);
				i++;
			}
			Integer[] what = Arrays.stream( arr2 ).boxed().toArray( Integer[]::new );
			Arrays.sort(what, Collections.reverseOrder());
			
			
			System.out.println("#"+t+" "+what[K-1]);
			
		}
		
	}
	
	


	static String src="5\r\n" + 
			"12 10\r\n" + 
			"1B3B3B81F75E\r\n" + 
			"16 2\r\n" + 
			"F53586D76286B2D8\r\n" + 
			"20 14\r\n" + 
			"88F611AE414A751A767B\r\n" + 
			"24 16\r\n" + 
			"044D3EBA6A647B2567A91D0E\r\n" + 
			"28 11\r\n" + 
			"8E0B7DD258D4122317E3ADBFEA99";
	
}
