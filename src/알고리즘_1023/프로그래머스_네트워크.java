package 알고리즘_1023;

import java.util.*;

public class 프로그래머스_네트워크 {
	static int cnt = 0;
	public static void main(String[] args) {
	
		int n = 3;
		
//		int[][] computers = {{1,1,0},{1,1,0},{0,0,1}};
		int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
		
		
		int size = computers.length;
		
		boolean[] visit = new boolean[computers.length];
		
		for(int r=0; r<computers.length; r++) {
			if(!visit[r]) {
				cnt++;
				dfs(r, visit, computers);
			}
		}
		
		// 이어져있는 지 확인하는 방법?
		
		System.out.println(cnt);
		
		
		
	}

	private static void dfs(int r, boolean[] visit, int[][] computers) {
		visit[r] = true;
		
		
		for(int c=0; c<computers.length; c++) {
			if(computers[r][c] == 1 && !visit[c]) {
				dfs(c, visit, computers);
			}
		}
		
		
	}
	
}
