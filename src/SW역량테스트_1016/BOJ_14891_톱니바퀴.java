package SW역량테스트_1016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class BOJ_14891_톱니바퀴 {
	/*
	 * 시계 방향, 반시계 방향으로 이동
	 * 톱니바퀴별 상태 체크 (2개 배열 이용)
	 * 톱니바퀴 움직이기 
	 * 첫 열의 숫자로 계산하기 
	 */
	
	static int K;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
	
		char[][] gear = new char[4][9];
		
		for(int r=0; r<4; r++) {
			gear[r] = br.readLine().toCharArray();
		}

//		for(char[] a: gear) {
//			System.out.println(Arrays.toString(a));
//		}
	
		K = Integer.parseInt(br.readLine());

		while(K-- > 0) {
			StringTokenizer tokens = new StringTokenizer(br.readLine());
			int target = Integer.parseInt(tokens.nextToken())-1;
			int cmd = Integer.parseInt(tokens.nextToken());
			
			int[] move_cmd = new int[4];
			
			move_cmd[target] = cmd;
			
			for(int left= target-1; left>=0 ; left--) {
				
				int right = left+1;
				if(gear[left][2] == gear[right][6]) {
					break;
				}else {
					move_cmd[left] = move_cmd[right]*-1;
				}
			}
			for(int right= target+1; right<4; right++) {
				int left = right-1;
				
				if(gear[right][6] == gear[left][2]) {
					break;
				}else {
					move_cmd[right] = move_cmd[left]*-1;
				}
				
			}
//			System.out.println(Arrays.toString(move_cmd));
			for(int i=0; i<4; i++) {
				if(move_cmd[i] == 1) {
					char tmp = gear[i][7];
					for(int j=7; j>0; j--) {
						gear[i][j] = gear[i][j-1];
					}
					gear[i][0] = tmp;
					
				}else if(move_cmd[i] == -1) {
					char tmp = gear[i][0];
					for(int j=0; j<7; j++) {
						gear[i][j] = gear[i][j+1];
					}
					gear[i][7] = tmp;
				}
			}
		}
		
		int ret= 0;
		for(int i=0; i<4; i++) {
			if(gear[i][0] == '1') {
				ret += Math.pow(2,i);
			}
		}
		System.out.println(ret);
		
		
		
		
	}

	static String src ="10101111\r\n" + 
			"01111101\r\n" + 
			"11001110\r\n" + 
			"00000010\r\n" + 
			"2\r\n" + 
			"3 -1\r\n" + 
			"1 1";
}
