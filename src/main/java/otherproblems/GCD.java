package otherproblems;

public class GCD {
	int a,b;
	
	GCD(int a, int b){
		this.a = a;
		this.b = b;
	}
	
	int getGCD(int x, int y) {
		if(x == 0 || y == 0) {
			return 0;
		}
		if(x == 1 || y == 1) {
			return 1;
		}
		if(x == y) {
			return x;
		}
		if(x>y) {
			return getGCD(x-y, y);
		}else {
			return getGCD(y-x, x);
		}
	}
	
	public static void main(String[] args) {
		GCD g = new GCD(25,35);
		System.out.println(g.getGCD(25, 35));
	}
}
