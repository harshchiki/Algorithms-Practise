package trees;

import java.util.LinkedList;
import java.util.List;

public class LongestPathInATree {
	TreeNode root;
	int lengthOfTheLongestPath = -1;
	TreeNode lastNodeOnLongestPath;
	List<TreeNode> longestPath = new LinkedList<>();
	List<List<TreeNode>> allPaths = new LinkedList<>();
	
	// this method is a prerequisite for populating longest path
	// this method populates both the last node on the longest path
	// as well as the length of the longest path
	void setLengthOfLongestPath(TreeNode node, int height) {
		if(node == null) return;
		
		if(lengthOfTheLongestPath < height) {
			lengthOfTheLongestPath++;
			lastNodeOnLongestPath = node;
		}
		
		setLengthOfLongestPath(node.left, height+1);
		setLengthOfLongestPath(node.right, height+1);
	}
	
	// uses the logic to find all paths in a tree
	// checks if the encountered leaf is the last node on the longest path or not
	// if yes, prints the path
	void populateLongestPath(TreeNode node, TreeNode[] paths, int pathLen) {
		// certainly the lastNodeOnLongestPath is a leaf
		
		if(node == null) return;
		
		paths[pathLen++] = node;
		if(node.left == null && node.right == null && node.data == lastNodeOnLongestPath.data) {
			for(int i = 0;i<pathLen;i++) {
				System.out.println(paths[i]);
			}
			return; // no point going further. 
		}else {
			populateLongestPath(node.left, paths, pathLen);
			populateLongestPath(node.right, paths, pathLen);
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = TreeUtils.getTree();
		LongestPathInATree lpt = new LongestPathInATree();
		lpt.setLengthOfLongestPath(root, 0);
		lpt.populateLongestPath(root, new TreeNode[1000], 0);
	}
}
