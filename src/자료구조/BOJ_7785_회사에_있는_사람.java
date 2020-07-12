package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BOJ_7785_회사에_있는_사람 {
	
	static Map<String, Boolean> log = new TreeMap<>(Collections.reverseOrder());
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i=0; i<t; i++) {
			StringTokenizer tokens = new StringTokenizer(br.readLine());
			String name = tokens.nextToken();
			String IO = tokens.nextToken();
			
			if(IO.equals("enter")) {
				log.put(name,true);
			}
			else if(IO.equals("leave")) {
				log.put(name,false);
			}
		}
		
		Iterator<String> iterator = log.keySet().iterator();
		while ( iterator.hasNext()) {
			String name = iterator.next();
			boolean inout = log.get(name);
			if(inout) System.out.println(name);
		}

	}
	
	private static String src = "4\r\n" + 
			"Baha enter\r\n" + 
			"Askar enter\r\n" + 
			"Baha leave\r\n" + 
			"Artem enter";
}
