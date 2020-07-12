package algo;

import java.util.Scanner;

public class 에라토스테네스의체_1 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		boolean[] check = new boolean[num+1];
		if(num ==1 ) return ;
		check[0] = false;
		check[1] = false;

		for(int i=2; i<=num; i++) {
			check[i] = true;
		}
		
		
		for(int i=2; i*i<=num; i++) {
			for(int j=i*i; j<=num; j+=i) {
				check[j] = false;
			}
		}
		
		System.out.println("2부터 "+num+"까지 소수 Count");
		
		for(int i=0; i<=num; i++) {
			if(check[i] == true) {
				System.out.print(i+" ");
			}
		}
		
//		System.out.println(a);
	}
}
