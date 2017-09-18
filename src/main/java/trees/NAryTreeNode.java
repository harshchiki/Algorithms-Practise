package trees;

import java.util.LinkedList;
import java.util.List;

public class NAryTreeNode {
	public int data;
	public List<NAryTreeNode> children = new LinkedList<>();
	
	public NAryTreeNode(int data) {
		this.data = data;
	}
}
