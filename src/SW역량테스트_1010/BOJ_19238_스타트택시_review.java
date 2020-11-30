package SW역량테스트_1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_19238_스타트택시_review {
	/**
	 * M명의 승객을 태우기
	 * 출발지에서 택시를 타고, 목적지에서 택시를 내린다.
	 * 현재 위치에서 최단 거리가 가장 짧은 승객을 고른다.
	 * 승객 중 최단거리가 짧은 승객 우선, 행이 작은 승객, 그중에서도 열이 작은 승객을 고른다.
	 * 
	 * 승객을 태워 이동하면서 소모한 연료의 양의 2배가 충전된다.
	 * 연료가 바닥나면 이동에 실패
	 * 
	 */
	static class CUSTOMER{
		int start, end;

		@Override
		public String toString() {
			return "CUSTOMER [start=" + start + ", end=" + end + "]";
		}

		public CUSTOMER(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		
		
		
	}
	static class TAXI {
		int pos, distance;

		@Override
		public String toString() {
			return "TAXI [pos=" + pos + ", distance=" + distance + "]";
		}

		public TAXI(int pos, int distance) {
			this.pos = pos;
			this.distance = distance;
		}
		
		
		
		
	}
	static CUSTOMER[] customer = new CUSTOMER[400];
	static int taxi_r, taxi_c;
	static TAXI candi;
	static int N, M, fuel;
	static int[][] board;
	static int ret = -1;
	static int[] dirR = {-1, 0, 1, 0};
	static int[] dirC = {0, 1, 0, -1};
	static boolean[][] visit;
	static boolean runOut = false;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		fuel = Integer.parseInt(tokens.nextToken());
		
		board = new int[N][N];
		
		for(int r=0; r<N; r++) {
			tokens = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				board[r][c] = Integer.parseInt(tokens.nextToken())-2;
			}
		}
		
//		for(int[] a: board) {
//			System.out.println(Arrays.toString(a ));
//		}
		
		// 택시 위치
		tokens = new StringTokenizer(br.readLine());
		taxi_r = Integer.parseInt(tokens.nextToken())-1;
		taxi_c = Integer.parseInt(tokens.nextToken())-1;
		
		
		int c,d;
		int guestN = 1;
		for(int r=0; r<M; r++) {
			tokens = new StringTokenizer(br.readLine());
			int sr = Integer.parseInt(tokens.nextToken())-1;
			int sc = Integer.parseInt(tokens.nextToken())-1;
			int er = Integer.parseInt(tokens.nextToken())-1;
			int ec = Integer.parseInt(tokens.nextToken())-1;
			board[sr][sc] = r;
			
			// 승객의 위치를 int에 한 번에 담기
			customer[r] = new CUSTOMER(sr * 100 + sc, er * 100 + ec);

		}
//		for(int[] z: board) {
//			System.out.println(Arrays.toString(z));
//		}

		int ret = solve();
		
		System.out.println(ret);
		return ;
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


	private static int find_customer() {
		/*
		 * 택시를 기준으로 후보 중에서 가장 가까운 승객 찾기
		 */
		Queue<TAXI> q = new LinkedList<>();
		visit = new boolean[20][20];
		
		TAXI cur = new TAXI(taxi_r*100+taxi_c, 0);
		
		visit[taxi_r][taxi_c] = true;
		q.add(cur);
		
		int candi_size = 0;
		int[] candi = new int[400];
		int candi_distance = -1;
		
		while(!q.isEmpty()) {
			
			cur = q.poll();
			
			if(candi_distance != -1 && cur.distance > candi_distance) {
				break;
			}
			
			int r = cur.pos / 100;
			int c = cur.pos % 100;
			
			if(board[r][c] >= 0) {
				candi[candi_size++] = board[r][c];
				candi_distance = cur.distance;
			}
			
				
			for(int d=0; d<4; d++) {
				int nr = r + dirR[d];
				int nc = c + dirC[d];
				
				if(isOut(nr,nc) || board[nr][nc] == -1) continue;
				
				if(visit[nr][nc]) continue;
				
				visit[nr][nc] = true;
				TAXI next = new TAXI(nr*100 + nc, cur.distance+1);
				q.add(next);
			
			}
			
		}
		
		
		if( candi_distance > fuel) {
			return -1;
		}
		
		int ret = -1;
		int candi_val = 1000000;
		
		for(int i=0; i<candi_size; i++) {
			if(candi_val > customer[candi[i]].start) {
				candi_val = customer[candi[i]].start;
				ret = candi[i];
			}
		}
		
		taxi_r = customer[ret].start / 100;
		taxi_c = customer[ret].start % 100;
		
		board[taxi_r][taxi_c] = -2;
		fuel = fuel-candi_distance;
		
		return ret;
		
		
		
		
	}
	
	
	private static boolean move_customer(int target) {
		/*
		 * 택시를 기준으로 후보 중에서 가장 가까운 승객 찾기
		 */
		
		Queue<TAXI> q = new LinkedList<>();
		visit = new boolean[20][20];
		
		TAXI cur = new TAXI(taxi_r*100+taxi_c, 0);
		
		visit[taxi_r][taxi_c] = true;
		q.add(cur);
		
		while(!q.isEmpty()) {
			cur = q.poll();
			
			if(cur.distance > fuel) {
				return false;
			}
			
			
			if(cur.pos == customer[target].end) {
				taxi_r = customer[target].end / 100;
				taxi_c = customer[target].end % 100;
				fuel += cur.distance;
				return true;
			}
			
			int r = cur.pos / 100;
			int c = cur.pos % 100;
			
				
				
			for(int d=0; d<4; d++) {
				int nr = r + dirR[d];
				int nc = c + dirC[d];
				
				if(isOut(nr,nc) || board[nr][nc] == -1) continue;
				
				if(visit[nr][nc]) continue;
				
				
				TAXI next = new TAXI(nr*100 + nc, cur.distance+1);
				q.add(next);
				visit[nr][nc] = true;
				
			
			}
			
		}
		return false;
		
	}

	private static boolean isOut(int nr, int nc) {
		return 0>nr || nr >=N || 0>nc || nc >=N;
	}

	static String src = "6 1 1\r\n" + 
			"0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0\r\n" + 
			"3 4\r\n" + 
			"3 4 2 5";
	
}
