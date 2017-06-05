package string;

public class KMPAlgo {
	public static void main(String[] args) {
		findMatches("hello world".toCharArray(), "world".toCharArray());
	}
	
	static void findMatches(char[] t, char[] p){
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
