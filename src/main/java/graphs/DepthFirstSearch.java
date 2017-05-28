package graphs;

import trees.TreeNode;

import trees.NodeColor;
import trees.TreeUtils;

public class DepthFirstSearch {
	public static void main(String[] args) {
		TreeNode root = TreeUtils.getTree();
		TreeUtils.printInOrder(root);
		System.out.println();
		dfs(root);
	}
	
	static void dfs(TreeNode root){
		initializeAllNodes(root);
		
		root.color = NodeColor.GRAY;
		System.out.print(root.data+" ");
		root.distFromRoot = 0;
		root.parent = null;
			
		if(root.left != null && root.left.color == NodeColor.WHITE){
			dfsVisit(root.left, root);
		}
		
		if(root.right != null && root.right.color == NodeColor.WHITE){
			dfsVisit(root.right, root);
		}
	}
	
	static void dfsVisit(TreeNode root, TreeNode parent){
		root.color = NodeColor.GRAY;
		root.parent = parent;
		root.distFromRoot = parent.distFromRoot+1;
		
		if(root.left != null && root.left.color == NodeColor.WHITE){
			dfsVisit(root.left, root);
		}
		
		if(root.right != null && root.right.color == NodeColor.WHITE){
			dfsVisit(root.right, root);
		}
		
		// coloring it black is not a mandatory step.
		root.color = NodeColor.BLACK;
		System.out.print(root.data+" ");
	}
	
	static void initializeAllNodes(TreeNode root){
		if(root == null) return;
		
		root.color = NodeColor.WHITE;
		root.distFromRoot = Integer.MIN_VALUE;
		root.parent = null;
		initializeAllNodes(root.left);
		initializeAllNodes(root.right);
	}


}
