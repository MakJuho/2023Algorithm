package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_13168_내일로여행 {
	
	static int N, R, M, K;
	static int [][] Aarr = new int [101][101]; // 그냥 여행
	static int [][] Barr = new int [101][101]; // 내일로 여행
	static HashMap<String, Integer> hm = new HashMap<String, Integer>();
	static int INF = 1000000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		R = Integer.parseInt(tokens.nextToken());
		
		init();
		
		tokens = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			hm.put(tokens.nextToken(), i);
		}
		
		
		M = Integer.parseInt(br.readLine());
		String[] trips = new String[M+1];
		tokens = new StringTokenizer(br.readLine());
		for(int i=1; i<=M; i++) {
			trips[i] = tokens.nextToken();
		}
		
		K = Integer.parseInt(br.readLine());
		for(int i=1; i<=K; i++) {
			tokens = new StringTokenizer(br.readLine());
			String type = tokens.nextToken();
			String start = tokens.nextToken();
			String end = tokens.nextToken();
			
			int cost = Integer.parseInt(tokens.nextToken());
			
			Aarr[hm.get(start)][hm.get(end)] = Integer.min(cost, Aarr[hm.get(start)][hm.get(end)]);
			Aarr[hm.get(end)][hm.get(start)] = Integer.min(cost, Aarr[hm.get(start)][hm.get(end)]);
			
			if(type.equals("S-Train") || type.equals("V-Train")) {
				Barr[hm.get(start)][hm.get(end)] = Integer.min(cost/2, Barr[hm.get(start)][hm.get(end)]);
				Barr[hm.get(end)][hm.get(start)] = Integer.min(cost/2, Barr[hm.get(start)][hm.get(end)]);
			}else if(type.equals("Mugunghwa")||type.equals("ITX-Saemaeul")||type.equals("ITX-Cheongchun")) {
				Barr[hm.get(start)][hm.get(end)] = Barr[hm.get(end)][hm.get(start)] = 0;
			}else {
				Barr[hm.get(start)][hm.get(end)] = Integer.min(cost, Barr[hm.get(start)][hm.get(end)]);
				Barr[hm.get(end)][hm.get(start)] = Integer.min(cost, Barr[hm.get(start)][hm.get(end)]);
			}
		}
		
		//floyd_warshall
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(Aarr[i][k] + Aarr[k][j] < Aarr[i][j]) {
						Aarr[i][j] = Aarr[i][k] + Aarr[k][j];
					}
					if(Barr[i][k] + Barr[k][j] < Barr[i][j]) {
						Barr[i][j] = Barr[i][k] + Barr[k][j];
					}
				}
			}
		}
		
		int Atot=0, Btot = 0;
		
		
		for(int i=1; i<M; i++) {
			Atot += Aarr[hm.get(trips[i])][hm.get(trips[i+1])];
			Btot += Barr[hm.get(trips[i])][hm.get(trips[i+1])];
		}
		Btot += R; // 내일로 경비 추가
		
		if(Atot > Btot) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}
		
	}
	

	private static void init() {
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(i == j) {
					Aarr[i][j] = Barr[i][j] = 0;
				}else {
					Aarr[i][j] = Barr[i][j] = INF;
				}
			}
		}
	}

	static String src ="5 50000\r\n" + 
			"Seoul Cheonan Daejeon Daegu Busan\r\n" + 
			"3\r\n" + 
			"Seoul Busan Seoul\r\n" + 
			"5\r\n" + 
			"ITX-Saemaeul Seoul Cheonan 7000\r\n" + 
			"ITX-Saemaeul Cheonan Daejeon 4000\r\n" + 
			"ITX-Saemaeul Daejeon Daegu 10000\r\n" + 
			"ITX-Saemaeul Daegu Busan 7000\r\n" + 
			"KTX Seoul Busan 24999";
}
