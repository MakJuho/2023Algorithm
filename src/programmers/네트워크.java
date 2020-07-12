package programmers;

public class 네트워크 {
	
	public static void main(String[] args) {
		int n = 7;
		int[][]computers = {
				{1,1,0,0,0,1,0},
				{1,1,0,0,0,0,0},
				{0,0,1,0,1,0,0},
				{0,0,0,1,0,0,1},
				{0,0,1,0,1,0,0},
				{1,0,0,0,0,1,1},
				{0,0,0,1,0,1,1},
				
		};
		boolean[] ischecked = new boolean[n];
		
		for(int i=0; i<n; i++) {
			ischecked[i] = false;
		}
		
		int network = 0;
		// dfs
		for(int row=0; row<n; row++) {
			
			if(ischecked[row] == false) {
				network++;
				dfs(computers,ischecked,row);
			}
		}
		System.out.println(network);
		
		
	}

	private static void dfs(int[][] computers, boolean[] ischecked, int node) {
		ischecked[node] = true;
		
		for(int col=0; col<computers.length; col++ ) {
			if(computers[node][col] == 1 && ischecked[col] == false) {
				dfs(computers,ischecked,col);
			}
		}
		
		
		
	}
}
