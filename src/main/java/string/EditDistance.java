package string;

public class EditDistance {
	int getEditDistanceRecursive(String str1, String str2, int m, int n) {
		
	    if (m == 0) return n;
	      
	    if (n == 0) return m;
	      
	    if (str1.charAt(m-1) == str2.charAt(n-1))
	        return getEditDistanceRecursive(str1, str2, m-1, n-1);
	      
	    return 1 + min ( getEditDistanceRecursive(str1,  str2, m, n-1),    // Insert
	    		getEditDistanceRecursive(str1,  str2, m-1, n),   // Remove
	    		getEditDistanceRecursive(str1,  str2, m-1, n-1) // Replace                     
	                   );
		
	}
	
	int min(int a, int b) {
		return a < b ? a : b;
	}
	
	int min(int a, int b, int c) {
		return c < min(a,b) ? c : min(a,b);
	}
	
	int editDistanceDP(String str1, String str2, int m, int n)
    {
        // Create a table to store results of subproblems
        int editDistanceTable[][] = new int[m+1][n+1];
      
        // Fill d[][] in bottom up manner
        for (int i=0; i<=m; i++)
        {
            for (int j=0; j<=n; j++)
            {
                // If first string is empty, only option is to
                // insert all characters of second string
                if (i==0)
                    editDistanceTable[i][j] = j;  // Min. operations = j
      
                // If second string is empty, only option is to
                // remove all characters of second string
                else if (j==0)
                    editDistanceTable[i][j] = i; // Min. operations = i
      
                // If last characters are same, ignore last char
                // and recur for remaining string
                else if (str1.charAt(i-1) == str2.charAt(j-1))
                    editDistanceTable[i][j] = editDistanceTable[i-1][j-1];
      
                // If last character are different, consider all
                // possibilities and find minimum
                else
                    editDistanceTable[i][j] = 1 + min(editDistanceTable[i][j-1],  // Insert
                                       editDistanceTable[i-1][j],  // Remove
                                       editDistanceTable[i-1][j-1]); // Replace
            }
        }
  
        return editDistanceTable[m][n];
    }
	
	public static void main(String[] args) {
		final EditDistance edist = new EditDistance();
		final String str1 = "geek";
		final String str2 = "gesek";
		System.out.println(edist.getEditDistanceRecursive(str1, str2, str1.length(), str2.length()));
		System.out.println(edist.editDistanceDP(str1, str2, str1.length(), str2.length()));
	}
}
