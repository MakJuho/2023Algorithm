package SW역량테스트_1015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_16235_나무재테크 {

	/**
	 * 처음 모든 땅에 양분 5
	 * 봄 : 나무가 자신의 나이만큼 양분을 먹고 나이 +1, 한칸에 여러 나무가 있다면 어린 나무부터 양분을 먹음.
	 * 		자신의 나이만큼 양분을 먹지 못하면 그 나무는 죽는다.
	 * 여름 : 봄에 죽은 나무가 양분으로 변하게 된다. 죽은 나무 /2만큼 양분으로 추가된다. ( 소수점 버림 )
	 * 가을 : 번식, 나이가 5배수여야 함. 인접한 8개의 칸에 나이가 1인 나무가 생긴다. 벗어나면 생기지 않는다.
	 * 겨울 : 입력만큼 양분이 추가된다.
	 * K년 후 살아있는 나무의 수를 구하시오.
	 */
	
	static class TREE implements Comparable<TREE>{
		int r,c,age;

		public TREE(int r, int c, int age) {
			this.r = r;
			this.c = c;
			this.age = age;
		}


		@Override
		public String toString() {
			return "TREE [r=" + r + ", c=" + c + ", age=" + age + "]";
		}

		@Override
		public int compareTo(TREE o) {
			return this.age - o.age;
		}
		
		
		
	}
	
	static int N,M,K;
	
	static int[][] fuel;
	static int[][] addfuel;
	static int[] dirR = {-1,-1,-1,0,0,1,1,1};
	static int[] dirC = {-1,0,1,-1,1,-1,0,1};
	static int ret=0;
	static PriorityQueue<TREE> trees;
	static ArrayList<TREE> die = new ArrayList<>();
	static ArrayList<TREE> breed = new ArrayList<>();
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		
		fuel = new int[N+1][N+1];
		addfuel = new int[N+1][N+1];
		
		trees = new PriorityQueue<>();
		
		for(int r=1; r<=N; r++) {
			tokens = new StringTokenizer(br.readLine());
			for(int c=1; c<=N; c++) {
				fuel[r][c] = 5;
				addfuel[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		
//		for(int[] a: fuel) {
//			System.out.println(Arrays.toString(a));
//		}
		
		
		for(int i=0; i<M; i++) {
			tokens = new StringTokenizer(br.readLine());
			int tr = Integer.parseInt(tokens.nextToken());
			int tc = Integer.parseInt(tokens.nextToken());
			int age = Integer.parseInt(tokens.nextToken());
			trees.add(new TREE(tr,tc,age));
		}
		
		
		
//		System.out.println(Arrays.toString(trees));
		
		/**
		 * 처음 모든 땅에 양분 5
		 * 봄 : 나무가 자신의 나이만큼 양분을 먹고 나이 +1, 한칸에 여러 나무가 있다면 어린 나무부터 양분을 먹음.
		 * 		자신의 나이만큼 양분을 먹지 못하면 그 나무는 죽는다.
		 * 여름 : 봄에 죽은 나무가 양분으로 변하게 된다. 죽은 나무 /2만큼 양분으로 추가된다. ( 소수점 버림 )
		 * 가을 : 번식, 나이가 5배수여야 함. 인접한 8개의 칸에 나이가 1인 나무가 생긴다. 벗어나면 생기지 않는다.
		 * 겨울 : 입력만큼 양분이 추가된다.
		 * K년 후 살아있는 나무의 수를 구하시오.
		 */

		
		for(int y=1; y<=K; y++) {
			
//			System.out.println("양분주기전");
//			for(int[] a: fuel) {
//				System.out.println(Arrays.toString(a));
//			}
//			System.out.println();
			spring();
//			System.out.println("양분준 후");
//			for(int[] a: fuel) {
//				System.out.println(Arrays.toString(a));
//			}
//			System.out.println();
			
			summer();
			
			fall();
			
			winter();
			
		}
		
		System.out.println(trees.size());
		
		
		
		
	}
	
	
	
	private static void winter() {
//		 겨울 : 입력만큼 양분이 추가된다.
		
		for(int r=1; r<=N; r++) {
			for(int c=1; c<=N; c++) {
				fuel[r][c] += addfuel[r][c];
			}
		}
	}



	private static void fall() {
//		 * 가을 : 번식, 나이가 5배수여야 함. 인접한 8개의 칸에 나이가 1인 나무가 생긴다. 벗어나면 생기지 않는다.
		for(TREE tr : breed) {
			int r = tr.r;
			int c = tr.c;
			
			for(int d=0; d<8; d++) {
				int nr = r+dirR[d];
				int nc = c+dirC[d];
				
				if(isOut(nr,nc)) continue;
				
				trees.add(new TREE(nr,nc,1));
			}
		}
		breed.clear();
	}
	



	private static boolean isOut(int nr, int nc) {
		return 1>nr || nr>N || 1>nc || nc>N ;
	}



	private static void summer() {
//		 * 여름 : 봄에 죽은 나무가 양분으로 변하게 된다. 죽은 나무 /2만큼 양분으로 추가된다. ( 소수점 버림 )
		for(TREE tr: die) {
			int nr = tr.r;
			int nc = tr.c;
			
			fuel[nr][nc] += tr.age/2;
			
		}
		die.clear();
	}



	private static void spring() {
		 /** 처음 모든 땅에 양분 5
		 * 봄 : 나무가 자신의 나이만큼 양분을 먹고 나이 +1, 한칸에 여러 나무가 있다면 어린 나무부터 양분을 먹음.
		 * 		자신의 나이만큼 양분을 먹지 못하면 그 나무는 죽는다.*/
		int tsize = trees.size();
		PriorityQueue<TREE> newpq = new PriorityQueue<>();
		
		
		for(int i=0; i<tsize; i++) {
			
			TREE cur = trees.poll();
			int nr = cur.r;
			int nc = cur.c;
			
			
			// 죽음
			if(fuel[nr][nc] < cur.age) {
				die.add(new TREE(nr, nc, cur.age));
				continue;
			}
			
			fuel[nr][nc] -= cur.age;
			newpq.add(new TREE(nr, nc, cur.age+1));
			
			if((cur.age+1)%5 == 0) {
				breed.add(new TREE(nr,nc,cur.age+1));
			}
			
			
		}
		trees = new PriorityQueue<>(newpq);
	}



	static String src= "5 2 6\r\n" + 
			"2 3 2 3 2\r\n" + 
			"2 3 2 3 2\r\n" + 
			"2 3 2 3 2\r\n" + 
			"2 3 2 3 2\r\n" + 
			"2 3 2 3 2\r\n" + 
			"2 1 3\r\n" + 
			"3 2 3";
	
}
