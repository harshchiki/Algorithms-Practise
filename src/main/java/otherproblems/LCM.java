package otherproblems;

public class LCM {
	int getLCM(int a, int b) {
		GCD g = new GCD(a,b);
		return (a*b)/g.getGCD(a, b);
	}
	public static void main(String[] args) {
		LCM m = new LCM();
		System.out.println(m.getLCM(25, 35));
	}

}
