package programmers;

import java.util.Arrays;
import java.util.HashMap;

public class 스킬트리 {

	
	static int[] ary;
	static int ans=0;
	public static void main(String[] args) {
		String skill= "CBD";
		String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
		
		int skillCnt= skill_trees.length;
		
		HashMap<Character, Integer> map = new HashMap<>();
		for(int i=0; i<skill.length(); i++) {
			map.put(skill.charAt(i), i);
		}
		
		for(int i=0; i<skillCnt; i++) {
			ary = new int[skill_trees[i].length()];
			for(int j=0; j<skill_trees[i].length(); j++) {
				if( map.get(skill_trees[i].charAt(j)) != null ) {
					ary[j]=map.get(skill_trees[i].charAt(j))+1;
				}
			}
			int cnt=1;
			boolean isPossible = true;
			for(int j=0; j<skill_trees[i].length(); j++) {
				if(cnt == ary[j]) {
					cnt++;
				}else if(cnt < ary[j]) {
					isPossible = false;
				}
			}
			
			if(isPossible) ans++;
			
			System.out.println(Arrays.toString(ary));
		}
		System.out.println(ans);
	}
	
}
