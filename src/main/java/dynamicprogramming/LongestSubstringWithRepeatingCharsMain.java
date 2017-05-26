package dynamicprogramming;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
https://leetcode.com/problems/longest-substring-without-repeating-characters/?tab=Description

Longest Substring Without Repeating Characters
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. 
Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * @author Harsh
 *
 */
public class LongestSubstringWithRepeatingCharsMain {
	public static void main(String[] a){
		System.out.println(new LongestSubstringWithRepeatingCharsMain().lengthOfLongestSubstring("au"));
	}
	
	public int lengthOfLongestSubstring(String s) {
		if(null == s || s.length()==0) return 0;
		int length = 1, inputStringLength = s.length();
		char[] chars = s.toCharArray();
		Set<Character> set;
		for(int i=0;i<inputStringLength-1;i++){
			set = new HashSet<Character>(inputStringLength);
			for(int j=i;j<inputStringLength;j++){
				if(set.contains(Character.valueOf(chars[j]))){
					break;
				}else{
					set.add(Character.valueOf(chars[j]));
				}
			}
			length = set.size()>length?set.size():length;
		}
		return length;
	}

	public int lengthOfLongestSubstring1(String s) {
		if(null == s || s.length()==0) return 0;
		int length = 1;
		char[] chars = s.toCharArray();
		int inputStringLength = s.length();
		StringBuilder str;
		for(int i=0;i<inputStringLength-1;i++){
			str = new StringBuilder();
			int j=i;
			for(;j<inputStringLength;j++){
				str.append(chars[j]);
				if(!isUnique(str.toString())){
					break;
				}else{
					if(j-i+1>length) length = j-i+1;
				}
			}			
		}
		return length;
	}
	
	/*
	 * Time comp: O n 
	 * Space comp: O n
	 */
	public boolean isUnique(String s){
		Map<Character, Integer> map = new HashMap<Character, Integer>(s.length());
		for(char c : s.toCharArray()){
			if(map.containsKey(Character.valueOf(c))){
				return false;
			}
			map.put(Character.valueOf(c), null);
		}
		return true;
	}
}
