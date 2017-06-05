package trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BoundaryTraversal {
	public static void main(String[] args) {
		System.out.println("Inorder Traversal");
		TreeUtils.printInOrder(TreeUtils.getTree());
		System.out.println();
		System.out.println("*******************");
		System.out.println("Boundary");
		printBoundary(TreeUtils.getTree());
	}

	static void printBoundary(TreeNode root){
		if(null == root){
			return;
		}

		Stack<TreeNode> stackRightBoundary = new Stack<TreeNode>();

		Queue<TreeNode> thisLevel = new LinkedList<TreeNode>();
		thisLevel.add(root);
		System.out.print(root.data+" ");

		while(!thisLevel.isEmpty()){
			Queue<TreeNode> nextLevel = new LinkedList<>();

			while(!thisLevel.isEmpty()){
				TreeNode removedNode = thisLevel.poll();
				if(null != removedNode.left){
					nextLevel.add(removedNode.left);
				}
				if(null != removedNode.right){
					nextLevel.add(removedNode.right);
				}	

				// if removed Node is a leaf - print it as soon as you get
				if(null == removedNode.left && null == removedNode.right){
					System.out.print(removedNode.data+" ");
				}
			}

			if(nextLevel.size()>0){
				@SuppressWarnings("unchecked")			
				TreeNode first = ((List<TreeNode>)nextLevel).get(0);

				// if first is not a leaf
				if(!(first.left == null && first.right == null)){
					System.out.print(first.data+" ");
				}

				if(nextLevel.size()>1){
					@SuppressWarnings("unchecked")
					TreeNode last =  ((List<TreeNode>)nextLevel).get(nextLevel.size()-1);

					if(!first.equals(last) && !(last.left == null && last.right == null)){
						stackRightBoundary.push(last);
					}
				}
			}
			thisLevel = nextLevel;
		}

		while(!stackRightBoundary.isEmpty()){
			System.out.print(stackRightBoundary.pop().data+" ");
		}

	}
}
