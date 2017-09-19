package trees;

import java.util.LinkedList;
import java.util.List;

// TODO: complete the logic to find the lowest common ancestor, which will be based on paths
// paths have been identified
public class LowestCommonAncestorOfNAryTree {
	public static void main(String[] args) {
		LowestCommonAncestorOfNAryTree lcaNTree = new LowestCommonAncestorOfNAryTree();
		NAryTreeNode root = lcaNTree.getTree();
		lcaNTree.setAllPaths(root, new NAryTreeNode[1000], 0);
		lcaNTree.printAllPaths();
	}

	List<List<NAryTreeNode>> allPaths = new LinkedList<>();
	
	
	
	
	void printAllPaths() {
		allPaths.stream().forEach(list -> {
			list.stream().forEach(node -> System.out.print(node.data +" "));
			System.out.println();
		});
	}
	
	void setAllPaths(NAryTreeNode node, NAryTreeNode[] paths, int pathLen) {
		if(node == null) {
			return;
		}
		
		paths[pathLen++] = node;
		
		if(node.children.size() == 0) {
			// is a leaf
			List<NAryTreeNode> list = new LinkedList<>();
			for(int i = 0;i<pathLen;i++) {
				list.add(paths[i]);
			}
			allPaths.add(list);
		}else {
			final int pathLength = pathLen;
			node.children.forEach(child -> {
				setAllPaths(child, paths, pathLength);
			});
		}
	}
	
	NAryTreeNode getTree() {
		NAryTreeNode n1 = new NAryTreeNode(1);
		NAryTreeNode n2 = new NAryTreeNode(2);
		NAryTreeNode n3 = new NAryTreeNode(3);
		NAryTreeNode n4 = new NAryTreeNode(4);
		NAryTreeNode n5 = new NAryTreeNode(5);
		NAryTreeNode n6 = new NAryTreeNode(6);
		NAryTreeNode n7 = new NAryTreeNode(7);
		NAryTreeNode n8 = new NAryTreeNode(8);
		NAryTreeNode n9 = new NAryTreeNode(9);
		NAryTreeNode n10 = new NAryTreeNode(10);
		NAryTreeNode n11 = new NAryTreeNode(11);
		NAryTreeNode n12 = new NAryTreeNode(12);
		
		
		n1.children.add(n2);
		n1.children.add(n3);
		n1.children.add(n4);
		
		n2.children.add(n5);
		n2.children.add(n6);
		n2.children.add(n7);
		
		n3.children.add(n8);
		n3.children.add(n9);
		n3.children.add(n10);
		
		n5.children.add(n11);
		n5.children.add(n12);
		
		return n1;
		
	}
}
