package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

class Node implements Comparable <Node>{
	int start;
	int end;
	
	public Node(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	@Override
	public String toString() {
		return "Node[ start : " + start + ", end : " + end + " ] ";
	}
	
	@Override
	public int compareTo(Node o) {
		if(o.start < this.start) {
			return -1;
		}else if(o.start == this.start) {
			return 0;
		}
		
		return 1;
	}
	
	
}

public class sort_try1 {
	public static void main(String[] args) {
		
		int[] arr = {1,2,5,1,2,4};
		
		ArrayList<Node> list = new ArrayList<>();
		
		Node node = new Node(1, 3);
		list.add(node);
		
		node = new Node(2, 1);
		list.add(node);
		
		Collections.sort(list);
		
		System.out.println(list);
		
	}
}
