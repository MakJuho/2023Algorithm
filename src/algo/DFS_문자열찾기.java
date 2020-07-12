package algo;

public class DFS_문자열찾기 {
	
	static boolean[] check;
	public static void main(String[] args) {
		String A = "fasfafas";
		String B = "asf";
		
		check = new boolean[A.length()];
		dfs(A,B,0,0,0);
		
		
	}

	private static void dfs(String A, String B,int i, int j,int k) {
	
		if(i>A.length()) {
			return;
		}
		if(B.length() == j) {
			System.out.println("success");
			return ;
		}
		
		
		
		if(A.charAt(i) == B.charAt(j)) {
			dfs(A,B,i+1, j+1, k);
		}else {
			dfs(A,B,k+1,0,k+1);
		}
		
	}
}
