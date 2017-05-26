package trees;
import java.util.Stack;

public class SearchATreeWithinATree {
	static StringBuilder containerPreOrder = new StringBuilder(), containerInOrder = new StringBuilder();
	static StringBuilder searchPreOrder = new StringBuilder(), searchInOrder = new StringBuilder();

	public static void main(String[] args) {
		TreeNode containerTree = getContainerTree();
		TreeNode searchTree = getSearchTree();
		
		String contPreOrder = preOrder(containerTree, containerPreOrder).toString();
		String contInOrder = inOrder(containerTree, containerInOrder).toString();
		String srchPreOrder = preOrder(searchTree, searchPreOrder).toString();
		String srchInOrder = inOrder(searchTree, searchInOrder).toString();
		
		if(contPreOrder.contains(srchPreOrder) 
				&& contInOrder.contains(srchInOrder)){
			System.out.println("EXISTS!");
		}else{
			System.out.println("DOES NOT EXIST!");
		}
	}

	static TreeNode getContainerTree(){
		TreeNode n1 = new TreeNode(1);
		
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		
		n1.left = n2;
		n1.right = n3;
		
		n2.left = n4;
		n2.right = n5;
		
		n3.left = n6;
		
		
		return n1;
	}
	
	static TreeNode getSearchTree(){
		TreeNode n2 = new TreeNode(2);
		
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		
		n2.left = n4;
		n2.right = n5;
		
		return n2;
	}
	
	static StringBuilder preOrder(TreeNode root, StringBuilder builder){
		if(root == null) {
			builder.append("");
		}else{
			builder.append(root.data);
			preOrder(root.left, builder);
			preOrder(root.right, builder);
		}
		return builder;
	}
	
	static StringBuilder inOrder(TreeNode node, StringBuilder builder){
		if(node != null){
			inOrder(node.left, builder);
			builder.append(node.data);
			inOrder(node.right, builder);
		}
		
		return builder;
	}
	
	static boolean isMatch(TreeNode containerRoot, TreeNode searchRoot){
		boolean isMatch = false;
		
		return isMatch;
	}
	
	static TreeNode getSubTree(TreeNode mainTree, TreeNode nodeToSearch){
		if(mainTree == null || nodeToSearch == null){
			return nodeToSearch;
		}
		
		Stack<TreeNode> s = new Stack<TreeNode>();
		
		return null;
	}

}
