package algo;

import java.util.Scanner;
import java.util.*;

public class 에라토스테네스의체 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		boolean[] check = new boolean[num+1];
		
		Arrays.fill(check, true);
		
		check[0] = false;
		check[1] = false;
		
		for(int i=2; i*i<=num; i++) {
			for(int j=i*i; j<=num; j=j+i) {
				check[j] = false;
			}
		}
		
		for(int i=0; i<=num; i++) {
			if(check[i])
				System.out.println(i);
		}
		
		
	}
}
