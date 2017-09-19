package search;

public class SearchInARotatedSortedArray {
	
	public static void main(String[] args) {
		System.out.println("Searching for 1");
		System.out.println(new SearchInARotatedSortedArray().pivotedBinarySearch(new int[]{3,4,5,1,2},1));
		System.out.println("Searching for 2");
		System.out.println(new SearchInARotatedSortedArray().pivotedBinarySearch(new int[]{3,4,5,1,2},2));
		System.out.println("Searching for 3");
		System.out.println(new SearchInARotatedSortedArray().pivotedBinarySearch(new int[]{3,4,5,1,2},3));
		System.out.println("Searching for 4");
		System.out.println(new SearchInARotatedSortedArray().pivotedBinarySearch(new int[]{3,4,5,1,2},4));
		System.out.println("Searching for 5");
		System.out.println(new SearchInARotatedSortedArray().pivotedBinarySearch(new int[]{3,4,5,1,2},5));
		
	}

	int pivotedBinarySearch(int[] a, int key) {
		int pivot = findPivot(a, 0, a.length-1);
		System.out.println("Pivot = "+pivot);
		if(pivot == -1) {
			return BinarySearch.binarySearch(a, 0, a.length-1, key);
		}
		
		if(a[pivot] == key) {
			return pivot;
		}
		
		// given that we have a pivot in hand here
		// idea of looking to the left of pivot makes sense
		// only when the first element is less than key.
		// this is because element (not elements) to the right
		// of pivot is smaller than the a[pivot]
		// so certainly the element at the last position is
		// smaller than the first element in the array
		// So, if first element is less than key, we have to look at values
		// smaller than first element, which certainly would
		// exist on the right of the pivot.
		if(a[0] <= key) {
			return BinarySearch.binarySearch(a, 0, pivot-1,  key);
		}
		
		
		// obviously, we are left with only one condition,
		// where right of the pivot elements are to be considered.
		return BinarySearch.binarySearch(a, pivot+1, a.length-1, key);
	}
	
	/*
	 * pivot element is the only element of which the immediate right element is smaller
	 * for eg 3,4,5,1,2
	 * 5 is the pivot
	 */
	int findPivot(int[] a, int low, int high) {
		
		if(high < low) return -1;
		
		if(high == low) return low;
		
		int mid = low + (high-low)/2;
		
		// immediate right element is smaller, given there is an element on the right
		// mid < high -> there is atleast one element on the right
		// a[mid] >  a[mid+1] is self explanatory
		if(mid < high && a[mid] > a[mid+1]) {
			pivotLog(low, high, mid);
			System.out.println("FINDPIVOT: Returning "+mid);
			return mid;
		}
		
		// suppose there are no elements to the right
		// then we check on our left
		// elements will exist on our left, only is mid > low 
		// so checking the elment immediatelyl to the left of mid, is by a[mid] < a[mid-1]
		// since the element next to pivot has to be smaller, a[mid] has to be smaller than a[mid-1] 
		// so that (mid-1) is the pivot
		if(mid > low && a[mid] < a[mid-1]) {
			pivotLog(low, high, mid);
			System.out.println("FINDPIVOT: Returning "+(mid-1));
			return (mid-1);
		}
		
		// if neither of the conditions meet,
		// we go to the left sub array.
		// benefit of going to the left array 
		// does not exist, if a[low] < a[mid]
		// so we go to the left sub array only
		// if a[low] > a[mid] (to break the ascending order)
		if(a[low] >= a[mid]) {
			return findPivot(a, low, mid-1);
		}
		
		// similarly we could go right, is a[low] < a[mid]
		// since that is the only option left, at this stage
		return findPivot(a, mid+1, high);
	}
	
	void pivotLog(int low, int high, int mid) {
		System.out.println("low = "+ low + " high = "+high+" mid = "+mid);
	}
}
