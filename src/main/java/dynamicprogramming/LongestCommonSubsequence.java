package dynamicprogramming;

import java.util.Arrays;

public class LongestCommonSubsequence {
	char[] s1, s2;
	
	public LongestCommonSubsequence(String s1, String s2) {
		this.s1 = s1.toCharArray();
		this.s2 = s2.toCharArray();
	}
	
	int getLengthOfLongestCommonSubsequence() {
		int l1 = s1.length, l2 = s2.length; // s1.length -> no. cols, s2.length -> no.of rows
		int[][] table = new int[l2+1][l1+1];
		
		for(int i = 0;i<l1;i++) {
			table[0][i] = 0;
		}
		
		for(int i = 0;i<l2;i++) {
			table[i][0] = 0;
		}
		
		for(int i = 0;i<l2;i++) { // s2
			for(int j = 0;j<l1;j++) { //s1
				if(s1[j] == s2[i]) {
					table[i+1][j+1] = 1+table[i][j];
				}else {
					table[i+1][j+1] = max(table[i+1][j], table[i][j+1]);
				}
			}
		}
		
		return table[l2][l1];
	}
	
	int max(int a, int b) {
		return a > b ? a : b;
	}
	
	public static void main(String[] args) {
		LongestCommonSubsequence l = new LongestCommonSubsequence("abcdh", "aedfhr");
		System.out.println(l.getLengthOfLongestCommonSubsequence());
	}
}
