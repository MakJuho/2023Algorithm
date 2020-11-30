package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;

public class BOJ_2295_세수의합 {
	
	
	static int[] arr;
	static int ret = -1;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
//		System.out.println(Arrays.toString(arr));
		LinkedList<Integer> list = new LinkedList<>();
		
		Combination(list,N,4,0);
		
		System.out.println(ret);
	}
	


	private static void Combination(LinkedList<Integer> list, int n, int r, int index) {
		if(r == 0) {
//			for(int a: list) {
//				System.out.print(a+" ");
//			}
//			System.out.println();
			int pick = -1;
			if( list.get(3) == list.get(0) + list.get(1) + list.get(2)) {
				pick = list.get(3);
			}
			
			if(ret < pick) {
				ret = pick;
			}
			
			return;
		}
		
		else if(n == index) return;
		
		list.add(arr[index]);
		Combination(list, n, r-1, index+1);
		list.removeLast();
		Combination(list, n, r, index+1);
			
			
			
	}



	static String src ="5\r\n" + 
			"2\r\n" + 
			"3\r\n" + 
			"5\r\n" + 
			"10\r\n" + 
			"18";
}
