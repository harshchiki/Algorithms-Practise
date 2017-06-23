package dynamicprogramming;

public class KnapsackProblem {
	public static void main(String[] args) {
		int val[] = new int[]{60, 100, 120};
		int wt[] = new int[]{10, 20, 30};
		int  W = 50;
		int n = val.length;
		System.out.println(knapsack(W, wt, val, n));
	}
	

	static int knapsack(int W, int[] wt, int[] val, int n){
		if(n == 0 || W == 0){
			return 0;
		}

		if(wt[n-1] > W){
			// skip last object - because it can never be picked, its weight is greater than capacity
			return knapsack(W, wt, val, n-1);
		}else{
			// consider having the last object, and not having (0-1) property
			return max(
					val[n-1] + knapsack(W-wt[n-1], wt, val, n-1),
					knapsack(W, wt, val, n-1)
					);
		}
	}

	static int max(int a, int b){
		return a>b ? a : b;
	}
}
