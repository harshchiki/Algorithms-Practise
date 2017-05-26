package trees;
import java.awt.Color;
import java.util.LinkedList;
import java.util.Queue;

public class DepthOfTree {
	public static void main(String[] args) {
		TreeNode root = TreeUtils.getTree();
		System.out.println("Depth = "+getDepth(root));
		System.out.println("recursive");
		System.out.println("Depth = "+recursiveGetDepth(TreeUtils.getTree()));
	}
	
	public static int getDepth(TreeNode root){
		int depth = 0;
		
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		root.color = Color.GRAY;
		root.distFromRoot = 1;
		q.add(root);
		
		while(!q.isEmpty()){
			TreeNode remNode = q.poll();
			if(remNode.left!=null && remNode.left.color == Color.WHITE){
				remNode.left.color = Color.GRAY;
				remNode.left.parent = remNode;
				int thisNodesDistanceFromRoot = remNode.distFromRoot+1;
				remNode.left.distFromRoot = thisNodesDistanceFromRoot;
				depth = depth>thisNodesDistanceFromRoot? depth:thisNodesDistanceFromRoot;
				q.add(remNode.left);
			}
			
			if(remNode.right!=null && remNode.right.color == Color.WHITE){
				remNode.right.color = Color.GRAY;
				remNode.right.parent = remNode;
				int thisNodesDistanceFromRoot = remNode.distFromRoot+1;
				remNode.right.distFromRoot = thisNodesDistanceFromRoot;
				depth = depth>thisNodesDistanceFromRoot? depth:thisNodesDistanceFromRoot;
				q.add(remNode.right);
			}
			
			remNode.color = Color.BLACK;
		}
		
		return depth;
	}
	
	public static int recursiveGetDepth(TreeNode root){
		if(root == null){
			return 0;
		}
		
		int leftDepth = recursiveGetDepth(root.left);
		int rightDepth = recursiveGetDepth(root.right);
		
		return leftDepth>rightDepth?leftDepth+1:rightDepth+1;
	}
}

