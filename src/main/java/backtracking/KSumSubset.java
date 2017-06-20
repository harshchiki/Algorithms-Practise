package backtracking;

import java.util.Stack;

public class KSumSubset {

	public static void main(String[] args) {
		new KSumSubset().init();
	}
	void init(){
		int[] a = new int[]{1,2,3};
		int k = 3;
		Node root = new Node();
		root.sum = 0;
		root.index = 0;
		root.parent = null;
		
		buildTree(a, root, 0, k);
		System.out.println("Built tree");
	}
	
	void buildTree(int[] a, Node root, int index, int k){
		if(index == a.length){
			return;
		}
		Node leftNode = new Node();
		leftNode.sum = root.sum;
		leftNode.parent = root;
		leftNode.index = root.index + 1;
		root.left = leftNode;
		buildTree(a, root.left, index+1, k);
		
		Node rightNode = new Node();
		rightNode.sum = root.sum + a[root.index];
		if((root.sum+a[root.index]) == k){
			System.out.println("Found at "+root.index);
			printTraceForSumSubset(root, a);
		}
		rightNode.parent = root;
		rightNode.index = root.index + 1;
		root.right = rightNode;
		buildTree(a, root.right, index+1, k);
	}
	
	void printTraceForSumSubset(Node root, int[] a){
		Stack<Node> stack = new Stack<>();
		stack.add(root);
		
		Node node = root.parent;
		while(node != null && node.sum>0){
			stack.push(node);
			node = node.parent;
		}
		
		while(!stack.isEmpty()){
			System.out.print(a[stack.pop().index]+" ");
		}
		System.out.println("Printed");
	}
	
	class Node{
		int sum = 0; // sum so far, at this node
		int index = -1; // at this node, left is a[index] is not chosen, and right is when a[index] is chosen
		Node parent, left, right;
	}
}
