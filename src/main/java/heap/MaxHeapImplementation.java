package heap;

public class MaxHeapImplementation {

	int[] heap;
	int length;
	public static void main(String[] args) {
		int[] a = new int[]{9,7,5,2};
		
		
		MaxHeapImplementation o = new MaxHeapImplementation();
		o.length = a.length;
		o.heap = o.buildMaxHeap(a);
		System.out.println();
		o.getMax();
		o.extractMin();
		o.insert(18);
		o.delete();
		o.printHeap();
	}
	
	void printHeap(){
		System.out.println("********************");
		for(int i = 1;i<heap.length;i++){
			if(heap[i] != Integer.MAX_VALUE){
				System.out.print(heap[i]+" ");
			}
		}
		System.out.println();
		System.out.println("********************");
	}
	int getMax(){
		System.out.println("Max = "+heap[1]);
		return heap[1];
	}
	
	int extractMin(){
		int min = heap[1];
		length--;
		heap[1] = Integer.MAX_VALUE;
		maxHeapify(heap, 1, length);
		
		return min;
	}
	
	void insert(int value){
		int[] newHeap = new int[heap.length+1];
		newHeap[1] = value;
		int j = 2;
		for(int i = 1;i<heap.length;i++){
			newHeap[j++] = heap[i];
		}
		heap = newHeap;
		maxHeapify(heap, 1, heap.length-1);
	}
	
	void delete(){
		extractMin();
	}
	
	int[] buildMaxHeap(int[] a){
		int n = a.length;
		int[] heap = new int[n+1];
		for(int i = 0;i<a.length;i++){
			heap[i+1] = a[i];
		}
		for(int i = n/2;i>0;i--){
			maxHeapify(heap, i, a.length);
		}
		
		for(int i = 1; i< heap.length; i++) {
			System.out.print(heap[i]+" ");
		}
		
		return heap;
	}
	
	void maxHeapify(int[] a, int i, int length){
		int leftIndex = 2*i;
		int rightIndex = 2*i+1;
		
		int largest;
		if(leftIndex <= length // boundary condition
				&& a[leftIndex] > a[i]){
			largest = leftIndex;
		}else{
			largest = i;
		}
		
		if(rightIndex <= length && a[rightIndex] > a[largest]){
			largest = rightIndex;
		}
		
		if(largest != i){
			swap(a, i, largest);
			maxHeapify(a, largest, length);
		}
	}
	
	void swap(int[] a, int i, int j){
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

}
