package trees;

import java.util.LinkedList;
import java.util.List;

public class TrieNode {
	public boolean isLeaf;
	public Character character;
	public List<TrieNode> children;
	public TrieNode() {
		children = new LinkedList<>();
	}
}
