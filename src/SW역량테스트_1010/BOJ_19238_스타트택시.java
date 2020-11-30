package SW역량테스트_1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_19238_스타트택시 {
	
	
	/**
	 *  아기상어 문제와 비슷한 느낌이 있다.
	 *  #1 BFS 접근
	 * 
	 */
	static boolean[][] visit;
	static int[][] map;
	static int N, M, fuel;
	static int taxi_r, taxi_c;
	static CUSTOMER[] customer = new CUSTOMER[400];
	
	static final int WALL = -1;
	static final int EMPTY = -2;
	
	static int[] dirR = {-1, 0, 1, 0};
	static int[] dirC = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
	
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		fuel = Integer.parseInt(tokens.nextToken());
		
		map = new int[N][N];
		visit = new boolean[N][N];
		
		for(int r=0; r<N; r++) {
			tokens = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken())-2;
			}
		}
		
//		for(int[] a: map) {
//			System.out.println(Arrays.toString(a));
//		}
		
		tokens = new StringTokenizer(br.readLine());
		taxi_r = Integer.parseInt(tokens.nextToken())-1;
		taxi_c = Integer.parseInt(tokens.nextToken())-1;
		
		// 승객의 정보
		for(int i=0; i<M; i++) {
			tokens = new StringTokenizer(br.readLine());
			int sr = Integer.parseInt(tokens.nextToken())-1;
			int sc = Integer.parseInt(tokens.nextToken())-1;
			int er = Integer.parseInt(tokens.nextToken())-1;
			int ec = Integer.parseInt(tokens.nextToken())-1;
			
			// 승객의 위치를 int에 한 번에 담기
			customer[i] = new CUSTOMER(sr * 100 + sc, er * 100 + ec);
			
			// 승객의 번호 저장
			map[sr][sc] = i;
		}

		// 길이 있다면 연료만큼 반환, 없으면 -1
		int ret = solve();
		
		System.out.println(ret);
		
		return;
	
	}
	
	
	private static int solve() {

		int ret= -1;
		
		for(int i=0; i<M; i++) {
			int target = find_customer();
			if(target == -1) {
				return ret;
			}
			boolean success = move_customer(target);
			if(success == false) {
				return ret;
			}
		}
		ret = fuel;
		
		return ret;
	}


	private static boolean move_customer(int target) {
		Queue<TAXI> q= new LinkedList<>();
		boolean[][] visit = new boolean[20][20];
		
		TAXI cur = new TAXI(taxi_r*100+taxi_c, 0);
		
		visit[taxi_r][taxi_c] = true;
		q.offer(cur);
		
		while(!q.isEmpty()) {
			cur = q.poll();
			
			if(cur.distance > fuel) {
				return false;
			}
			
			// 승객을 데려다 줌.
			if(cur.pos == customer[target].end) {
				taxi_r = customer[target].end / 100;
				taxi_c = customer[target].end % 100;
				fuel += cur.distance;
				return true;
				
			}
			
			int r = cur.pos / 100;
			int c = cur.pos % 100;
			
			for(int d=0; d<4; d++) {
				int nr = r+ dirR[d];
				int nc = c+ dirC[d];
				if(isOut(nr,nc) || map[nr][nc] == WALL || visit[nr][nc]) continue;
			
				TAXI next = new TAXI(nr*100 + nc, cur.distance+1);
				q.offer(next);
				visit[nr][nc] = true;
			
			}
			
		}
		
		return false;
	}


	private static int find_customer() {

		Queue<TAXI> q= new LinkedList<>();
		boolean[][] visit = new boolean[20][20];
		
		// 시작점
		TAXI cur = new TAXI(taxi_r*100+taxi_c, 0);
		
		visit[taxi_r][taxi_c] = true;
		q.offer(cur);
		
		int candi_size = 0;
		int[] candi = new int[400];
		int candi_distance= -1;
		
		while(!q.isEmpty()) {
			cur = q.poll();
		
			
			if(candi_distance != -1 && cur.distance > candi_distance) {
				break;
			}
			
			int r = cur.pos / 100;
			int c = cur.pos % 100;
			
			// 후보자 들어가는 조건
			if(map[r][c] >= 0) {
				candi[candi_size++] = map[r][c];
				candi_distance = cur.distance;
			}
			
			for(int d=0; d<4; d++) {
				int nr = r + dirR[d];
				int nc = c + dirC[d];
				
				if(isOut(nr,nc) || map[nr][nc] == WALL || visit[nr][nc]) continue;
				
				visit[nr][nc] = true;
				TAXI next = new TAXI(nr*100+ nc, cur.distance+1);
				q.offer(next);
				
			}
			
		}
		
		
		// 나온 거리가 fuel보다 크다면
		if( candi_distance > fuel) {
			return -1;
		}
		
		// 못찾았을경우 -1
		int ret = -1;
		int candi_val = 1000000;
		/**
		 * 손님 후보 수만큼 for문
		 * 시작점 크기 비교
		 * 
		 */
		for(int i=0; i<candi_size; i++) {
			if(candi_val > customer[candi[i]].start) {
				candi_val = customer[candi[i]].start;
				ret = candi[i];
			}
		}
		
		// 승객 출발지점 위치 시키기
		taxi_r = customer[ret].start / 100;
		taxi_c = customer[ret].start % 100;
		
		map[taxi_r][taxi_c] = EMPTY;
		fuel = fuel-candi_distance;
		
		return ret;
	}


	private static boolean isOut(int nr, int nc) {
		return nr<0 || nr>=N || nc<0 || nc>=N;
	}


	
	// 고객의 정보
	static class CUSTOMER{
		private int start, end;

		public CUSTOMER(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public String toString() {
			return "CUSTOMER [start=" + start + ", end=" + end + "]";
		}
		
	}
	
	// 택시의 위치
	static class TAXI{
		private int pos, distance;

		public TAXI(int pos, int distance) {
			this.pos = pos;
			this.distance = distance;
		}

		@Override
		public String toString() {
			return "TAXI [pos=" + pos + ", distance=" + distance + "]";
		}
		
	}
	
	static String src = "6 3 1\r\n" + 
			"0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0\r\n" + 
			"1 1\r\n" + 
			"1 1 1 2\r\n" + 
			"1 2 1 3\r\n" + 
			"1 3 1 6";
}
