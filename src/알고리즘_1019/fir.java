package 알고리즘_1019;

import java.util.LinkedList;

public class fir {

	// 첫 번째 숫자부터 뒤로 갈수록 차이가 가장 큰 수를 찾기.
	// 2번 반복하면 됨.
	static int max = 0;
	static int ret = 0;
	public static void main(String[] args) {
		int[] prices = {1, 10, 5, 11, 7};

		LinkedList<Integer> list = new LinkedList<>();
		LinkedList<Integer> idxList = new LinkedList<>();
		
		Combination(list, idxList, prices,2,0);
		
		System.out.println(max);
		
	}
	
	private static void Combination(LinkedList<Integer> list, LinkedList<Integer> idxList, int[] prices, int r, int idx) {
		if(r == 0) {
//			System.out.println(idxList);
//			System.out.println(list);

			// tmpPrices를 만든다.
			
			int[] tmpPrices = new int[prices.length];
			
			for(int i=0; i<prices.length; i++) {
				tmpPrices[i] = prices[i];
			}
			
			tmpPrices[idxList.get(0)] = 0;
			tmpPrices[idxList.get(1)] = 0;
			
			int a = list.get(0);
			int b = list.get(1);
			
			
			if(a < b) {
				
				ret = b-a;
				
				if(max < ret) {
					max = ret;
				}
				
				LinkedList<Integer> list2 = new LinkedList<>();
				Combination2(list2, tmpPrices, 2, 0);
				
				
			}
			
			return ;
		}
		else if(idx == prices.length) return;
		
		idxList.add(idx);
		list.add(prices[idx]);
		Combination(list, idxList, prices, r-1, idx+1);
		idxList.removeLast();
		list.removeLast();
		Combination(list, idxList, prices, r, idx+1);
		
		
	}

	private static void Combination2(LinkedList<Integer> list2, int[] tmpPrices, int r, int idx) {
		if( r == 0 ) {
			if(list2.get(0) == 0 || list2.get(1) == 0 ) return;
			
			int a = list2.get(0);
			int b = list2.get(1);
			
			if(a < b) {
				ret+= b-a;
				
				if(max < ret) {
					max = ret;
				}
				ret -= b-a;
			}
			
			
			return;
		}
		if ( idx == tmpPrices.length) return;
		
		list2.add(tmpPrices[idx]);
		Combination2(list2, tmpPrices, r-1, idx+1);
		list2.removeLast();
		Combination2(list2, tmpPrices, r, idx+1);
		
	}
	
	
	
}
