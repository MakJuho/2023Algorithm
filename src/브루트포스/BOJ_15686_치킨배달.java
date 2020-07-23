package 브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_15686_치킨배달 {

	
	static int[][] board;
	static int N,M;
	static LinkedList<Pos> chicken = new LinkedList<>();
	static LinkedList<Pos> selected = new LinkedList<>();
	static LinkedList<Pos> house = new LinkedList<>();
	static int ans= Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// N : board를 그림.
		// M : 선택함
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));

		StringTokenizer tokens = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		board = new int[N][N];
		
		
		
		for(int r=0; r<N; r++) {
			tokens = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				board[r][c] = Integer.parseInt(tokens.nextToken());
				if(board[r][c] == 2) {
					chicken.add(new Pos(r,c));
				}else if(board[r][c] == 1) {
					house.add(new Pos(r,c));
				}
			}
		}

		Combination(M, 0);
		
		
		System.out.println(ans);
		
		
	}
	
	private static void Combination(int r, int idx) {
		if(r == 0) {
			System.out.println(selected);
			// board판에서 1인 위치와 거리를 구해서 최소값을 찾기
			int minDist = 0;
			for(int i=0; i<selected.size(); i++) {
				int minPerChicken = 0;
				for(int j=0; j<house.size(); j++) {
					int tmp = Math.abs(selected.get(i).r- house.get(j).r)+Math.abs(selected.get(i).c - house.get(j).c);
						// 치킨 한개에 대한 최소 거리
					minPerChicken += tmp;
				}
				// 모든 치킨집에 대한 최소거리
				minDist += minPerChicken;
			}
			
			if(ans > minDist) {
				ans = minDist;
			}
			
			return;
		}
		if(idx == chicken.size()) return;
		
		selected.add(chicken.get(idx));
		Combination(r-1, idx+1);
		selected.removeLast();
		Combination(r, idx+1);
		
			
			
		
		
	}

	static class Pos{
		int r,c;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Pos [r=" + r + ", c=" + c + "]";
		}
		
		
	}
	
	
	
	static String src = "5 3\r\n" + 
			"0 0 1 0 0\r\n" + 
			"0 0 2 0 1\r\n" + 
			"0 1 2 0 0\r\n" + 
			"0 0 1 0 0\r\n" + 
			"0 0 0 0 2";
}
