package com.hphan.string;

/**
 * I see it can be solved recursively from begining
 * I see it can be optimized using DP also
 * The problem I have is not taking care of all edge case, 26, 17 and handle 0 properly
 * @author Ly
 *
 */
public class DecodeWays_91
{
    public int numDecodings(String s)
    {
	// Edge
	if (s.length() == 0 || s.charAt(0) == '0')
	    return 0;

	int[] mem = new int[s.length() + 1];

	mem[s.length()] = 1;

	if (s.charAt(s.length() - 1) != '0')
	    mem[s.length() - 1] = 1;

	for (int i = s.length() - 2; i >= 0; i--)
	{
	    if (s.charAt(i) == '0' && s.charAt(i + 1) == '0')
		return 0;

	    if (s.charAt(i) == '0')
		mem[i] = 0;
	    else
	    {
		mem[i] = mem[i + 1];
		if (s.charAt(i) == '2' && s.charAt(i + 1) < '7' || s.charAt(i) == '1' && s.charAt(i + 1) <= '9')
		    mem[i] += mem[i + 2];
	    }
	}
	return mem[0];
    }
}
