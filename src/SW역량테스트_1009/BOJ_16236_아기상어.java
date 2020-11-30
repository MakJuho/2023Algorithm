package SW역량테스트_1009;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16236_아기상어 {

	/**
	 *  오래 걸린 이유 !
	 *  1. BFS할 때 방문 체크를 안해서 다시 돌아갔었음. 
	 *  2. 물고기가 같은 거리일 때 조건 따지는 부분을 어디서 해야할 지 많이 해맸음.
	 *  -> while 문 들어가기전에 Candi로 정의해놓고, poll()로 꺼내온 뒤 바로 비교하여 예외처리하면 된다.
	 */
	
	static int[] dirR = {-1, 0, 1, 0};
	static int[] dirC = {0, 1, 0, -1};
	static int[][] map;
	static boolean[][] visit;
	static int N;
	static int shark_eat, shark_size;
	// 전역변수로 선언해놓고 쓰면 편했음 SHARK.
	static Pos SHARK;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		// N, map 입력 -> 아기상어 위치 Pos로 받기.(사이즈 2)
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		// 상어 초기화
		for(int r=0; r<N; r++) {
			StringTokenizer tokens = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
				// 아기 상어 위치
				if(map[r][c] == 9) {
					SHARK = new Pos(r,c,0);
					shark_eat = 0;
					shark_size = 2;
					map[r][c] = 0;
					
				}
			}
		}
		
		// 변경된 내용이 없으면 종료.!! -> 핵심
		boolean isUpdate = true;
		
		while(isUpdate) {
			isUpdate = false;
			visit = new boolean[N][N];
			visit[SHARK.r][SHARK.c] = true;
			
			// Queue 선언, 상어 시작위치 추가
			Queue<Pos> q = new LinkedList<>();
			q.offer(SHARK);
			
			// 선택된 물고기 -> 거리 비교 
			Pos candi = new Pos(20,20,-1);
			
			while(!q.isEmpty()) {
				
				Pos tmp = q.poll();
				
				// poll()로 현재꺼 빼자마자 조건으로 예외처리
				// 후보 물고기가 있고, 시간이 더 짧으면 끝내기
				if(candi.time != -1 && candi.time < tmp.time) {
					break;
				}
				
				// 물고기 크기 작고, 빈칸아니여야됨.
				if(map[tmp.r][tmp.c] < shark_size && map[tmp.r][tmp.c] != 0) {
					// 행, 열 비교해서 더 작으면 갱신
					if(tmp.r < candi.r || (tmp.r == candi.r && tmp.c< candi.c)){
						candi = tmp;
						isUpdate = true;
					}
					
				}
				
				// 사방 탐색
				for(int dir=0; dir<4; dir++) {
					int nr = tmp.r+dirR[dir];
					int nc = tmp.c+dirC[dir];
					int ntime = tmp.time+1;
					
					// 범위 초과할 경우
					if(isOut(nr,nc)) continue;
					
					// 이미 방문 했을 경우
					if(visit[nr][nc]) continue;
						
					// 상어크기보다 클 경우
					if(map[nr][nc] > shark_size) continue;
					
					// 새로 등장한 물고기의 행이 더 적을 경우
					// 같은 행이면 열이 더 작을 경우
					
					visit[nr][nc] = true;
					q.add(new Pos(nr,nc,ntime));
					
					
				}
				
				
			}
			// 업데이트 되었으면 동기화해야한다.
			if(isUpdate) {
				
				SHARK = candi;
				
				shark_eat ++;
				if(shark_eat == shark_size) {
					shark_size ++;
					shark_eat = 0;
				}
				
				
				map[SHARK.r][SHARK.c] = 0;
				
			}
			
		}
		
		
		System.out.println(SHARK.time);
		
		
		
	}
	
	// 경계선 조건
	private static boolean isOut(int nr, int nc) {
		return 0>nr || nr >= N || 0>nc || nc >= N;
	}

	// 위치, 시간
	static class Pos{
		private int r,c,time;

		public Pos(int r, int c, int time) {
			this.r = r;
			this.c = c;
			this.time = time;
		}

		@Override
		public String toString() {
			return "Pos [r=" + r + ", c=" + c + ", time=" + time + "]";
		}
		
		
		
	}
	
	static String src = "6\r\n" + 
			"5 4 3 2 3 4\r\n" + 
			"4 3 2 3 4 5\r\n" + 
			"3 2 9 5 6 6\r\n" + 
			"2 1 2 3 4 5\r\n" + 
			"3 2 1 6 5 4\r\n" + 
			"6 6 6 6 6 6";
	
}
