package trees;

import java.util.LinkedList;
import java.util.List;

public class TrieNode {
	public boolean isLeaf;
	public Character character;
	public List<TrieNode> children; // should be optimized to be a set or something to facilitate O(1) search complexity
	public TrieNode() {
		children = new LinkedList<>();
	}
}
