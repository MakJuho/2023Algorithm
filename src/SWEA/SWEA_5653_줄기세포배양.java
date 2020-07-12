package SWEA;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_5653_줄기세포배양 {
	
	static class Cell{
		int i; // i 세로좌표
		int j; // j 가로좌표
		int x; // x 줄기세포의 생명력
		
		int life; // 활성화까지 시간 -> 살아있는 시간(시간이 지나면서 감소됨)
		int time; // 배양 시간 (시간이 지나면서 감소됨)
		int flag; // 활성화상태( 0: 비활성화, 1: 활성화)
		
		public Cell(int i, int j, int x, int life, int time, int flag) {
			this.i = i;
			this.j = j;
			this.x = x;
			
			this.life = life;
			this.time = time;
			this.flag = flag;
		}
	}

	static int N,M,K;
	static int[][] map;
	static List<ArrayList<Cell>> list; // 줄기 세포생명력 (1<=X<=10)별 저장(인덱스 0~9사용)
	static int[] di = {-1,1,0,0}; // 상, 하, 좌, 우
	static int[] dj = {0,0,-1,1};
	
	static void bfs() {
		Queue<Cell> q = new LinkedList<>();
		for(int x=9; x>=0; x--) {
			for(int s=0; s<list.get(x).size(); s++){
				q.offer(list.get(x).get(s));
			}
		}
		
		while(!q.isEmpty()) {
			Cell c = q.poll();
			
			// 비활성화이고 
			if(c.life==0 && c.flag ==1) {
				map[c.i][c.j] = -1;
				continue;
			}
			if(c.time==0) continue;
			if(c.life!=0) {
				q.offer(new Cell(c.i,c.j,c.x,c.life-1,c.time-1,c.flag));
				continue;
			}
			// c.life==0
			q.offer(new Cell(c.i,c.j,c.x,c.x,c.time,1));
			for(int d=0; d<4; d++) {
				int ni=c.i+di[d];
				int nj=c.j+dj[d];
				if(0<=ni && ni<N+K && 0<=nj && nj<M+K && map[ni][nj]==0) {
					map[ni][nj]=c.x;
					q.offer(new Cell(ni,nj,c.x,c.x,c.time-1,0));
				}
				
			}
			
			
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new FileReader("./res/5653.txt"));
		
		int T = Integer.parseInt(br.readLine());
		System.out.println(T);
		list.clear();
		
		for(int tc=1; tc<=T; tc++) {
			for(int x=0; x<=9; x++) {
				list.add(new ArrayList<>());
			}
		}
		
		
		String line = br.readLine();
		StringTokenizer tokens = new StringTokenizer(line);
		
		N = Integer.parseInt(tokens.nextToken()); // 세로 1<=N<=50
		M = Integer.parseInt(tokens.nextToken()); // 가로 1<=M<=50
		K = Integer.parseInt(tokens.nextToken()); // 배양시간 1<=K<=300
		
		map = new int[N+K][M+K]; // 세로+배양시간, 가로+배양시간

		for(int i=(K/2); i<N+(K/2); i++) {
			line = br.readLine();
			tokens = new StringTokenizer(line);
			for(int j=(K/2); j<M+(K/2); j++) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
				if(map[i][j]!=0) {
					int idx= map[i][j]-1; // 리스트작업시 0 ~9까지 (줄기세포생명령 1<=X<=10)
					list.get(idx).add(new Cell(i,j,map[i][j], map[i][j],K,0));
				
				}
			}
		}

		// 처리
		bfs();
		
		// 출력
		int cnt=0;
		for(int i=0; i<N+K; i++) {
			for(int j=0; j<M+K; j++) {
				if(map[i][j]!=0 && map[i][j] != -1) cnt++; // 상태 누적(비활성화+활성화)
			}
		}
		System.out.println(cnt);
	}
	
	
	



	private static String src = "5 5 19\r\n" + 
			"3 2 0 3 0\r\n" + 
			"0 3 0 0 0\r\n" + 
			"0 0 0 0 0\r\n" + 
			"0 0 1 0 0\r\n" + 
			"0 0 0 0 2";
}
