package trees;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class PrintAllPathsOfBinaryTreeFromRoot {
	static Set<List<TreeNode>> paths = new HashSet<>();
	
	public static void main(String[] args) {
		TreeNode root = TreeUtils.getTree();
		TreeUtils.printInOrder(root);
		System.out.println();
		printAllPaths(root, new TreeNode[1000], 0);
		
		System.out.println("************************");
		System.out.println("Printing all paths again");
		System.out.println("************************");
		paths.stream()
		.forEach(
					(list) ->{
						list.stream()
							.forEach(
									(node) -> System.out.print(node.data + " ")
									);
						System.out.println();
					}
				);
	}
	
	
	static void printAllPaths(TreeNode root, TreeNode[] path, int pathLen){
		if(root == null) return;
		
		path[pathLen++] = root;
		
		if(root.left == null && root.right == null){
			// this is a leaf node, so print the entire path
			printArray(path, pathLen);
			System.out.println();
		}else{
			printAllPaths(root.left, path, pathLen);
			printAllPaths(root.right, path, pathLen);
		}
	}
	
	static void printArray(TreeNode[] arr, int pathLen){
		/*
		 * pathLen plays a crucial role.
		 */
		List<TreeNode> thisPath = new LinkedList<TreeNode>();
		for(int i=0;i<pathLen;i++){
			thisPath.add(arr[i]);
			System.out.print(arr[i].data);
		}
		paths.add(thisPath);
	}
}
