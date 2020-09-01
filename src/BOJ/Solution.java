package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int p; // 마스터 라인수
	static int q; // 사용자 라인수
	
	static char[][] prr; // 마스터 내용
	static char[][] qrr; // 사용자 내용
	static int[] res;

	public static void main(String[] args) throws Exception{

		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(rd.readLine());
		
		StringTokenizer st = null;
		for(int t = 1; t <= TC; t++) {
			st = new StringTokenizer(rd.readLine(), " ");
			p = Integer.parseInt(st.nextToken());
			q = Integer.parseInt(st.nextToken());
			prr = new char[p][];
			qrr = new char[q][];
	
			res = new int[q];
			
//			사용된 흔적은 판단하는 수로 초기화
			for(int i = 0 ; i < q; i++) {
				res[i] = -2; 
			}
			
			for(int i = 0 ; i < p ; i++) {
				prr[i] = rd.readLine().toCharArray();
			}
			for(int i = 0 ; i < q; i++) {
				qrr[i] = rd.readLine().toCharArray();
			}
//			솔루션 구현
			for(int r = 1; r <= 20 ; r++) {
				for(int c = 1 ; c <= 20; c++) {
					for(int s = 1 ; s <= 20; s++) {
						if(isFind(r,c,s)) {
							solve(r,c,s);
						}
					}
				}
			}
			
			
			
			System.out.print("#" + t + " " ); //추가 출력
			for(int i = 0; i < q; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}

	}
	private static boolean isFind(int r, int c, int s) {
		int rCnt = 0, cCnt = 0, sCnt = 0;
		boolean flag = true;
		int cnt =0;
		int intent = 0;
		for(int i = 0 ; i < p; i++) {
			cnt = 0;
			for(char ch : prr[i]) {
				if(ch == '.') {
					cnt++;
				}else {
					break;
				}
			}
//			공백 판단
			intent = rCnt * r + cCnt * c + sCnt * s;
			if(intent != cnt) {
				flag = false;
				break;
			}
			for(char ch : prr[i]) {
				switch(ch) {
				case '(':
					rCnt++;
					break;
				case ')':
					rCnt--;
					break;
				case '{':
					cCnt++;
					break;
				case '}':
					cCnt--;
					break;
				case '[':
					sCnt++;
					break;
				case ']':
					sCnt--;
					break;
				}
			}
		}
		return flag;
	}
	private static void solve(int r, int c, int s) {

		int rCnt = 0, cCnt = 0, sCnt = 0;
		int intent;
		for(int i = 0 ; i < q; i++) {
			intent = rCnt * r + cCnt * c + sCnt * s;
			
//			조금더 판단 필요
			if(res[i] == -2) {
				res[i] = intent; //처음들어가는 값인지 아닌지 판단
			}else if(res[i] != intent){
				res[i] = -1;  // 5  5  5
			}
			
			
			
			for(char ch : qrr[i]) {
				switch(ch) {
				case '(':
					rCnt++;
					break;
				case ')':
					rCnt--;
					break;
				case '{':
					cCnt++;
					break;
				case '}':
					cCnt--;
					break;
				case '[':
					sCnt++;
					break;
				case ']':
					sCnt--;
					break;
				}
			}
		}
		
	}



}




























