package com.hphan.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfMatchingSubsequence_792
{
    public int numMatchingSubseq(String t, String[] words)
    {
	/**
	 * Part 1: Build hashMap for string
	 */
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
	int count = 0;
	for (String s : words)
	{
	    if (isSubSequence(s, t, tMap))
		count++;
	}
	return count;
    }

    private boolean isSubSequence(String s, String t,  HashMap<Character, List<Integer>> tMap)
    {
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
    
    
    /////////////////// If wanna check one by one should check for repeated words /////////////////////
    
    public int numMatchingSubseq2(String t, String[] words)
    {
        int count = 0;
        Map<String,Integer> wordCount = new HashMap<String,Integer>();
        for (String w: words)
        {
            wordCount.put(w,wordCount.getOrDefault(w, 0) + 1);
        }
        for (String w : wordCount.keySet())
        {
            if (isSubsequenceBasic(w,t))
                count += wordCount.get(w);
        }
        return count;
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
}
