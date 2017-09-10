package arrays;

/**
 * http://www.geeksforgeeks.org/convert-array-into-zig-zag-fashion/
 * 
Example: 
Input:  arr[] = {4, 3, 7, 8, 6, 2, 1}
Output: arr[] = {3, 7, 4, 8, 2, 6, 1}

Input:  arr[] =  {1, 4, 3, 2}
Output: arr[] =  {1, 4, 2, 3}
 * @author harshchiki
 *
 */
public class ArrayIntoZigZag {
	public static void main(String[] args) {
		int[] a = {4, 3, 7, 8, 6, 2, 1};
		zigzag_bubblesort(a);
		for(int i : a) {
			System.out.println(i);
		}
	}
	
	/*
	 * Time complexity: O(n)
	 * Space complexity: O(1)
	 * 
	 * Idea is to use bubble sort, with the nature of comparison to change in every 
	 * iteration, since we need zigzag comparison order, not increasing nor decreasing order
	 * 
	 */
	public static void zigzag_bubblesort(int[] a) {
		if(a == null || a.length == 0) {
			return;
		}
		boolean flag = true;
		for(int i = 0;i<a.length-1;i++) {
			if(flag) {
				if(a[i] > a[i+1]) {
					swap(a, i);
				} 
			}else {
				if(a[i] < a[i+1]) {
					swap(a, i);
				}
			}
			flag = !flag;
		}
	}

	private static void swap(int[] a, int i) {
		int tmp = a[i+1];
		a[i+1] = a[i];
		a[i] = tmp;
	}
}
