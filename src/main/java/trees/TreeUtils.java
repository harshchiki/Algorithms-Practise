package trees;
import java.awt.Color;

public class TreeUtils {
	public static void printInOrder(TreeNode node){
		if(node == null) return;
		
		printInOrder(node.left);
		System.out.print(node.data +" ");
		printInOrder(node.right);
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
		n3.left = n6;
		n3.right = n7;
		
		return n1;
	}
}



