package string;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/*
 * You have an infinite stream of characters
 * 
 * A given set of strings at bootup.
 * 
 * At any point of time, give me the number of occurences of each given string.
 */
public class LookupStringsInAnInfiniteStream {
	Map<String, Integer> map = new HashMap<>();
	Map<String, Integer> matchesMap = new HashMap<>();
	
	public void checkAndIncrement(char x){
		
		Iterator<Entry<String, Integer>> entryIterator = map.entrySet().iterator();
		
		
		while(entryIterator.hasNext()){
			Entry<String, Integer> e = entryIterator.next();
			String key = e.getKey();
			int matches = e.getValue().intValue();
			
			if(key.charAt(matches+1) == x){
				if((key.length()-1)==(matches+1)) {
					if(matchesMap.containsKey(key)){
						matchesMap.put(key, 
								Integer.valueOf(matchesMap.get(key).intValue()+1));
					}else{
						matchesMap.put(key, Integer.valueOf(1));
					}
					System.out.println("Found match for "+key+ " for "+matchesMap.get(key)+" number of times");
					map.put(key, Integer.valueOf(-1));
				}else{
					map.put(key, Integer.valueOf(matches+1));
				}
			}else{
				map.put(key, Integer.valueOf(-1));
			}
		}
	}
	
	public static void main(String[] args) {
		LookupStringsInAnInfiniteStream o = new LookupStringsInAnInfiniteStream();
		System.out.println("Enter the number of string to check");
		Scanner sc = new Scanner(System.in);
		int nS = Integer.parseInt(sc.nextLine());
		System.out.println("No of strings : "+nS);
		for(int i = 0;i<nS;i++){
			System.out.println("Enter string: "+i);
			o.map.put(sc.nextLine(), Integer.valueOf(-1));
		}
		
		System.out.println("Begin the character stream");
		while(true){
			char next = sc.nextLine().toCharArray()[0];
			o.checkAndIncrement(next);
		}
	}
}
