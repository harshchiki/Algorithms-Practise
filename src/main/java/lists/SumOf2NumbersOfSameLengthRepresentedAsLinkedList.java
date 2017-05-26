package lists;

class SumOf2NumbersOfSameLengthRepresentedAsLinkedList {
	public static void main(String[] args) {
		ListNode startAddend = getAddend();
		ListNode startAddendum = getAddendum();
		
		int addendSize = getSize(startAddend);
		int addendumSize = getSize(startAddendum);
		
		ListNode sumStart = null;
		
		if(addendSize == addendumSize){
			ReturnStuff ret = addSameSize(startAddend, startAddendum, 0); 
			if(ret.carry != 0){
				sumStart = new ListNode(ret.carry);
				sumStart.next = ret.node;
			}else{
				sumStart = ret.node;
			}
		}
		
		printList(startAddend);
		System.out.println("££££££££££££££££££££££££");
		printList(startAddendum);
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$");
		printList(sumStart);
	}
	
	static ReturnStuff addSameSize(ListNode addend, ListNode addendum, int carry){
		
		if(addend == null){
			return null;
		}
		
		int sum = 0;
		int carryOver = 0;
		
		ListNode sumNode = new ListNode(0); 
		ReturnStuff returnStuff1 = addSameSize(addend.next, addendum.next, carry);
		sumNode.next = returnStuff1!=null?returnStuff1.node:null;
		
		sumNode.data = (addend.data+addendum.data+carry)%10;
		carry = (addend.data+addendum.data+carry)/10;
		
		ReturnStuff returnStuff = new ReturnStuff();
		returnStuff.node = sumNode;
		returnStuff.carry = carry;
		return returnStuff;
	}

	static void printList(ListNode node){
		ListNode n = node;
		while(n!=null){
			System.out.print(n.data +" -> ");
			n =n.next;
		}
	}

	static int getSize(ListNode node){
		ListNode n = node;
		int size = 0;
		while(n!=null){
			n = n.next;
			size++;
		}
		
		return size;
	}
//	
//	static void getSum(ListNode s1, ListNode s2, int carryOver, ListNode sum){
//		if(s1 == null && s2!=null){
//			sum.next = new ListNode(s1.data+carryOver);
//		}
//
//		if(s2 == null && s1!=null){
//			sum.next = new ListNode(s1.data+carryOver);
//		}
//
//		if(s1 == null && s2 == null){
//			if(carryOver != 0){
//				sum.next = new ListNode(carryOver);
//			}
//			sum.next = null;
//		}
//
//		if(s1 != null && s2 != null){
//			if(sum ==null){
//				sum = new ListNode((s1.data+s2.data)%10);
//				
//			}else{
//				sum.next = new ListNode((s1.data+s2.data)%10);
//				sum = sum.next;
//			}
//
//			getSum(s1.next, s2.next, (s1.data+s2.data)/10,sum);
//		}
//
//
//	}

	static ListNode getAddend(){
		ListNode start = new ListNode(1);
		start.next = new ListNode(2);
		start.next.next = new ListNode(3);
		return start;
	}

	static ListNode getAddendum(){
		ListNode start = new ListNode(9);
		start.next = new ListNode(9);
		start.next.next = new ListNode(9);
		return start;
	}
	static class ListNode{
		int data;
		ListNode next = null;
		ListNode(int data){
			this.data = data;
		}
	}
	static class ReturnStuff{
		int carry;
		ListNode node;
		
	}
}




