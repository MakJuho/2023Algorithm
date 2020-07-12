package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_6109_추억의2048게임 {

	static int [][] map;
	static int T, N;
	static String motion;
	
	static int[] di = { -1, 1, 0, 0};	
	static int[] dj = { 0, 0, -1, 1};	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		T = Integer.parseInt(br.readLine());
		
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		motion = tokens.nextToken();
		
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			tokens = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		

		switch(motion) {
			case "down" :
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						move(i,j,0);
					}
				}
				break;
			case "up" :
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						move(i,j,1);
					}
				}
				break;
			case "right" :
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						move(i,j,2);
					}
				}
				break;
			case "left" :
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						move(i,j,3);
					}
				}
				break;
		
		
		}
		
		for(int[] a : map) {
			System.out.println(Arrays.toString(a));
		}
		
		
	}
	
	
	
	private static void move(int i, int j, int dir) {

		int c = map[i][j];
		int s = -1;
		int dx=0, dy=0;
		boolean flag = false;
		if(dir == 0 || dir == 1) {
			for(int k=1; k<N; k++) {
				dx = i+di[dir]*k;
				dy = j+dj[dir];
				
				if(0<=dx && dx<N && 0<=dy && dy<N && map[dx][dy]!=0) {
					flag = true;
					s = map[dx][dy];
					break;
				}
				
			}
		}else if(dir == 1 || dir ==2 ) {
			for(int k=1; k<N; k++) {
				dx = i+di[dir];
				dy = j+dj[dir]*k;
				
				if(0<=dx && dx<N && 0<=dy && dy<N && map[dx][dy]!=0) {
					flag = true;
					s = map[dx][dy];
					break;
				}
			}
		}
		
		if(flag) {
			if(c == s) {
				map[i][j] *=2;
				map[dx][dy] = 0;
			}
			else if( c != s) {
				if(c == 0) {
					map[i][j] = map[dx][dy];
					map[dx][dy] = 0;
				}else if( c != 0) {
					// 아무 처리 안함.
				}
			}
		}
		
		
	}



	static String src = 
			"2\r\n" + 
			"5 up\r\n" + 
			"4 8 2 4 0\r\n" + 
			"4 4 2 0 8\r\n" + 
			"8 0 2 4 4\r\n" + 
			"2 2 2 2 8\r\n" + 
			"0 2 2 0 0\r\n" + 
			"2 down\r\n" + 
			"16 2\r\n" + 
			"0 2";
}
