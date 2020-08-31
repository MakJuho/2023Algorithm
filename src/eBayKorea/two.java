package eBayKorea;

public class two {
	public static void main(String[] args) {
		int num = 8;
		int[] cards = {1, 4, 5};
		
		int ans = Integer.MAX_VALUE;
		int cnt = 0;
		int endIdx = cards.length-1;
		int tmp = num;
		int level = cards.length-1;
		
		while(true) {
			
			// 가장 작은 값보다 남은 값이 작으면 초기화
			if(tmp < cards[0]) {
				tmp = num;
				cnt = 0 ;
				endIdx = level - 1;
			}else if(tmp < cards[endIdx]) {
				endIdx--;
			}

			tmp = tmp - cards[endIdx];
			cnt ++;
			
			
			// cnt의 값을 반환
			if( tmp == 0 ) {
				ans = (ans > cnt) ? cnt : ans;
				System.out.println(ans);
			}
			
			
		}
			
		
	}
}
