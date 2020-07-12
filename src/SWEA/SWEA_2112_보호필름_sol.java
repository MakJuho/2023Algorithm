package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SWEA_2112_보호필름_sol {
	
	static int T,D,W,K;
	static boolean[][] origin, copyMap;
	static int[][] check;
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer tokens = new StringTokenizer(br.readLine(), " ");
			D = Integer.parseInt(tokens.nextToken());
			W = Integer.parseInt(tokens.nextToken());
			K = Integer.parseInt(tokens.nextToken());

			origin = new boolean[D][W];
			copyMap = new boolean[D][W];
			check = new int[2][W];
			result = Integer.MAX_VALUE;

			for(int r=0; r<D; r++) {
				tokens = new StringTokenizer(br.readLine(), " ");
				for(int c=0; c<W; c++) {
					origin[r][c] = Integer.parseInt(tokens.nextToken()) ==1 ? true : false;
					copyMap[r][c] = origin[r][c];
				}
			}
			if (K != 1) {
				recursive(0, 0);
			} else {
				result = 0;
			}
			System.out.println("#" + t + " " + result);
		}
	}

	private static void recursive(int depth, int changeNum) {

		if (depth == D) {
			if (isPossible()) {
				result = Math.min(result, changeNum);
			}
			return;
		}
		recursive(depth + 1, changeNum); // 그대로 재귀
		
		changeRow(depth, true);
		recursive(depth + 1, changeNum + 1); // 색 바꾸고 재귀
		
		changeRow(depth, false);
		recursive(depth + 1, changeNum + 1); // 다른 색으로 바꾸고 재귀
		
		restore(depth); // 원상복구

	}

	private static void changeRow(int depth, boolean flag) {
		Arrays.fill(copyMap[depth], flag);
		for(boolean[] a: copyMap) {
			System.out.println(Arrays.toString(a));
		}
		System.out.println();
		System.out.println();
	}

	private static void restore(int depth) {
		copyMap[depth] = origin[depth].clone();
	}

	private static boolean isPossible() {
		OUTER: for (int j = 0; j < W; j++) {
			boolean now = copyMap[0][j];
			int count = 1;
			for (int i = 1; i < D; i++) {
				if (copyMap[i][j] == now) {
					count++;
					if (count == K) {
						continue OUTER;
					}
				} else {
					count = 1;
					now = copyMap[i][j];
				}
			}
			return false;
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
