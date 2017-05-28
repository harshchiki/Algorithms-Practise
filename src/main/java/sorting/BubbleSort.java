package sorting;

public class BubbleSort {
	public static void main(String[] args) {
		int[] arr = new int[]{4,2,6,1,7};
		System.out.println("Unsorted");
		for(int i : arr){
			System.out.print(i+" ");
		}
		
		System.out.println("***************************");
		
		int[] sortedArray = bubbleSort(arr);
		
		System.out.println("Sorted");
		for(int i : sortedArray){
			System.out.print(i+" ");
		}
	}
	
	/**
	 * With every iteration, the larger numbers keep shifting to the right
	 * Hence, j runs from 0 to length-i-1, since the array is already sorted
	 * after that index.
	 * 
	 * j approaches left (in terms of elements it spans)
	 * 
	 * Bubbling up the larger number
	 * 
	 * Characteristic of this algo is, it compare this and the next element.
	 * 
	 * @param arr
	 * @return
	 */
	static int[] bubbleSort(int[] arr){
		int length = arr.length;
		
		for(int i=0;i<length-1;i++){
			for(int j=0;j<length-i-1;j++){
				if(arr[j]>arr[j+1]){
					int tmp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = tmp;
				}
			}
		}
		return arr;
	}
}
