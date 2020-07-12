package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA_2112_보호필름 {
	
	static int[][] map;
	static int T,D,W,K;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer tokens = new StringTokenizer(br.readLine(), " ");
			D = Integer.parseInt(tokens.nextToken());
			W = Integer.parseInt(tokens.nextToken());
			K = Integer.parseInt(tokens.nextToken());
			
			map = new int[D][W];
			
			for(int r=0; r<D; r++) {
				tokens = new StringTokenizer(br.readLine(), " ");
				for(int c=0; c<W; c++) {
					map[r][c] = Integer.parseInt(tokens.nextToken());
				}
			}
			
//			for(int[] a: map) {
//				System.out.println(Arrays.toString(a));
//			}
//			System.out.println(isAvailable()); 체크함수 완성.
			
//			while(!isAvailable()) {
//				
//				
//			}
			LinkedList<Integer> list = new LinkedList<>();
			for(int r=0; r<=D; r++) {
				Com(list, D, r, 0);
			}
			
		}
		
	}
	
	
	


	private static void Com(LinkedList<Integer> list, int n, int r, int idx) {
		if(r == 0) {
			int result_cnt = list.size();
			for(Integer val : list) {
				
			}
			return;
		}
		else if(idx == n) return;
		
		else {
			list.add(idx);
			Com(list,n,r-1,idx+1);
			list.removeLast();
			Com(list,n,r,idx+1);
		}
	}


	private static boolean isAvailable() {
		
		
		boolean isPass;
		for(int c=0; c<W; c++) {
			int now=-1;
			int count = 0;
			isPass = false;
			for(int r=0; r<D; r++) {
				
				
				if(now == map[r][c]) {
					count++;
				}else {
					now=map[r][c];
					count=1;
				}
				if(count == K) {
					// 해당 열은 통과
					isPass = true;
					break;
				}
			}
			if(isPass == false) {
				return false;
			}
		}
		
		return true;
		
	}


	static String src ="1\r\n"+
			"6 8 3\r\n" + 
			"0 0 1 0 1 0 0 1\r\n" + 
			"0 1 0 0 0 1 1 1\r\n" + 
			"0 1 1 1 0 0 0 0\r\n" + 
			"1 1 1 1 0 0 0 1\r\n" + 
			"0 1 1 0 1 0 0 1\r\n" + 
			"1 0 1 0 1 1 0 1";
}
