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
		findMatchesUsingNaiveAlgo(text.toCharArray(), pattern.toCharArray());
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
}
