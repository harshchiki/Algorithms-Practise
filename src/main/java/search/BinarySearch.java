package search;

public class BinarySearch {
	public static void main(String[] args) {
		int[] a = new int[]{2,3,4,5,6};
		System.out.println(binarySearch(a, 0, a.length-1,3));
	}
	
	static int binarySearch(int[] a, int l, int r, int x){
		while(l<=r){
			int mid = (l+r)/2;
			
			if(a[mid] < x){
				l = mid+1;
			}
			
			if(a[mid] > x){
				r = mid-1;
			}
			
			if(a[mid] == x){
				return mid;
			}
		}
		return -1;
	}
}
