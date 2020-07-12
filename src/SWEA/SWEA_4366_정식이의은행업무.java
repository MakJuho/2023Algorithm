package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;

public class SWEA_4366_정식이의은행업무 {

	static LinkedList<String> str_2 = new LinkedList<>();
	static LinkedList<String> str_3 = new LinkedList<>();
	static LinkedList<Integer> int_2 = new LinkedList<>();
	static LinkedList<Integer> int_3 = new LinkedList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder copied;
		for(int t=1; t<=T; t++) {
			String str2 = br.readLine();
			String str3 = br.readLine();
			
			for(int i=0; i<str2.length(); i++){
				copied = new StringBuilder(str2);
				if(str2.charAt(i)=='1') {
					copied.setCharAt(i, '0');
					str_2.add(copied.toString());
				}else if(str2.charAt(i)=='0') {
					copied.setCharAt(i, '1');
					str_2.add(copied.toString());
				}
			}
			
			for(int i=0; i<str3.length(); i++) {
				copied = new StringBuilder(str3);
				if(str3.charAt(i)=='2') {
					copied.setCharAt(i, '1');
					str_3.add(copied.toString());
					copied.setCharAt(i, '0');
					str_3.add(copied.toString());
				}else if(str3.charAt(i)=='1') {
					copied.setCharAt(i, '2');
					str_3.add(copied.toString());
					copied.setCharAt(i, '0');
					str_3.add(copied.toString());
				}else if(str3.charAt(i)=='0') {
					copied.setCharAt(i, '2');
					str_3.add(copied.toString());
					copied.setCharAt(i, '1');
					str_3.add(copied.toString());
				}
			}

			
			int rlt=0;
			for(int i=0; i<str_2.size(); i++) {
				for(int j=0; j<str_3.size(); j++) {
					if(Integer.parseInt(str_2.get(i),2) == Integer.parseInt(str_3.get(j),3)) {
						rlt=Integer.parseInt(str_2.get(i),2);
						break;
					}
				}
			}
			
			System.out.println("#"+t+" "+rlt);
			
			
			
			
			
		}
		
		return;
		
		
	}
	
	
	static String src =
			"2\r\n" + 
			"1010\r\n" + 
			"212\r\n"+
			"1010\r\n" + 
			"212";
}
