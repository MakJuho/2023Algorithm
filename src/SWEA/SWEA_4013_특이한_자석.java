package SWEA;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class SWEA_4013_특이한_자석 {

	static LinkedList<Integer>[] magnet;
	static int K; // 자석을 임의로 돌리는 횟수
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(src);
		int TC = sc.nextInt();
		
		for(int tc=1; tc<=TC; tc++) {
			K = sc.nextInt();
			magnet = new LinkedList[5];
			
			for(int i=0; i<magnet.length; i++) {
				magnet[i] =new LinkedList<>();
				for(int j=0; j<8; j++) {
					magnet[i].add(sc.nextInt());
				}
			}
			
			for(int k=0; k<K; k++) {
				int mNum = sc.nextInt();
				boolean dir = sc.nextInt()==1?true:false; // 1이면 시계방향 , 아니면 반시계
				
				
				
			}
			
		}
		System.out.println(Arrays.toString(magnet));
		
		
	}
	
	
	static String src = "10\r\n" + 
			"2\r\n" + 
			"0 0 1 0 0 1 0 0\r\n" + 
			"1 0 0 1 1 1 0 1\r\n" + 
			"0 0 1 0 1 1 0 0\r\n" + 
			"0 0 1 0 1 1 0 1\r\n" + 
			"1 1\r\n" + 
			"3 -1\r\n" + 
			"2\r\n" + 
			"1 0 0 1 0 0 0 0\r\n" + 
			"0 1 1 1 1 1 1 1\r\n" + 
			"0 1 0 1 0 0 1 0\r\n" + 
			"0 1 0 0 1 1 0 1\r\n" + 
			"3 1\r\n" + 
			"1 1\r\n" + 
			"5\r\n" + 
			"0 0 1 1 1 1 1 1\r\n" + 
			"1 1 1 1 1 0 1 0\r\n" + 
			"0 0 0 0 1 0 0 1\r\n" + 
			"0 1 0 1 0 1 0 1\r\n" + 
			"4 -1\r\n" + 
			"3 1\r\n" + 
			"4 -1\r\n" + 
			"3 -1\r\n" + 
			"1 -1\r\n" + 
			"2\r\n" + 
			"1 0 1 0 0 1 0 1\r\n" + 
			"0 0 1 0 1 1 1 1\r\n" + 
			"0 0 1 1 0 0 0 1\r\n" + 
			"0 1 0 1 1 0 0 0\r\n" + 
			"2 -1\r\n" + 
			"1 1\r\n" + 
			"7\r\n" + 
			"0 0 1 1 0 1 1 1\r\n" + 
			"0 1 0 1 1 0 0 0\r\n" + 
			"1 1 1 0 0 0 0 1\r\n" + 
			"1 1 1 0 0 1 0 0\r\n" + 
			"4 1\r\n" + 
			"2 1\r\n" + 
			"2 -1\r\n" + 
			"3 1\r\n" + 
			"2 1\r\n" + 
			"4 1\r\n" + 
			"2 -1\r\n" + 
			"10\r\n" + 
			"1 0 0 0 0 0 0 1\r\n" + 
			"1 0 1 0 1 1 0 1\r\n" + 
			"1 0 0 1 0 0 0 1\r\n" + 
			"1 1 0 1 0 1 1 1\r\n" + 
			"2 1\r\n" + 
			"1 1\r\n" + 
			"2 -1\r\n" + 
			"3 1\r\n" + 
			"3 -1\r\n" + 
			"2 -1\r\n" + 
			"2 -1\r\n" + 
			"1 1\r\n" + 
			"4 1\r\n" + 
			"4 1\r\n" + 
			"10\r\n" + 
			"0 1 0 0 1 1 0 0\r\n" + 
			"0 1 1 0 1 0 1 1\r\n" + 
			"0 0 0 0 0 1 1 0\r\n" + 
			"0 0 1 0 1 0 1 1\r\n" + 
			"3 1\r\n" + 
			"1 -1\r\n" + 
			"2 1\r\n" + 
			"4 -1\r\n" + 
			"3 1\r\n" + 
			"3 -1\r\n" + 
			"4 -1\r\n" + 
			"2 -1\r\n" + 
			"1 -1\r\n" + 
			"3 -1\r\n" + 
			"10\r\n" + 
			"0 1 0 1 0 1 0 0\r\n" + 
			"0 1 1 1 1 1 0 1\r\n" + 
			"1 0 0 0 0 1 1 0\r\n" + 
			"1 0 0 0 0 0 0 1\r\n" + 
			"1 1\r\n" + 
			"4 -1\r\n" + 
			"4 -1\r\n" + 
			"2 -1\r\n" + 
			"2 -1\r\n" + 
			"2 -1\r\n" + 
			"3 -1\r\n" + 
			"2 1\r\n" + 
			"3 1\r\n" + 
			"3 -1\r\n" + 
			"20\r\n" + 
			"1 0 0 0 1 1 0 0\r\n" + 
			"1 0 0 1 1 1 0 0\r\n" + 
			"0 1 1 1 0 1 1 1\r\n" + 
			"1 1 1 1 0 1 1 1\r\n" + 
			"1 1\r\n" + 
			"4 -1\r\n" + 
			"4 -1\r\n" + 
			"2 -1\r\n" + 
			"3 -1\r\n" + 
			"1 1\r\n" + 
			"4 1\r\n" + 
			"4 -1\r\n" + 
			"4 -1\r\n" + 
			"4 -1\r\n" + 
			"3 -1\r\n" + 
			"3 -1\r\n" + 
			"4 -1\r\n" + 
			"4 -1\r\n" + 
			"2 -1\r\n" + 
			"1 1\r\n" + 
			"3 -1\r\n" + 
			"3 -1\r\n" + 
			"2 1\r\n" + 
			"1 1\r\n" + 
			"20\r\n" + 
			"0 0 1 1 1 0 1 0\r\n" + 
			"0 1 0 0 1 0 1 0\r\n" + 
			"1 1 1 0 1 0 1 0\r\n" + 
			"0 0 1 0 0 1 1 1\r\n" + 
			"1 -1\r\n" + 
			"4 -1\r\n" + 
			"3 -1\r\n" + 
			"1 1\r\n" + 
			"4 1\r\n" + 
			"2 1\r\n" + 
			"1 -1\r\n" + 
			"4 1\r\n" + 
			"2 -1\r\n" + 
			"4 -1\r\n" + 
			"1 1\r\n" + 
			"4 -1\r\n" + 
			"1 1\r\n" + 
			"2 -1\r\n" + 
			"1 -1\r\n" + 
			"3 -1\r\n" + 
			"1 1\r\n" + 
			"2 1\r\n" + 
			"3 1\r\n" + 
			"3 -1";
}
