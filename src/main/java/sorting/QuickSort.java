package sorting;

/*
 * Time: O(n log n)
 */
public class QuickSort {
	public static void main(String[] args) {
//		int [] a = new int[]{10,9,5,6};
//		int [] a = new int[]{2,8,3,7};
//		int [] a = new int[]{6,7,8,9};
		
		int [] a = new int[]{6,5,4,3,2,1};
		
		printArray(a);
		System.out.println();
//		System.out.println("partition = "+partition(a,0,a.length-1));
//		printArray(a);
		quickSort(a, 0, a.length-1);
		printArray(a);
	}

	static void printArray(int[] a){
		for(int i = 0;i< a.length;i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	
	static void quickSort(int[] a, int start, int end){
		if(start > end) return;
		System.out.println();
		System.out.println("Next Iteration");
		int pivot = partition(a, start, end);
		
		quickSort(a,start, pivot-1);
		quickSort(a, pivot+1, end);
	}
	
	static int partition(int[] a, int start, int end){
		System.out.println("Finding pivot");
		int pivot = a[end];
		int i = start-1;
		
		for(int j = start; j<end;j++){
			if(a[j] <= pivot){
				i++;
				System.out.println(" Found less i = "+i+" j = "+j+" swapping "+a[i]+" and "+a[j]);
				swap(a, i, j);
				printArray(a);
			}
		}
		
		System.out.println("Swapping "+a[end]+" and "+a[i+1]);
		int tmp = a[end];
		a[end] = a[i+1];
		a[i+1] = tmp; // the pivot
		printArray(a);
		System.out.println("Pivot found = "+(i+1));
		return i+1;
	}

	private static void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
}
