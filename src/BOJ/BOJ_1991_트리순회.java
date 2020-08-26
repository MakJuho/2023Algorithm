package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_1991_트리순회 {
	
	static Map<String, List<String>> map = new HashMap<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer tokens = null;
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			String[] lines = br.readLine().split(" ");
			
			List<String> list = new ArrayList<>();
			list.add(lines[1]);
			list.add(lines[2]);
			
			map.put(lines[0], list);
			
		}
		
		preorder("A");
		System.out.println();
		inorder("A");
		System.out.println();
		postorder("A");
	}
	

	private static void preorder(String v) {
		if(v.equals(".")) {
			return ;
		}
		
		System.out.print(v);
		preorder(map.get(v).get(0));
		preorder(map.get(v).get(1));
		
	}
	private static void inorder(String v) {
		if(v.equals(".")) {
			return ;
		}
		inorder(map.get(v).get(0));
		System.out.print(v);
		inorder(map.get(v).get(1));
	}
	private static void postorder(String v) {
		if(v.equals(".")) {
			return ;
		}
		postorder(map.get(v).get(0));
		postorder(map.get(v).get(1));
		System.out.print(v);
	}


	static String src = "7\r\n" + 
			"A B C\r\n" + 
			"B D .\r\n" + 
			"C E F\r\n" + 
			"E . .\r\n" + 
			"F . G\r\n" + 
			"D . .\r\n" + 
			"G . .";
	
}
