package trees;
/*
 * Amazon SDE 2 interview
 * 
 * http://www.geeksforgeeks.org/amazon-interview-set-82-for-sde-2/
 * http://www.geeksforgeeks.org/construct-all-possible-bsts-for-keys-1-to-n/
 * Algo given on just above link is different from what is done below.
 * 
 * 
 
 Algo:
 1.) length == 0 -> 0
 2.) length == 1 -> 1
 3.) length == 2 -> 2
 4.) Iterate through all the elements of the array, making each the root.
 5.) Use the left elements, and pass recursively to get count of left subtrees.
 6.) Use the right elements, and pass recursively to get count of right subtree.
 7.) Count of tree with this i as root is max of (5) and (6)
 
 */

public class UniqueBSTFromSortedArray {

	public static void main(String[] args) {
		System.out.println(getNoOfUniqueBST(getSortedArray()));
	}

	public static int getNoOfUniqueBST(int[] a){
		if(a.length == 0){
			return 0;
		}
		if(a.length == 1){
			return 1;
		}
		if(a.length ==2){
			return 2;
		}
		int count = 0;
		for(int i=0;i<a.length;i++){
			int noOfUniqueBSTLeft = 0;
			int[] leftSubArray = new int[0];
			leftSubArray = getSubArray(a, 0, i-1);
			noOfUniqueBSTLeft = getNoOfUniqueBST(leftSubArray);	

			int noOfUniqueBSTRight = 0;
			int[] rightSubArray = new int[0];
			rightSubArray = getSubArray(a,i+1,a.length-1);
			noOfUniqueBSTRight = getNoOfUniqueBST(rightSubArray);
			count += noOfUniqueBSTLeft > noOfUniqueBSTRight? noOfUniqueBSTLeft : noOfUniqueBSTRight;
		}
		return count;
	}



	public static int[] getSubArray(int[] arr, int startIndex, int endIndex){
		if(startIndex <0 || endIndex <0 || startIndex > endIndex || startIndex > arr.length || endIndex > arr.length) 
			return new int[0];

		int a[] = new int[endIndex-startIndex+1];
		int j = 0;
		for(int i = startIndex;i<=endIndex;i++,j++){
			a[j] = arr[i];
		}
		return a;
	}

	public static void printArray(int a[]){
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+", ");
		}
		System.out.println();
	}

	public static int[] getSortedArray(){
		int[] a = new int[4];
		a[0] = 1;
		a[1] = 2;
		a[2] = 3;
		a[3] = 4;
		return a;
	}
}
