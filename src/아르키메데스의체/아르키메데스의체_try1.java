package 아르키메데스의체;

import java.util.Arrays;

public class 아르키메데스의체_try1 {
	public static void main(String[] args) {
		int n = 1000;
		
		boolean[] check = new boolean[n+1];
		
		Arrays.fill(check, true);
		
		check[0] = false;
		check[1] = false;
		
		for(int i=0; i<Math.sqrt(n); i++) {
			if(!check[i]) continue;
			
			for(int j=i*i; j<=n; j=j+i) {
				check[j] = false;
			}
		}
		
		for(int i=0; i<check.length; i++) {
			if(check[i]) {
				System.out.print(i+" ");
			}
		}
		
		
		
	}
}
