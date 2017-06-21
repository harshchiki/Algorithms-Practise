package dynamicprogramming;

/*
 * Approach 1: Brute Force - find all substring - check if palindrome - retain max at every iteration
 * 
 * Approach 2: Recursion
 * {
 * if start == end -> return 1;
 * 
 * if char[start] == char[end] && j == (i+1) -> return 2;
 * 
 * if(char[start] == char[end) -> return lps(characters, start+1, end-1) +2;
 * 
 * return max(lps(characters, start+1, end), lps(characters, start, end-1)) 
 * }
 * 
 * Approach 3: Memoization
 * remember the results and apply in the recursive approach (approach 2) -
 * would save a few CPU cycles
 * 
 *  Approach 4: Manacher's algorithm 
 *  Time Complexity: O(n)
 */
public class LongestPalindromicSubstring {
	int lo, maxLen;
	public static void main(String[] s){
//		System.out.println(new LongestPalindromicSubstring().longestPalindrome("babad"));
		String str = "dfsfvdbabaddfsfg";
		System.out.println(new LongestPalindromicSubstring()
				.getLengthOfLongestPalindrome(str.toCharArray(), 0,(str.length()-1)));
	}

	int getLengthOfLongestPalindrome(char[] a, int start, int end){
		if(start<0 || end < 0) {
			return 0;
		}
		
		if(start == end){
			return 1;
		}
		
		if (start>end){
			return -1;
		}
		
		if(a[start] == a[end]){
			return getLengthOfLongestPalindrome(a, start+1, end-1)+2;
		}else{
			return max(getLengthOfLongestPalindrome(a, start, end-1),
					getLengthOfLongestPalindrome(a, start+1, end));
		}
		
	}
	
	int max(int a, int b){
		return a>b?a:b;
	}
	
	public String longestPalindrome(String s) {
		String pal = "";
		int length = s.length();
		for(int from = 0;from<length-pal.length();from++){
			for(int to=from;to<length;to++){
				String substring = s.substring(from,  to+1);
				pal = palindromeAndLonger(substring, pal);
			}
		}
		return pal;
	}

	private String palindromeAndLonger(String s, String ex){
		return s.length()>ex.length() && s.equals((new StringBuffer(s)).reverse().toString())?s:ex;
	}
	
	/**
	 * below method - provided by someone else online.
	 * @param s
	 * @return
	 */
	public String longestPalindrome1(String s) {
		int len = s.length();
		if (len < 2)
			return s;
		
	    for (int i = 0; i < len-1; i++) {
	     	extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
	     	extendPalindrome(s, i, i+1); //assume even length.
	    }
	    return s.substring(lo, lo + maxLen);
	}

	private void extendPalindrome(String s, int j, int k) {
		while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
			j--;
			k++;
		}
		if (maxLen < k - j - 1) {
			lo = j + 1;
			maxLen = k - j - 1;
		}
	}
	class IndexPair{
		int from, to;
		IndexPair(int from, int to){this.from = from;this.to= to;}
	}
}
