package arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;

public class NextGreaterElement {
	Map<Integer, Integer> map = new HashMap<>();
	public static void main(String[] args) {
		new NextGreaterElement().nextGreaterElement(new int[]{4,5,2,25});
	}
	
	/*
	 * Time: O(n)
	 * Space: O(n)
	 */
	void nextGreaterElement(int[] arr){
		Stack<Integer> s = new Stack<>();
		s.push(Integer.valueOf(arr[0]));
		
		for(int i = 1;i< arr.length; i++){
			Integer next = arr[i];
			
			if(!s.isEmpty()){
				
				while(s.peek() < next){
					Integer element = s.pop();
//					System.out.println(element +" "+ next);
					map.put(element, Integer.valueOf(next)); // element's next greater is next
					if(s.isEmpty()){
						break;
					}
				}
			}
			
			s.push(next);
		}
		
		
		for(Entry<Integer, Integer> entry : map.entrySet()){
			System.out.println(entry.getKey()+" -- "+entry.getValue());
		}
	}
	
	
}
