package SW역량테스트_1013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17825_주사위윷놀이 {

	/**
	 * 말은 총 4개
	 * 총 10개의 턴
	 * 이동하는 칸에 말이 있으면 이동이 불가능
	 * 말이 이동할 때마다 점수가 증가
	 * 
	 */
	
	// idx, move1, move2, move3, move4, move5
	static int[][] look_up = {
		{0, 1, 2, 3, 4, 5},
		{2, 2, 3, 4, 5, 6},
		{4, 3, 4, 5, 6, 7},
		{6, 4, 5, 6, 7, 8},
		{8, 5, 6, 7, 8, 9},
		{10, 21, 22, 23, 24, 25},
		{12, 7, 8, 9, 10, 11},
		{14, 8, 9, 10, 11, 12},
		{16, 9, 10, 11, 12, 13},
		{18, 10, 11, 12, 13, 14},
		{20, 27, 28, 24, 25, 26},
		{22, 12, 13, 14, 15, 16},
		{24, 13, 14, 15, 16, 17},
		{26, 14, 15, 16, 17, 18},
		{28, 15, 16, 17, 18, 19},
		{30, 29, 30, 31, 24, 25},
		{32, 17, 18, 19, 20, 32},
		{34, 18, 19, 20, 32, 32},
		{36, 19, 20, 32, 32, 32},
		{38, 20, 32, 32, 32, 32},
		{40, 32, 32, 32, 32, 32},
		{13, 22, 23, 24, 25, 26},
		{16, 23, 24, 25, 26, 20},
		{19, 24, 25, 26, 20, 32},
		{25, 25, 26, 20, 32, 32},
		{30, 26, 20, 32, 32, 32},
		{35, 20, 32, 32, 32, 32},
		{22, 28, 24, 25, 26, 20},
		{24, 24, 25, 26, 20, 32},
		{28, 30, 31, 24, 25, 26},
		{27, 31, 24, 25, 26, 20},
		{26, 24, 25, 26, 20, 32},
		{0, 32, 32, 32, 32, 32}
	};
	
	
	
	static int score = 0;
	
	static int[] in = new int[10];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		/*		 
		 * 말은 총 4개
		 * 총 10개의 턴
		 * */
		int ret = 0;
		String bNum="";
		StringBuilder sb = new StringBuilder();
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		for(int i=0; i<10; i++) {
			in[i] = Integer.parseInt(tokens.nextToken());
		}
		int candi =0;
		// 말에게 분배
		// Math.pow(2, 20)
		for(int i=0; i<Math.pow(2, 20); i++) {
			
			// 말 입력
			bNum = Integer.toBinaryString(i);
			if(bNum.length() < 20) {
				for(int j=0; j<20-bNum.length(); j++) {
					sb.append("0");
				}
				bNum = sb.append(bNum).toString();
				
			}
			sb.setLength(0);

			
			// 말 이동
			candi = move(bNum);
			
			if(candi > ret) {
				ret = candi;
			}
			
		}
		
		System.out.println(ret);
		
	}
	
	
	private static int move(String bNum) {
		int sum=0;
		boolean[] visit = new boolean[33];
		int[] horse = new int[4];
//		System.out.println(Arrays.toString(visit));
		// 2자리씩 끊어서 주사위 확인하기
		int cur_pos =0;
		for(int cnt=0; cnt<10; cnt++) {
			String a = bNum.substring(2*cnt, 2*cnt+2);
			
			int move = in[cnt];
			
			// 첫 번째 주사위
			if( a.equals("00")) {
				cur_pos = horse[0];
				int next_pos = look_up[cur_pos][move];
				int add_score = look_up[next_pos][0];
				
				if(visit[next_pos] && next_pos !=32) {
					return -1;
				}
			
				sum += add_score;
				visit[cur_pos] = false;
				visit[next_pos] = true;
				horse[0] = next_pos;
				
				
			}else if( a.equals("01")) {
				cur_pos = horse[1];
				int next_pos = look_up[cur_pos][move];
				int add_score = look_up[next_pos][0];
				
				if(visit[next_pos] && next_pos !=32) {
					return -1;
				}
			
				sum += add_score;
				visit[cur_pos] = false;
				visit[next_pos] = true;
				horse[1] = next_pos;
			
			}else if( a.equals("10")) {
				cur_pos = horse[2];
				int next_pos = look_up[cur_pos][move];
				int add_score = look_up[next_pos][0];
				
				if(visit[next_pos] && next_pos !=32) {
					return -1;
				}
			
				sum += add_score;
				visit[cur_pos] = false;
				visit[next_pos] = true;
				horse[2] = next_pos;
			}else if( a.equals("11")) {
				cur_pos = horse[3];
				int next_pos = look_up[cur_pos][move];
				int add_score = look_up[next_pos][0];
				
				if(visit[next_pos] && next_pos !=32) {
					return -1;
				}
			
				sum += add_score;
				visit[cur_pos] = false;
				visit[next_pos] = true;
				horse[3] = next_pos;
			}
			
			
		}
		
//		System.out.println(sum);
		
		return sum;
		
		
	}


	static String src = "1 2 3 4 1 2 3 4 1 2";
	
	
	
	
}
