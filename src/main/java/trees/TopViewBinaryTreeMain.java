package trees;

import java.util.Stack;

public class TopViewBinaryTreeMain {
	public static void main(String[] args) {
		TopViewBinaryTreeMain topView = new TopViewBinaryTreeMain();
		
		topView.printTopView(topView.initTree());
	}
	
	void printTopView(TreeNode root){
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
		TreeNode(int data){this.data = data;}
	}
}

