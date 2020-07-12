package programmers;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Arrays;
public class Prog1 {

	public static void main(String[] args) {
		int[][] cart = {
				{3,5},
				{4,2},
				{1,10}
		};
		
		Character[][] buy = {
				{'3', 'a'},
				{'3', 'b'},
				{'3', 'c'},
				{'4', 'a'},
				{'4', 'd'},
				{'1', 'c'},
				{'1', 'e'}
		};

		// 카트 아이디가 3인 경우의 개수를 센다.
		int[] result = new int[cart.length];
		for(int i=0; i<cart.length; i++) {
			for(int j=0; j<buy.length; j++) {
				if(cart[i][0] == Character.getNumericValue(buy[j][0])) {
					result[i]++;
				}
			}
		}
		
		
		System.out.println(Arrays.toString(result));
		int[][] rlt = new int[cart.length][2];
		for(int r=0; r<cart.length; r++) {
			// 틀린 개수
			rlt[r][0] = cart[r][1]-result[r];
			// 맞는 개수
			rlt[r][1] = cart[r][1] - rlt[r][0];
		}
		
		for(int[] r : rlt) {
			System.out.println(Arrays.toString(r));
		}
	}
	
}
