package trees;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class LowestCommonAncestor {
	public static Set<List<TreeNode>> paths = new HashSet<List<TreeNode>>();
	static TreeNode lowestCommonAncestor;
	public static void main(String[] args) {
		TreeNode root = TreeUtils.getTree();
		System.out.println("printing tree");
		TreeUtils.printInOrder(root);
		System.out.println("In order printed");
		findLowestCommonAncestor(root, new TreeNode(5), new TreeNode(7));
	}

	static void findLowestCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2){
		System.out.println("Paths: ");
		setAllPathsToLeaves(root, node1, node2);
		System.out.println();
		switch(paths.size()){
		case 0:
			System.out.println("None of the nodes found");
			break;
		case 1:
			List<TreeNode> path = paths.iterator().next();
			int index = -1;
			for(TreeNode node : path){
				index++;
				if(node.equals(node1)|| node.equals(node2)){
					lowestCommonAncestor = node;
				}
			}
			break;
		case 2:
			Iterator<List<TreeNode>> pathIterator= paths.iterator();
			List<TreeNode> list1 = pathIterator.next();
			List<TreeNode> list2 = pathIterator.next();
			
			Iterator<TreeNode> list1Iterator = list1.iterator();
			Iterator<TreeNode> list2Iterator = list2.iterator();
			
			TreeNode next1, next2, prev1 = null, prev2;
			
			while(list1Iterator.hasNext() && list2Iterator.hasNext()){
				next1 = list1Iterator.next();
				next2 = list2Iterator.next();
				
				if(!next1.equals(next2)){
					lowestCommonAncestor = prev1;
					System.out.println("Lowest Common Ancestor = "+lowestCommonAncestor.data);
					break;
				}
				
				prev1 = next1;
				prev2 = next2;
			}
			
			break;
		default:
			System.out.println("You code broke!");
		}
	}

	static void setAllPathsToLeaves(TreeNode root, TreeNode node1, TreeNode node2){
		TreeNode[] path = new TreeNode[1000];
		int pathLen = 0;

		System.out.println();
		System.out.println("working out all the paths");
		workoutAllPathsContainingRequiredNodes(root, path, pathLen, node1, node2);
		System.out.println();
		for(int i= 0;i<100;i++){
			if(path[i] == null){
				break;
			}
			System.out.print(path[i].data +" ");
		}
		
		System.out.println();
		System.out.println("paths printed");
		
		paths.stream()
		.forEach((list) ->{
			list.stream()
			.forEach(
					(node) -> System.out.print(node.data +" ")
					);
			System.out.println();
		}
				);

	}

	static void workoutAllPathsContainingRequiredNodes(TreeNode root, TreeNode[] path, int pathLen,
			TreeNode node1, TreeNode node2){
		/*
		path has to be an array, not a collection. It is will pathLen, that we hok thngs up
			A
		    B       C
		  D   E   F   G
		  paths would be like
		            A
			AB      AC
	             ABD  ABE ACF  ACG   (how path array grows as we traverse down the tree
		*/
		if(root == null) return;
		
		
		System.out.println("adding to path "+root.data+" at index"+(pathLen));
		path[pathLen++] = root;


		if(root.equals(node1) || root.equals(node2)){
			/*
			We are looking for paths containing the nodes node1 and node2, not all paths,
			hence adding only those to lst (list of paths having node1 and node2)
			
			Since we care about the lowest common ancestor - their is no need to go further done this subtree 
			- we could maintain a flag to remember if both have been found or not, otherwise, no point traversing
			the whole tree
			*/
			// this is a leaf. path found - add
			List<TreeNode> lst = new LinkedList<>();
			for(int i = 0;i<pathLen;i++){
				lst.add(path[i]);
			}
			paths.add(lst);
		}else{
			workoutAllPathsContainingRequiredNodes(root.left, path, pathLen, node1, node2);
			workoutAllPathsContainingRequiredNodes(root.right, path, pathLen, node1, node2);
		}

	}
}
