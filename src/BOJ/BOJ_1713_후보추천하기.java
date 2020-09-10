package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_1713_후보추천하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[] arr = new int[M];
		
		ArrayList<Pair> list = new ArrayList<>();
		
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		
		for(int i=0; i<M; i++) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		
		for(int i=0; i<M; i++) {
			loop:
			if(list.size() == N) {
				
				// 이미 사진을 가지고 있다면 +1
				for(int j=0; j<list.size(); j++) {
					if(list.get(j).num == arr[i]) {
						list.get(j).cnt++;
						break loop;
					}
				}
				
				int min = Integer.MAX_VALUE;
				// 추천 수가 가장 작은 사진이 둘 이상일 경우, 가장 오래된 사진 삭제
				int rmIdx = -1;
				
				for(int j=0; j<list.size(); j++) {
					if(min > list.get(j).cnt) {
						min = list.get(j).cnt;
						rmIdx = j;
					}
				}
				list.remove(rmIdx);
				list.add(new Pair(arr[i], 1));
				
				
				
			}else {
				
				boolean isIn = false;
				// 이미 사진을 가지고 있다면 +1
				for(int j=0; j<list.size(); j++) {
					if(list.get(j).num == arr[i]) {
						list.get(j).cnt++;
						isIn = true;
						break;
					}
				}
				if(!isIn) list.add(new Pair(arr[i], 1));
				
			}			
			
			
			
		
		}
		list.sort(new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				return o1.num - o2.num;
			}
		});
		
		for(Pair p : list) {
			System.out.print(p.num+" ");
		}
		
	}
	
	static class Pair{
	
		int num;
		int cnt;
		
		public Pair(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Pair [num=" + num + ", cnt=" + cnt + "]";
		}
		
		
		
	}
	static String src = "3\r\n" + 
			"9\r\n" + 
			"2 1 4 3 5 6 2 7 2";
}
