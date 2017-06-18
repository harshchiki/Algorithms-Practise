package dynamicprogramming;

public class LongestPalindromicSubstring {
	int lo, maxLen;
	public static void main(String[] s){
		System.out.println(new LongestPalindromicSubstring().longestPalindrome("babad"));
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
