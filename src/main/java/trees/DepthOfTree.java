package trees;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class DepthOfTree {
	public static void main(String[] args) {
		TreeNode root = TreeUtils.getTree();
		System.out.println("Depth = "+getDepth(root));
		System.out.println("recursive");
		System.out.println("Depth = "+recursiveGetDepth(TreeUtils.getTree()));
	}
	
	// iterative
	public static int getDepth(TreeNode root){
		int depth = 0;
		
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		root.color = NodeColor.GRAY;
		root.distFromRoot = 1;
		q.add(root);
		
		while(!q.isEmpty()){
			TreeNode remNode = q.poll();
			if(remNode.left!=null && remNode.left.color == NodeColor.WHITE){
				remNode.left.color = NodeColor.GRAY;
				remNode.left.parent = remNode;
				int thisNodesDistanceFromRoot = remNode.distFromRoot+1;
				remNode.left.distFromRoot = thisNodesDistanceFromRoot;
				depth = depth>thisNodesDistanceFromRoot? depth:thisNodesDistanceFromRoot;
				q.add(remNode.left);
			}
			
			if(remNode.right!=null && remNode.right.color == NodeColor.WHITE){
				remNode.right.color = NodeColor.GRAY;
				remNode.right.parent = remNode;
				int thisNodesDistanceFromRoot = remNode.distFromRoot+1;
				remNode.right.distFromRoot = thisNodesDistanceFromRoot;
				depth = depth>thisNodesDistanceFromRoot? depth:thisNodesDistanceFromRoot;
				q.add(remNode.right);
			}
			
			remNode.color = NodeColor.BLACK;
		}
		
		return depth;
	}
	
	// post order traversal is to be used
	public static int recursiveGetDepth(TreeNode root){
		if(root == null){
			return 0;
		}
		
		int leftDepth = recursiveGetDepth(root.left);
		int rightDepth = recursiveGetDepth(root.right);
		
		return leftDepth>rightDepth?leftDepth+1:rightDepth+1;
	}
}

