package lists;

/**
https://leetcode.com/problems/add-two-numbers/?tab=Description
You are given two non-empty linked lists representing two non-negative integers. 
The digits are stored in reverse order and each of their nodes contain a single digit. 
Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

Actually, 342+465 = 807

 * @author Harsh
 *
 */
public class AddTwoNumbersMain {
	public static void main(String[] a){
		ListNode one = new ListNode(2);
		one.next = new ListNode(4);
		one.next.next = new ListNode(3);
		
		ListNode two = new ListNode(5);
		two.next = new ListNode(6);
		two.next.next = new ListNode(4);
		
		long ms = System.currentTimeMillis();
		ListNode res = new AddTwoNumbersMain().addTwoNumbers(one, two);
		System.out.println("Took = "+(System.currentTimeMillis()-ms));
		ListNode result = res;
		while(result != null){
			System.out.println(result.val);
			result = result.next;
		}
		
		ms = System.currentTimeMillis();
		res = new AddTwoNumbersMain().addTwoNumbersFaster(one, two);
		System.out.println("Took = "+(System.currentTimeMillis()-ms));
		result = res;
		while(result != null){
			System.out.println(result.val);
			result = result.next;
		}
	}

	/*
	 * First attempt
	 */
	public ListNode addTwoNumbers(ListNode start1, ListNode start2) {
		ListNode node = null;
		ListNode start = node;
		
		ListNode n1 = start1;
		ListNode n2 = start2;
		int carryOver = 0;
		int one, two;
		
		while(n1 != null || n2 != null){
			if(n1 != null){
				one = n1.val;
				n1 = n1.next;
			}else{
				one = 0;
			}
			
			if(n2 != null){
				two = n2.val;
				n2 = n2.next;
			}else{
				two = 0;
			}
			
			int sum = one + two + carryOver;
			int value = sum%10;
			carryOver = sum/10;
			
			
			if(node == null){
				node = new ListNode(value);
				start = node;
			}else{
				node.next = new ListNode(value);
				node = node.next;
			}
			
		}
		
		if(carryOver != 0){
			node.next = new ListNode(carryOver);
		}
		return start;
	}
	
	public ListNode addTwoNumbersFaster(ListNode l1, ListNode l2) {
        ListNode ln1 = l1, ln2 = l2, head = null, node = null; // declare same type variables within a statement
        int carry = 0, remainder = 0, sum = 0;
        head = node = new ListNode(0);
        
        while(ln1 != null || ln2 != null || carry != 0) {
            sum = (ln1 != null ? ln1.val : 0) + (ln2 != null ? ln2.val : 0) + carry; // intelligent use of ternary operator - most stuff within a single statement
            carry = sum / 10;
            remainder = sum % 10;
            node = node.next = new ListNode(remainder); // most stuff within a single statement, assignment operator is right to lef associative
            ln1 = (ln1 != null ? ln1.next : null);
            ln2 = (ln2 != null ? ln2.next : null);
        }
        return head.next;
    }
	
	public ListNode addTwoNumberMyFinal(ListNode start1, ListNode start2) {
        if(start1 == null && start2 == null) return null;
        
        ListNode node=null, start = null, n1 = start1, n2 = start2;
		int carryOver = 0;
		
		
		
		while(n1 != null || n2 != null || carryOver != 0){
			int sum = (n1!=null?n1.val:0) + (n2!=null?n2.val:0) + carryOver;
			int value = sum%10;
			carryOver = sum/10;
			if(node == null){
				start = node = new ListNode(value);
			}else{
				node = node.next = new ListNode(value);
			}
		    if(n1!= null) n1 = n1.next;
		    if(n2!= null) n2 = n2.next;
		}
		return start;
	
    }
	static class ListNode{
		int val;
		ListNode next = null;

		ListNode(int x) { val = x; }
	}
}


