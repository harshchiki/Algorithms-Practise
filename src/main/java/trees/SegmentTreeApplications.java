package trees;

public class SegmentTreeApplications {
	boolean logEnabled = true;
	public static void main(String[] args) {
		int[] arr = new int[]{1,3,5,7,9,11};
		SegmentTreeApplications o = new SegmentTreeApplications();
		SegmentTreeNode sumSegmentTree = o.buildSumSegmentTree(arr, 0, arr.length-1);
		
		// get sum of numbers in array from range 1-3
		
//		o.printSegmentTree(sumSegmentTree);
	}
	
	int getSumFromSegmentTree(SegmentTreeNode root, int l, int r){
		if(l>r){
			throw new RuntimeException("Bad indexes for sum, "+l+", "+r);
		}
		int left = root.leftIndex;
		int right = root.rightIndex;
		
		if(l>= left && r <= right){
			//within this range
			// TO DO
		}
		
		return 0;
	}
	
	// get sum by range segment tree
	SegmentTreeNode buildSumSegmentTree(int[] arr, int l, int r){
		log(l,r);
		if(l == r){
			return new SegmentTreeNode(arr[l], l,r);
		}
		
		if(l>r){
			return null;
		}
		
		int mid = l + (r-l)/2;
		
		SegmentTreeNode left = buildSumSegmentTree(arr, l, mid);
		SegmentTreeNode right = buildSumSegmentTree(arr, mid+1, r);
		
		SegmentTreeNode root = new SegmentTreeNode(
				(left!=null?left.data:0) 
				+ (right!=null?right.data:0), 
				l,r);
		root.left = left;
		root.right = right;
		
		return root;
		
	}
	
	void log(int left, int right){
		if(logEnabled){
			System.out.println("Left: "+left+" Right: "+right);
		}
	}
	
	void printSegmentTree(SegmentTreeNode root){
		if(root == null) {
			return;
		}
		
		printSegmentTree(root.left);
		System.out.println("Data: "+root.data+" Left: "+root.leftIndex+" Right: "+root.rightIndex);
		printSegmentTree(root.right);
	}
	
	
	
	class SegmentTreeNode{
		int data;
		int leftIndex;
		int rightIndex;
		SegmentTreeNode left, right;
		
		SegmentTreeNode(int data, int leftIndex, int rightIndex){
			this.data = data;
			this.leftIndex = leftIndex;
			this.rightIndex = rightIndex;
		}
	}
}
