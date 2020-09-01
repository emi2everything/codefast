package com.hphan.array;

import java.util.Arrays;

/**
 * Congrat! Done in first run
 * @author Ly
 *
 */
public class AssignCookie_445
{
    public int findContentChildren(int[] g, int[] s)
    {
	Arrays.sort(g);
	Arrays.sort(s);

	int j = 0, count = 0;

	outer: for (int i = 0; i < g.length; i++)
	{
	    if (j >= s.length)
	    {
		break outer;
	    }
	    inner: while (j < s.length)
	    {
		if (g[i] <= s[j])
		{
		    count++;
		    j++;
		    break inner;
		}
		j++;
	    }
	}
	return count;
    }
}
