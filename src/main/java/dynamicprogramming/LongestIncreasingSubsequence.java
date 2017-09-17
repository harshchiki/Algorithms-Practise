package dynamicprogramming;

public class LongestIncreasingSubsequence {
	public static void main(String[] args) {
		System.out.println(new LongestIncreasingSubsequence().getLengthOfLongestIncreasingSubsequence(new int[] {10,22,9,33,21,50,41,60,80}));
	}

	int getLengthOfLongestIncreasingSubsequence(int[] a) {
		int lengthOfCurrentIncresingSequence = 1;
		int lengthOfLISSoFar = 1;
		int prevElement = a[0]; // updated in all cases
		int index = 0; // keeps track of where the sequence starts
		
		for(int i = 0;i<a.length;i++) {
			if(a[i] > prevElement) {
				lengthOfCurrentIncresingSequence++;
				prevElement = a[i];
			}else {
				lengthOfCurrentIncresingSequence = 1;
				prevElement = a[i];
			}
			if(lengthOfLISSoFar != max(lengthOfLISSoFar, lengthOfCurrentIncresingSequence)) {
				index = i;
			}
			lengthOfLISSoFar = max(lengthOfLISSoFar, lengthOfCurrentIncresingSequence);
			System.out.println("maxSoFar is "+ lengthOfLISSoFar);
		}
		System.out.println("Length = "+lengthOfLISSoFar+" starting in the array from "+(index-lengthOfLISSoFar+1));
		return lengthOfLISSoFar;
	}
	
	int max(int a, int b) {
		return a>b ? a:b;
	}
}
