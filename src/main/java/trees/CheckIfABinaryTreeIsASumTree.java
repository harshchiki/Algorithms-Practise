package trees;

/*
 * http://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-sumtree/
 */
public class CheckIfABinaryTreeIsASumTree {
	public static void main(String[] args) {
		CheckIfABinaryTreeIsASumTree o = new CheckIfABinaryTreeIsASumTree();
		TreeUtils.printInOrder(TreeUtils.getTree());
		System.out.println(o.isSumTree(TreeUtils.getTree()).isSum);
	}

	Tuple isSumTree(TreeNode root) {
		if(root == null) {
			return new Tuple(false, 0);
		}
		
		Tuple left = isSumTree(root.left);
		Tuple right = isSumTree(root.right);
		
		if(!left.isSum || !right.isSum) {
			return new Tuple(false, 0);
		}else {
			if((left.sum+right.sum) == root.data) {
				return new Tuple(true, left.sum+right.sum+root.data);
			}else {
				return new Tuple(false, left.sum+right.sum+root.data);
			}
		}
	}
	
	class Tuple{
		boolean isSum;
		int sum;
		
		Tuple(boolean isSum, int sum){
			this.isSum = isSum;
			this.sum = sum;
		}
	}
}
