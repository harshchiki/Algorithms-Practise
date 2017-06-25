package arrays;

/*
 * Prob: Count the number of inversions in the array
 * eg. {6,1,9,2,4}
 * we need count only, not pairs.
 * (6,1), (6,2), (6,4), (9,2), (9,4) -> 5
 * 
 * Inversion count of an array defines how close or how far the array is sorted.
 */
public class CountNumberOfInversions {
	class UsingMergeSort{

		int getCountOfInversionsUsingMergeSortApproach(int[] a,int[] tmp, int start, int end){
			if(end > start){
				int count = 0;
				int mid = (start+end)/2;
				count += getCountOfInversionsUsingMergeSortApproach(a, tmp, start, mid);
				count += getCountOfInversionsUsingMergeSortApproach(a, tmp, mid+1, end);

				count += merge(a, tmp, start, mid+1, end);
				return count;
			}
			else{
				return 0;
			}
		}

		// merging 2 sorted arrays
		int merge(int[] a, int[] tmp, int start, int mid, int end){
			int count = 0;

			int i = start, j = mid, mainIndex = start;

			while((i<=mid-1) && (j<=end)){
				if(a[i]<=a[j]){
					tmp[mainIndex++] = a[i++];
				}else{
					tmp[mainIndex++] = a[j++];
					
					// all elements to the right of i (because it is sorted), will be greater than 
					// this element at j index.
					count += mid-i;
				}
			}

			while(i <mid){
				tmp[mainIndex++] = a[i++];
			}

			while(j<end){
				tmp[mainIndex++] = a[j++];
			}

			for(int p = start; p <= end; p++){
				a[p] = tmp[p];
			}

			return count;
		}

	}
	public static void main(String[] args) {
		int[] a = {6,1,9,2,4};
		int[] tmp = new int[a.length];
		CountNumberOfInversions.UsingMergeSort o = new CountNumberOfInversions().new UsingMergeSort();
		System.out.println("Using Merge Sort aproach"+o.getCountOfInversionsUsingMergeSortApproach(a, tmp, 0, a.length-1));
	}
}
