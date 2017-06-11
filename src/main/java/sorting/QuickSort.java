package sorting;

public class QuickSort {
	public static void main(String[] args) {
		int [] a = new int[]{10,9,5,6};
//		int [] a = new int[]{6,7,8,9};
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
	}
	
	static void quickSort(int[] a, int start, int end){
		if(start > end) return;
		
		int pivot = partition(a, start, end);
		
		quickSort(a,start, pivot-1);
		quickSort(a, pivot+1, end);
	}
	
	static int partition(int[] a, int start, int end){
		int pivot = a[end];
		int i = start-1;
		
		for(int j = start; j<end;j++){
			if(a[j] <= pivot){
				i++;
				int tmp = a[i];
				a[i] = a[j];
				a[j] = tmp;
			}
		}
		
		int tmp = a[end];
		a[end] = a[i+1];
		a[i+1] = tmp; // the pivot
		
		return i+1;
	}
}
