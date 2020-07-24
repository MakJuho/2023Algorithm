package 카카오인턴;

import java.util.HashSet;

public class 보석쇼핑 {

	public static void main(String[] args) {

		HashSet<String> hs = new HashSet<>();
		
		// 보석 개수 체크
		for(String gem : gems ) {
			hs.add(gem);
		}
		
		
		
		System.out.println(hs);
		
		
	}
	
	
	static String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
	
}
