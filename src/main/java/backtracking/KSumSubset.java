package backtracking;

import java.util.Stack;

/*
 * http://www.geeksforgeeks.org/backttracking-set-4-subset-sum/
 * 
 * THIS ALGO IS WRONG. Needs to be corrected.
 */
public class KSumSubset {

	public static void main(String[] args) {
		new KSumSubset().init();
	}
	
	void init(){
		int[] a = new int[]{2,3,4,5};
		int k = 7;
		Node root = new Node();
		root.sum = 0;
		root.index = 0;
		root.parent = null;
		
//		buildTree1(a, 0, root, k);
		
		buildTree(a, root, 0, k);
//		System.out.println("Built tree");
	}
	
	
	void buildTree1(int[] a, int index, Node parent, int k) {
		if(index == a.length-1) {
			return;
		}
		
		Node leftNode = new Node(parent.sum, index, parent);
		parent.left = leftNode;
		buildTree1(a, index+1, leftNode, k);
		
		Node rightNode = new Node(parent.sum + a[index], index, parent);
		parent.right = rightNode;
		if((parent.sum + a[index]) == k) {
			printPath(parent, a);
		}
		buildTree1(a, index+1, rightNode, k);
	}
	
	void printPath(Node node, int[] a) {
		Stack<Node> s = new Stack<>();
		Node tmp = node;
		
		while(tmp != null) {
			s.push(tmp);
			tmp = tmp.parent;
		}
		
		System.out.println();
		while(!s.isEmpty()) {
			System.out.print(a[s.pop().index] + " ");
		}
		System.out.println();
	}
	
	// starts with a, root (sum: 0, index: 0, parent: null), 0, given k
	void buildTree(int[] a, Node root, int index, int k){
		if(index == a.length){
			return;
		}
		
		// at every stage, we have a choice to choose then element, or not choose that element
		
		// left node is for when I do not choose a[index]
		Node leftNode = new Node();
		leftNode.sum = root.sum; // sum remains the same
		leftNode.parent = root; // parent changes to root
		leftNode.index = root.index + 1; // index certainly increments (doesn't vary, whether or not we have chosen the element)
		root.left = leftNode; // attaching leftNode to the node passed
		buildTree(a, root.left, index+1, k); // and go on building the left tree
		
		// right node is when I choose a[index]
		Node rightNode = new Node();
		rightNode.sum = root.sum + a[index]; // since we have chose this element, we add a[index] to the sum. a[index] is always == a[index]
		if((root.sum+a[root.index]) == k){
//			System.out.println("Found at "+root.index);
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
		System.out.println();
		System.out.println("Printed");
	}
	
	class Node{
		int sum = 0; // sum so far, at this node (as we go down the tree)
		int index = -1; // at this node, left is a[index] is not chosen, and right is when a[index] is chosen
		Node parent, left, right;
		Node(){}
		Node(int sum, int index, Node parent){
			this.sum = sum;
			this.index = index;
			this.parent = parent;
		}
	}
}
