package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;

public class BOJ_5639_이진검색트리 {
	
	static StringBuilder sb =new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		// 루트 노드 생성
		BinaryTree tree = new BinaryTree(Integer.parseInt(br.readLine()));
		
		String s ="";
		while((s = br.readLine()) != null && s.length() != 0 ) {
			tree = tree.addTree(tree, Integer.parseInt(s));
		}
		
//		System.out.println(tree);
//		preorder(tree);
		postorder(tree);
		
		System.out.println(sb);
		
	}
	

	private static void postorder(BinaryTree tree) {
		if(tree.left != null) postorder(tree.left);
		if(tree.right != null) postorder(tree.right);
		sb.append(tree.data + "\n");
	}

	static class BinaryTree{
		int data;
		BinaryTree left;
		BinaryTree right;
		
		public BinaryTree(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
		
		public BinaryTree addTree(BinaryTree tree, int val) {
			BinaryTree curTree = null;
			
			// 트리가 비어있으면
			if( tree == null) return new BinaryTree(val);
			
			else if( tree.data > val) {
				curTree = addTree(tree.left, val);
				tree.left = curTree;
			}
			else if( tree.data < val) {
				curTree = addTree(tree.right, val);
				tree.right = curTree;
			}
			
			return tree;
			
		}

		@Override
		public String toString() {
			return "BinaryTree [data=" + data + ", left=" + left + ", right=" + right + "]";
		}
		
		
		
		
		
	}
	
	static String src ="50\r\n" + 
			"30\r\n" + 
			"24\r\n" + 
			"5\r\n" + 
			"28\r\n" + 
			"45\r\n" + 
			"98\r\n" + 
			"52\r\n" + 
			"60";
}
