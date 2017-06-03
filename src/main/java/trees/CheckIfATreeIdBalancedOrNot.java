package trees;

public class CheckIfATreeIdBalancedOrNot {
	public static void main(String[] args) {
		BalTreeNode r1 = new BalTreeNode(1);
		BalTreeNode r2 = new BalTreeNode(2);
		BalTreeNode r3 = new BalTreeNode(3);
		BalTreeNode r4 = new BalTreeNode(4);
		BalTreeNode r5 = new BalTreeNode(5);
		BalTreeNode r6 = new BalTreeNode(6);
		BalTreeNode r7 = new BalTreeNode(7);
		
		
		r1.left = r2;
		r1.right = r3;
		
		r2.left = r4;
		r2.right = r5;
		
		r5.left = r6;
		
		r6.right = r7;
		
		checkIfTreeIsBalanced(r1);
		
		
	}
	
	static int checkIfTreeIsBalanced(BalTreeNode root){
		if(root == null){
			return -1;
		}
		
		int leftTreeDepth = checkIfTreeIsBalanced(root.left);
		int rightTreeDepth = checkIfTreeIsBalanced(root.right);
		
		int depthOfThisNode = leftTreeDepth > rightTreeDepth ?  leftTreeDepth+1 : rightTreeDepth + 1;
		
		if(depthOfThisNode > 1){
			System.out.println(root.data +" is not balanced, its depth = "+depthOfThisNode);
		}
		
		return depthOfThisNode;
	}
	
	static class BalTreeNode{
		int data;
		BalTreeNode left, right;
		int height;
		public BalTreeNode(int data) {
			this.data = data;
		}
	}
}
