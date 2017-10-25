package trees;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class TrieNode {
	public boolean isLeaf;
	public Character character;
	public boolean isEndOfWord = false;
	public Map<Character, TrieNode> children;
	
	public TrieNode() {
		children = new HashMap<>();
	}
	
	public TrieNode(char character) {
		this.character = Character.valueOf(character);
		children = new HashMap<>();
	}
	
	public TrieNode(char character, final boolean isEndOfWord) {
		this.character = Character.valueOf(character);
		children = new HashMap<>();
		this.isEndOfWord = isEndOfWord;
	}
	
	
	@Override
	public boolean equals(Object other) {
		if(other != null && other instanceof TrieNode){
			return this.character.equals(((TrieNode) other).character);
		}
		
		return false;
	}
}
