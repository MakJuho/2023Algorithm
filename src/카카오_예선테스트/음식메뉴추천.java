package 카카오_예선테스트;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class 음식메뉴추천 {
	
	static ArrayList<Character> list = new ArrayList<>();
	static LinkedList<Character> menu = new LinkedList<>();
	
	static HashMap<String, Integer> map = new HashMap<String, Integer>();
	static int totCnt;
	static ArrayList<String> answer = new ArrayList<>();
	static String[] answers = {};
	public static void main(String[] args) {
		String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		int[] course = {2,3,4};
		solution(orders,course);
		return ;
	}
	
	public static String[] solution(String[] orders, int[] course) {
        
		int[] alpha = new int[26];
		
		for(int i=0; i<orders.length; i++) {
			for(int j=0; j<orders[i].length(); j++) {
				alpha[orders[i].charAt(j)-65]++;
			}
		}
		
		// 길이가 2이상인 문자를 arr로..
		for(int i=0; i<alpha.length; i++) {
			if(alpha[i] >=2) {
				list.add((char)(i+65));
			}
		}

		// 코스 요리의 개수를 보고 선택해서 Map으로 표시하기
		for(int i=0; i<course.length; i++) {
			totCnt = Integer.MIN_VALUE;
			combination(orders, list.size(), course[i], 0);
			menu.clear();
			System.out.println(answer);
			// 2개인 것중에 최고인 것 선택
		}
		
        
        return null;
    }
	
	private static void combination(String[] orders, int n, int r, int index) {
		if(r == 0){//r이 0이면 다 뽑았다는 뜻
			
			//orders에 menu문자열을 포함하고 있으면 cnt에 넣고 map에 삽입
			
			// menu arr생성
			String pattern="";
			
			for(int i=0; i<menu.size(); i++) {
				pattern += menu.get(i);
			}
			
			int perCnt = 0;
			
//			orders를 정렬
			for(int i=0; i<orders.length; i++) {
				String[] array = orders[i].split("");
				Arrays.sort(array);
				String line= ""; 
				for(String a: array) {
					line +=a;
				}
				if(line.contains(pattern)) {
					perCnt++;
				}
			
			}
			if( perCnt > totCnt ) {
				// 지우고 삽입
				totCnt = perCnt;
				if(!answer.isEmpty()) {
					answer.remove(answer.size()-1);
				}
				answer.add(pattern);
				
			}else if( perCnt == totCnt) {
				// 삽입
				answer.add(pattern);
			}


			return;
		}
		if(index == n) return; //다 탐색했으면 종료..
		
		menu.add(list.get(index));
		combination(orders, n, r-1, index+1);//뽑았으니 ,r-1
		menu.removeLast();
		combination(orders, n, r, index+1);//안뽑았으니, r
	}
	
}
