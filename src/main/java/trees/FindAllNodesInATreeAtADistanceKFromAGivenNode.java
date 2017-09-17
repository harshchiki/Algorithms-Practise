package trees;

import java.util.LinkedList;
import java.util.List;

// TODO: Add comments for better understanding
public class FindAllNodesInATreeAtADistanceKFromAGivenNode {
	List<TreeNode> getAllNodesAtDistanceKFrom(TreeNode root, TreeNode node, int k){
		List<TreeNode> list = new LinkedList<>();
		
		
		
		return list;
	}
	
	// This method is supposed to traverse down
	// the value of k is the pivot, until we keep finding nodes
	// the moment the value of k == 0, thats ones of the nodes
	void printKDistanceNodeDown(TreeNode node, int k) {
		// obvious terminating condition
		if(node == null || k < 0) {
			return;
		}
		
		// obvious condition to print the node
		if(k == 0) {
			System.out.println(node.data);
		}
		
		// Since a step is going to be taken, going down,
		// we do a k-1 here 
		printKDistanceNodeDown(node.left, k-1);
		printKDistanceNodeDown(node.right, k-1);
	}
	
	// initially passed with root, targetNode, k
	int printKDistanceNodes(TreeNode node, TreeNode target, int k) {
		
		// obvious boundary condition
		if(node == null) {
			return -1;
		}
		
		// since initially the call was made with node = root,
		// we start start 'looking' once the target node is found
		if(node == target) {
			// as soon as the node is found
			// we traverse down (explanation in the method called)
			printKDistanceNodeDown(node, k);
			
			// code terminates here, in this lo
			return 0;
		}
		
		//ANCESTORS
		
		
		// Recur for LEFT subtree
		// dLeft is the distance of the left child from the target
		int dLeft = printKDistanceNodes(node.left, target, k);
		
		if(dLeft != -1) {
			// OR dLeft == (k-1), since we are at least a level up
			if((dLeft + 1) == k) {
				System.out.println(node.data);
			}else {
				printKDistanceNodes(node.right, target, dLeft-k-2);
			}
			return dLeft + 1;
		}
		
		// Recur for RIGHT subtree
		int dRight = printKDistanceNodes(node.right, target, k);
		
		if(dRight != -1) {
			if((dRight + 1) == k) {
				System.out.println(node.data);
			}else {
				printKDistanceNodes(node.right, target, k);
			}
			return dRight +1;
		}
		
		// -1 is to denote that no k distance nodes are available at k distance from the target node.
		return -1;
	}
	
	
	
	public static void main(String[] args) {
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
		
		TreeNode root = n1;
		int k = 2;
		
		List<TreeNode> list = new FindAllNodesInATreeAtADistanceKFromAGivenNode()
				.getAllNodesAtDistanceKFrom(root, n5, k);
		list.stream().forEach(listNode -> System.out.print(listNode.data + " "));
		
		
		
	}
	
}
