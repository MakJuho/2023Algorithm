package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1253_좋다 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		Arrays.sort(arr);
//		System.out.println(Arrays.toString(arr));
		/**
		 * 두 수의 합이 음수이면 left + 1
		 * 두 수의 합이 양수면 right - 1
		 */
		int ans = 0;

		for(int i=0; i<N; i++) {
			int left = 0;
			int right = arr.length-1;

			/**
			 * 자기자신을 제외하고 숫자들의 합으로 구성해야한다.
			 */
			while(left < right ) {
				
				
				if(arr[left] + arr[right] == arr[i]) {
					if(left != i && right != i) {
						ans++;
						break;
					}else if(right == i) {
						right = right -1;
					}else if(left == i) {
						left = left + 1;
					}
				}else if(arr[left] + arr[right] >= arr[i] ) {
					right = right - 1;
				}else if(arr[left] + arr[right] < arr[i] ) {
					left = left + 1;
				}
			}
			
		}
		System.out.println(ans);
		
	}
	
	static String src = "7\r\n" + 
			"-6 -2 0 3 6 8 9";
}
