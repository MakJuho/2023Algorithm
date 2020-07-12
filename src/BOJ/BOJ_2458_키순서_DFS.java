package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2458_키순서_DFS {
	
	static int result = 0;
	static int N, M;
	static int[][] map;
	static int cnt;
	static boolean[] v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        br= new BufferedReader(new StringReader(src));

        int T = Integer.parseInt(br.readLine());
        
        StringTokenizer tokens;
        
        for(int t =1; t <= T ; t++){
	        N = Integer.parseInt(br.readLine());
	        M = Integer.parseInt(br.readLine());
	        map = new int[N+1][N+1];
	        for(int i=0; i<M; i++) {
	        	tokens = new StringTokenizer(br.readLine());
	        	int a = Integer.parseInt(tokens.nextToken());
	        	int b = Integer.parseInt(tokens.nextToken());
	        	map[a][b] = 1;
	        }
	        
	        result =0;
	        
	        // 구현 - 모든 정점에서 나보다 큰 사람 수 세고 나보다 작은 사람 수 센다.
	        
	        // 그 합이 N-1이면 알 수 있다. result++;
	        for(int i=1; i<=N; i++) {
	        	cnt = 0;
	        	// 나보다 큰사람 세기
	        	v = new boolean[N+1];
	        	dfs(i);
	        	
	        	
	        	// 나보다 작은 사람 세기
	        	v = new boolean[N+1];
	        	dfs1(i);
	        	
	        	// 합이 나를 뺸 수와 같으면 다 알 수 있다.
	        	if(cnt == N-1) {
	        		result++;
	        	}
	        	
	        }
	        
	        
	        System.out.println("#"+t+" "+ result);
        }
    }


    static void dfs1(int idx) {
    	v[idx] = true;
    	for(int i = 1; i<=N; i++) {
    		if(v[i]) {
    			continue;
    		}
    		if(map[i][idx] == 0) {
    			continue;
    		}
    		cnt++;
    		dfs1(i);
    	}
	}


	private static void dfs(int idx) {
    	v[idx] = true;
    	for(int i = 1; i<=N; i++) {
    		if(v[i]) {
    			continue;
    		}
    		if(map[idx][i] == 0) {
    			continue;
    		}
    		cnt++;
    		dfs(i);
    	}
	}


	static String src = "1\r\n" + 
    		"6\r\n" + 
    		"6\r\n" + 
    		"1 5\r\n" + 
    		"3 4\r\n" + 
    		"5 4\r\n" + 
    		"4 2\r\n" + 
    		"4 6\r\n" + 
    		"5 2";
}
