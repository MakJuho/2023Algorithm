package SW역량테스트_1016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_15684_사다리조작 {
	/**
	 * 
	 * N: 세로, M: 가로, H: 가로선을 놓을 수 있는 위치
	 * 
	 * 가로선이 연속하거나 접하면 안됨.
	 * 
	 * boolean 이차원 배열 생성 ( N + (N-1), H+ (+2) )
	 * 
	 * 기본 틀 만들어놓기.
	 * 
	 * 빈 공간 리스트에 넣어놓고, 인접한지 체크하면서 공간에 넣고
	 * 정상 동작하는 지 체크
	 * 동작 이상하다면 원래대로 리셋
	 * 
	 * 반복
	 * @throws IOException 
	 */
	
	static class POS{
		int r,c;

		@Override
		public String toString() {
			return "POS [r=" + r + ", c=" + c + "]";
		}

		public POS(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
		
	}
	
	static int N, M, H;
	static boolean[][] board;
	static ArrayList<POS> wait = new ArrayList<>();
	static int[] dirR = {0, 0, 1};
	static int[] dirC = {1, -1, 0};
	static int ret = -1;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		H = Integer.parseInt(tokens.nextToken());
		
		board = new boolean[H+2][2*N-1];
		
		for(int r=0; r<board.length; r++) {
			
			for(int c=0; c<board[r].length; c++) {
				if(c% 2 == 0) {
					board[r][c] = true;
				}
			}
		}
		for(int i =0; i<M; i++) {
			tokens = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			
			board[a][2*b-1] = true;
			
			
		}
		
//		for(boolean[] a: board) {
//			System.out.println(Arrays.toString(a));
//		}
		
		// false인 곳 정보를 리스트에 저장해놓기
		
		for(int r=1; r<board.length-1; r++) {
			for(int c=0; c<board[r].length; c++) {
				if(!board[r][c]) {
					wait.add(new POS(r,c));
				}
			}
		}
		
//		System.out.println(wait);
		for(int i=1; i<wait.size(); i++) {
			LinkedList<POS> list = new LinkedList<>();
			
			Combination(list,i,0);
			if(ret != -1) {
				System.out.println(ret);
				return;
			}
		}
		System.out.println(-1);
		
		
		
	}
	
	private static void Combination(LinkedList<POS> list, int r, int idx) {
		if(r == 0) {
//			System.out.println(list);
			
			boolean[][] subBoard = new boolean[H+2][2*N-1];
			
			for(int i=0; i<board.length; i++) {
				for(int j=0; j<board[i].length; j++) {
					subBoard[i][j] = board[i][j];
				}
			}
//			System.out.println();
			
			// 선택된 애들을 board로 갱신하기
			
		
			for(POS tmp : list) {
				int nr = tmp.r;
				// subBoard 연이어지면 탈락.->
				int nc1 = tmp.c-2;
				int nc2 = tmp.c+2;
				
				// 범위가 왼쪽으로 벗어날 경우 제외하고 비교
				if(nc1 >0) {
					if(subBoard[nr][nc1]) {
						return;
					}
				}
				
				// 범위가 오른쪽만 벗어날 경우, 왼쪽만 비교
				if(nc2 < subBoard[0].length) {
					if(subBoard[nr][nc2]) {
						return;
					}
				}
				
				subBoard[tmp.r][tmp.c]= true;
			}
//			for(boolean[] a: subBoard) {
//				System.out.println(Arrays.toString(a));
//			}
			// 오른쪽이나 왼쪽이 있으면 오른쪽이나 왼쪽으로 이동하고 아니면 아래로 이동, 바닥에 닿을 때까지
//			System.out.println();
			
			for(int i=0; i<N; i++) {
				
				POS start = new POS(0,i*2);
				int start_c = i;
				int end_c = -1;
				boolean[][] visit = new boolean[subBoard.length][subBoard[0].length];
				
				
				while(true) {
					
					for(int d=0; d<3; d++) {
						int nr = start.r+dirR[d];
						int nc = start.c+dirC[d];
						
						if(isOut(nr,nc)) continue;
						
						if(visit[nr][nc]) continue;
						
						if(subBoard[nr][nc]) {
							visit[nr][nc] = true;
							start = new POS(nr,nc);
							break;
							
						}
						
					}
					
					if(start.r == H+1) {
						end_c = start.c/2;
						break;
					}
					
					
				}
				
				if(start_c != end_c) {
					// 계속 진행
					return;
				}
			}
			
			
			ret = list.size();
			
			return;
		}
		else if(wait.size() == idx) return;
		
		list.add(wait.get(idx));
		Combination(list, r-1, idx+1);
		list.removeLast();
		Combination(list, r, idx+1);
		
	}

	private static boolean isOut(int nr, int nc) {
		return 0>nr || nr>=board.length || 0>nc || nc>=board[0].length;
	}

	private static boolean isIn(int nr, int nc) {
		return 0<=nr && nr<board.length && 0<=nc && nc<board[0].length;
	}

	static String src ="5 8 6\r\n" + 
			"1 1\r\n" + 
			"2 2\r\n" + 
			"3 3\r\n" + 
			"4 4\r\n" + 
			"3 1\r\n" + 
			"4 2\r\n" + 
			"5 3\r\n" + 
			"6 4";
}
