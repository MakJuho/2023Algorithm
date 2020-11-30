package HashMap;

import java.util.*;

public class HashMap_try1 {
	public static void main(String[] args) {
		HashMap<String, String> hm = new HashMap<>();
		
		hm.put("A", "B");
		hm.put("B", "C");
		
		System.out.println(hm);
		
		Set<String> keys = hm.keySet();
		
		for(String key : keys) {
		
			System.out.println(hm.get(key));
		}
		
		HashMap<String, HashSet<String>> hm2 = new HashMap<>();
		HashSet<String> hs = new HashSet<>();
		hs.add("A");
		hs.add("B");
		hs.add("C");
		
		hm2.put("1", hs);
		
		System.out.println(hm2);
		
		Set<String> sets = hm2.keySet();
		for(String key : sets) {
			System.out.println(hm2.get(key));
		}
		
		
		
	}
}
