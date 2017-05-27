package string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CheckAnagramInInfiniteSequence {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Set<Integer> hashSet = new HashSet<Integer>();
		
		
		while(true){
			String str = sc.nextLine();
			
			/* convert to character array */
			char[] atrArray = str.toCharArray();
			
			/* sort the characters (all anagram strings are same is sorted)*/
			Arrays.sort(atrArray);
			
			/* lookup to a set of hashCodes (strings are imuutable and in a run, hashCodes will be same*/
			String sortedString = String.valueOf(atrArray);
			Integer hashCode = Integer.valueOf(sortedString.hashCode());
			
			if(hashSet.contains(hashCode)){
				System.out.println("Anagram of "+str+" has already been found");
			}else{
				hashSet.add(hashCode);
			}
		}
	}
}
