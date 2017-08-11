package bits;

public class CountSetBitsInAnInteger {
	public static void main(String[] args) {
		System.out.println("Count = "+new CountSetBitsInAnInteger().getCount(6));
	}
	
	int getCount(int n) {
		
		int count = 0;
		while(n>0) {
			count += n & 1;
			n >>= 1;
			System.out.println(n);
		}
		return 0;
	}
}
