package string;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CheckDuplicateInInfiniteStream {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		Set<Integer> hashSet = new HashSet<Integer>();
		
		while(true){
			String str = sc.nextLine();
			Integer hashCode = Integer.valueOf(str.hashCode());
			
			if(hashSet.contains(hashCode)){
				System.out.println(str +" is duplicate");
			}else{
				hashSet.add(hashCode);
			}
		}
	}
}
