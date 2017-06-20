package backtracking;

public class KSumSubset {

	public static void main(String[] args) {
		new KSumSubset().init();
	}
	void init(){
		int[] a = new int[]{1,2,3};
		int n = 3;
		Node root = new Node();
		root.sum = 0;
		root.index = 0;
		root.parent = null;
		
		buildTree(a, root, 0);
		System.out.println("Built tree");
	}
	
	void buildTree(int[] a, Node root, int index){
		if(index == a.length){
			return;
		}
		Node leftNode = new Node();
		leftNode.sum = root.sum;
		leftNode.parent = root;
		leftNode.index = root.index + 1;
		root.left = leftNode;
		buildTree(a, root.left, index+1);
		
		Node rightNode = new Node();
		rightNode.sum = root.sum + a[root.index];
		rightNode.parent = root;
		rightNode.index = root.index + 1;
		root.right = rightNode;
		buildTree(a, root.right, index+1);
	}
	
	class Node{
		int sum = 0; // sum so far, at this node
		int index = -1; // at this node, left is a[index] is not chosen, and right is when a[index] is chosen
		Node parent, left, right;
	}
}
