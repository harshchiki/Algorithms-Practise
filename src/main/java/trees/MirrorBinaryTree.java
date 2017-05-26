package trees;

public class MirrorBinaryTree {
	public static void main(String[] args) {
		TreeNode root = TreeUtils.getTree();
		TreeUtils.printInOrder(root);
		System.out.println("Mirror:");
		TreeUtils.printInOrder(getMirror(root));
	}
	
	public static TreeNode getMirror(TreeNode root){
		if(root == null){
			return null;
		}
		
		TreeNode tmpRight = root.right;
		
		root.right = getMirror(root.left);
		root.left = getMirror(tmpRight);
		
		return root;
	}

}
