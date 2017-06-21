package trees;

/*
 * Time Complexity: O(n)
 */
public class BoundaryTraversal {
	public static void main(String[] args) {
		System.out.println("Inorder Traversal");
		TreeUtils.printInOrder(TreeUtils.getTree());
		System.out.println();
		System.out.println("*******************");
		System.out.println("Boundary");
		printBoundaryOfBinaryTree(TreeUtils.getTree());
		System.out.println();
	}

	
	static void printLeaves(TreeNode node){
		if(node != null){
			printLeaves(node.left);
			
			if(node.left == null && node.right == null){
				System.out.print(node.data+" ");
			}
			
			printLeaves(node.right);
		}
	}
	
	static void printLeftSubtree(TreeNode node){
		if(node != null){
			if(node.left != null){
				/*
				 * ensuring top down order by printing first a
				 * and then calling on the left
				 */
				System.out.print(node.data+" ");
				printLeftSubtree(node.left);
			}else if(node.right != null){
				System.out.print(node.data+" ");
				printLeftSubtree(node.right);
			}
		}
	}
	
	static void printRightSubtree(TreeNode node){
		if(node != null){
			if(node.right != null){
				printRightSubtree(node.right);
				System.out.print(node.data+" ");
			}else if(node.left != null){
				printRightSubtree(node.left);
				System.out.println(node.data);
			}
		}
	}
	
	static void printBoundaryOfBinaryTree(TreeNode root){
		if(root != null){
			System.out.print(root.data+" ");
			printLeftSubtree(root.left);
			
			printLeaves(root.left);
			printLeaves(root.right);
			
			printRightSubtree(root.right);
		}
	}
}
