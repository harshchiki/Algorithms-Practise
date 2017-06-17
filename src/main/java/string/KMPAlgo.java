package string;
/*
 * References:
 * 1.) http://jakeboxer.com/blog/2009/12/13/the-knuth-morris-pratt-algorithm-in-my-own-words/
 * (Good explanation of longest prefix which is also a suffix) 
 *
 */
public class KMPAlgo {
	public static void main(String[] args) {
		String pattern = "world";
		String text = "hello world";
//		findMatchesUsingNaiveAlgo(text.toCharArray(), pattern.toCharArray());
		
		for(int i : findLPS(new char[]{'a','b','c','d','a','b','c','y'})){
			System.out.println(i);
		}
		
		KMPSearch(text.toCharArray(), pattern.toCharArray());
	}
	
	
	
	// Naive ALgo O(mn), KMP is O(m+n)
	static void findMatchesUsingNaiveAlgo(char[] t, char[] p){
		int currentIndex = 0;
		int leftOverChars = t.length;
		
		while(leftOverChars > 0 ){
			for(int i = 1;i<=p.length;i++){
				if(!(t[currentIndex+i-1] == p[i-1])){
					currentIndex += i;
					leftOverChars = t.length - currentIndex;
					break;
				} else{
					if(i == (p.length)){
						System.out.println("Found at "+currentIndex);
						
						leftOverChars = t.length - (currentIndex + p.length);
						currentIndex += i;
						
					}
				}
			}
		}
	}
	
	
	static void KMPSearch(char[] text, char[] patt){
		int tl = text.length;
		int pl = patt.length;
		
		int[] lps = findLPS(patt);
		
		int j = 0; // index for pattern
		int i = 0; // index for text
		
		while(i<tl){
			if(patt[j] == text[i]){
				i++;
				j++;
			}
			
			if(j == pl){
				System.out.println("Found at "+i);
				j = lps[j-1];
			}
			else if(i<tl && patt[j] != text[i]){
				// mismatch after j matches
				if(j == 0){
					i++;
				}else{
					j = lps[j-1];
				}
			}
		}
		
	}
	
	
	static int[] findLPS(char[] p){
		int j =0, i =1;
		int[] lps = new int[p.length];
		lps[0] = 0;
		
		while(i<p.length){
			if(p[i] == p[j]){
				//match
				lps[i] = j+1;
				i++;
				j++;
			}else{
				if(j == 0){
					lps[i] = 0;
					i++;
				}else{
					// j != 0
					/* recall the so far found
					 * the max length of proper prefix
					 * which is also the suffix
					*/
					j = lps[j-1];
				}
			}
		}
		
		
		return lps;
	}
}
