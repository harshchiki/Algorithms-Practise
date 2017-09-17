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
	
	TreeNode(TreeNode node){
		this(node.data);
		this.left = node.left;
		this.right = node.right;
	}
	
	@Override
	public boolean equals(Object node){
		return this.data == ((TreeNode)node).data;
	}
	
	@Override
	public String toString(){
		return this.data+" ";
	}
}