package 투포인터;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class 카카오인턴_보석쇼핑 {

	static HashSet<String> hs = new HashSet<>();
	static HashMap<String, Integer> hm = new HashMap<>();
	static Queue<String> q = new LinkedList<>();
	static int startPoint = 0;
	static int length = Integer.MAX_VALUE;
	public static void main(String[] args) {
		
		String[] gems = {"AA", "AB", "AC", "AA", "AC"};
		int start=0;
		for(int i=0; i<gems.length; i++) {
			hs.add(gems[i]);
		}
		
		for(int i=0; i<gems.length; i++) {
			
			if(!hm.containsKey(gems[i])) {
				hm.put(gems[i], 1);
			}else {
				hm.put(gems[i], hm.get(gems[i])+1);
			}
			
			q.add(gems[i]);
			
			while(true) {
				String tmp = q.peek();
				if(hm.get(tmp) > 1) {
					hm.put(tmp, hm.get(tmp)-1);
					q.poll();
					startPoint++;
				}else {
					break;
				}
				
			}
			
			
			if(hs.size() == hm.size() && length > q.size()) {
				length = q.size();
				start = startPoint;
				
			}
			
			
			
			
		}
		System.out.println(Arrays.toString(new int[] {start+1, start+length}));
		
		
		
		
	}
	
}
