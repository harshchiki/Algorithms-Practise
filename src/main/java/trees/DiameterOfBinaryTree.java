package trees;
import java.util.LinkedList;
import java.util.Queue;

public class DiameterOfBinaryTree {
	public static void main(String[] args) {
		System.out.println("Diameter = "+diameterOfBinaryTree(TreeUtils.getTree()));
	}
	
	public static int diameterOfBinaryTree(TreeNode root){
		if(root == null) return 0;
		
		int diameter = 1;
		
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		
		while(!q.isEmpty()){
			Queue<TreeNode> qToRemember = new LinkedList<TreeNode>();
			while(!q.isEmpty()){
				TreeNode remNode = q.poll();
				if(remNode.left != null){
					qToRemember.add(remNode.left);
				}
				if(remNode.right!=null){
					qToRemember.add(remNode.right);
				}
			}
			diameter = diameter>qToRemember.size()?diameter:qToRemember.size();
			q = qToRemember;
		}
		
		
		return diameter;
	}
}
