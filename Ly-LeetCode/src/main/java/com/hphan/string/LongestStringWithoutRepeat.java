package com.hphan.string;

import java.util.HashSet;
import java.util.Set;

public class LongestStringWithoutRepeat
{
    public static void main(String[] args)
    {
	System.out.println((int) 'a' );
	System.out.println((int) ' ' );
	System.out.println((int) '?');

    }
    
    /**
     * My original idea - window slide. I know it can be optimized using array
     * instead of set
     */
    public int lengthOfLongestSubstringE(String s)
    {
	if (s.length() < 2)
	    return s.length();

	int max = 0, i = 0, j = 1;

	Set<Character> cache = new HashSet<Character>();
	cache.add(s.charAt(i));

	while (i < s.length() && j < s.length())
	{
	    while (cache.contains(s.charAt(j)))
		cache.remove(s.charAt(i++));
	    cache.add(s.charAt(j++));
	    max = Math.max(max, j - i);
	}
	return max;
    }

    /**
     * Now use array to make it faster
     */
    public int lengthOfLongestSubstring(String s)
    {
	if (s.length() < 2)
	    return s.length();

	int max = 0, i = 0, j = 1;

	boolean[] cache = new boolean[128];
	cache[s.charAt(i) - ' '] = true;

	while (i < s.length() && j < s.length())
	{
	    while (cache[s.charAt(j)-' '])
		    cache[s.charAt(i++)-' '] = false; 
	    cache[s.charAt(j++)-' '] = true;;
	    max = Math.max(max, j - i);
	}
	return max;
    }
}
