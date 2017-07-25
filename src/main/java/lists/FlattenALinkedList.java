package lists;
/*
 * http://www.geeksforgeeks.org/flattening-a-linked-list/
 *  	   5 -> 10 -> 19 -> 28
       |    |     |     |
       V    V     V     V
       7    20    22    35
       |          |     |
       V          V     V
       8          50    40
       |                |
       V                V
       30               45
       
       There are down pointers and right pointers.
       
       Final list has to be a sorted list, and has to traverse 'down'.
 */
public class FlattenALinkedList {
	
	public static void main(String[] args) {
		FlattenALinkedList o = new FlattenALinkedList();
		Node n5 = o.new Node(5);
		Node n7 = o.new Node(7);
		Node n8 = o.new Node(8);
		Node n30 = o.new Node(30);
		Node n10 = o.new Node(10);
		Node n20 = o.new Node(20);
		Node n19 = o.new Node(19);
		Node n22 = o.new Node(22);
		Node n50 = o.new Node(50);
		Node n28 = o.new Node(28);
		Node n35 = o.new Node(35);
		Node n40 = o.new Node(40);
		Node n45 = o.new Node(45);
		n5.right = n10;
		n10.right = n19;
		n19.right = n28;
		
		n5.down = n7;
		n7.down = n8;
		n8.down = n30;
		n10.down = n20;
		n19.down = n22;
		n22.down = n50;
		n28.down = n35;
		n35.down = n40;
		n40.down = n45;
		
		Node flattenedList = o.flatten(n5);
		o.printList(flattenedList);
	}
	
	void printList(Node root) {
		Node node = root;
		while(node != null) {
			System.out.print(node.data +" ");
			node = node.down;
		}
	}
	
	Node merge(Node root, Node right) {
		if(root == null) {
			return right;
		}
		if(right == null) {
			return root;
		}
		Node result;
		if(root.data < right.data) {
			result = root;
			result.down = merge(root.down, right);
		}else {
			result = right;
			result.down =merge(right.down, root);
		}
		
		return result;
	}
	
	Node flatten(Node root) {
		if(root == null || root.right == null) {
			return root;
		}
		
		Node right = flatten(root.right);
		Node result = merge(root, right);
		
		return result;
	}
	
	class Node{
		int data;
		Node right, down;
		Node(int data){
			this.data = data;
		}
	}
}
