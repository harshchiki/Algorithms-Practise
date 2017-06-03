package trees;

import java.util.Stack;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class IterativeTraversalsOfBinaryTree {
	public static void main(String[] args) {
		TreeNode root = TreeUtils.getTree();
		System.out.println("Recursive In Order");
		TreeUtils.printInOrder(root);
		System.out.println();
		System.out.println("Iterative InOrder");
		iterativeInOrder(root);
		System.out.println();
		System.out.println("Iterative Preorder");
		iterativePreOrder(root);
		System.out.println();
		System.out.println("Iterative post order");
		iterativePostOrderUsing2Stacks(root);
	}
	
	static void iterativePostOrderUsing2Stacks(TreeNode root){
		if(root == null){
			return;
		}
		
		Stack<TreeNode> s1 = new Stack<TreeNode>();
		Stack<TreeNode> s2 = new Stack<TreeNode>();
		
		s1.push(root);
		while(!s1.isEmpty()){
			TreeNode node = s1.pop();
			if(node.left != null){
				s1.push(node.left);
			}
			
			if(node.right != null){
				s1.push(node.right);
			}
			
			
			s2.push(node);
		}
		
		while(!s2.isEmpty()){
			System.out.print(s2.pop().data +", ");
		}
	}
	
	
	static void iterativeInOrder(TreeNode root){
		if(root == null){
			return;
		}
		
		TreeNode currentNode = root;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		currentNode = pushLeftSubTree(currentNode, stack);
		
		while(!stack.isEmpty()){
			currentNode = stack.pop();
			System.out.print(currentNode.data +", ");
			
			if(currentNode.right!= null){
				pushLeftSubTree(currentNode.right, stack);
			}
		}
		
		
	}

	private static TreeNode pushLeftSubTree(TreeNode currentNode, Stack<TreeNode> stack) {
		while(currentNode != null){
			stack.push(currentNode);
			currentNode = currentNode.left;
		}
		return currentNode;
	}
	
	static void iterativePostOrderUsing1Stack(TreeNode root){
		if(null == root){
			return;
		}
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		
//		while(!stack.isEmpty()){
			TreeNode currentNode = stack.pop();
			
			// filling up the stack, until the leftmost child is reached
			while(currentNode != null){
				if(currentNode.right != null){
					stack.push(currentNode.right);
				}
				
				// push this node to visit back
				stack.push(currentNode);
				
				// move to left
				currentNode = currentNode.left;
			}
			System.out.println("Stack filled to the left most child of the tree");
			stack.stream()
			.forEach((node) -> System.out.print(node.data));
			System.out.println();
			
			// now stack moving back and print qualifying nodes.
			
			while(!stack.isEmpty()){
				TreeNode node = stack.pop();
				
				if(node.right != null){
					TreeNode peek = stack.isEmpty()? null: stack.peek();
					
					if(peek != null && node.right.equals(peek)){
						stack.pop();
						stack.push(node);
						stack.push(peek);
						continue;
					}else{
						stack.push(node.right);
						if(node.left != null){
							stack.push(node.left);
						}
					}
				}
				
				System.out.print(node.data+", ");
				
			}
//		}
		
		
	}
	
	static void iterativePreOrder(TreeNode root){
		if(null == root){
			return;
		}
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		stack.push(root);
		
		while(!stack.isEmpty()){
			TreeNode poppedNode = stack.pop();
			System.out.print(poppedNode.data +", ");
			if(poppedNode.right != null){
				stack.push(poppedNode.right);
			}
			
			if(poppedNode.left != null){
				stack.push(poppedNode.left);
			}
		}
	}
}
