package otherproblems;

//import heap.MinHeapImplementation;

/*
 * http://www.geeksforgeeks.org/connect-n-ropes-minimum-cost/
 */
public class MinimumCostToConnectNRopes {

//	public static void main(String[] args) {
//		int[] pipes = new int[]{4,2,3,6};
//		System.out.println("Minimum Cost = "
//				+ new MinimumCostT oConnectNRopes().minCost(pipes));
//	}
//
//	int minCost(int[] pipes){
//		MinHeapImplementation minHeap = new MinHeapImplementation(pipes);
//
//		while(minHeap.getSize()>1){
//			int p1 = minHeap.extractMin();
//			System.out.println("P1 = "+p1);
//			int p2 = 0;
//			if(minHeap.getSize()==1){
//				System.out.println(" in 1");
//				printHeaps(minHeap);
//				return minHeap.getMin()+p1;
//			}else{
//				
//				p2 = minHeap.extractMin();
//				System.out.println("P2 = "+p2);
//				minHeap.insert(p1+p2);
//			}
//			System.out.println();
//		}
//		System.out.println("Outer");
//		printHeaps(minHeap);
//		return minHeap.getMin();
//	}
//
//	private void printHeaps(MinHeapImplementation minHeap) {
//		minHeap.printHeap();
//		minHeap.printHeapArray();
//	}
}
