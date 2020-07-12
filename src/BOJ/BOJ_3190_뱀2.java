package BOJ;
import java.io.*;
import java.util.*;
 
class BOJ_3190_뱀2 {
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {-1, 0, 1, 0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int[][] map = new int[N+2][N+2];
        Map<Integer, String> dirSet = new HashMap<>();
        // 테투리 설정
        for(int i = 0; i < N+2; i++) {
            map[0][i] = map[N+1][i] = map[i][0] = map[i][N+1] = 1;
        }
        // 사과 설정
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r][c] = 2;
        }
 
        // 방향 설정
        int L = Integer.parseInt(br.readLine());
        for(int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            String c = st.nextToken();
            dirSet.put(x, c);
        }
 
        int dir = 1;
        int time = 0;
        Deque<Location> snake = new ArrayDeque<>();
        snake.add(new Location(1,1));
        while(true) {
            time++;
            Location head = snake.peekLast();
            int nX = head.x + dx[dir];
            int nY = head.y + dy[dir];
            if(map[nY][nX] == 1) {
                break;
            }
            if(map[nY][nX] != 2) {
                Location tail = snake.poll();
                map[tail.y][tail.x] = 0;
            }
            map[nY][nX] = 1;
            snake.addLast(new Location(nY, nX));
            if(dirSet.containsKey(time)) {
                dir = (dirSet.get(time).equals("D")) ? (dir+1) % 4 : (dir+3) % 4;
            }
            System.out.println(snake);
            
        }
        System.out.println(time);
    }
 
    private static class Location {
        int x;
        int y;
        Location(int y, int x) {
            this.y = y;
            this.x = x;
        }
		@Override
		public String toString() {
			return "Location [x=" + x + ", y=" + y + "]";
		}
        
    }
}