package arrays;

import java.util.Arrays;

public class Merge2SortedArraysInPlace {
	public static void main(String[] args) {
		int[] a1 = new int[]{1,5,9,10,15,20};
		int[] a2 = new int[]{2,3,8,13};
		
		
		new Merge2SortedArraysInPlace().merge(a1, a2);
		for(int i : a1){
			System.out.print(i+" ");
		}
		System.out.println();
		for(int i : a2){
			System.out.print(i+" ");
		}
	}
	
	void merge(int[] a1, int[] a2){
		int l1 = a1.length;
		int l2 = a2.length;
		
		for(int i = 0;i<l1;i++){
			for(int j = l2-1; j>=0; j--){
				if(a2[j] < a1[i]){
					swap(a1,a2,i,j);
				}
			}
		}
		
//		Arrays.sort(a2);
	}
	
	void swap(int[] a1, int[] a2, int i, int j){
		int tmp = a1[i];
		a1[i] = a2[j];
		a2[j] = tmp;
	}
}
