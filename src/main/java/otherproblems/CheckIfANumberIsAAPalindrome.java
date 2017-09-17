package otherproblems;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class CheckIfANumberIsAAPalindrome {
	public static void main(String[] args) {
		CheckIfANumberIsAAPalindrome c = new CheckIfANumberIsAAPalindrome();
		int number = 12321;
		int divisor = c.getDivisor(number);
		System.out.println("Divisor = "+divisor);
		System.out.println(c.isPalindrome(number, divisor));
	}
	
	// Time: O(n), Space: O(1)
	int getDivisor(int n) {
		int length = 1;
		while(n >9) {
			n /= 10;
			length++;
		}
		
		int divisor = 1;
		for(int i = 1;i<length;i++) {
			divisor *= 10;
		}
		return divisor;
	}
	
	// Time: O(n), Space: O(1)
	boolean isPalindrome(int num, int divisor) {
		if(num < 10) {
			return true;
		}
		
		int first = num/divisor;
		int last = num % 10;
		
		if(first != last) {
			return false;
		}
		
		return isPalindrome(first % divisor,
				divisor / 10);
	}
}
