package dynamicprogramming;
/*
 * Given a value N, if we want to make change for N cents, 
 * and we have infinite supply of each of S = { S1, S2, .. , Sm}
 *  valued coins, how many ways can we make the change? The order 
 *  of coins doesn't matter. (test commit)
 */

/*
 * This solution approach found here is also application to the solution of 
 * Count number of ways to reach a given score in a game
 * http://www.geeksforgeeks.org/count-number-ways-reach-given-score-game/
 * Both recursive and DP apply here
 */

public class CoinChangeProblem {

	public static void main(String[] ar){
		CoinChangeProblem o = new CoinChangeProblem();
		System.out.println(o.noOfWaysToMakeChangeRecursive(new int[]{1, 2, 3}, 3, 4));
		System.out.println(o.noOfWaysToMakeChangeDP(new int[]{3,5,10}, 20));
	}

	int noOfWaysToMakeChangeRecursive(int[] coins, int m, int totalValue){
		if(totalValue == 0){
			return 1; // only way is to give nothing
		}

		if(totalValue < 0){
			return 0; 
		}

		if(m<=0 && totalValue > 0){
			// cant manage;
			return 0;
		}

		return noOfWaysToMakeChangeRecursive(coins, m-1, totalValue) // excluding the last coin
				
				// fixing the value of last coin, and trying to place all others
				+ noOfWaysToMakeChangeRecursive(coins, m, totalValue - coins[m-1]); 

	}

	int noOfWaysToMakeChangeDP(int[] coins, int value){
		/*
		 * table will be storing the number of solutions
		 * for value i (index in table) with the given coins, coins[]
		 */
		int table[] = new int[value+1];
		
		// initialize the table with value 0 (0 ways)
		for(int i = 0;i<= coins.length;i++){
			table[i] = 0;
		}
		
		table[0] = 1;
		
		// table[i] will be storing the number of solutions for value i(value).
		for(int i = 0;i<coins.length;i++){
			for(int j = coins[i];j<=value;j++){
				table[j] += table[j-coins[i]];
			}
		}
		
		return table[value];
	}
}
