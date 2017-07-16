package string;

import java.util.HashSet;
import java.util.Set;

public class AllPermutationsOfAString {
	static Set<String> permutations = new HashSet<>();
	public static void main(String[] args) {
		String s = "ABC";
		permute(s,0,s.length());
		System.out.println(permutations.size());
	}
	
	// l = 0, r = string.length().
	static void permute(String s, int l, int r) {
		if(l == r) {
			permutations.add(s);
//			System.out.println(s);
		}else {
			for(int i = l;i<r;i++) {
				s = swap(s,l,i);
				permute(s, l+1, r);
				s = swap(s,l,i);
			}
		}
	}
	
	static String swap(String s, int a, int b) {
		char[] chars = s.toCharArray();
		
		char tmp = chars[a];
		chars[a] = chars[b];
		chars[b] = tmp;
		
		return new String(chars);
	}
}
