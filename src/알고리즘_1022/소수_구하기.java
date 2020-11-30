package 알고리즘_1022;

import java.util.Arrays;

public class 소수_구하기 {
	
	
	static boolean[] prime; // 소수를 체크할 배열
	
	public static void main(String[] args) {
		
		int N = 4000000;
		
		make_prime(N);
		
		for(int i=0; i<prime.length; i++) {
			if(prime[i] == true) {
				System.out.println(i);
			}
		}
		
		
	}
	
	private static void make_prime(int N) {
		
		prime = new boolean[N+1];
		
		/*
		 * 소수가 아닌 index = false
		 * 소수인 index = true
		 */
		Arrays.fill(prime, true);
		
		if(N <2) {
			return ;
		}
		
		// 0하고 1은 소수가 아니므로 false
		prime[0] = prime[1] = false;
		
		for(int i=2; i<=Math.sqrt(N); i++) {
			// 이미 체크된 배열이면 다음 반복문으로 skip
			if(prime[i] == false) {
				continue;
			}
			for(int j= i*i; j<prime.length; j= j+i) {
				prime[j] = false;
			}
			
		}
		
		
		
	}
	
}
