package trees;

/*
 * This is DFS
 * SInce tree is acyclic - we could relax a few conditions
 */
public class PrintAllPathsOfBinaryTreeFromRoot {
	public static void main(String[] args) {
		TreeNode root = TreeUtils.getTree();
		TreeUtils.printInOrder(root);
		System.out.println();
	}


	
}
