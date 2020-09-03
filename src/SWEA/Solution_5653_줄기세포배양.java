
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

// SWEA 5653줄기세포배양
public class Solution_5653_줄기세포배양 {
	static int N, M, K; // 배열의 기본사이즈, 세포의 생명력
	static int res;
	static int[][]  map;
	
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
//	리스트에 리스트 사용
	static List<ArrayList<Data>> list = new ArrayList<>() ;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
//		
		
		for(int t= 1; t <= TC ; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt();
//			세포의 생명력이 먼저 퍼져야 한다. 이것을 관리하기가 필요하다
//			그러면  생명력별로 세포를 모아놓았다가, 생명력이 높은것을 먼저 퍼트리면(BFS) 되지 않을까?
//			생명력별 세포들 모아놓을 리스트 만들기
//			생명력의 최갯수만큼만 리스트가 필요함
			list.clear();
			for(int i = 0; i < 10; i++) {
				list.add(new ArrayList<Data>());
			}
			
//			세포가 퍼질 공간까지 기억장소 확보
			map = new int[700][700]; //최대 사이즈 잡기
			for(int i = 350; i < N + 350; i++) {
				for(int j = 350; j < M + 350; j++) {
					map[i][j] = sc.nextInt(); // map에 데이터 저장
					if(map[i][j] != 0) { //읽어 들이면서 바이러스는 별도의 리스트에 저장하기
//						배열 첨자 보정
						list.get(map[i][j]-1).add(new Data(j,i,map[i][j],map[i][j],K,false));
					}
				}
			}
//			처리
//			for(int i = 350; i < N + 350; i++) {
//				for(int j = 350; j < M + 350; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println();
//			}
			
			bfs();
//			System.out.println("================================");
//			for(int i = 350-K; i < N + 350 + K; i++) {
//				for(int j = 350-K; j < M + 350 + K; j++) {
//					System.out.print(map[i][j] + "\t");
//				}
//				System.out.println();
//			}
			res = 0;
//			세포수 세기
			for(int i = 0; i < 700; i++ ) {
				for(int j = 0 ; j < 700; j++) {
//					세포가 퍼져있지 않거나, 세포가 죽어 있는 자리를 빼고 계산하기
					if(map[i][j] != 0 && map[i][j]!= -1) {
						res++;
					}
				}
			}
			System.out.println("#" + t + " " + res);
		}
		
	}
	
	private static void bfs() {
//		큐에 생명력이 높은것 부터 넣기
		Queue<Data>  q = new LinkedList<Data>();
//		Data를 가지고 있는 리스트에서 생명력이 높은것부터 퍼트리기 위해 큐에 삽입
		for(int i = 9; i >= 0; i--) {
			if(list.get(i).size() != 0) { //생명력이 존재하는것 들만
				for(Data d : list.get(i)) {
					q.offer(d);
				}
			}
		}
//		세포 퍼트리기
//		System.out.println(q.size());
		Data d;
		while(!q.isEmpty()) {
			d = q.poll();
//			죽은 세포면 -1 값을 변경하고 이 세포는 무시하기
			if(d.life == 0 && d.flag) {
				map[d.y][d.x] = -1;
				continue;
			}
			
			if(d.time == 0) {// 배양시간이 다 끝나면 무시
				continue;
			}
			if(d.life != 0 ) { // 라이프가 살아 있으면 라이프를 1 감소하고 다시 큐에 삽입 배양은 하지 않음
				q.offer(new Data(d.x, d.y, d.X, d.life -1, d.time-1, d.flag));
				continue;
			}
//			라이프가 0이 되면서 비활성화가 끝남 활성화가 됨 다음에 큐에서 배포가 되어야 함
			q.offer(new Data(d.x, d.y, d.X, d.X, d.time, true));
//			현재 세포는 세포 분양을 4방향으로 해야 함
			for(int i = 0 ; i< 4 ; i++) {
				int nx = d.x + dx[i];
				int ny = d.y + dy[i];
//				범위 체크
				if(nx < 0 || nx >= 700 || ny < 0 || ny >= 700) {
					continue;
				}
//				다른 세포가 없을때만 배포됨
				if(map[ny][nx] == 0) {
					map[ny][nx] = d.X;  // 새로 배양된 세포의  생명력 입력
					q.offer(new Data(nx, ny, d.X, d.X, d.time-1, false));
				}
			}
		}
		
	}

	static class Data { // 세포정보 저장 클래스
		int x;
		int y;
        int X;//X줄기세포의 생명력
        
        int life; //활성화 시간 즉 살아있는 시간으로 감소할 변수 저장
        int time; //배양시간 (시간이 지나면감소함)
        boolean flag; // 화성화 상태(비활성화 : false, 활성화 : true;
		public Data(int x, int y, int X, int life, int time, boolean flag) {
			super();
			this.x = x;
			this.y = y;
			this.X = X;
			this.life = life;
			this.time = time;
			this.flag = flag;
		}
        
        
	}

}
