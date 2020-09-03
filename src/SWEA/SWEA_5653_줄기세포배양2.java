package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class SWEA_5653_줄기세포배양2 {
	

	static int res = 0;
	static int N,M,K =0;
	static int[][] map;
	static int[] dirR= {-1, 0, 1, 0};
	static int[] dirC= {0, 1, 0, -1};
	
	
	static List<ArrayList<Data>> list;
	
	static class Data{
		int r; // 좌표값
		int c;
		int x; // 생명력
		int life; // 비활성화 카운트
		int time; // 활성화된 후 카운트
		boolean flag; // 활성화, 비활성화
		
		public Data(int r, int c, int x, int life, int time, boolean flag) {
			this.r = r;
			this.c = c;
			this.x = x;
			this.life = life;
			this.time = time;
			this.flag = flag;
		}
		
		
		
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader
				
				(src));
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=TC; t++) {
			StringTokenizer tokens = new StringTokenizer(br.readLine());
			N = Integer.parseInt(tokens.nextToken());
			M = Integer.parseInt(tokens.nextToken());
			K = Integer.parseInt(tokens.nextToken());
			
			int[][] map = new int[700][700];
			list = new ArrayList<>();
			for(int i=0; i<10; i++) {
				list.add(new ArrayList<>());
			}
			
			for(int r=350; r<350+N; r++) {
				tokens = new StringTokenizer(br.readLine());
				for(int c=350; c<350+M; c++) {
					map[r][c] = Integer.parseInt(tokens.nextToken());
					if(map[r][c] != 0) {
						list.get(map[r][c]-1).add(new Data(r,c,map[r][c],map[r][c], map[r][c], false));
					}
				}
			}
			
			bfs();
			
			// 죽은 세포는 값을 -1로 변경
			for(int r=0; r<700; r++) {
				for(int c=0; c<700; c++) {
					if(map[r][c] != 0 && map[r][c] != -1) {
						res ++;
					}
				}
			}
			
			System.out.println("#"+t+" "+res);
			
			
			
			
		}
		
		
	}
	
	
	private static void bfs() {
		Queue<Data> q = new LinkedList<>();
		
		for(int i=9; i>=0; i--) {
			if(list.get(i).size() != 0) {
				for(Data d : list.get(i)) {
					q.offer(d);
				}
			}
		}
		
		
		Data tmp;
		while(!q.isEmpty()) {
			
			tmp = q.poll();
			
			// 죽을세포처리
			if(tmp.life == 0 && tmp.flag ) {
				map[tmp.r][tmp.c] = -1; 
				continue;
			}
			
			// 배양시간처리
			if(tmp.time == 0) {
				continue;
			}
			
			// 라이프 사이클 감소 처리
			if(tmp.life != 0) {
				q.offer(new Data(tmp.r, tmp.c, tmp.x, tmp.life-1, tmp.time-1, tmp.flag));
				continue;
			}
			
			// 비활성화 라이프 사이클 감소해서 0 => 활성화 만들기
			q.offer(new Data(tmp.r, tmp.c, tmp.x, tmp.x, tmp.time, true));
			
			// 줄기세포 배양
			for(int i=0; i<4; i++) {
				int nr = tmp.r+dirR[i];
				int nc = tmp.c+dirC[i];
				
				// 범위 체크
				if(isOut(nr,nc)) continue;
				
				if(map[nr][nc] == 0) {
					map[nr][nc] = tmp.x;
					q.offer(new Data(nr, nc, tmp.x, tmp.x, tmp.time-1, false));
				}
			}
			
			
			
		}
		
		
		
	}


	private static boolean isOut(int nr, int nc) {
		return 0 > nr || nr >= 700 || 0 > nc || nc >= 700;
	}


	static String src = "2\r\n" + 
			"2 2 10\r\n" + 
			"1 1\r\n" + 
			"0 2\r\n" + 
			"5 5 19\r\n" + 
			"3 2 0 3 0 \r\n" + 
			"0 3 0 0 0 \r\n" + 
			"0 0 0 0 0 \r\n" + 
			"0 0 1 0 0 \r\n" + 
			"0 0 0 0 2";
}
