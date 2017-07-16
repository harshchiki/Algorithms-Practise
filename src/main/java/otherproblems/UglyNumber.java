package otherproblems;

/*
 * http://www.geeksforgeeks.org/ugly-numbers/
 * An ugly number is a number, whose prime factors are 2,3 or 5.
 * 
 * Input: n
 * Output: nth ugly number starting from 1. (By convention, 1 is included as an ugly number)
 */
public class UglyNumber {
	public static void main(String[] args) {
		System.out.println(new UglyNumber().getUglyNumber(150));
	}
	
	int getUglyNumber(int n) {
		int i = 1;
		int count = 1; // ugly number count 

		while(n > count) {
			i += 1;
			if(isUgly(i) == 1) {
				count++;
			}
		}
		return i;
	}

	int isUgly(int p) {
		p = maxDivide(p,2);
		p = maxDivide(p,3);
		p = maxDivide(p,5);
		return (p == 1)?1:0;
	}

	/*This function divides a by greatest divisible 
    power of b*/
	int maxDivide(int a, int b)
	{
		while(a % b == 0)
			a = a/b;
		return a;
	}
}
