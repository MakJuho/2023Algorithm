package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SWEA_2112_보호필름_sol2 {
	
	static int T,D,W,K;
	static int[][] map;
	static int min;
	static int[] list; // 0: 약품을 투여하지 않은 경우, 1: a약품을 투여한경우, 2: b약품을 투여한 경우.
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer tokens = new StringTokenizer(br.readLine(), " ");
			D = Integer.parseInt(tokens.nextToken());
			W = Integer.parseInt(tokens.nextToken());
			K = Integer.parseInt(tokens.nextToken());
			list = new int[D];
			map = new int[D][W];
			min = Integer.MAX_VALUE;

			for(int r=0; r<D; r++) {
				tokens = new StringTokenizer(br.readLine(), " ");
				for(int c=0; c<W; c++) {
					map[r][c] = Integer.parseInt(tokens.nextToken());
				}
			}
			dfs(0, 0);
			// 결과 처리
			System.out.println("#" + t + " " + min);
		}
	}

	private static void dfs(int row, int count) {

		if (row == D) {
			if (isPossible()) {
				min = Math.min(min, count);
			}
			return;
		}
		if(count>=min) {
			return ;
		}
		
		// 부분 집합
		// 투약하지 않았을 때
		list[row] = 0;
		dfs(row+1, count); // 투약하지 않아서 count는 그대로
		// a 약품 투약 했을 때
		list[row] = 1;
		dfs(row+1, count+1);
		// b 약품 투약 했을 때
		list[row] = 2;
		dfs(row+1, count+1);
		
	}


	private static boolean isPossible() {
		
		int count;
		int cur, next;
		for(int i=0; i<W; i++) {
			count = 1;
			for(int j=0; j<D-1; j++) {
				cur = map[j][i];
				next = map[j+1][i];
				if(list[j]>0) {
					cur = list[j]-1;
				}
				if(list[j+1]>0) {
					next = list[j+1]-1;
				}
				if(cur == next) { // 연속된 경우
					count ++;  
					if(count>=K) break;
				}else { // 연속되지 않은 경우
					count =1;
				}
			}
			if(count < K) {
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
