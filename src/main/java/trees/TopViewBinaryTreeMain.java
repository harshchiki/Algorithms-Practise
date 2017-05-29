package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TopViewBinaryTreeMain {
	public static void main(String[] args) {
		TopViewBinaryTreeMain topView = new TopViewBinaryTreeMain();

		TreeNode initTree = topView.initTree();
		System.out.println("Inorder");
		topView.printInOrder(initTree);
//		topView.printTopViewLimited(topView.initTree());
		System.out.println();
		System.out.println("Top View");
		topView.printTopView(initTree);
	}

	void printInOrder(TreeNode root){
		if(root == null){ 
			return;
		}
		
		printInOrder(root.left);
		System.out.print(root.data +" ");
		printInOrder(root.right);

	}


	void printTopView(TreeNode root){
		if(null == root){
			return ;
		}

		int leftMax = 0, rightMax = 0;

		Queue<TreeNode> thisLevel = new LinkedList<TreeNode>();
		thisLevel.add(root);

		while(!thisLevel.isEmpty()){

			Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();

			while(!thisLevel.isEmpty()){
				TreeNode polledNode = thisLevel.poll();

				if(polledNode.x <= leftMax){
					leftMax = polledNode.x;
					System.out.print(polledNode.data+" ");
				}else if(polledNode.x >= rightMax){
					rightMax = polledNode.x;
					System.out.print(polledNode.data+" ");
				}

				if(polledNode.left!= null){
					polledNode.left.x = polledNode.x-1;
					nextLevel.add(polledNode.left);
				}

				if(polledNode.right!= null){
					polledNode.right.x = polledNode.x+1;
					nextLevel.add(polledNode.right);
				}
			}
			thisLevel = nextLevel;
		}
	}


	/*
	 * this approach covers very limited cases.
	 */
	void printTopViewLimited(TreeNode root){
		if(root == null) return;

		Stack<TreeNode> stack = new Stack<TreeNode>();

		TreeNode node = root;

		while(node != null){
			stack.push(node);
			node = node.left;
		}

		while(!stack.isEmpty()){
			System.out.print(stack.pop().data);
		}
		if(root.right == null) return;

		node = root.right;

		while(node != null){
			System.out.print(node.data);
			node = node.right;
		}

	}

	public TreeNode initTree(){
		TreeNode root = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);

		root.left = n2;
		root.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;

		return root;
	}
	static class TreeNode{
		int data; TreeNode left, right;
		int x = 0;
		TreeNode(int data){this.data = data;}
	}
}

