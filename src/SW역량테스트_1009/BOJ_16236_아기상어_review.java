package SW역량테스트_1009;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16236_아기상어_review {
	/**
	 * 가장 처음 아기상어 크기 2 r,c,size
	 * 크기가 같은 물고기는 먹을 수는 없지만, 지나갈 수 있다.
	 * 더 이상 먹을 수 있는 물고기가 없으면 엄마 상어에게 요청 
	 * 거리가 동일한 물고기가 있다면 가장 위에, 그중 가장 왼쪽에 (위치를 숫자로 저장하면 쉽게 판단 가능)
	 * 전역 변수로 먹은 물고기 수
	 */
	
	
	static class SHARK{
		int r, c, time;

		@Override
		public String toString() {
			return "SHARK [r=" + r + ", c=" + c + ", time=" + time + "]";
		}

		public SHARK(int r, int c, int time) {
			this.r = r;
			this.c = c;
			this.time = time;
		}
		
		
	}
	
	
	static SHARK candi;
	static SHARK shark;
	static int[] fish = new int[6];
	static int N;
	static int fish_eat=0;
	static int shark_size = 2;
	static int[][] board;
	static boolean[][] visit;
	static boolean isOut = false;
	static int[] dirR = {-1, 0, 1, 0};
	static int[] dirC = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
			
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		shark = new SHARK(-1,-1,-1);
		for(int r=0; r<N; r++) {
			StringTokenizer tokens = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				board[r][c] = Integer.parseInt(tokens.nextToken());
				// 물고기 크기별 마리수 체크
				if(board[r][c] != 0 && board[r][c] != 9) {
					fish[board[r][c]-1]++;
				}else if(board[r][c] == 9) {
					// 상어 위치
					shark = new SHARK(r,c,0);
					board[r][c] = 0;
				}
			}
		}
		
//		System.out.println(Arrays.toString(fish));
		
		
		// 탈출 조건  비어있거나, 상어 사이즈보다 작은 사이즈의 물고기가 없을 경우
		// 물고기 찾기, 상어 이동
		while(true) {
			if(!findFish(shark)) {
				break;
			}
			move();
		}
		
		System.out.println(shark.time);
	}
	
	private static boolean findFish(SHARK shark) {
		// BFS 탐색할 때 visit 방문 배열은 필수
		visit = new boolean[N][N];
		Queue<SHARK> q = new LinkedList<>();
		q.add(shark);
	
		// 물고기 후보군 선택해야한다. -> 후보중 가장 왼쪽, 위쪽을 골라야 하므로 가장 큰값을 넣어놓는다.
		candi = new SHARK(21,21, -1);
		
		
		while(!q.isEmpty()) {
			SHARK cur = q.poll();
			
			// 후보군이 있는 데 현재 시간보다 현재 시간이 후보군보다 길면 break;
			if(candi.time != -1 && candi.time < cur.time) break;
			
			// 물고기가 들어있는데 상어의크기보다 작고, 후보군에 적합하다면 후보군 변경
			if(board[cur.r][cur.c] >0 && board[cur.r][cur.c] < shark_size) {
				if(candi.r > cur.r || (candi.r == cur.r) &&(candi.c > cur.c)) {
					candi = new SHARK(cur.r, cur.c, cur.time);
					isOut = true;
					
				}
			}
			
			// 사방 탐색
			for(int d=0; d<4; d++) {
				
				int nr = cur.r + dirR[d];
				int nc = cur.c + dirC[d];
				int ntime = cur.time+1;
				
				
				if(isOut(nr,nc) || visit[nr][nc]) continue;
				
				if(board[nr][nc] > shark_size) continue;
				// 만약 먹은 양과 사이즈가 같다면 +1로 증가

				visit[nr][nc] = true;
				if(board[nr][nc] <= shark_size) {
					q.add(new SHARK(nr,nc,ntime));
				}
				
				
			}
			
		}
		
		// 후보군이 없다는 의미
		if(candi.r == 21) {
			return false;
		}
		return true;
	
	}
	private static void move() {

		// 해당 위치로 이동
		shark = candi;
		
		fish_eat++;
		
		if(shark_size == fish_eat) {
			shark_size ++;
			fish_eat =0;
		}
		
		board[shark.r][shark.c] = 0;
	}

	private static boolean isOut(int nr, int nc) {
		return 0>nr || 0>nc || nr>=N || nc>=N;
	}



	static String src = "6\r\n" + 
			"6 0 6 0 6 1\r\n" + 
			"0 0 0 0 0 2\r\n" + 
			"2 3 4 5 6 6\r\n" + 
			"0 0 0 0 0 2\r\n" + 
			"0 2 0 0 0 0\r\n" + 
			"3 9 3 0 0 1";
	
}
