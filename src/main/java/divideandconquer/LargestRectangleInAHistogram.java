package divideandconquer;

import java.util.Arrays;
import java.util.Stack;

/**
 * http://www.geeksforgeeks.org/largest-rectangle-under-histogram/
 * @author harshchiki
 *
 */
public class LargestRectangleInAHistogram {
	
	public static void main(String[] args) {
		System.out.println(new LargestRectangleInAHistogram().getLargestREctangleInAHistogram(new int[]{6, 2, 5, 4, 5, 1, 6}));
	}
	
	
	
	

	int getLargestREctangleInAHistogram(int[] a) {
		int maxArea = -1;
		
		Stack<Integer> s = new Stack<>();
		int areaWithTop = -1;
		int i;
		for(i = 0;i<a.length;) { // IMP: the loop counter should not be incremented here
			if(s.isEmpty() || a[s.peek()] <= a[i]) {
				s.push(i++);
				/*
				 * IMP: The loop counter is incremented here.
				 * Only after pushing should we increment the counter.
				 */
				System.out.println();
				System.out.println("PUSHED");
				printStack(s, maxArea, areaWithTop, i);
				System.out.println();
			} else {
				int top = s.pop();
				System.out.println();
				System.out.println("POPPED");
				
				/* top which is removed, is considered the smallest bar.
				 * Since it is the smallest bar, the area will be calculated
				 * by multiplying it with the number of bars traversed so far
				 * with a[top], which is height of the removed bar.
				 *  */
				areaWithTop = a[top] * (s.isEmpty() ? i : i-s.peek()-1);
				
				if(maxArea < areaWithTop) {
					maxArea = areaWithTop;
				}
				printStack(s, maxArea, areaWithTop, i);
				System.out.println();
			}
		}
		
		while(!s.isEmpty()) {
			int top = s.pop();
			/* top which is removed, is considered the smallest bar.
			 * Since it is the smallest bar, the area will be calculated
			 * by multiplying it with the number of bars traversed so far
			 * with a[top], which is height of the removed bar.
			 *  */
			areaWithTop = a[top] * (s.isEmpty() ? i : i-s.peek()-1);
			if(maxArea < areaWithTop) {
				maxArea = areaWithTop;
			}
		}
		
		return maxArea;
	}
	
	void printStack(Stack s, int areaWithTop, int maxArea, int i) {
		System.out.println(Arrays.toString(s.toArray())+" areaWithTop = "+areaWithTop + " maxArea = "+maxArea + " array index = "+ i);
	}
}
