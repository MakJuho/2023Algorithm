package eBayKorea;

import java.util.Arrays;

public class one {
	public static void main(String[] args) {
		int N = 1;
		int[][] simulation_data = {{2, 3}, {5, 4}, {6, 3}, {7, 4}};
		
		// 창구 개수만큼 배열 만들기.
		boolean[][] counter = new boolean[N][1000];
		
		int t=0;
		int tot = 0;
		
		int isOut = 0;
		for(int i=0; i<simulation_data.length; i++) {
			isOut += simulation_data[i][1];
		}
		
		// 탈출 조건
		while(isOut >= t) {
			
			boolean isFull = true;
			boolean isFirst = true;
			int jump = 0;
			for(int i=0; i<counter.length; i++) {
				// 빈 창구 찾기
				if(!counter[i][t] && isFirst) {
					for(int j=0; j<simulation_data.length; j++) {
						// 시간 확인
						if(simulation_data[j][0] == t-tot) {
							
							for(int k=0; k<simulation_data[j][1]; k++) {
								counter[i][t+k]= true;
								isFirst = false;
								jump = k+1;
							}
						}
					}
					isFull = false;
				}
			}
			
			// 창구에 자리가 없으면 대기시간이랑 시간 증가
			if(isFull) tot++;
			if(jump !=0) t = t+jump;
			else {
				t++;
			}
				
		}
		System.out.println("tot : " + tot);
		
	}
}
