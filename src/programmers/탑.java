package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 탑 {
	public static void main(String[] args) {

		int[] heights = {3,9,9,3,5,7,2};
		int[] answer = new int[heights.length];
		for(int i=heights.length-1; i>=0; i--) {
			for(int cnt=1; i-cnt >=0; cnt++) {
				if( heights[i-cnt] > heights[i]) {
					answer[i] = i-cnt+1;
					break;
				}
			}
		}
		
		System.out.println(Arrays.toString(answer));
		
		
		
	}
	
	static class Pos{
		int idx;
		int val;
		
		public Pos(int idx, int val) {
			this.idx = idx;
			this.val = val;
		}
		@Override
		public String toString() {
			return "Pos [idx=" + idx + ", val=" + val + "]";
		}
		
		
		
	}
	
	
	
}
