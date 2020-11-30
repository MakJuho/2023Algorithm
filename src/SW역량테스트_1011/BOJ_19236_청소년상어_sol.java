package SW역량테스트_1011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.sound.midi.Soundbank;

public class BOJ_19236_청소년상어_sol {

	/**
	 * 
	 * 청소년 상어가 (0,0) 물고기를 먹고 방향을 가진다.
	 * 
	 * 물고기 이동
	 * 물고기가 작은 번호 순서대로 이동한다.
	 * 상어가 있거나 경계는 이동할 수 없다.
	 * 방향 45도씩 반시계 회전( 이동할 수 있을 때까지)/ 이동할 수 있는 칸이 없으면 이동하지 않는다.
	 * 서로 위치를 바꾸는 식으로 이동
	 * 
	 * 상어 이동
	 * 여러 칸 이동 가능 / 물고기 없는 칸은 이동할 수 없다.
	 * DFS
	 * 한칸 움직였을 때 , 두칸 움직였을 때, 세칸 움직였을때
	 * 
	 */
	static class FISH{
		int r, c, dir;

		public FISH(int r, int c, int dir) {
			this.r = r;
			this.c = c;
			this.dir = dir;
		}

		@Override
		public String toString() {
			return "FISH [r=" + r + ", c=" + c + ", dir=" + dir + "]";
		}
		
		
	}
	
	static class SHARK{
		int r,c, dir, eat;

		public SHARK(int r, int c, int dir, int eat) {
			this.r = r;
			this.c = c;
			this.dir = dir;
			this.eat = eat;
		}

		@Override
		public String toString() {
			return "SHARK [r=" + r + ", c=" + c + ", dir=" + dir + ", eat=" + eat + "]";
		}
		
		
	}
	
	static int[][] board = new int[4][4];
	static int[] dirR = {0, -1, 0, +1, +1, +1, 0, -1 };
	static int[] dirC = {-1,-1, -1, -1, 0, +1, +1, +1};
	static FISH[] fish;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));

		StringTokenizer tokens;

		fish = new FISH[17];
		
		for(int r=0; r<4; r++) {
			tokens = new StringTokenizer(br.readLine());
			for(int c=0; c<4; c++) {
				board[r][c] = Integer.parseInt(tokens.nextToken());
				fish[board[r][c]] = new FISH(r,c, Integer.parseInt(tokens.nextToken()));
			}
		}
		
		
//		System.out.println(Arrays.toString(fish));
		
//		 * 청소년 상어가 (0,0) 물고기를 먹고 방향을 가진다.
		SHARK shark = new SHARK(0,0,fish[board[0][0]].dir,board[0][0]);
		board[0][0] = -1;
		
		
		
		fishMove();
		
		
	}
	
	private static void fishMove() {
//		 * 물고기 이동
//		 * 물고기가 작은 번호 순서대로 이동한다.
//		 * 상어가 있거나 경계는 이동할 수 없다.
//		 * 방향 45도씩 반시계 회전( 이동할 수 있을 때까지)/ 이동할 수 있는 칸이 없으면 이동하지 않는다.
//		 * 서로 위치를 바꾸는 식으로 이동

		for(int[] a: board) {
			System.out.println(Arrays.toString(a));
		}
		
		int pickFish = 1;
		for(int i=1; i<=16; i++) {
			loop:
			for(int r=0; r<4; r++) {
				for(int c=0; c<4; c++) {
					if(board[r][c] == pickFish) {
						// 방향 가졌다.
						int d = fish[pickFish].dir;
						for(; d<d+8; d++) {
							
							int nr = r+dirR[(d-1)%8];
							int nc = c+dirC[(d-1)%8];
							
							if(isOut(nr,nc)) continue;
							
							if(board[nr][nc] == -1) continue;
							
							fish[board[r][c]].dir = d%8;
//							 ↑(1), ↖(2), ←(3), ↙(4), ↓(5), ↘(6), →(7), ↗(8)
							FISH tmp2 = fish[board[r][c]];
							fish[board[r][c]] = fish[board[nr][nc]];
							fish[board[nr][nc]]= tmp2;
							
							// swap
							int tmp = board[r][c];
							board[r][c] = board[nr][nc];
							board[nr][nc] = tmp;
							
							
							pickFish ++;
							break loop;
						}
					}
					
				}
			}
			
		}
		
		for(int[] a: board) {
			System.out.println(Arrays.toString(a));
		}
		
		
	}

	private static boolean isOut(int nr, int nc) {
		return 0 > nr || 0> nc || 4<=nr || 4<=nc;
	}

	static String src = "7 6 2 3 15 6 9 8\r\n" + 
			"3 1 1 8 14 7 10 1\r\n" + 
			"6 1 13 6 4 3 11 4\r\n" + 
			"16 1 8 7 5 2 12 2";
}
