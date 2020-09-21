package 카카오인턴;

import java.util.Arrays;
import java.util.LinkedList;

public class 후보키 {
	
	static LinkedList<Integer> list = new LinkedList<>();
	
	public static void main(String[] args) {
		String[][] relation = 
			{{"100","ryan","music","2"},
			{"200","apeach","math","2"},
			{"300","tube","computer","3"},
			{"400","con","computer","4"},
			{"500","muzi","music","3"},
			{"600","apeach","music","2"}};
		solution(relation);
		
		return;
	}
	public static int solution(String[][] relation) {
        int answer = 0;
        int len = relation[0].length;

        int[] arr = new int[len];
        
        for(int i=0; i<arr.length; i++) {
        	arr[i] = i+1;
        }
        System.out.println(Arrays.toString(arr));
        for(int i=1; i<=len; i++) {
        	// 하나씩 선택
        	Combination(arr, i, 0);
        	
        }
        return answer;
    }
	private static void Combination(int[] arr, int r, int idx) {
		if(r == 0 ) {
			// list에 Combination 번호 뽑기
			
			
			return ;
			
		}
		else if( idx == arr.length) return;
		list.add(arr[idx]);
		Combination(arr, r-1, idx+1);
		list.removeLast();
		Combination(arr, r, idx+1);
		
	}
}
