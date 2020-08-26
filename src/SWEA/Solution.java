import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int T, R, C, result;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new char[R][C];

			for (int i = 0; i < R; i++) {
				int j = 0;
				for(char ch : br.readLine().toCharArray()) {
					map[i][j++] = ch;
				}
			}

			result = 1;
//			백트래킹 하지 않고 재귀의 인자를 가지고 가면서 방문체크를 비트 마스트로 함
			dfs(0, 0, 1, (1<<(map[0][0]-'A')));

			sb.append("#" + t + " " + result + "\n");
		}
		System.out.println(sb.toString());
	}

	public static void dfs(int x, int y, int cnt, int bitmask) {

//		알파벳으로 하기 때문에 최대 갯수는 26개를 넘어가지 않음
//		가지 치기 필수입니다.
		if(result == 26) return ;
		result = Math.max(result, cnt);
		int nx, ny;
		for (int i = 0; i < 4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];

			if (nx < 0 || nx >= C || ny < 0 || ny >= R ) {
				continue;
			}
			if((bitmask & (1 << map[ny][nx]-'A')) != 0) {
				continue;
			}

			dfs(nx, ny, cnt + 1, (bitmask | (1 << map[ny][nx]-'A')));     
		}

	}
}