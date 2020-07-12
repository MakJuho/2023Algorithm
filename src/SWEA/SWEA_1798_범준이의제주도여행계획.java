package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEA_1798_범준이의제주도여행계획 {
	static StringBuilder sb =new StringBuilder();
	
	static int TC;
	
	static int N; // 지점의 개수
	static int M; // 휴가 일 수
	
	// 관리할 지점들
	static Point airPort;
	static List<Point> hotels;
	static List<Point> tourSpots;
	
	// 각 지점별 비용 그래프
	static int[][] graph;
	
	// 최대 만족도
	static int maxSatis;
	
	// 최대 만족도를 얻는 경로
	static List<Integer> maxSatisPath;
	
	// 탐색해보는 임시 경로
	static Stack<Integer> tempPath;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		TC = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=TC; t++ ) {
			StringTokenizer tokens = new StringTokenizer(br.readLine());
			N = Integer.parseInt(tokens.nextToken()); // 호텔 + 공항 + 관광지 개수
			M = Integer.parseInt(tokens.nextToken()); // 휴가일
			
			graph = new int[N+1][N+1];
			for(int r=1; r<N; r++) {
				tokens = new StringTokenizer(br.readLine());
				for(int c= r+1; c< graph.length; c++) {
					graph[r][c] = graph[c][r] = Integer.parseInt(tokens.nextToken());
				}
			}
			
//			for(int[] row: graph) {
//				System.out.println(Arrays.toString(row));
//			}
			
			// 지점 정보 가져오기
			tourSpots = new ArrayList<>();
			hotels = new ArrayList<>();
			
			for(int n=1; n<=N; n++) {
				tokens = new StringTokenizer(br.readLine());
				String type = tokens.nextToken();
				if(type.equals("H")) {
					hotels.add(new Point(type, n));
				}else if(type.equals("A")) {
					airPort = new Point(type, n);
				}else {
					tourSpots.add(new Point(type, n, tokens.nextToken(), tokens.nextToken()));
				}
			}
			
			// 지점들의 가장 가까운 호텔 찾아주기. - 그래프에서 호텔과 지점사이의 거리 물어보기
			for(Point p : tourSpots) {
				int min = Integer.MAX_VALUE;
				for(Point h : hotels) {
					if(graph[p.idx][h.idx] < min) {
						min = graph[p.idx][h.idx];
						p.nearH = h;
					}
				}
			}
			
			maxSatis = Integer.MIN_VALUE;
			tempPath = new Stack<>();
			
			// 값 구해보기
			sol(0, airPort, 0, 0, new boolean[N+1], 0);
			
			// 결과 출력 - 여전히 만족도가 MIN_VALUE이면 여행 못한 것.
			sb.append("#").append(t).append(" ");
			if(maxSatis == Integer.MIN_VALUE) {
				sb.append(0);
			}
			else {
				sb.append(maxSatis).append(" ");
				for(int i=0; i < maxSatisPath.size(); i++) {
					sb.append(maxSatisPath.get(i)).append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
	
	static void sol(int day, Point start, int satis, int time, boolean[] visited, int visitedCnt) {
		
		// 종료 조건 : 마지막 날이거나 이미 모든 관광지를 방문했다면 끝
		if( day == M || visitedCnt == tourSpots.size()) {
			if(satis > maxSatis) {
				maxSatis = satis;
				// 최대 만족 경로도 전달
				maxSatisPath = new ArrayList<>(tempPath);
			}
			return ;
		}
		
		// 다음에 가볼 지점이 있나?
		boolean canGoNext = false;
		
		for(int p=0; p< tourSpots.size(); p++) {
			Point point = tourSpots.get(p);
			
			// 먼저 퇴로가 있는지 확인해본다. m-1일 이전까지는 호텔로 가고, m-1일은 공항으로 가야한다.
			if(!visited[point.idx]) {
				int tempTime = 0;
				if(day == M-1) {
					tempTime = time + graph[start.idx][point.idx] + point.playTime + graph[point.idx][airPort.idx];
				}else {
					tempTime = time + graph[start.idx][point.idx] + point.playTime + graph[point.idx][point.nearH.idx]; 
				}
				
				// 이 시간이 540 이상이면 이 길은 못간다.
				if(tempTime > 540) {
					continue;
				}
				
				// 갈 수 있다면
				canGoNext = true;
				visited[point.idx] = true;
				tempTime = time + graph[start.idx][point.idx] + point.playTime;
				tempPath.push(point.idx);
				sol(day, point, satis+point.satis, tempTime, visited, visitedCnt+1);
				tempPath.pop();
				visited[point.idx]= false; 
			}
		}
		
		if(!canGoNext) {
			if (day == M-1) {
				tempPath.push(airPort.idx);
				sol(day+1, airPort, satis, 0, visited, visitedCnt);
				tempPath.pop();
			}
			// 그렇지 않다면 호텔로 가는데 가까운 호텔만 가는 것이 아니다. 가까운 호텔의 기준은 관광지 한 번 더 볼 수 있나?
			else {
				for(int h =0; h<hotels.size(); h++) {
					Point hotel = hotels.get(h);
					if(time + graph[start.idx][hotel.idx] <= 540) {
						tempPath.push(hotel.idx);
						sol(day +1, hotel, satis, 0, visited, visitedCnt);
						tempPath.pop();
					}
				}
			}
		}
		
		
	}

	static String src ="1\r\n" + 
			"10 3 \r\n" + 
			"60 90 100 110 240 40 30 60 30\r\n" + 
			"60 120 140 200 120 100 60 60\r\n" + 
			"90 110 170 100 100 30 90\r\n" + 
			"50 110 40 80 90 90\r\n" + 
			"70 30 50 90 90\r\n" + 
			"100 140 180 120\r\n" + 
			"40 90 40\r\n" + 
			"100 20\r\n" + 
			"70\r\n" + 
			"A \r\n" + 
			"P 240 6\r\n" + 
			"P 120 4\r\n" + 
			"P 240 5\r\n" + 
			"P 60 4\r\n" + 
			"P 200 6\r\n" + 
			"P 180 1\r\n" + 
			"P 180 1\r\n" + 
			"H \r\n" + 
			"H";
	
	static class Point{
		String type; // 타입
		int idx, playTime, satis; // 인덱스, 즐기는 시간, 만족도
		Point nearH; // 가까운 호텔 정보

		public Point(String type, int idx) {
			this.type = type;
			this.idx = idx;
		}

		public Point(String type, int idx, String playTime, String satis) {
			super();
			this.type = type;
			this.idx = idx;
			this.playTime = Integer.parseInt(playTime);
			this.satis = Integer.parseInt(satis);
		}



		@Override
		public String toString() {
			return "Point [type=" + type + ", idx=" + idx + ", playTime=" + playTime + ", satis=" + satis + ", nearH="
					+ nearH + "]";
		}
		
		
		
		
	}
	
	
}
