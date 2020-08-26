import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution_3 {

	static int result = 0;
	static int R, C; // 행, 열의 갯수
	static int[][] map;
//	static char[][] map;
	static int[] dx = {0,0,-1,1}; //상, 하, 좌, 우
	static int[] dy = {-1,1,0,0};
//	static int[][] v;
//	static Set<Character> set = new HashSet<>();
	static int[] v = new int[26+1];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int t = 1; t <= TC; t++) {
			result = 0;
//			set.clear();
			Arrays.fill(v, 0);
			R = sc.nextInt();
			C = sc.nextInt();
			map = new int[R][C];  // 사이즈 크기 변경을 할 경우고 필요할 수 있죠 1,1
//			v = new int[R][C];
			String s = "";
			for(int i = 0; i < R; i++) {
				s = sc.next();
				for(int j = 0; j < C; j++) {
					map[i][j] = s.charAt(j) - 'A';
				}
			}//입력 완료
			dfs(1-1,1-1, 1);
			System.out.println("#" + t + " " + result);
		}

	}
	static void dfs(int x, int y, int cnt) {
//		종료
		if(cnt == 26) {
			result = 26;
			return;
		}
//		실행및 재귀 호출
		result = Math.max(result, cnt);
//		v[y][x] = 1; // 1 방문, 0 : 방문 안함
//		set.add(map[y][x]);
		v[map[y][x]] = 1;
		int nx, ny;
		for(int i = 0 ; i < 4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
//			범위 체크, 방문체크
			if(nx < 0 || nx >=C || ny < 0 || ny >= R) {
				continue;
			}
			if(v[map[ny][nx]] == 1) {
				continue;
			}
//			기존 문자열 방문 체크 확인
//			if(set.contains(map[ny][nx])) {
//				continue;
//			}
			dfs(nx, ny, cnt + 1);
//			v[ny][nx] = 0;
			v[map[ny][nx]] = 0;
//			set.remove(map[ny][nx]);
		}
	}

}
