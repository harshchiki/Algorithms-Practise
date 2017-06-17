package stack;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Boundary conditions have not been checked
 * Exception handling - TODO
 * 
 * behavior of iterator - TODO
 */
public class StackUsingQueue {
	Queue<Integer> q1ForCostlyPush = new LinkedList<>();
	Queue<Integer> q2ForCostlyPush = new LinkedList<>();
	
	Queue<Integer> q1ForCostlyPop = new LinkedList<>();
	Queue<Integer> q2ForCostlyPop = new LinkedList<>();


	void costlyPush(Integer x){
		q2ForCostlyPush.add(x);

		while(q1ForCostlyPush.size()>0){
			Integer polledElement = q1ForCostlyPush.poll();
			q2ForCostlyPush.add(polledElement);
		}

		Queue<Integer> tmp = q1ForCostlyPush;
		q1ForCostlyPush = q2ForCostlyPush;
		q2ForCostlyPush = tmp;
	}

	Integer peekOnCostlyPush(){
		if(q1ForCostlyPush.size()>0){
			return q1ForCostlyPush.peek();
		}else{
			return null;
		}
	}
	
	Integer popOnCostlyPush(){
		if(q1ForCostlyPush.size()>0){
			return q1ForCostlyPush.poll();
		}else{
			return null;
		}
	}
	
	void pushOnCostlyPop(Integer x){
		q1ForCostlyPop.add(x);
	}
	
	Integer popOnCostlyPop(){
		while(q1ForCostlyPop.size()>1){
			q2ForCostlyPop.add(q1ForCostlyPop.poll());
		}
		Integer result = q1ForCostlyPop.poll();
		Queue<Integer> tmp = q1ForCostlyPop;
		q1ForCostlyPop = q2ForCostlyPop;
		q2ForCostlyPop = tmp;
		
		return result;
				
	}
	
	public static void main(String[] args) {
		int[] a = new int[]{2,3,4,5};
		StackUsingQueue s = new StackUsingQueue();
		for(int i = 0;i<a.length;i++){
			s.costlyPush(Integer.valueOf(a[i]));
		}
		
		while(s.peekOnCostlyPush() != null){
			System.out.println(s.popOnCostlyPush());
		}
	}
}
