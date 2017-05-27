package string;

import java.util.Scanner;

public class AllAnagrams {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		System.out.println("Anagrams for "+str);
		System.out.println("***********************************8");
		printAnagrams(str.toCharArray());
	}

	static void printAnagrams(char[] str){
		if(str.length == 0) {
			return;
		}

		if(str.length == 1){
			System.out.print(str[0]);
		}else{
			for(int i=0;i<str.length;i++){
				String rest = String.copyValueOf(getRestOfChars(str, i));
				System.out.println(str[i] + rest);
			}
		}
	}

	static char[] getRestOfChars(char[] str, int index){
		char[] ret;
		if(str.length == 0){
			ret = new char[1];
			return ret;
		}else{
			ret = new char[str.length-1];
			int k = 0;
			for(int i=0;i<str.length;i++){
				if(i != index){
					ret[k] = str[i];
					k++;
				}
			}
			return ret;
		}
	}
}
