package HashMap;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Function_Ex {
	public static void main(String[] args) {
		
		HashMap<String, Integer> fruitMap = new HashMap();
		
		fruitMap.put("사과", 1000);
		fruitMap.put("배", 2000);
		fruitMap.put("자두", 3000);
		fruitMap.put("수박", 4000);
		
		System.out.println(fruitMap);

		// 키 값만 출력하는 경우.
		Set<String> keys = fruitMap.keySet();
		
		for(String key: keys) {
		
			System.out.println(key);		

		}
		
		// Value값만 출력하는 경우.
		Collection<Integer> values = fruitMap.values();
		for(Integer value: values) {
		
			System.out.println(value);
		
		}

		// values.forEach(value -> System.out.println(value));
		
		// 동시에 출력하는 경우.
		Set<Map.Entry<String, Integer>> entries = fruitMap.entrySet();
		
		for(Map.Entry<String, Integer> entry: entries) {
			System.out.print("key: "+ entry.getKey());
			System.out.println(", Value: "+ entry.getValue());
		}

	}
}