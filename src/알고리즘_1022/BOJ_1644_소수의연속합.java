package 알고리즘_1022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ_1644_소수의연속합 {
	
	static boolean[] check;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int target = 4000000;
		
		check = new boolean[target+1];
		
		Arrays.fill(check, true);
		
		check[0] = check[1] = false;
		
		for(int i=2; i<Math.sqrt(check.length); i++) {
			
			if(!check[i])
				continue;
			
			for(int j= i*i; j<check.length; j=j+i) {
				check[j] = false;
			}
			
		}
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0; i<check.length; i++) {
			if(check[i]) {
				if(i > N) {
					break;
				}
				list.add(i);
				
			}
		}
//		System.out.println(list);
		// 투포인터
		/**
		 * 앞에는 가만히 두고 두번째 인자를 하나씩 증가
		 * 만약 더 커지면 앞에 인자를 증가
		 */
		int s = 0;
		int e = 0;
		int sum = 0;
		int cnt = 0;
		while(true) {
			// 합이 N보다 크거나 같으면, 값을 빼고 앞에꺼 한칸 증가
			if(sum >= N) {
				sum = sum-list.get(s);
				s++;
			}else if(e == list.size()) {
				break;
			}else if(sum < N) {
				// 합이 N보다 작으면 마지막 더하고 한칸 증가
				sum = sum+list.get(e);
				e++;
			}
			
			
			if(sum == N) {
				cnt ++;
			}
			
		}
		System.out.println(cnt);
		
		
	}
}
