package arrays;

public class FindUniqueInArrayOfDuplicates {
	public static void main(String[] args) {
		FindUniqueInArrayOfDuplicates o = new FindUniqueInArrayOfDuplicates();
		System.out.println(o.find(new int[]{1,2,1,2,4,5,5,6,6,7,7}));
	}
	
	// Time complexity: O(n)
	// x^x = 0
	// 0^x = x
	// XOR is commutative in nature
	int find(int[] arr){
		int result = arr[0];
		
		for(int i = 1;i<arr.length;i++){
			result = result^arr[i];
		}
		
		return result;
	}
}
