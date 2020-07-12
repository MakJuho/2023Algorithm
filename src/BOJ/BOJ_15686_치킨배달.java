package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_15686_치킨배달 {

	static int map[][];
	static LinkedList<Pos> house = new LinkedList<>();
	static LinkedList<Pos> chicken = new LinkedList<>();
	static LinkedList<Pos> temp = new LinkedList<>();
	static int N,M;
	static int tot = Integer.MAX_VALUE;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		
		StringTokenizer tokens = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		map = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			tokens = new StringTokenizer(br.readLine(), " ");
			for(int j=1; j<=N; j++) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}

		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(map[i][j] == 1) {
					house.add(new Pos(i,j));
				}else if(map[i][j] == 2) {
					chicken.add(new Pos(i,j));
				}
			}
		}
		
		Combination(temp, M, 0);
		
		System.out.println("최소거리:"+tot);
		
	}
	


	private static void Combination(LinkedList<Pos> temp, int r, int index) {
		if(r == 0) {
			int subtot= 0;
			for(int i=0; i<house.size(); i++) {
				int min=Integer.MAX_VALUE;
				for(int j=0; j<temp.size(); j++) {
					int val = Math.abs(temp.get(j).x-house.get(i).x)+
							Math.abs(temp.get(j).y-house.get(i).y);
					if(min > val) {
						min = val;
					}
				}
				subtot += min;
			}
			if(tot > subtot) {
				tot = subtot;
			}
			
			
			return;
		}
		else if(index == chicken.size()) return;
		
		temp.add(chicken.get(index));
		Combination(temp, r-1, index+1);
		temp.removeLast();
		Combination(temp, r, index+1);
		
		
	}



	static String src = "5 3\r\n" + 
			"0 0 1 0 0\r\n" + 
			"0 0 2 0 1\r\n" + 
			"0 1 2 0 0\r\n" + 
			"0 0 1 0 0\r\n" + 
			"0 0 0 0 2";
	
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
	
	
}
