package SWEA;

import java.io.*;
import java.util.*;

public class Solution_d4_6109_추억의2048게임 {
	public static int[] di = { -1, 1, 0, 0 };// 상0,하1,좌2,우3
	public static int[] dj = { 0, 0, -1, 1 };
	public static int[][] a;
	public static boolean[][] v;
	public static int N;

	public static void move(int i, int j, int d) {
		// 이동할 새좌표
		int ni = i + di[d];
		int nj = j + dj[d];
		
		// 범위체크
		if (ni < 0 || ni >= N || nj < 0 || nj >= N || v[ni][nj])
			return;
		
		if (a[i][j] != 0 && a[i][j] == a[ni][nj] && !v[i][j]) {
			a[ni][nj] = a[i][j] * 2;//새 위치에 합한 값 저장
			a[i][j] = 0;//원래자리는 0으로
			v[ni][nj] = true;// 새 위치방문처리
			
		} else if (a[ni][nj] == 0) {//이동할 새위치가 0이면
			a[ni][nj] = a[i][j];
			a[i][j] = 0;
		}
		move(ni, nj, d);//새 위치에서부터 다시 또 체크
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			
			String s = st.nextToken();//dir
			a = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					a[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			v = new boolean[N][N];
			switch (s) {
			case "up":// 상0
				for (int j = 0; j < N; j++) {
					for (int i = 1; i < N; i++)
						move(i, j, 0);
				}
				break;
			case "down":// 하1
				for (int j = 0; j < N; j++) {
					for (int i = N - 2; i >= 0; i--)
						move(i, j, 1);
				}
				break;
			case "left":// 좌2
				for (int i = 0; i < N; i++) {
					for (int j = 1; j < N; j++)
						move(i, j, 2);
				}
				break;
			case "right":// 우3
				for (int i = 0; i < N; i++) {
					for (int j = N - 2; j >= 0; j--) // 맨뒤에서 바로 앞부터
						move(i, j, 3);
				}
			}
			System.out.println("#" + tc);
			for (int[] b : a) {
				for (int i : b) {
					System.out.print(i + " ");
				}
				System.out.println();
			}
		}
		br.close();
	}
	
	static String src =  
			"2\r\n" + 
			"5 up\r\n" + 
			"4 8 2 4 0\r\n" + 
			"4 4 2 0 8\r\n" + 
			"8 0 2 4 4\r\n" + 
			"2 2 2 2 8\r\n" + 
			"0 2 2 0 0\r\n" + 
			"2 down\r\n" + 
			"16 2\r\n" + 
			"0 2";
	
	
}