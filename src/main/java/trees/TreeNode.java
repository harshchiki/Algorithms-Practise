package trees;

public class TreeNode{
	public int data;
	public TreeNode left, right;
	public NodeColor color = NodeColor.WHITE;
	public TreeNode parent = null;
	public int distFromRoot = Integer.MIN_VALUE;
	TreeNode(int data){
		this.data = data;
	}
	
	@Override
	public boolean equals(Object node){
		return this.data == ((TreeNode)node).data;
	}
}