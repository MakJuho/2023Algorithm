package toss;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class First {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		boolean isPossible = true;
		for(int i=0; i<input.length()-1; i++) {
			if(input.charAt(i)=='1' && input.charAt(i+1)=='1') {
				isPossible = false;
			}
			if(input.charAt(input.length()-1) == '1'){
				isPossible = false;
				System.out.println(isPossible);
				return ;
			}
		}
		
		System.out.println(isPossible);
		return;
	}
}
