package trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


// TODO: Need some finish ups. NOT WORKING as of now!!
public class Trie {
	public final TrieNode root;

	Trie(){
		root = new TrieNode();
	}

	void insert(String str) {
		char[] chars = str.toCharArray();
		TrieNode prevNode = root;
		for(int i = 0;i<chars.length;i++) {
			Character character = Character.valueOf(chars[i]);
			TrieNode thisNode = new TrieNode();
			thisNode.character = character;
			if(!doesListContain(prevNode.children, character)) {
				prevNode.children.add(thisNode);
			}else {
				// parent has a child with this character
				for(TrieNode nodeInList : prevNode.children) {
					if(nodeInList.equals(nodeInList.character)) {
						thisNode = nodeInList;
						break;
					}
				}
			}
			prevNode = thisNode;
		}
	}

	boolean search(String str) {
		char[] chars = str.toCharArray();
		TrieNode node = root;
		for(int i = 0;i<chars.length;i++) {
			Character character = Character.valueOf(chars[i]);
			
			TrieNode listNode = getNodeWithChar(node.children, character);
			
			if(listNode == null) {
				return false;
			}
			
			// node found
			if(i == (chars.length-1) && 
					listNode.children.size() == 0 // i.e. is a leaf (other could be a substring of some other string
					) {
				return true;
			}
			
			node = listNode;
		}
		
		
		
		return false;
	}

	private TrieNode getNodeWithChar(List<TrieNode> list, Character character) {
		for(TrieNode node : list) {
			if(node.character.equals(character)) {
				return node;
			}
		}
		
		return null;
	}
	
	private boolean doesListContain(List<TrieNode> list, Character character) {
		for(TrieNode node : list) {
			if(node.character.equals(character)) {
				return true;
			}
		}

		return false;
	}
	

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("there");
		trie.insert("their");
		trie.insert("answer");
		trie.insert("any");
		trie.insert("bye");
		System.out.println("DONE!!");
		System.out.println("Search for there" + trie.search("there"));
		System.out.println("Search for their" + trie.search("their"));
		System.out.println("Search for any" + trie.search("any"));
		System.out.println("Search for horse" + trie.search("harsh"));
		System.out.println("Search for warrior" + trie.search("warrior"));
	}
}
