package sorting;

/*
 * Repeatedly finds the minimum elements and places it at the beginning
 * So 2 portions left, one is a sorted sub array, other is an unsorted sub array
 */
public class SelectionSort {
	public static void main(String[] args) {
		int[] a = new int[]{2,5,3,8};
		SelectionSort s = new SelectionSort();
		s.printArray(a);
		s.selectionSort(a);
		s.printArray(a);
	}
	
	void printArray(int[] a){
		for(int i = 0;i< a.length;i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	
	void selectionSort(int[] a){
		for(int i = 0;i<a.length-1;i++){
			int minIndex = i;
			for(int j = i+1;j<a.length;j++){
				if(a[j] < a[minIndex]){
					minIndex = j;
				}
			}
			swap(a, minIndex, i);
		}
	}
	
	void swap(int[] a, int i, int j){
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
}	
