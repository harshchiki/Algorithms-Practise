package arrays;

public class RemoveDuplicatesFromAnArray {
	public static void main(String[] args) {
		int[] arr = new int[5];
		
		int[] uniqueArray = getUniqueArray(arr);
		
		for(int i : uniqueArray){
			System.out.println(i);
		}
	}
	
	static int[] getUniqueArray(int[] arr){
		/*
		 * Approach 1:
		 * use a hash set to lookup on every iteration
		 * Time: O(n)
		 * Space: O(n)
		 * 
		 * Approach 2:
		 * Sort the array in place
		 * Iterate - encountering duplicate - shift right to fill in return array
		 * Time: O(n logn) + O(n) = O(n log n)
		 * Space: O(1)
		 */
		return null;
	}
}
