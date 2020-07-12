package algo;

public class BinaryTree {
	public static void main(String[] args) {
		Tree tree = new Tree();
		
		tree.addNode(24);
		tree.addNode(19);
		tree.addNode(2);
		tree.addNode(15);
		tree.addNode(7);
		tree.addNode(6);
		tree.addNode(9);
		tree.addNode(11);
		
		System.out.println(tree);
		
		System.out.println("preorder:");
		tree.preOrder(tree.root);
		System.out.println();
		System.out.println("inorder:");
		tree.inOrder(tree.root);
		System.out.println();
		System.out.println("postorder:");
		tree.postOrder(tree.root);
		
	}
	static class Node{
		int value;
		Node left;
		Node right;
		
		
		@Override
		public String toString() {
			return "Node [value=" + value + ", left=" + left + ", right=" + right + "]";
		}
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public Node getLeft() {
			return left;
		}
		public void setLeft(Node left) {
			this.left = left;
		}
		public Node getRight() {
			return right;
		}
		public void setRight(Node right) {
			this.right = right;
		}
	}
	
	static class Tree{
		Node root;
		
		
		
		@Override
		public String toString() {
			return "Tree [root=" + root + "]";
		}

		public void addNode(int value) {
			if(root == null) {
				Node node = new Node();
				node.setValue(value);
				root = node; // root에 값이 없으면 root에 넣는다.
			}else {
				// root가 존재할 경우
				addNode(value, root);
			}
		}
		
		public void addNode(int value, Node root) {
			if(value <= root.getValue()) {
				if(root.getLeft() == null) {
					Node node = new Node();
					node.setValue(value);
					root.setLeft(node);
				}else {
					addNode(value,root.getLeft());
				}
			}else {
				if(root.getRight() == null) {
					Node node = new Node();
					node.setValue(value);
					root.setRight(node);
				}else {
					addNode(value,root.getRight());
				}
			}
			
		}
		
		public void preOrder(Node root) {
			if (root == null)

				return;

				

			System.out.print(root.getValue() + " ");

		     preOrder(root.getLeft());

		     preOrder(root.getRight());



		}
		public void inOrder(Node root) {
			if (root == null)

				return;

				

			inOrder(root.getLeft());

		     System.out.print(root.getValue() + " ");

		     inOrder(root.getRight());



			
		}
		public void postOrder(Node root) {
			if (root == null)
				return;
			postOrder(root.getLeft());
		     postOrder(root.getRight());
		     System.out.print(root.getValue() + " ");
		}
		
		
	}
	
}
