package sorting;

/**
 * Divide and conquer algo
 * 
 * Much much faster than Bubble sort, 
 * and is highlighted when the number objects 
 * to sort is large.
 * 
 *Time: O(n log n)
 */
public class MergeSort {
	public static void main(String[] args) {
		int[] arr = new int[]{5,9,1,7,3,2,10};
		mergeSort(arr,0,arr.length);
		System.out.println("Sorted:");
		for(int i : arr){
			System.out.print(i+" ");
		}
	}

	static void mergeSort(int[] arr, int left, int right){
		if(right >  left){
			int middle = (left+right)/2;
			
			mergeSort(arr,left, middle);
			mergeSort(arr,middle+1, right);
			merge(arr, left, middle, right);
		}
	}
	
	/**
	 * received here are basically 2 "sorted" arrays
	 * 
	 * 
	 * @param a
	 * @param left
	 * @param middle
	 * @param right
	 */
	static void merge(int[] a, int left, int middle, int right){
		int l1 = middle - left ;
		int l2 = right - middle;
		
		int[] L = new int[l1];
		int[] R = new int[l2];
		
		int j = 0;
		for(int i = left;i<middle;i++){
			L[j++] = a[i];
		}
		
		j = 0;
		
		for(int i=middle;i<right;i++){
			R[j++] = a[i];
		}
		
		
		int leftIndex = 0, rightIndex = 0, mainCounter = left;
		
		while(leftIndex < l1 && rightIndex <l2){
			if(L[leftIndex] < R[rightIndex]){
				a[mainCounter++] = L[leftIndex++];
			}else{
				a[mainCounter++] = R[rightIndex++];
			}
		}
		
		while(leftIndex<l1){
			a[mainCounter++] = L[leftIndex++];
		}
		
		while(rightIndex < l2){
			a[mainCounter++] = R[rightIndex++];
		}
	}
}
