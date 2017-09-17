package trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
 * Depth first traversal in a way
 */
public class AllPathsInATree {
	TreeNode root;
	List<List<TreeNode>> allPaths = new LinkedList<>();
	
	AllPathsInATree(TreeNode root){
		this.root = root;
	}
	
	AllPathsInATree setPaths() {
//		TreeNode[] path = new TreeNode[1000];
//		this.setAllPathsAppraoch1(this.root, path, 0);
		
		this.setAllPathsApproach2(root, "");
		return this;
	}
	
	// problem with this approach is that we originally
	// need to have an array - which is fixed size, so certainly
	// needs its own additional computation and this an overhead.
	void setAllPathsAppraoch1(TreeNode root, TreeNode[] path, int pathLen){
		if(root == null) return;
		
		path[pathLen++] = root;
		
		
		if(root.left == null && root.right == null) {
			// is a leaf
			List<TreeNode> list = new ArrayList<>(pathLen);
			for(int i = 0;i<pathLen;i++) {
				list.add(path[i]);
			}
			allPaths.add(list);
		}else {
			setAllPathsAppraoch1(root.left, path, pathLen);
			setAllPathsAppraoch1(root.right, path, pathLen);
		}
	}
	
	// Idea of having a path, here is to have an immutable reference
	// this method does not add to List<List<TreeNode>>. 
	void setAllPathsApproach2(TreeNode root, String path) {
		if(root == null) return;
		
		if(root.left == null && root.right == null) {
			path += root.data+" ";
			System.out.println(path);
		}else {
			path += root.data+" ";
			setAllPathsApproach2(root.left, path);
			setAllPathsApproach2(root.right, path);
		}
	}
	
	List<List<TreeNode>> getAllPaths(){
		return this.allPaths;
	}
	
	public static void main(String[] args) {
		new AllPathsInATree(TreeUtils.getTree()).setPaths().getAllPaths().stream().forEach(path -> {
			path.forEach(node -> System.out.print(node.data+" "));
			System.out.println();
		});
		System.out.println("Inorder");
		TreeUtils.printInOrder(TreeUtils.getTree());
	}
}
