package trees;



public class Trie {
	private TrieNode root;
	
	public Trie(){
		root = new TrieNode();
	}
	
	public void insert(final String str){
		final char[] chars = str.toCharArray();
		
		TrieNode node = root; // cannot be final
		for(int i = 0;i<str.length();i++){
			final char thisChar = chars[i];
			
			TrieNode searchedNode = searchInChildren(node, thisChar);
			if(null != searchedNode){
				final TrieNode newNode = new TrieNode(thisChar);
				node.children.put(Character.valueOf(thisChar), newNode);
				node = newNode;
			}else{
				node = searchedNode;
			}
			
			if(i == (str.length()-1)){
				node.isEndOfWord = true;
			}
		}
	}
	
	public boolean search(final String str){
		return false;
	}
	
	public boolean delete(final String str){
		return false;
	}
	
	public void printAllWords(){
		
	}
	
	// private methods following
	private TrieNode searchInChildren(final TrieNode node, final char character){
		Character characterQueriedFor = Character.valueOf(character);
		if(node.children.containsKey(characterQueriedFor)){
			return node.children.get(characterQueriedFor);
		}
		
		return null;
	}
}
