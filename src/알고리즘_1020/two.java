package 알고리즘_1020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class two {

	/**
	 * 유저는 한번에 최대 5개 까지 음식 주문
	 * HashMap으로 음식을 넣고, 길이를 통해 다양성 확인
	 * 길이를 배열에 넣고 비교
	 */
	
	public static void main(String[] args) {
//		String[] order = {
//				"alex pizza pasta", "alex pizza pizza", "alex noodle", "bob pasta", "bob noodle sandwich pasta",
//				"bob steak noodle"
//		};
		String[] order = {
				"alex pizza pasta steak",
				"bob noodle sandwich pasta",
				"choi pizza sandwich pizza",
				"alex pizza pasta steak"
		};
		
//		System.out.println(order[0]);
		
		HashMap<String, HashSet<String>> map = new HashMap<String, HashSet<String>>();
		
		
		for(int i=0; i<order.length; i++) {
			// alex pizza pasta
			StringTokenizer tokens = new StringTokenizer(order[i]);
			// 이름
			String name = tokens.nextToken();
			
			HashSet<String> hs = new HashSet<>();
			
			// map에 이름을 포함한다면
			if(map.containsKey(name)) {
				while(tokens.hasMoreTokens()) {
					String food = tokens.nextToken();
					map.get(name).add(food);
					
				}
			}else {
				while(tokens.hasMoreTokens()) {
					
					String food = tokens.nextToken();
					hs.add(food);
				}
				
				map.put(name, hs);
				
			}

			
		}
		
		// 가장 다양한 음식 종류 수
		int max = 0;
		for(String key : map.keySet()) {
			if(map.get(key).size()>max) {
				max = map.get(key).size();
			}
		}
			
		System.out.println(max);
		
		ArrayList<String> list = new ArrayList<>();
		
		for(String key: map.keySet()) {
			if(map.get(key).size() == max) {
				list.add(key);
			}
		}
		
		System.out.println(list);
		
		
		String[] answer = new String[list.size()];
		for(int i=0; i<list.size(); i++) {
			answer[i] = list.get(i);
		}
		System.out.println(Arrays.toString(answer));
		
	}
	
}
