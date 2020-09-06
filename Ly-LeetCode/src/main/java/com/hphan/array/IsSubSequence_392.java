package com.hphan.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Just be careful while coding, and do follow-up questions
 * Haha tried to make it faster but is is slower. Just implement isSubsequence with a queue will do
 * 
 * @author Ly
 *
 */
public class IsSubSequence_392
{
    public boolean isSubsequence(String s, String t)
    {

	if (s.length() == 0)
	    return true;
	if (t.length() == 0)
	    return false;

	HashMap<Character, List<Integer>> tMap = new HashMap<Character, List<Integer>>();

	// Prepare the map
	for (int i = 0; i < t.length(); i++)
	{
	    char c = t.charAt(i);
	    if (tMap.get(c) == null)
	    {
		List<Integer> indexList = new ArrayList<Integer>();
		indexList.add(i);
		tMap.put(c, indexList);
	    } else
	    {
		tMap.get(c).add(i);
	    }
	}

	// For every s I don't compute again and again

	int j = 0;
	int curIndex = -1;
	while (j < s.length() && curIndex < t.length())
	{
	    boolean found = false;
	    if (tMap.get(s.charAt(j)) == null)
		return false;
	    inner: for (Integer i : tMap.get(s.charAt(j)))
	    {
		System.out.println(tMap.get(s.charAt(j)));
		System.out.println(s.charAt(j));
		if (i > curIndex)
		{
		    j++;
		    curIndex = i;
		    found = true;
		    break inner;
		}
	    }
	    if (!found)
		return false;
	}
	return true;
    }

    public boolean isSubsequenceBasic(String s, String t)
    {
	if (s.length() == 0)
	    return true;
	if (t.length() == 0)
	    return false;

	int i = 0, j = 0;
	while (j < t.length() && i < s.length())
	{
	    if (s.charAt(i) == t.charAt(j))
	    {
		i++;
		j++;
	    } else
	    {
		j++;
	    }
	}

	if (i == s.length())
	    return true;
	return false;
    }
    
    //////////////////From discussion//////////////////// ca=t
    private boolean isSubsequence(String s, char[] ca) 
    {
        if (s.length() == 0) return true;
        if (s.length() > ca.length) return false;
        Queue<Character> q = new LinkedList<Character>();
        for (char c : s.toCharArray()) q.offer(c);
        for (char c : ca) {
            if (c == q.peek()) q.poll();
            if (q.isEmpty()) return true;
        }
        return false;
    }
}
