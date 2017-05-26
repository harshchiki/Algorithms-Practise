package trees;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Objects;

public class TrieMain {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String input = reader.readLine();
		Node root = null;
		while(!Objects.equals(input, "done")){
			insert(root, input);
			input = reader.readLine();
		}


	}

	private static void insert(Node root, String input) {
	}
	
	private static void printTree(Node root){
	}
	
	private static boolean searchText(Node root, String word){
		return false;
	}

	private class Node{
		String data;
		Collection<Node> nodes = new LinkedList<Node>();
	}
}
