package SW역량테스트_1014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_17140_이차원배열과연산 {
	/**
	 *  3x3 배열 A
	 *  R 연산 : 행의 개수 >= 열의 개수
	 *  C 연산 : 행의 개수 < 열의 개수
	 *  한 행에 정렬을 수행하면 각 숫자가 몇번 나왔는 지 알아야한다.
	 *  등장 횟수가 커지는 순으로 정렬 ( 만약 등장 횟수가 같다면 오름차순으로 )
	 *  ( 숫자, 개수, 숫자, 개수, ~~ )
	 *  
	 *  행 또는 열의 크기가 100을 넘어가는 경우 처음 100개를 제외하고는 버린다.
	 *  100 초가 지나도 k가 되지 않으면 -1
	 *  최소 시간을 구해라
	 *  
	 */
	
	static class NUM implements Comparable<NUM>{
		int val, cnt;

		@Override
		public String toString() {
			return "NUM [val=" + val + ", cnt=" + cnt + "]";
		}

		public NUM(int val, int cnt) {
			this.val = val;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(NUM o) {
			if(this.cnt == o.cnt) {
				if(this.val > o.val) {
					return 1;
				}else {
					return -1;
				}
			}else if(this.cnt > o.cnt) {
				return 1;
			}else {
				return -1;
			}
		}

		
	}
	
	static int[][] board = new int[100][100];
	static int Rsize=3;
	static int Csize=3;
	static NUM[] numArr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		int tR = Integer.parseInt(tokens.nextToken())-1;
		int tC = Integer.parseInt(tokens.nextToken())-1;
		int tV = Integer.parseInt(tokens.nextToken());
		
		// 만약 더이상 다음 줄이 없다면 종료.
		for(int r=0; r<3; r++) {
			tokens = new StringTokenizer(br.readLine());
			for(int c=0; c<3; c++) {
				board[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
//		for(int[] a: board) {
//			System.out.println(Arrays.toString(a));
//		}
		
		/* *  3x3 배열 A
		 *  R 연산 : 행의 개수 >= 열의 개수
		 *  C 연산 : 행의 개수 < 열의 개수*/
		int time = 0;
		boolean success =false;
		while(time <= 100) {
			if(board[tR][tC] == tV) {
				success = true;
				break;
			}

			if(Rsize >= Csize) {
				Rdo();
			}else if(Rsize < Csize){
				Cdo();
			}
			
//			for(int r=0; r<Rsize; r++) {
//				for(int c=0; c<Csize; c++) {
//					System.out.print(board[r][c]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println();
//			System.out.println();
//			System.out.println();
			time ++;
		}
		
		if(success) {
			System.out.println(time);
		}else {
			System.out.println(-1);
		}
		
		
		
		
	}
	
	private static void Cdo() {
		for(int c=0; c<Csize; c++) {
			
			HashMap<Integer, Integer> map = new HashMap<>();
			for(int i=0; i<=100; i++) {
				map.put(i, 0);
			}
			
			
			for(int r=0; r<Rsize; r++) {
				map.put(board[r][c], map.get(board[r][c])+1);
			}
			
			Iterator iterator = map.keySet().iterator();
			
			List<NUM> list = new ArrayList<>();
			
			while(iterator.hasNext()) {
				int temp = (Integer)iterator.next();
				if(map.get(temp) != 0 && temp != 0) {
					list.add(new NUM(temp, map.get(temp)));
				}
			}
			
//			System.out.println(list);
			
			Collections.sort(list);
			
//			System.out.println(list);
			
			if(Rsize < list.size()*2) {
				Rsize = list.size()*2;
			}
			
			for(int r=0; r<100; r++) {
				board[r][c] = 0;
			}

			for(int i=0; i<list.size(); i++) {
				board[2*i][c] = list.get(i).val;
				board[2*i+1][c] = list.get(i).cnt;
			}
			
			list.clear();
			
		}
	}

	private static void Rdo() {
/*		 *  한 행에 정렬을 수행하면 각 숫자가 몇번 나왔는 지 알아야한다.
		 *  등장 횟수가 커지는 순으로 정렬 ( 만약 등장 횟수가 같다면 오름차순으로 )
		 *  ( 숫자, 개수, 숫자, 개수, ~~ )*/		

		// 등장 횟수가 작은 거부터하고 동일 할 경우, 숫자가 작은 거 부터
		// cnt가 0인 것을 제외하고, 등장 횟수가 작은 것부터 나열, 동일할 경우 숫자가 작은 거부터 나열.

		// HASHMAP 생성
		
		
		
		for(int r=0; r<Rsize; r++) {

			
			HashMap<Integer, Integer> map = new HashMap<>();
			for(int i=0; i<=100; i++) {
				map.put(i, 0);
			}
			
			
			for(int c=0; c<Csize; c++) {
				map.put(board[r][c], map.get(board[r][c])+1);
			}
			
			Iterator iterator = map.keySet().iterator();
			
			List<NUM> list = new ArrayList<>();
			
			while(iterator.hasNext()) {
				int temp = (Integer)iterator.next();
				if(map.get(temp) != 0 && temp != 0) {
					list.add(new NUM(temp, map.get(temp)));
				}
			}
			
//			System.out.println(list);
			
			Collections.sort(list);
			
//			System.out.println(list);
			
			if(Csize < list.size()*2) {
				Csize = list.size()*2;
			}
			
			Arrays.fill(board[r], 0);
			
			for(int i=0; i<list.size(); i++) {
				board[r][2*i] = list.get(i).val;
				board[r][2*i+1] = list.get(i).cnt;
			}
			
			list.clear();
			
			
			
			
		}
		
	}

	static String src = "3 3 3\r\n" + 
			"1 1 1\r\n" + 
			"1 1 1\r\n" + 
			"1 1 1";
	
}
