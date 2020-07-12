package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class sort {

	public static void main(String[] args) {
		List<String> nameList = new ArrayList<>();
		
		nameList.add("Heo");
		nameList.add("Choi");
		nameList.add("Lee");
		
		System.out.println("정렬 전"+nameList);
		
		Collections.sort(nameList);
		
		System.out.println("정렬 후"+nameList);
		
	}
}
