package KT대비_1028;

import java.util.Arrays;

public class 아르키메데스의체 {
	public static void main(String[] args) {
		int N = 100;
		
		boolean[] prime = new boolean[N+1];
		
		Arrays.fill(prime, true);
		prime[0] = false;
		prime[1] = false;
		
		for(int i=2; i<Math.sqrt(N); i++) {
			
			
			for(int j=i*i; j<=N; j=j+i) {
				prime[j] = false;
			}
			
			
		}
		
		for(int i=1; i<prime.length; i++) {
			if(prime[i]) {
				System.out.print(i+" ");
			}
		}
		
		
		
	}
}
