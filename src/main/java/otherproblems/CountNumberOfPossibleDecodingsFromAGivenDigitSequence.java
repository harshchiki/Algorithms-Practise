package otherproblems;

/*
 * http://www.geeksforgeeks.org/count-possible-decodings-given-digit-sequence/
 */
public class CountNumberOfPossibleDecodingsFromAGivenDigitSequence {

	public static void main(String[] args) {
		CountNumberOfPossibleDecodingsFromAGivenDigitSequence o = new CountNumberOfPossibleDecodingsFromAGivenDigitSequence();
		String str = "1234";
		System.out.println(o.getCount(str.toCharArray(), str.length()));
	}
	int getCount(char[] digits, int length) {
		int count = 0;
		if(length == 0 || length == 1) {
			return 1;
		}
		
		// considering singles
		if(digits[length-1] > '0') {
			count = getCount(digits, length-1);
		}
		
		// considering doubles
		if(digits[length-2] == '1' || (digits[length-2] == '2' && digits[length-1] < '7')) {
			count += getCount(digits, length-2);
		}
		
		return count;
	}
}
