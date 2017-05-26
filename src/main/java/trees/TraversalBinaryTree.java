package trees;
import java.util.Stack;

public class TraversalBinaryTree {
	public static void main(String[] args) {
		iterativeInOrder(TreeUtils.getTree());
	}
	
	static void iterativeInOrder(TreeNode root){
		if(root == null) return;
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		TreeNode node = root;
		while(node!=null){
			stack.push(node);
			node = node.left;
		}
		
		while(!stack.isEmpty()){
			TreeNode currentNode = stack.pop();
			System.out.print(currentNode.data);
			
			if(currentNode.right != null){
				currentNode = currentNode.right;
				
				while(currentNode != null){
					stack.push(currentNode);
					currentNode = currentNode.right;
				}
			}
		}
		
		stack.push(root);
	}
}
