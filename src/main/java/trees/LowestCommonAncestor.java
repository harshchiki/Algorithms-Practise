package trees;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class LowestCommonAncestor {
	static Set<List<TreeNode>> paths = new HashSet<List<TreeNode>>();

	public static void main(String[] args) {
		TreeNode root = TreeUtils.getTree();
	}
	
	static void setAllPathsToLeaves(TreeNode root){
		TreeNode[] path = new TreeNode[1000];
		int pathLen = 0;
		
		workoutAllPaths(root, path, pathLen);
		
	}
	
	static void workoutAllPaths(TreeNode root, TreeNode[] path, int pathLen){
		if(root == null) return;
		
		path[pathLen++] = root;
		
		if(root.left == null && root.right == null){
			// this is a leaf. path found - add
			List<TreeNode> lst = new LinkedList<>();
			for(int i = 0;i<pathLen;i++){
				lst.add(path[i]);
			}
			paths.add(lst);
		}else{
			workoutAllPaths(root.left, path, pathLen);
			workoutAllPaths(root.right, path, pathLen);
		}
		
	}
}
