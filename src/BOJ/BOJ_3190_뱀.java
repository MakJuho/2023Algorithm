package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3190_뱀 {
	
	static class Pos{
		private int x;
		private int y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public String toString() {
			return "Pos [x=" + x + ", y=" + y + "]";
		}
		
	}
	
	static int[][] map;
	static HashMap<Integer, String> hm = new HashMap<>();
	static LinkedList<Pos> q = new LinkedList<Pos>();
	static int N,K,L;
	static int t=0;
	static int[] di= {0,1,0,-1};
	static int[] dj= {1,0,-1,0};
	static int dir = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
		map = new int[N+1][N+1];
		
		for(int i=0; i<K; i++) {
			StringTokenizer tokens = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
		
			map[a][b] = 2;
			
		}
		
		L = Integer.parseInt(br.readLine());
		
		for(int i=0; i<L; i++) {
			StringTokenizer tokens = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(tokens.nextToken());
			String b = tokens.nextToken();
			hm.put(a,b);
		}

		
		q.add(new Pos(1,1));
		map[1][1] = 1;
		int ni = 0;
		int nj = 0;
		while(!q.isEmpty()) {
			
			
			Pos temp = q.getLast();
			// 해당 시간이 있을경우
			
			ni = temp.x+di[dir];
			nj = temp.y+dj[dir];
			
			
			t++;
			if( 1<= ni && ni < N+1 && 1<= nj && nj < N+1) {
				if(map[ni][nj] == 2) {
					q.add(new Pos(ni,nj));
					map[ni][nj] = 1;
				}else if(map[ni][nj] == 1) {
					System.out.println(t);
					return;
				}else {
					temp = q.poll();
					map[temp.x][temp.y] = 0;
					q.add(new Pos(ni, nj));
					map[ni][nj] = 1;
				}
				
			}else {
				System.out.println(t);
//				for(int[] a: map) {
//					System.out.println(Arrays.toString(a));
//				}
				return;
			}
			
			if(hm.containsKey(t)) {

				if(hm.get(t).equals("D")) {
					dir = (dir+5)%4;
				}else if(hm.get(t).equals("L")) {
					dir = (dir+3)%4;
				}
				
			}
			
			
			
			
		}
		
		
		
		
		
	}
	
	
	
	
	static String src = "10\r\n" + 
			"4\r\n" + 
			"1 2\r\n" + 
			"1 3\r\n" + 
			"1 4\r\n" + 
			"1 5\r\n" + 
			"4\r\n" + 
			"8 D\r\n" + 
			"10 D\r\n" + 
			"11 D\r\n" + 
			"13 L";
	
	
}
