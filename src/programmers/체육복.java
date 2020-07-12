package programmers;

import java.util.Arrays;

public class 체육복 {
	public static void main(String[] args) {
		int n = 3;
		int[] lost = {3};
		int[] reserve = {1};
		
		int[] arr= new int[n+2];
		Arrays.fill(arr, 0);
		
		for(int a: lost) {
			arr[a] -= 1;
		}
		
		for(int b: reserve) {
			arr[b] += 1;
		}

		for(int i=n; i>0; i--) {
			if(arr[i] == -1) {
				if(arr[i+1]==1) {
					arr[i]++;
					arr[i+1]--;
				}else if(arr[i-1]==1) {
					arr[i]++;
					arr[i-1]--;
				}
			}
		}
		int cnt=0;
		for(int i=1; i<=n; i++) {
			if(arr[i]>=0) {
				cnt++;
			}
		}
		
		
		System.out.println(cnt);
						
	}
}
