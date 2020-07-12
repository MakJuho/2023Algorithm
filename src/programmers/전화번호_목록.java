package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class 전화번호_목록 {
	public static void main(String[] args) {
		String[] phone_book = {
				"119", "97674223", "1195524421"
		};
		
		Arrays.sort(phone_book, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		
		boolean flag = true;
		for(int i=0; i<phone_book.length-1; i++) {
			if(phone_book[i+1].startsWith(phone_book[i])) {
				flag = false;
			}
			break;
		}
		System.out.println(flag);
		
		
		
	}
}
