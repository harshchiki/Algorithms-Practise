package trees;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class DistanceBetweenTwoNodesInATree {
	public static void main(String[] args) {
		TreeNode root = TreeUtils.getTree();
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(7);
		LowestCommonAncestor.setAllPathsToLeaves(root, node1, node2);
		LowestCommonAncestor.findLowestCommonAncestor(root, node1, node2);
		Set<List<TreeNode>> paths = LowestCommonAncestor.paths;
		
		TreeNode LCA = LowestCommonAncestor.lowestCommonAncestor;
		if(LCA == null){
			return;
		}
		
		switch(paths.size()){
		case 1:
			Iterator<TreeNode> listIterator = paths.iterator().next().iterator();
			boolean isLCAFound = false;
			int distance = 0;
			while(listIterator.hasNext()){
				TreeNode node = listIterator.next();
				
				if(isLCAFound){
					distance++;
				}
				
				if(node.equals(LCA)){
					isLCAFound = true;
				}
			}
			System.out.println("Distance = "+distance);
			break;
		case 2:
			Iterator<List<TreeNode>> pathIterator = paths.iterator();
			Iterator<TreeNode> iteratorList1 = pathIterator.next().iterator();
			Iterator<TreeNode> iteratorList2 = pathIterator.next().iterator();
			boolean commonNodeFound = false;
			int dist = 0;
			TreeNode nodeL1 = null, nodeL2 = null, prevN1 = null, prevN2 = null;
			while(!commonNodeFound && (iteratorList1.hasNext() || iteratorList2.hasNext())){
//				if(iteratorList1.hasNext()){
//					nodeL1 = iteratorList1.next();
//				}
//				
//				if(iteratorList2.hasNext()){
//					nodeL2 = iteratorList2.next();
//				}
//				
//				if(nodeL1 != null && nodeL2 != null){
//					if(!nodeL1.equals(nodeL2)){
//						commonNodeFound = true;
//						break;
//					}
//				}
//				
//				prevN1 = nodeL1;
//				prevN2 = nodeL2;
				
				if(iteratorList1.next().equals(LCA)){
					commonNodeFound = true;
					iteratorList2.next(); //because that of first list already progressed
					break;
				}
			}
			
			while(iteratorList1.hasNext()){
				iteratorList1.next();
				dist++;
			}
			
			while(iteratorList2.hasNext()){
				iteratorList2.next();
				dist++;
			}
			System.out.println("Distance = "+dist);
			break;
		}
	}
}
