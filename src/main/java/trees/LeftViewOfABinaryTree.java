package trees;

import java.util.LinkedList;
import java.util.List;

import heap.MaxHeapImplementation;

/*
 * Problem: Left view of a binary tree
 * Time: O(n)
 * Space: O(1)
 * 
 * With the approach using extra space, level order traversal 
 * could be used to print the first node of each level
 */
public class LeftViewOfABinaryTree {
	int maxDepthExplored = -1;
	List<TreeNode> leftView = new LinkedList<>();
	
	void populateLeftView(TreeNode root, int height) {
		if(root == null) return;
		
		if(maxDepthExplored < height) {
			maxDepthExplored++;
			leftView.add(root);
		}
		
		populateLeftView(root.left, height+1);
		populateLeftView(root.right, height+1);
	}
	
	void print() {
		leftView.stream().forEach(node -> System.out.print(node.data+" "));
	}
	
	public static void main(String[] args) {
		LeftViewOfABinaryTree l = new LeftViewOfABinaryTree();
		l.populateLeftView(TreeUtils.getTree(), 0);
		System.out.println("Printing inorder");
		TreeUtils.printInOrder(TreeUtils.getTree());
		System.out.println();
		System.out.println("Printing left view");
		l.print();
		System.out.println();
		// maxDepthExplored holds the value of the length of the longest path in a tree
		System.out.println("Length of the longest path "+ l.maxDepthExplored);
	}
}
