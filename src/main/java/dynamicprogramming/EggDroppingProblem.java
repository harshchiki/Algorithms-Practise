package dynamicprogramming;

/*
 *  http://www.geeksforgeeks.org/dynamic-programming-set-11-egg-dropping-puzzle/
 */
public class EggDroppingProblem {
	public static void main(String[] args) {
		EggDroppingProblem o = new EggDroppingProblem();
		int floors = 10;
		int eggs = 2;
		System.out.println(o.eggDrop(eggs, floors));
		
	}
	/* Function to get minimum number of trials needed in worst
	  case with n eggs and k floors */
	int eggDrop(int eggs, int floors)
	{
	    // If there are no floors, then no trials needed. OR if there is
	    // one floor, one trial needed.
	    if (floors == 1 || floors == 0)
	        return floors;
	 
	    // We need k trials for one egg and k floors
	    if (eggs == 1)
	        return floors;
	 
	    int min = Integer.MAX_VALUE, x, res;
	 
	    // Consider all droppings from 1st floor to kth floor and
	    // return the minimum of these values plus 1.
	    for (x = 1; x <= floors; x++)
	    {
	        res = max(eggDrop(eggs-1, x-1), eggDrop(eggs, floors-x));
	        if (res < min)
	            min = res;
	    }
	 
	    return min + 1;
	}
	
	int max(int a, int b) {
		return a>b?a:b;
	}
}
