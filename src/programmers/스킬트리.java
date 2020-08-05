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
			Arrays.fill(ary, -1);
			int tmp = 0;
			for(int j=0; j<skill_trees[i].length(); j++) {
				if( map.get(skill_trees[i].charAt(j)) != null ) {
					ary[j]=map.get(skill_trees[i].charAt(j));
				}
			}
			
			boolean isPossible = true;
			int pre=100;
			for(int j=0; j<skill_trees[i].length(); j++) {
				if(ary[j] != -1) {
					if(pre > ary[j] ) {
						pre = ary[j];
						if(ary[j]>=1) {
							isPossible = false;
							break;
						}
					}
				}
			}
			
			
			if(isPossible) ans++;
			
			System.out.println(Arrays.toString(ary));
		}
		System.out.println(ans);
	}
	
}
