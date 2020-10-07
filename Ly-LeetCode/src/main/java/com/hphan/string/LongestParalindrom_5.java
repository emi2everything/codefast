package com.hphan.string;

public class LongestParalindrom_5
{
    public static void main(String[] args)
    {
	System.out.println("Here I go");
	System.out.println(longestPalindrome("cabba"));
    }
    
    
    /**
     * Why am I not focusing??? All silly mistake here and there
     */
    public static String longestPalindrome(String s)
    {
	int maxStart = 0, maxEnd = 0, max = 0;

	for (int i = 0; i < s.length(); i++)
	{
	    int start1 = i, end1 = i, start2 = i, end2 = i + 1, localMax = 0;
	    inner1: while (start1 > -1 && end1 < s.length())
	    {
		if (s.charAt(start1) == s.charAt(end1))
		{
		    localMax = end1 - start1 + 1;
		} else
		    break inner1;

		if (localMax > max)
		{
		    max = localMax;
		    maxStart = start1;
		    maxEnd = end1;
		}
		start1--;
		end1++;
	    }
	    
	    localMax = 0;
	    inner2: while (start2 > -1 && end2 < s.length())
	    {
		if (s.charAt(start2) == s.charAt(end2))
		{
		    localMax = end2 - start2 + 1;
		} else
		    break inner2;

		if (localMax > max)
		{
		    max = localMax;
		    maxStart = start2;
		    maxEnd = end2;
		}
		start2--;
		end2++;
	    }
	    
	}

	return s.substring(maxStart, maxEnd + 1);
    }
}
