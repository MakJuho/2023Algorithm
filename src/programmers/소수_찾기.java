package programmers;
import java.util.Arrays;
import java.util.LinkedList;

public class 소수_찾기 {
	static int tot =0;
	static boolean[] ans = new boolean[1000000];
	static int[] arr;
	public static void main(String[] args) {
		
		
		String numbers="17";

		arr = new int[numbers.length()];
		
		
		
		for(int i=0; i<numbers.length(); i++) {
			arr[i] = numbers.charAt(i)-'0';
		}
		
		
		
		for(int cnt=1; cnt<=numbers.length(); cnt++) {
			// 순열
			LinkedList<Integer> list = new LinkedList<>();
			boolean[] check = new boolean[numbers.length()];
			Permutation(list, arr, check, cnt);
			
		}
		System.out.println(tot);
		
	}

	private static void Permutation(LinkedList<Integer> list, int[] arr, boolean[] check, int idx) {
		if(list.size() == idx) {
			
//			System.out.println(list);
			
			String val="";
			for(int i: list) {
//				System.out.print(arr[i]);
				val += arr[i];
			}
			System.out.println(val);
			if(!ans[Integer.parseInt(val)]) {
				
				
				if(isPrimary(val)) {
					tot++;
				}
			}
			
			ans[Integer.parseInt(val)] = true;
//			System.out.println(val);
			
			
			return ;
		}
		
		for(int i=0; i<arr.length; i++) {
			if(!check[i]) {
				check[i] = true;
				list.add(i);
				Permutation(list, arr, check, idx);
				check[i] = false;
				list.removeLast();
			}	
		}
		
		
	}

	private static boolean isPrimary(String val) {
		
		int target = Integer.parseInt(val);
		
		if(target == 1 || target == 0) return false;
		
		if(target == 2 ) return true;
		
		for(int i=2; i*i<=target; i++) {
			for(int j=i*i; j<=target; j=j+i) {
				if(target %j == 0) {
					return false;
				}	
			}
		}
		return true;
		
		
		
	}
	
	
	
}
