package otherproblems;

public class NumberToString {
	public static void main(String[] args) {
		System.out.println(new NumberToString().getString(String.valueOf(345)));
	}
	
	String getString(String given) {
		switch(given.length()) {
		case 2:
			char extreme = given.charAt(0);
			int digit = Integer.parseInt(extreme+"");
			
		}
		return "";
	}
	
	
}
