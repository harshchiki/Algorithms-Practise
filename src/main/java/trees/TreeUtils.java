package trees;
import java.util.LinkedList;
import java.util.List;

public class TreeUtils {
	public static void printInOrder(TreeNode node){
		if(node == null) return;
		
		printInOrder(node.left);
		System.out.print(node.data +" ");
		printInOrder(node.right);
	}
	
	static void inOrderList(TreeNode root, List<TreeNode> list){
		if(root == null) return;
		
		if(list == null){
			System.out.println("list constructed");
			list = new LinkedList<TreeNode>();
		}
		
		inOrderList(root.left, list);
		list.add(root);
		inOrderList(root.right, list);
	}
	
	
	public static TreeNode getTree(){
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		
		n1.left = n2;
		n1.right = n3;
		
		n2.left = n4;
		n2.right = n5;
//		n3.left = n6;
		n3.right = n7;
		
		n5.left = n6;
		
		return n1;
	}
	
	public static TreeNode getTreeWithParentsPopulated(TreeNode root) {
		// makes changes in the tree passed
		root.parent = null;
		populateParent(root);
		return root;
		
	}
	
	private static void populateParent(TreeNode root) {
		if(root == null) return;
		
		if(root.left != null) {
			root.left.parent = root;
			populateParent(root.left);
		}
		
		if(root.right != null) {
			root.right.parent = root;
			populateParent(root.right);
		}
		
	}
}



