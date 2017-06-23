package trees;

public class TreeFromInOrderAndPreOrder {
	int preOrderIndex = 0;
	
	TreeNode makeBinaryTree(int[] inOrder, int[] preOrder, int inStart, int inEnd){
		if(inStart > inEnd){
			return null;
		}
		
		System.out.println(preOrderIndex+" "+inStart+" "+inEnd);
		TreeNode node = new TreeNode(preOrder[preOrderIndex++]);
		
		int inOrderIndex = getInOrderIndex(inOrder, node.data);
		
		node.left = makeBinaryTree(inOrder, preOrder, inStart, inOrderIndex-1);
		node.right = makeBinaryTree(inOrder, preOrder, inOrderIndex+1, inEnd);
		
		return node;
		
	}
	
	int getInOrderIndex(int[] inOrder, int data){
		for(int i = 0;i<inOrder.length;i++){
			if(inOrder[i] == data){
				return i;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		TreeFromInOrderAndPreOrder o = new TreeFromInOrderAndPreOrder();
		int [] inOrder = {2,5,6,10,12,14,15};
		int [] preOrder = {10,5,2,6,14,12,15};
		
		TreeNode root = o.makeBinaryTree(inOrder, preOrder, 0, inOrder.length-1);
		TreeUtils.printInOrder(root);
	}
}
