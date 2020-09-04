package 카카오인턴;

import java.util.ArrayList;
import java.util.Arrays;

public class 실패율 {
	public static void main(String[] args) {
		int N = 4;
		int[] stages = {4, 4, 4, 4, 4};
		double[] ans = new double[N];		
		int approach = stages.length;
		
		
		
		
		for(int i=0; i<N; i++) {
			int notClear=0;
			for(int j=0; j<stages.length; j++) {
				
				
				if(i+1 == stages[j]) {
					notClear ++;
				}
				
				
			}
			if(notClear == 0 && approach == 0) {
				ans[i] = 0;
			}else {
				ans[i] = (float)notClear/approach;
			}
			approach = approach - notClear;
			
		}

		ArrayList<Integer> list = new ArrayList<>();
		int[] ans2 = new int[N];
		for(int i=0; i<N; i++) {
			
			double max = Integer.MIN_VALUE;
			int pos = -1;
			for(int j=0; j<N; j++) {
				
				if(ans[j] > max) {
					max = ans[j];
					pos = j;
					
				}

				
			}
			list.add(pos+1);
			ans[pos] = -1;
			
		}
		for(int i=0; i<list.size(); i++) {
			ans2[i] = list.get(i);
		}
		System.out.println(Arrays.toString(ans2));
		
	}
}
