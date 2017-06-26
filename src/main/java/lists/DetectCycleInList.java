package lists;

import java.util.LinkedList;
import java.util.List;

public class DetectCycleInList {
	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n2;

		DetectCycleInList o = new DetectCycleInList();
		Node cycle = o.detectCycleInLinkedList(n1);
		if(cycle != null){
			List<Node> nodesInCycle = o.getNodesInCycle(n1, cycle);
			o.removeCycle(n1, nodesInCycle);
			o.printList(n1);
		}
	}
	
	void printList(Node start){
		Node p = start;
		while(p != null){
			System.out.print(p.data + " ");
			p = p.next;
		}
	}
	
	void removeCycle(Node start, List<Node> lstNodes){
		Node p = start;
		while(p!=null && !lstNodes.contains(p)){
			p = p.next;
		}
		
		// p is the node - the kind of last node points to
		Node q = p.next;
		Node prev = null;
		while(q != null && q.data != p.data){
			prev = q;
			q = q.next;
		}
		if(prev != null){
			System.out.println("Removing link at "+prev.data);
			prev.next = null;
		}
	}
	
	List<Node> getNodesInCycle(Node start, Node cycle){
		List<Node> lst = new LinkedList<>();
		lst.add(cycle);
		Node p = cycle.next;
		while(p != null && p.data != cycle.data){
			lst.add(p);
			p = p.next;
		}
		return lst;
	}
	
	// Floyd's Cycle Detection Algorithm
	Node detectCycleInLinkedList(Node l){
		Node slow = l != null? l:null;
		Node fast = slow!= null? slow.next!=null? slow.next.next: null:null;

		while(fast != null){
			if(slow.data == fast.data){
				return slow;
			}else{
				slow = slow.next;
				fast = fast.next != null? fast.next.next != null? fast.next.next:null:null;
			}
		}
		return null;
	}
}
