package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BOJ_16890_창업 {
	
	static int MN = 300030;
	static char[] Gusa = new char[MN];
	static char[] Cube = new char[MN];
	static char[] ans;
	static ArrayList<Character> gList = new ArrayList<>();
	static ArrayList<Character> cList = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
	
		Gusa = br.readLine().toCharArray();
		Cube = br.readLine().toCharArray();
		
		int len = Gusa.length;
		ans = new char[len];
		for(int i=0; i<len; i++) {
			gList.add(Gusa[i]);
			cList.add(Cube[i]);
		}

		Collections.sort(gList);
		Collections.sort(cList);

		int turn = 0;
		int gLeft = 0, gRight= (len + 1)/2-1;
		int cLeft = (len + 1)/2, cRight= len - 1;
		int aLeft = 0, aRight = len -1;

		while( turn < len ) {
			// cubelover
			if( turn % 2 ==1) {
				if(gList.get(gLeft) < cList.get(cRight)) {
					ans[aLeft] = cList.get(cRight);
					aLeft ++;
					cRight --;
				}else {
					ans[aRight] = cList.get(cLeft);
					aRight--;
					cLeft++;
				}
			}else {
				// koosaga
				if(gList.get(gLeft) < cList.get(cRight)) {
					ans[aLeft] = gList.get(gLeft);
					aLeft++;
					gLeft++;
				}else {
					ans[aRight] = gList.get(gRight);
					aRight--;
					gRight--;
				}
			}
			turn ++;
		}
		
		for(int i=0; i<ans.length; i++) {
			System.out.print(ans[i]);
		}
		
		
		
		
	}
	
	static String src = "koooosaga\r\n" + 
			"cubelover";
}
