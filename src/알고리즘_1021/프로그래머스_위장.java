package 알고리즘_1021;

import java.util.ArrayList;
import java.util.HashMap;

public class 프로그래머스_위장 {
	public static void main(String[] args) {
		
//		String[][] clothes = {
//				{"yellow_hat", "headgear"}, 
//				{"blue_sunglasses", "eyewear"}, 
//				{"green_turban", "headgear"}	
//		};
		
		String[][] clothes = {
				{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}
		};
		
		solution(clothes);
	}
	
	private static void solution(String[][] clothes) {
		
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		
		for(int r=0; r<clothes.length; r++) {
			
			String name = clothes[r][1];

			// 만약 이름을 이미 들고 있으면 True
			// 새로 추가
			if( hm.containsKey(name)){
				hm.put(name, hm.get(name)+1);
			}else {
				hm.put(name, 1);
			}
			
		}
		
		
		int multi= 1;
		for(String key : hm.keySet()) {
				multi = multi*(hm.get(key)+1);
		}
		System.out.println(multi-1);
		
	}
	
}
