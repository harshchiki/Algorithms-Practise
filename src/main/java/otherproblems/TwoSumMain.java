package otherproblems;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * https://leetcode.com/problems/two-sum/?tab=Description
TWO SUM
Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
	
Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

 * @author Harsh
 *
 */
public class TwoSumMain {
	
	public static void main(String[] a){
		int[] nums = new int[4];
		int target = 9;
		
		nums[0] = 2;
		nums[1] = 7;
		nums[2] = 11;
		nums[3] = 15;
		
		long millis = System.currentTimeMillis();
		int[] result = new TwoSumMain().twoSum1(nums, target);
		System.out.println("Took = "+(System.currentTimeMillis()-millis));
		for(int i : result){
			System.out.println(i);
		}
		millis = System.currentTimeMillis();
		result = new TwoSumMain().twoSum2(nums, target);
		System.out.println("Took = "+(System.currentTimeMillis()-millis));
		for(int i : result){
			System.out.println(i);
		}
		millis = System.currentTimeMillis();
		result = new TwoSumMain().twoSum3(nums, target);
		System.out.println("Took = "+(System.currentTimeMillis()-millis));
		for(int i : result){
			System.out.println(i);
		}
	}
	
	/*
	 * Time comp: O n^2
	 * Space comp: O 1
	 */
	public int[] twoSum1(int[] nums, int target) {
		int[] result = new int[2];
		int arrayLength = nums.length;
		
		for(int i=0;i<arrayLength-1;i++){
			for(int j=i+1;j<arrayLength;j++){
				int first = nums[i];
				int second = nums[j];
				
				if((first+second) == target){
					result[0] = i;
					result[1] = j;
					return result;
				}
			}
		}
		
		return result;
    }
	
	/**
	 * Time comp: O n
	 * Space comp: O n
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum2(int[] nums, int target){
		int[] result = new int[2];
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>(nums.length);
		
		
		for(int i = 0;i<nums.length;i++){
			map.put(Integer.valueOf(nums[i]), i);
		}
		
		for(Integer i : map.keySet()){
			Integer expectedValue = Integer.valueOf(target - i.intValue());
			if(map.containsKey(expectedValue)){
				result[0] = map.get(i);
				result[1] = map.get(expectedValue);
				
				return result;
			}
		}
		
		
		return result;
	}
	
	/**
	 * Time comp: O n
	 * Space comp: O n
	 * 
	 * Fastest of all.
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum3(int[] nums, int target){
		int[] result = new int[2];
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>(nums.length);
		
		
		for(int i = 0;i<nums.length;i++){
			Integer thisValue = Integer.valueOf(nums[i]);
			Integer expectedValue = Integer.valueOf(target - nums[i]);
			
			if(map.containsKey(expectedValue)){
				result[0] = map.get(expectedValue);
				result[1] = i;
				
				return result;
			}
			map.put(thisValue, i);
		}
		return result;
	}
}
