package Codility;

public class test {

	public static void main(String[] args) {
		int v = 32;
		
		String a = Integer.toBinaryString(v);
		
		int max = 0;
		int cnt = 0;
		int oneCnt = 0;
		for(int i=0; i<a.length(); i++) {
			if(a.charAt(i) == '0') {
				cnt ++;
			}else if(a.charAt(i) == '1') {
				cnt =0;
				oneCnt++;
			}
			
			if(max < cnt) {
				max = cnt;
			}
			
		}
		if(oneCnt <2) max =0;
		
		System.out.println(max);
		
	}
}
