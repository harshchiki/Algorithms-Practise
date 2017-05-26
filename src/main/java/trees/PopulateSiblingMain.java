package trees;
import java.util.Objects;
import java.util.Stack;

public class PopulateSiblingMain {
	public static void main(String[] args) {
		Node root = initializeTree();
		System.out.println("############ BEFORE POINTING ############");
		printInOrder(root);
		pointRightSibling(root);
		System.out.println("############ SIBLINGS POINTED ############");
		printInOrder(root);
	}

	private static void pointRightSibling(Node root){
		if(root == null) return;

		Stack<Node> stack = new Stack<Node>();
		if(root.left != null && root.right != null){
			stack.push(root.right);
			stack.push(root.left);
		}

		while(!stack.isEmpty()){
			Stack<Node> nodes = new Stack<Node>();
			
			Node node = null;
			while(!stack.isEmpty()){
				Node poppedNode = stack.pop();
				if(node != null){
					node.rightSibling = poppedNode;
				}
				node = poppedNode;
				nodes.push(node);
			}
			
			while(!nodes.isEmpty()){
				Node thisNode = nodes.pop();
				pushToStackIfNotNull(stack, thisNode.right);
				pushToStackIfNotNull(stack, thisNode.left);			
			}
		}
	}

	private static void pushToStackIfNotNull(Stack<Node> stack, Node node) {
		if(!Objects.isNull(node)){
			stack.push(node);
		}
	}

	private static Node initializeTree(){
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);

		n1.right = n3;
		n1.left = n2;
		n2.left = n4;
		n3.right = n5;
		
		n5.right = new Node(7);

		return n1;
	}

	private static void printInOrder(Node root){
		if(root == null) return;

		printInOrder(root.left);
		printNode(root);
		printInOrder(root.right);

	}

	private static void printNode(Node node){
		if(node == null) return;
		System.out.println("**********************************************************");
		System.out.print("data = "+node.data);
		if(node.left != null){
			System.out.print("left = "+node.left.data);
		}
		if(node.right != null){
			System.out.print("right = "+node.right.data);
		}
		if(node.rightSibling != null){
			System.out.print("righSibling = "+node.rightSibling.data);
		}
		System.out.println();
		System.out.println("**********************************************************");
	}

	private static class Node{
		Node left,right,rightSibling;
		int data;
		Node(int data){this.data = data;}
	}
}
