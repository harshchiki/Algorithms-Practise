package arrays;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 * Find all possible pairs of elements in an array, (a,b)
 * such that a%b = k (k is given)
 */
public class PairsWhoseModIsK {
	int[] a;
	int k;
	Map<Integer, List<Integer>> map = new HashMap<>();
	
	public PairsWhoseModIsK(int[] a, int k) {
		this.a = a;
		this.k = k;
	}
	
	int getCountOfPairs() {
		int count = 0;
		populateMap();
		for(int i = 0;i<a.length;i++) {
			int thisMod = a[i] % k;
			Integer reqKey = Integer.valueOf(k-thisMod);
			if(map.containsKey(reqKey)) {
				if(thisMod == (k/2)) {
					count += map.get(reqKey).size()-1;
				}else {
					count += map.get(reqKey).size();
				}
			}
		}
		return count;
	}
	
	void populateMap() {
		for(int i = 0;i<a.length; i++) {
			Integer thisMod = Integer.valueOf(a[i] % k);
			if(map.containsKey(thisMod)) {
				map.get(thisMod).add(Integer.valueOf(i));
			}else {
				List<Integer> l = new LinkedList<Integer>();
				l.add(Integer.valueOf(i));
				map.put(thisMod, l);
			}
		}
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5};
		int k = 2;
		PairsWhoseModIsK o = new PairsWhoseModIsK(a, k);
		System.out.println(o.getCountOfPairs());
	}
}
