package lists;

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
		
		System.out.println(new DetectCycleInList().detectCycleInLinkedList(n1));
		
	}
	boolean detectCycleInLinkedList(Node l){
		Node slow = l != null? l:null;
		Node fast = slow!= null? slow.next!=null? slow.next.next: null:null;
		
		while(fast != null){
			if(slow.data == fast.data){
				System.out.println("Next = "+slow.data+" NN = "+fast.data);
				return true;
			}else{
				slow = slow.next;
				fast = fast.next != null? fast.next.next != null? fast.next.next:null:null;
			}
		}
		return false;
	}
}
