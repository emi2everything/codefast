package com.hphan.array;

/**
 * Subsequence --> Something to do with dynamic programming
 * Not everything sound like DP needs to go through complete DP with memory table and so
 * Not things becomes easy and clear
 * 
 * The problem here is this statement "strictly alternate between positive and negative"
 * The trick is that I have to handle same number repeating: What if it comes at the beginning, in the middle, at the end...
 * 
 * @author Ly
 *
 */
public class WiggleSubSequence
{
    public int wiggleMaxLength(int[] nums)
    {

	// Edge
	if (nums.length == 0)
	    return 0;
	if (nums.length == 1)
	    return 1;

	// Init
	int start = 1;
	int first = nums[0];
	int max = 1;
	boolean pos = true;

	// Find starting point
	while (start < nums.length && first == nums[start])
	    start++;

	// Logic
	for (int i = start; i < nums.length; i++)
	{
	    boolean newPos = nums[i] - nums[i - 1] > 0;
	    if ((nums[i] != nums[i - 1])) // important
	    {
		if ((i == start) || (pos != newPos))
		    max++;
		pos = newPos;
	    }
	}
	return max;
    }
}
