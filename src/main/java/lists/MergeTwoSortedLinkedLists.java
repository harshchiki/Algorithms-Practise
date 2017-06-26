package lists;

public class MergeTwoSortedLinkedLists {
	
	public static void main(String[] args) {
		Node l1 = new Node(1);
		Node l3 = new Node(3);
		Node l5 = new Node(5);
		Node l7 = new Node(7);
		Node l9 = new Node(9);
		
		l1.next = l3;
		l3.next = l5;
		l5.next = l7;
		l7.next = l9;
		
		Node l2 = new Node(2);
		Node l4 = new Node(4);
		Node l6 = new Node(6);
		Node l8 = new Node(8);
		
		l2.next = l4;
		l4.next = l6;
		l6.next = l8;
		
		MergeTwoSortedLinkedLists o = new MergeTwoSortedLinkedLists();
		o.merge(l1, l2);
		o.printList(l1);
		
	}
	
	Node merge(Node l1, Node l2){
		Node p1 = l1;
		Node p2 = l2;

		Node pl1 = null;
		Node l2n = (l2 != null)? l2.next: null;

		while(p1 != null && p2 != null){
			if(p1.data > p2.data){
				if(pl1 == null){
					// if first node of first list is greater than the element from second list
					p1 = l1; // updating first list reference
					p2.next = l1; // inserting in the middle;
					l1 = p2; // updating the start of l1
					p2 = l2n; // updating second list reference
				}else{
					pl1.next = p2;
					p2.next = p1;

					pl1 = l2; // previous of l1 retained well
					p2 = l2n;// moving the l2 reference forward
					l2n = (p2 != null)? p2.next: null; // caching l2 next every times
				}
			}else{
				// moving only the l1 pointed
				pl1 = p1; // updating the previous l1 reference
				p1 = p1.next; // moving forward the l1 pointer
			}
		}

		// pl1 is the last element of the first list
		if(p2 != null){
			pl1.next = p2;			
		}

		return l1;
	}
	
	void printList(Node l){
		while(l != null){
			System.out.print(l.data+" ");
			l = l.next;
		}
	}
}
