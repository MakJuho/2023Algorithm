package 카카오인턴;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class 후보키2 {
	
	static List<Integer> list = new ArrayList<>();

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
	        dfs(relation, "", -1);
	        int answer = 0;
	        Collections.sort(list);
	        System.out.println(list);
	        while(!list.isEmpty()) {
	            int v = list.remove(0);
	            answer++;
	            Iterator<Integer> it = list.iterator();
	            while(it.hasNext()) {
	                int next = it.next();
	                if((next&v) == v) {
	                    it.remove();
	                }
	            }
	        }
	        System.out.println(answer);
	        return answer;
	 
	    }
	    public static void dfs(String[][] relation, String s, int idx) {
	        if(idx == relation[0].length-1) {
	            if(check(relation, s)) {
	                int now = 0;
	                for(int i=0; i<s.length(); i++) {
	                    now |= 1<<(s.charAt(i)-'0');
	                }
	                list.add(now);
	            }
	            return;
	        }
	        dfs(relation, s+(idx+1), idx+1);
	        dfs(relation, s, idx+1);
	    }
	    
	    public static boolean check(String[][] relation, String s) {
	        Set<String> set = new TreeSet<>();
	        for(int i=0; i<relation.length; i++) {
	            StringBuilder sb = new StringBuilder();
	            for(int j=0; j<s.length(); j++) {
	                sb.append(relation[i][s.charAt(j)-'0']);
	            }
	            set.add(sb.toString());
	        }
	        if(set.size()==relation.length) return true;
	        return false;
	    }


}
