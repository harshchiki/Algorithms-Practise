package queues;

import java.util.Stack;

public class QueueUsingStack {
	/*
	 * COSTLY ADD
	 */
	Stack<Integer> s1OnCostlyAdd = new Stack<Integer>();
	Stack<Integer> s2OnCostlyAdd = new Stack<Integer>();
	
	void costlyAdd(Integer x){
		while(!s1OnCostlyAdd.isEmpty()){
			s2OnCostlyAdd.push(s1OnCostlyAdd.pop());
		}
		
		s1OnCostlyAdd.push(x);
		
		while(!s2OnCostlyAdd.isEmpty()){
			s1OnCostlyAdd.add(s2OnCostlyAdd.pop());
		}
	}
	
	Integer removeOnCostlyAdd(){
		return s1OnCostlyAdd.pop();
	}
	
	/*
	 * COSTLY REMOVE
	 */
	Stack<Integer> s1OnCostlyRemove = new Stack<Integer>();
	Stack<Integer> s2OnCostlyRemove = new Stack<Integer>();
	
	void addOnCostlyRemove(Integer x){
		s1OnCostlyRemove.push(x);
	}
	
	Integer costlyRemove(){
		while(s1OnCostlyRemove.size()>1){
			s2OnCostlyRemove.push(s1OnCostlyRemove.pop());
		}
		Integer result = s1OnCostlyRemove.pop();
		
		while(!s2OnCostlyRemove.isEmpty()){
			s1OnCostlyRemove.push(s2OnCostlyRemove.pop());
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		QueueUsingStack q = new QueueUsingStack();
		System.out.println("Costly Add");
		q.costlyAdd(Integer.valueOf(2));
		q.costlyAdd(Integer.valueOf(3));
		q.costlyAdd(Integer.valueOf(4));
		q.costlyAdd(Integer.valueOf(5));
		
		System.out.println(q.removeOnCostlyAdd());
		System.out.println(q.removeOnCostlyAdd());
		System.out.println(q.removeOnCostlyAdd());
		System.out.println(q.removeOnCostlyAdd());
		
		System.out.println("Costly Remove");
		q.addOnCostlyRemove(Integer.valueOf(2));
		q.addOnCostlyRemove(Integer.valueOf(3));
		q.addOnCostlyRemove(Integer.valueOf(4));
		q.addOnCostlyRemove(Integer.valueOf(5));
		
		System.out.println(q.costlyRemove());
		System.out.println(q.costlyRemove());
		System.out.println(q.costlyRemove());
		System.out.println(q.costlyRemove());
	}
}
