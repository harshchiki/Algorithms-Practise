package trees;

import java.util.Stack;

public class IterativePreOrderTraversalOfATree {
	public static void main(String[] args) {
		TreeNode root = TreeUtils.getTree();
		System.out.println("Inorder");
		TreeUtils.printInOrder(root);
		System.out.println();
		System.out.println("Iterative Inorder");
		iterativePreOrder(root);
	}
	
	static void iterativePreOrder(TreeNode root){
		if(null == root){
			return;
		}
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		stack.push(root);
		
		while(!stack.isEmpty()){
			TreeNode poppedNode = stack.pop();
			System.out.print(poppedNode.data +", ");
			if(poppedNode.right != null){
				stack.push(poppedNode.right);
			}
			
			if(poppedNode.left != null){
				stack.push(poppedNode.left);
			}
		}
	}
}
