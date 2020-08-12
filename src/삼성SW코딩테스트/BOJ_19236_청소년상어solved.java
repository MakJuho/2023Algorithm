package 삼성SW코딩테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_19236_청소년상어solved {
	
	// 물고기 위치, 거리
	static class Fish {
		int x;
		int y;
		int d;
		
		Fish(int x, int y, int d){
			this.x=x;
			this.y=y;
			this.d=d;
		}
	}
	
	// 시계반시계 방향으로
	static int[][] dir = {{0, 0}, {-1,0}, {-1,-1}, {0,-1}, {1, -1}, {1,0}, {1,1}, {0,1}, {-1, 1}};
	static int[][] map = new int[4][4];
	static boolean[] isLive = new boolean[17];	// 물고기가 죽었는지 살았는지 체크하는 배열
	static int answer = Integer.MIN_VALUE;
	static Fish[] fishes = new Fish[17];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer 미리 사용할 예정
		StringTokenizer st = null;
		// 모든 물고기 살아있다고 가정
		Arrays.fill(isLive, true);
		
		// map, 방향 insert
		for(int i=0; i<4; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<4; j++) {
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				map[i][j] = num;
				fishes[num] = new Fish(i, j, dir);
			}
		}
		
//		isLive[0]= true;
		isLive[map[0][0]] = false; // 상어가 처음 먹은 물고기를 죽인다.
		int n = map[0][0]; // 0,0 위치 방향 
		map[0][0] = -1; // 상어 표시
		eatFish(0, 0, fishes[n].d, n, 1); 
		
		System.out.println(answer);
	}
	
	public static void eatFish(int r, int c, int direction, int sum, int cnt) {
		
		int[][] copyMap = new int[4][4];
		Fish[] copyFishes = new Fish[17];
		
		// copyMap에 변경된 상태 저장
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				copyMap[i][j] = map[i][j];
			}
		}
		
		// 물고기 상태도 변환
		for(int i=1; i<=16; i++) {
			copyFishes[i] = fishes[i];
		}
		
		// 물고기 이동
		fishMove();
		
		// 최대 3칸까지 움직일 수 있음.
		for(int i=1; i<=3; i++) {
			// 해당 방향으로 1,2,3 칸 모두 들어감 DFS
			int nr = r + (dir[direction][0]*i);
			int nc = c + (dir[direction][1]*i);
			
			if(isInside(nr, nc)) { // 경계 범위 안이고 살아있는 물고기면
				
				// 비어있으면 다음칸 체크
				if(map[nr][nc] == 0) continue;
				
				// r,c 칸 물고기 잡아먹힘
				map[r][c] = 0;
				// fish 없애기 위해 n 값 받아놓음
				int n = map[nr][nc];
				// 상어 위치 시킴
				map[nr][nc] = -1;
				// fish 죽임
				isLive[n] = false;
//				System.out.println("[상어가 움직이는 다음 좌표] nr : " + nr + " / nc : " + nc + " / fishes[n].d : " + fishes[n].d + " / n : " + n);
//				System.out.println("상어가 지금 까지 먹은 물고기의 양 : " + (sum+n));
				eatFish(nr, nc, fishes[n].d, sum + n, cnt+1);
				// 원위치
				isLive[n] = true;
				map[nr][nc] = n;
				map[r][c] = -1;
				
			} else break;
		}
		
		
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				map[i][j] = copyMap[i][j];
			}
		}
		
		for(int i=1; i<=16; i++) {
			fishes[i] = copyFishes[i];
		}
		
//		System.out.println("sum : " + sum + " / cnt : " + cnt);
		// 상어가 이동할 수 있는 칸이 없으면 공간에서 벗어나 집으로 간다.
		answer = Math.max(sum, answer);
	}
	
	
	public static void fishMove() {
		
		for(int i=1; i<=16; i++) {
			
			if(!isLive[i]) continue; // 이미 잡아먹힌 물고기면 pass
			
			Fish cur = fishes[i];	// 현재 움직일 물고기
//			System.out.println("현재 움직이는 물고기 번호 : " + i + " / 현재 물고기의 이동 방향 : " + cur.d);
			int nd = cur.d;			
			int nx = cur.x, ny = cur.y;
			boolean flag = false;
			// 방향 전환 -> 한칸씩 미룬 값
			int[] changeDir = {0,2,3,4,5,6,7,8,1};
			
			// 모든 방향 체크 
			for(int j=0; j<8; j++) {
				
				nx = cur.x + dir[nd][0];
				ny = cur.y + dir[nd][1];
				
				// 4x4 안에 속하는 지 체크
				if(isInside(nx, ny)) {
					// 상어인지 체크
					if(map[nx][ny] == -1) {
						nd = changeDir[nd];
						continue;
					}
					// 상어가 아니고 빈 칸일 경우
					if(map[nx][ny] == 0 || map[nx][ny] != -1) {
						flag = true;
						break;
					}
				} else {
					// 밖일 경우 방향 전환
					nd = changeDir[nd];
				}
			}
			
			if(!flag) continue;
			
//			System.out.println("nx : " + nx + " / ny : " + ny + " / nd : " + nd + " / map[nx][ny] : " + map[nx][ny]);
			
			// 현재 움직일 물고기 좌표에 있는 물고기와 자리를 바꾼다.
			int temp = map[nx][ny];
			map[nx][ny] = map[cur.x][cur.y];
			map[cur.x][cur.y] = temp;
			
//			System.out.println("temp : " + temp);
			
			// 값 갱신
			fishes[i] = new Fish(nx, ny, nd);	// 현재 움직일 물고기
			
			if(temp != 0) { // 빈칸이 아니면 갱신
				fishes[temp] = new Fish(cur.x, cur.y, fishes[temp].d);
			}

//			print();
		}
	}
	
	public static boolean isInside(int x, int y) {
		return x>=0 && x<4 && y>=0 && y<4;
	}
	
	public static void print() {
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}