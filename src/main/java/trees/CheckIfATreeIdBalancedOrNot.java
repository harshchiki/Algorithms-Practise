package trees;

public class CheckIfATreeIdBalancedOrNot {
	public static void main(String[] args) {
		TreeNode r1 = new TreeNode(1);
		TreeNode r2 = new TreeNode(2);
		TreeNode r3 = new TreeNode(3);
		TreeNode r4 = new TreeNode(4);
		TreeNode r5 = new TreeNode(5);
		TreeNode r6 = new TreeNode(6);
		TreeNode r7 = new TreeNode(7);
		TreeNode r8 = new TreeNode(8);
		
		r1.left = r2;
		r1.right = r3;
		
		r2.left = r4;
		r2.right = r5;
		
		r5.left = r6;
		r4.right = r8;
		
		
		TreeUtils.printInOrder(r1);
		System.out.println();
		checkIfTreeIsBalanced(r1);
		
		
	}
	
	static int checkIfTreeIsBalanced(TreeNode root){
		if(root == null){
			return -1;
		}
		
		int leftTreeDepth = checkIfTreeIsBalanced(root.left);
		int rightTreeDepth = checkIfTreeIsBalanced(root.right);
		
		int depthOfThisNode = leftTreeDepth > rightTreeDepth ?  leftTreeDepth+1 : rightTreeDepth + 1;
		
		if(depthOfThisNode > 1){
			System.out.println(root.data +" is not balanced, its delta = "+depthOfThisNode
					+" left depth = "+leftTreeDepth + " right depth = "+ rightTreeDepth);
		}
		
		return depthOfThisNode;
	}
	
//	static class TreeNode{
//		int data;
//		TreeNode left, right;
////		int height;
//		public TreeNode(int data) {
//			this.data = data;
//		}
//	}
}
