package arrays;

public class RemoveDuplicatesFromSortedArray {
	public static void main(String[] args) {
		System.out.println(new RemoveDuplicatesFromSortedArray().removeDuplicatesAndGetSize(new int[]{1,2,2,3,4,5,5}));
	}
	
	int removeDuplicatesAndGetSize(int[] a) {
		int n = a.length;
		
		if(n==0 || n==1) return n;
		
		int j = 0;
		
		for(int i = 0;i<n-1;i++) {
			if(a[i] != a[i+1]) {
				a[j++] = a[i];
			}
		}
		
		
		a[j++] = a[n-1];
		for(int i = 0;i<j;i++) {
			System.out.println(a[i]);
		}
		System.out.println();
		return j;
	}
}
