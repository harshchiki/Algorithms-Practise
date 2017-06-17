package trees;

public class SegmentTreeApplications {
	boolean logEnabled = false;
	public static void main(String[] args) {
		int[] arr =  new int[]{ 1,3,5,7,9,11 };
		SegmentTreeApplications o = new SegmentTreeApplications();
		SegmentTreeNode sumSegmentTree = o.buildSumSegmentTree(arr, 0, arr.length-1);

		/* Now the implementation of segment tree using an array 
		 * (array representing segment tree */

		int[] sumSegmentTreeArray = new int[2*arr.length+1];
		o.populateArrayAsSegmentTreeForSum(sumSegmentTreeArray, arr, 0, arr.length-1, 0);
		System.out.println("Sum from 1 to 3 is: "
				+o.getSumForRange(sumSegmentTreeArray, 0, 0, arr.length-1, 1, 3));
		o.updateSumSegmentTree(sumSegmentTreeArray, 0, 0, arr.length-1, 2, 6);
		System.out.println("Sum from 1 to 3 after update is: "
				+o.getSumForRange(sumSegmentTreeArray, 0, 0, arr.length-1, 1, 3));
		
		
		/*
		 * For minimum
		 */
		int[] minSegmentTreeArray = new int[2*arr.length+1];
		o.populateArrayAsSegmentTreeForMinimum(minSegmentTreeArray, arr, 0, arr.length-1, 0);
		System.out.println("****************************");
		System.out.println("****************************");
		System.out.println("Min Seg tree");
		for(int i : minSegmentTreeArray){
			System.out.print(i+" ");
		}
		System.out.println();
		System.out.println("Min from 1 to 3 are "+o.getMinimumForRange(minSegmentTreeArray, 0, 0, arr.length-1, 1, 3));
		o.updateMinSegmentTreeArray(minSegmentTreeArray, 0, 0, arr.length-1, 2, -4);
		System.out.println("Min from 1 to 3, after update is "+o.getMinimumForRange(minSegmentTreeArray, 0, 0, arr.length-1, 1, 3));
	}
	
	
	void updateMinSegmentTreeArray(int[] tree, int treeIndex, int start, int end, int arrIndex, int value){
		if(start == end){
			tree[treeIndex] = value;
			return;
		}
		
		int mid = start + (end-start)/2;
		
		if(arrIndex > mid){
			updateMinSegmentTreeArray(tree, 2*treeIndex+2, mid+1, end, arrIndex, value);
		}else{
			updateMinSegmentTreeArray(tree, 2*treeIndex+1, start, mid, arrIndex, value);
		}
		
		int left = tree[2*treeIndex +1];
		int right = tree[2*treeIndex +2];
		
		tree[treeIndex] = left<right?left:right;
	}
	
	void populateArrayAsSegmentTreeForMinimum(int[] tree, int[] src, int start, int end, int treeIndex){
		if(start == end){
			tree[treeIndex] = src[start];
			return;
		}
		
		int mid = start + (end-start)/2;
		
		populateArrayAsSegmentTreeForMinimum(tree, src, start, mid, 2*treeIndex+1);
		populateArrayAsSegmentTreeForMinimum(tree, src, mid+1, end, 2*treeIndex+2);
		
		int left = tree[2*treeIndex+1];
		int right = tree[2*treeIndex+2];
		
		tree[treeIndex] = left<right?left:right;
	}
	
	int getMinimumForRange(int[] tree, int treeIndex, int start, int end, int qStart, int qEnd){
		if(start>qEnd || end<qStart){
			return Integer.MAX_VALUE;
		}
		
		if(qStart>=start && qEnd<=end){
			return tree[treeIndex];
		}
		
		int mid = start+(end-start)/2;
		
		if(qStart > mid){
			// go in right subtree
			getMinimumForRange(tree, 2*treeIndex+2, mid+1, end, qStart, qEnd);
		}else if(qEnd <= mid){
			// go in left subtree
			getMinimumForRange(tree, 2*treeIndex+1, start, mid, qStart, qEnd);
		}
		
		int left = getMinimumForRange(tree, 2*treeIndex+1, start, mid, qStart, qEnd);
		int right = getMinimumForRange(tree, 2*treeIndex+2, mid+1, end, qStart, qEnd);
		return left<right ? left: right;
	}
	

	/*
	 * Good link: https://leetcode.com/articles/recursive-approach-segment-trees-range-sum-queries-lazy-propagation/#1-build-the-tree-from-the-original-data
	 * 
	 */

	void populateArrayAsSegmentTreeForSum(int[] tree, int[] src, int start, int end, int treeIndex){
		try{

			if(start == end){
				tree[treeIndex] = src[start];
				return;
			}

			int mid = start + (end-start)/2;

			populateArrayAsSegmentTreeForSum(tree, src, start, mid, 2*treeIndex+1);
			populateArrayAsSegmentTreeForSum(tree, src, mid+1, end, 2*treeIndex+2);
			
			/* After having the child nodes built (in the recursion calls just above this comment
			 * we propagate the changes above in the merge operation just below this comment
			 */

			tree[treeIndex] = tree[2*treeIndex+1] + tree[2*treeIndex+2];// merge operation
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("arr index exception at "+treeIndex);
		}
	}

	/*
	 * Get sum for a range from the array representing the segment tree
	 * 
	 * Algorithm:
	 * 1.) If this segment is outside, i.e start > qEnd or end < qStart - return null (representation of null)
	 * 2.) If this segment lies within range, i.e. start=>qStart && end <= qEnd -> return this element (since it adds for the contribution to queried range
	 * 3.) else, find middle of start and end - if qStart>mid - recurse in the right subtree else recurse in the left subtree
	 * 4.) find the result of left subtree by recursing using mid right
	 * 5.) find the result of right subtree by recursing using mid left
	 * 5.) merge the results from point 4 and point 6 ( in case of sum, add 
	 */
	int getSumForRange(int[] tree, int treeIndex, int start, int end, int qStart, int qEnd){
		// qStart and qEnd - range queried for
		// start and end for recursive calls to span the tree array

		// segment outside the range
		// if this start right of range OR this end if left of range - return null
		if(start > qEnd || end < qStart){
			return 0; // represents a null node
		}

		// segment completely inside the range
		// we build on segments of the tree which could constitute the range
		if(qStart <= start && qEnd >= end){
			return tree[treeIndex];
		}

		//partial overlap of current segment and query range - recurse deeper
		int mid = start + (end-start)/2;

		if(qStart>mid){
			// go in right subtree
			getSumForRange(tree, 2*treeIndex+2, mid+1, end, qStart, qEnd);
		}else if(qEnd <= mid){
			// go in left subtree
			getSumForRange(tree, 2*treeIndex+1, start, mid, qStart, qEnd);
		}

		// sum from left subtree
		int left = getSumForRange(tree, 2*treeIndex+1, start, mid, qStart, qEnd);

		// sum from right subtree
		int right = getSumForRange(tree, 2*treeIndex+2, mid+1, end, qStart, qEnd);

		return left+right;
	}


	/* UPDATE THE VALUE OF AN ELEMENT
	 * 
	 * To update value at arrIndex in the main array with value val
	 
	 The leaf nodes represent the main array in fact -> hence an update should be done to the leaf node.
	 Once done - change is propagated up to the root (using merge operations)
	 */
	void updateSumSegmentTree(int[] tree, int treeIndex, int start, int end, int arrIndex, int val){
		if(start == end){
			tree[treeIndex] = val; // leaf node so replace the value
			return;
		}
		
		int mid = start+(end-start)/2;
		
		if(arrIndex > mid){
			updateSumSegmentTree(tree, 2*treeIndex+2, mid+1, end, arrIndex, val);
		}else{
			updateSumSegmentTree(tree, 2*treeIndex+1, start, mid, arrIndex, val);
		}
		
		/*Similar to building the segtree as an array - we build the nodes below (in the if section just above this
		 * and propagate the changes above, through merge operation, in the section just below this comment.
		 */
		
		// merge operation
		tree[treeIndex] = tree[2*treeIndex+1]+tree[2*treeIndex+2];		
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

		int mid = (l+r)/2;

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
