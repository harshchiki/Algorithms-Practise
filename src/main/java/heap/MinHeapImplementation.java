package heap;

import java.util.Arrays;

public class MinHeapImplementation {
	int[] heap;
	int length;
	public static void main(String[] args) {
		int[] a = new int[] {6,5,4,3,2,9};
		MinHeapImplementation minHeap = new MinHeapImplementation(a);
		System.out.println(minHeap.extractMin());
		minHeap.insert(-1);
		System.out.println(minHeap.extractMin());
		minHeap.insert(-5);
		System.out.println(minHeap.extractMin());
		System.out.println(minHeap.extractMin());
		System.out.println(minHeap.extractMin());
		System.out.println(minHeap.extractMin());
	}
	
	public void print() {
		System.out.println();
		Arrays.stream(heap).forEach(item -> System.out.print(item+" "));
		System.out.println();
	}
	
	
	MinHeapImplementation(int[] a){
		length = a.length+1;
		buildMinHeap(a);
	}
	
	private void buildMinHeap(int[] a){
		heap = new int[a.length+1];
		for(int i = 0;i<a.length;i++) {
			heap[i+1] = a[i];
		}
		
		for(int i = a.length/2;i>0;i--) {
			minHeapify(heap, i, heap.length-1);
		}
	}
	
	public int getMin() {
		return heap[1];
	}
	
	public int extractMin() {
		int min = heap[1];
		length--;
		
		int[] newHeap = new int[heap.length-1];
		for(int i = 2;i<heap.length;i++) {
			newHeap[i-1] = heap[i];
		}
		
		for(int i = newHeap.length/2;i>0;i--) {
			minHeapify(newHeap, i, newHeap.length-1);
		}
		heap = newHeap;
		return min;
	}
	
	public void insert(int n) {
		int[] newHeap = new int[heap.length+1];
		newHeap[1] = n;
		for(int i = 1;i<heap.length;i++) {
			newHeap[i+1] = heap[i];
		}
		
		for(int i = (newHeap.length-1)/2;i>0;i--) {
			minHeapify(newHeap, 1, newHeap.length-1);
		}
		heap = newHeap;
	}
	
	private void minHeapify(int[] heap, int index, int length) {
		int leftIndex = 2*index;
		int rightIndex = leftIndex + 1;
		
		int smallest;
		
		if(leftIndex < length
				&& heap[leftIndex] < heap[index]) { 
			smallest = leftIndex;
		}else {
			smallest = index;
		}
		
		
		// heap[rightIndex] is to be compared with heap[smallest] not heap[index]
		if(rightIndex < length
				&& heap[rightIndex] < heap[smallest]) {
			smallest = rightIndex;
		}
		// no else condition like that in left
		
		if(smallest != index) {
			swap(heap, index, smallest);
			minHeapify(heap, smallest, length);
		}
			
	}

	private void swap(int[] heap, int index, int smallest) {
		int tmp = heap[smallest];
		heap[smallest] = heap[index];
		heap[index] = tmp;
	}
}
