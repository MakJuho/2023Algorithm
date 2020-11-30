package 위상정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2252_줄세우기 {
	
	// 위상정렬 하는 방법
	// parents 배열 생성
	// 이차원 list 생성
	
	static int n;   // 노드 갯수
    static int m;   // 간선 갯수
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br = new BufferedReader(new StringReader(src));
        
        StringTokenizer tokens = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(tokens.nextToken());
        m = Integer.parseInt(tokens.nextToken());
        
        // 2차원 list 정의
        List<List<Integer>> list = new ArrayList<List<Integer>>();

        // 2차원 list 초기화
        for(int i=0; i<n+1; i++) {
        	list.add(new ArrayList<Integer>());
        }
        
        // 노드 개수
        int[] indegrees = new int[n+1];
        
        for(int i=0; i<m; i++) {
        	tokens = new StringTokenizer(br.readLine());
        	
        	int a = Integer.parseInt(tokens.nextToken());
        	int b = Integer.parseInt(tokens.nextToken());
        	
        	list.get(a).add(b);
        	indegrees[b]++;
        	
        }
        
        topologicalSort(indegrees, list);
        
        
        
    }
 
    static void topologicalSort(int[] indegree, List<List<Integer>> list) {
    	Queue<Integer> q = new LinkedList<Integer>();
    	Queue<Integer> result = new LinkedList<Integer>();
    	
    	for(int i=1; i<=n; i++) {
    		if(indegree[i] == 0) {
    			q.offer(i);
    		}
    	}
    	
    	while(!q.isEmpty()) {
    		int curNode = q.poll();
    		
    		result.offer(curNode);
    		
    		for(Integer idx : list.get(curNode)) {
    			indegree[idx]--;
    			
    			if(indegree[idx] == 0) {
    				q.offer(idx);
    			}
    			
    		}
    		
    		
    	}
    	
    	for(int i: result) {
    		System.out.print(i+" ");
    	}
    	
    }
    
    static String src ="4 2\r\n" + 
    		"4 2\r\n" + 
    		"3 1";
}
