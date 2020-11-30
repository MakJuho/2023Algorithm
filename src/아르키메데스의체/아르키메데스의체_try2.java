package 아르키메데스의체;

import java.util.Arrays;
import java.util.Scanner;

public class 아르키메데스의체_try2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		boolean[] isPrimary = new boolean[N+1];
		
		Arrays.fill(isPrimary, true);
		
		isPrimary[0] = false;
		isPrimary[1] = false;
		
		for(int i=0; i<Math.sqrt(N); i++) {
			if(!isPrimary[i])
				continue;
			
			for(int j=i*i; j<N+1; j= j+i) {
				isPrimary[j] = false;
				
			}
			
		}
		
		for(int i=0; i<N+1; i++) {
			if(isPrimary[i]) {
				System.out.print(i+" ");
			}
		}
		
		
	}
}
