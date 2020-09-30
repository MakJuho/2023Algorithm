package Algo0929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9205_맥주마시면서걸어가기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		int TC = Integer.parseInt(br.readLine());
		

		// BFS -> why? 편의점 위치가 순서대로 나와있지 않음.
		// 				현재 위치에서 1000이하의 거리에 있는 곳을 방문하고, 방문했으면 재방문하면 안된다.!!
		for(int t=1; t<=TC; t++) {
			Boolean isHappy = false;
			
			int convCnt = Integer.parseInt(br.readLine());
			boolean[] check = new boolean[convCnt+2];
			Pos[] position = new Pos[convCnt+2];
			
			for(int i=0; i<convCnt+2; i++) {
				StringTokenizer tokens = new StringTokenizer(br.readLine());
				
				int r = Integer.parseInt(tokens.nextToken());
				int c = Integer.parseInt(tokens.nextToken());
				
				position[i] = new Pos(r,c);
				
			}
			
			// position에 모든 위치를 저장.
			Queue<Pos> q = new LinkedList<>();
			// 시작 위치
			q.add(position[0]);
			check[0] = true;
			
			Pos end = position[convCnt+1];
			
			while(!q.isEmpty()) {
				
				Pos tmp = q.poll();
				
				if(tmp.equals(end)) {
					isHappy = true;
					break;
				}
				
				// 방문했다면 
				for(int i=1; i<convCnt+2; i++) {
					if(!check[i] && Math.abs(tmp.r-position[i].r)+Math.abs(tmp.c-position[i].c) <= 1000) {
						q.add(position[i]);
						check[i] = true;
					}
				}
				
				
			}
			if(isHappy) System.out.println("happy");
			else {
				System.out.println("sad");
			}
		}
	}
	
	static class Pos{
		
		private int r, c;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Pos [r=" + r + ", c=" + c + "]";
		}
		
		
	}
	
	static String src = "2\r\n" + 
			"2\r\n" + 
			"0 0\r\n" + 
			"1000 0\r\n" + 
			"1000 1000\r\n" + 
			"2000 1000\r\n" + 
			"2\r\n" + 
			"0 0\r\n" + 
			"1000 0\r\n" + 
			"2000 1000\r\n" + 
			"2000 2000";
}
