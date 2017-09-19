
package trees;

/*
 * Depth First Search Traversal of a tree
 * of a tree
 */
public class DepthFirstSearchOfATree {
	public static void main(String[] args) {
		TreeNode root = TreeUtils.getTree();
		TreeUtils.printInOrder(root);
		dfs(root);
	}
	
	static void dfs(TreeNode root) {
		if(root == null) return;
		System.out.print(root.data+" ");
		dfs(root.left);
		dfs(root.right);
	}
	
	
	


}
