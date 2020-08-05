package toss;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Second {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		boolean isPossible = true;
		int spaceCnt=0;
		for(int i=0; i<input.length(); i++) {
			if(input.charAt(i) == ' ') {
				spaceCnt++;
			}
		}
		
		if(spaceCnt != 5) {
			isPossible = false;
			System.out.println(isPossible);
			return ;
		}
		
		int[] arr = new int[6];
		
		StringTokenizer tokens = new StringTokenizer(input);

			
		for(int i=0; i<arr.length; i++) {
			arr[i] = Integer.parseInt(tokens.nextToken());
			// 번호 1~45로 구성
			if(arr[i] <=0 || arr[i] >45) {
				isPossible = false;
				System.out.println(isPossible);
				return ;
			}
			
		}
		
		
		// 중복 체크
		HashSet<Integer> hs = new HashSet<>();
		for(int i=0; i<arr.length; i++) {
			hs.add(arr[i]);
		}

		if(arr.length != hs.size()) {
			isPossible = false;
			System.out.println(isPossible);
			return ;
		}

		// 오름차순 정렬
		for(int i=0; i< arr.length-1; i++) {
			if(arr[i] > arr[i+1]) {
				isPossible=false;
				System.out.println(isPossible);
				return ;
			}
		}
		System.out.println(isPossible);
	}
}
