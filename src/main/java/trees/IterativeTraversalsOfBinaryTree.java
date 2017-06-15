package trees;

import java.util.Stack;

public class IterativeTraversalsOfBinaryTree {
	static boolean logEnabled = true;
	public static void main(String[] args) {
		
		TreeNode root = TreeUtils.getTree();
		
		TreeNode r1 = new TreeNode(1);
		TreeNode r2 = new TreeNode(2);
		TreeNode r3 = new TreeNode(3);
		TreeNode r4 = new TreeNode(4);
		TreeNode r5 = new TreeNode(5);
		
		r1.left = r2;
		r1.right = r3;
		r3.left = r4;
		r3.right = r5;
		
		//		System.out.println("Recursive In Order");
		//		TreeUtils.printInOrder(root);
		//		System.out.println();
		//		System.out.println("Iterative InOrder");
		//		iterativeInOrder(root);
		//		System.out.println();
		//		System.out.println("Iterative Preorder");
		//		iterativePreOrder(root);
		//		System.out.println();
		System.out.println("Iterative post order");
		iterativePostOrderUsing2Stacks(r1);
	}

	static void iterativePostOrderUsing2Stacks(TreeNode root){
		if(root == null){
			return;
		}

		Stack<TreeNode> s1 = new Stack<TreeNode>();
		Stack<TreeNode> s2 = new Stack<TreeNode>();

		s1.push(root);
		logTracePostOrderUsing2Stacks(null, s1, s2);
		while(!s1.isEmpty()){
			TreeNode node = s1.pop();
			if(node.left != null){
				s1.push(node.left);
			}

			if(node.right != null){
				s1.push(node.right);
			}


			s2.push(node);
			logTracePostOrderUsing2Stacks(node, s1, s2);
		}

		while(!s2.isEmpty()){
			System.out.print(s2.pop().data +", ");
		}
	}

	static void logTracePostOrderUsing2Stacks(TreeNode node, Stack<TreeNode> s1, Stack<TreeNode> s2){
		if(logEnabled){
			System.out.println("**************************");
			System.out.println("Node = "+node);
			System.out.println("s1");
			s1.stream().forEach((x) -> System.out.print(x));
			System.out.println();
			System.out.println("s2");
			s2.stream().forEach((x) -> System.out.print(x));
			System.out.println();
			System.out.println("**************************");
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
